package com.example.project;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.EditText;
import android.widget.Toast;

public class Recognizer extends Activity {
	int t;
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode==1111 && resultCode==RESULT_OK)
		{
			 
			ArrayList<String> results =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			//lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,results));
	Toast.makeText(getApplicationContext(), results.get(0), Toast.LENGTH_LONG).show();
		//id=(EditText) findViewById(R.id.ip);
			//id.setText(results.get(0));
		/*	Intent i=new Intent(this,store.class);
			i.putExtra("num", id.getText().toString());
			startActivity(i);
		*/
	
		Intent intent = new Intent();
		intent.putExtra("result",results.get(0));
		setResult(RESULT_OK, intent);    
			finish();
return;
		}
			
		super.onActivityResult(requestCode, resultCode, data);
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.store);
		Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		startActivityForResult(i,1111);
		
		
		
		
	}
	

}
