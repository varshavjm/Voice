package com.example.project;

import java.util.ArrayList;



import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.*;
import android.content.Intent;


public class retrieve extends Activity{

EditText id;
static final int check=1111;
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode==1111 && resultCode==RESULT_OK)
		{
			
			ArrayList<String> results =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			//lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,results));
		    Toast.makeText(getApplicationContext(), results.get(0), Toast.LENGTH_LONG).show();
		    id=(EditText) findViewById(R.id.ip);
			id.setText(results.get(0));
			Intent i=new Intent(retrieve.this,showall.class);
			i.putExtra("num", id.getText().toString());
			startActivity(i);
		
		}
			
		super.onActivityResult(requestCode, resultCode, data);
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.retrieve);
		Button b=(Button) findViewById(R.id.button1);
//		b.setOnClickListener(this);
		b.setVisibility(0);
		Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		startActivityForResult(i, check);
	}

	/*@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		startActivityForResult(i, check);
		
		
	}*/
		
}