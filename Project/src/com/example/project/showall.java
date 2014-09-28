package com.example.project;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class showall extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.store);
		EditText id,name,age;
		final Spinner spinner;
		RadioGroup sex;
		//int getsex = sex.getCheckedRadioButtonId();
		 spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	R.array.BloodGroup, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
	spinner.setAdapter(adapter);		
		
	Button b=(Button) findViewById(R.id.button1)	;
	b.setVisibility(View.INVISIBLE);
		
DatabaseHandler db=new DatabaseHandler(getBaseContext());
db.openDatabase();
String s=getIntent().getStringExtra("num");
EditText i=(EditText) findViewById(R.id.num);
i.setText(s);
String str="SELECT * FROM patient_table where id='"+s+"'";
Cursor c=db.retrieve(str);
if(c.moveToFirst())
{
	
	id=(EditText) findViewById(R.id.num);
	name=(EditText) findViewById(R.id.name);
	age=(EditText) findViewById(R.id.age);
	sex=(RadioGroup) findViewById(R.id.Sex);
	name.setText(c.getString(1));
	age.setText(c.getString(2));
	//sex.clearCheck();
	String chk=c.getString(3);
	RadioButton rd;
	sex.clearCheck();
	if(chk.equals("2131296271"))
	{
	rd=(RadioButton) findViewById(R.id.female);
	rd.setChecked(true);
	}
	else
	{
		rd=(RadioButton) findViewById(R.id.male);
		rd.setChecked(true);
	
	}
	
	
	//Toast.makeText(getApplicationContext(), chk, Toast.LENGTH_LONG).show();
		
	ArrayAdapter myadp=(ArrayAdapter) spinner.getAdapter();
	int spipos=myadp.getPosition(c.getString(4));
	spinner.setSelection(spipos);
}
else
{
	Toast.makeText(getApplicationContext(), "Data Not Present", Toast.LENGTH_SHORT).show();
	
}
db.closeDatabase();
	}
}
  