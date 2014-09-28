package com.example.project;

import java.util.ArrayList;

import android.app.*;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class store  extends Activity {

	 int getid;
		String getname;
		int getage;
	int getsex ;
		String getbldgrp;
	TextView tw;
	Button submit;
	static int t=0;
	EditText id,name,age;
	RadioGroup sex;
	DatabaseHandler dbhandler;
	RadioButton rad;
	ArrayList<String> results;
	String str,str1,str2,str3;
	Spinner spinner;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.store);
		submit=(Button) findViewById(R.id.button1);
		id=(EditText) findViewById(R.id.num);
		name=(EditText) findViewById(R.id.name);
		age=(EditText) findViewById(R.id.age);
		sex=(RadioGroup) findViewById(R.id.Sex);
		 spinner = (Spinner) findViewById(R.id.spinner1);
		 rad=(RadioButton) findViewById(R.id.male);
		 rad.setChecked(true);
			// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		R.array.BloodGroup, android.R.layout.simple_spinner_item);
			// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	Intent i=new Intent(this,Recognizer.class);
	//	i.putExtra("num", id.getText().toString());
	startActivityForResult(i, 1111);
//age.setText("111");
	
//Toast.makeText(getApplicationContext(), "Hi afterstart ", Toast.LENGTH_SHORT);
	//FOR NAME
	i=new Intent(this,Recognizer.class);
	//	i.putExtra("num", id.getText().toString());
	startActivityForResult(i, 1111);
	
	//FOR AGE
	i=new Intent(this,Recognizer.class);
	//	i.putExtra("num", id.getText().toString());
	startActivityForResult(i, 1111);	
	
	//FOR SUBMIT
	i=new Intent(this,Recognizer.class);
	//	i.putExtra("num", id.getText().toString());
	startActivityForResult(i, 1111);
}

		
protected void	onActivityResult(int requestCode, int resultCode, Intent data) {
	
	         if(resultCode == RESULT_OK){
	          str=data.getStringExtra("result").toString();
	  str1=id.getText().toString();
	  str2=name.getText().toString();
	  str3=age.getText().toString();
	
	  if(str.matches("submit"))
	  {
 tw= (TextView) findViewById(R.id.storetext);
tw.setText("Inside Submit!!");
dbhandler = new DatabaseHandler(getBaseContext());
dbhandler.openDatabase();
 getid = Integer.valueOf(id.getText().toString());
 getname = name.getText().toString();
 getage = Integer.valueOf(age.getText().toString());
 getsex = sex.getCheckedRadioButtonId();
 getbldgrp = spinner.getSelectedItem().toString();
long insertid = dbhandler.insertData(getid, getname, getage, getsex, getbldgrp);
if(insertid!=-1)
{	Toast.makeText(getBaseContext(), "Data Inserted Successfully", Toast.LENGTH_LONG).show();
	tw.setText("Inside Data storing successfully!!");
	dbhandler.closeDatabase();	
}
else
{
Toast.makeText(getBaseContext(), "Couldnt Insert data", Toast.LENGTH_LONG).show();	
}
dbhandler.closeDatabase();	
//finish();
Intent h=new Intent(this,MainActivity.class);
startActivity(h);
	  }
	  
	  else  if(str1.matches("")) 
	{
	          id.setText(str);
	       //   age.setText("12344");
	t=9;
	          return;
	}
	else if(str2.matches(""))
	{
	name.setText(str);
	t=9;
	return;          
	    }
	else
	{
		age.setText(str);
		t=9;
		return;
	}
	          

}
}
}