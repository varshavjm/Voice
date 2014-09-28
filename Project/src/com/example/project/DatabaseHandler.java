package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler {
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String AGE = "age";
	public static final String SEX = "sex";
	public static final String BLOOD_GRP = "bloodgrp";
	public static final String PATIENT_TABLE = "patient_table";
	public static final String DATABASE_NAME = "moraledb";
	public static final int DATABASE_VERSION = 1;
	public static final String CREATE_TABLE = "create table patient_table(id integer,name text, age integer,sex integer,bloodgrp text);";
	
	DatabaseHelper dbhelper;
	Context ctx;
	SQLiteDatabase db;
	
	public DatabaseHandler(Context ctx) {
		// TODO Auto-generated constructor stub
		this.ctx=ctx;
		dbhelper=new DatabaseHelper(ctx);
	}
	private static class DatabaseHelper extends SQLiteOpenHelper{

		public DatabaseHelper(Context ctx) {
			// TODO Auto-generated constructor stub
			//database is created whenever dbhelper initialised
			super(ctx,DATABASE_NAME,null,DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try{
				db.execSQL(CREATE_TABLE);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			//delete previous database of same name before upgradation
			//db.execSQL("DROP TABLE IF EXISTS patient_table");
			onCreate(db);
			
		}
	}
	
	public DatabaseHandler openDatabase(){
		db=dbhelper.getWritableDatabase();
		return this;
	}
	
	public void closeDatabase(){
		dbhelper.close();
	}
	
	public long insertData(int id,String name,int age,int sex,String bloodgrp){
		ContentValues content=new ContentValues();
		content.put(ID, id);
		content.put(NAME, name);
		content.put(AGE, age);
		content.put(SEX, sex);
		content.put(BLOOD_GRP, bloodgrp);
		return db.insertOrThrow(PATIENT_TABLE, null, content);
	}
	public Cursor retrieve(String sql)
	{
		
		return db.rawQuery(sql, null);
		
		
		
	}
}
