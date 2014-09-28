package com.example.project;

import java.util.ArrayList;
import java.util.Locale;


import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.widget.Toast;

public class TextVoice extends Activity {

	static final int check=1111;
    int count=0;
	static final String text =
		"Salaam ,waalekum ,Speak your aiydee,name,age,sex and,submit,in,order";
	
	TextToSpeech tts;
	
	private void AskNow() {
		// TODO Auto-generated method stub
		tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if(status!=TextToSpeech.ERROR){
					//Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_LONG).show();
					tts.setLanguage(Locale.US);
					tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				}
			}	
		});
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(getApplicationContext(), "In textvoice", Toast.LENGTH_LONG).show();
		AskNow();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		if(tts!=null){
			tts.stop();
			tts.shutdown();
		}
		super.onPause();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

