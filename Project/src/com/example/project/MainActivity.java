package com.example.project;

import java.util.ArrayList;
import java.util.Locale;

import com.example.project.MainActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	static final int check=1111;
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode==1111 && resultCode==RESULT_OK){	
			ArrayList<String> results =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			if(results.get(0).equals("store")){
				//new TextVoice();
				Toast.makeText(getApplicationContext(), results.get(0), Toast.LENGTH_SHORT).show();
				Intent i= new Intent(MainActivity.this,store.class);	
				startActivity(i);	
			}
			else if(results.get(0).equals("retrieve")){
				Toast.makeText(getApplicationContext(), results.get(0), Toast.LENGTH_SHORT).show();
				Intent j= new Intent(MainActivity.this,retrieve.class);
				startActivity(j);
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
				setContentView(R.layout.activity_main);
				//Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				//i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
			//	startActivityForResult(i, check);
			}	
		}	
		super.onActivityResult(requestCode, resultCode, data);
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RadioGroup grp=(RadioGroup) findViewById(R.id.radioGroup1);
		
		//START VOICE CODE FOR STORE AND RETRIEVE
		Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		startActivityForResult(i, check);
		
		//END
		
			/*grp.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				public void onCheckedChanged(RadioGroup group, int checkedId) {
			
					// TODO Auto-generated method stub
					
					if(checkedId==R.id.radio0)
					{
						Intent i= new Intent(MainActivity.this,store.class);	
						startActivity(i);
						
						
					}
					else if(checkedId==R.id.radio1)
					{
						Intent j= new Intent(MainActivity.this,retrieve.class);
						startActivity(j);
					}
					else
					{
						setContentView(R.layout.activity_main);
					}
						
						
						
						
				}

				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					// TODO Auto-generated method stub
					
				}
			});
		
*/	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
