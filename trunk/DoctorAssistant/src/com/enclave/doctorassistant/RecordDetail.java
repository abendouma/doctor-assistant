package com.enclave.doctorassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class RecordDetail extends Activity {

	TextView patientID, Date,Age;
	Button backbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.record_detail);
		patientID = (TextView) findViewById(R.id.tvPatientID);
		
		Age=(TextView)findViewById(R.id.tvPatientAge);
		Age.setText(this.getIntent().getStringExtra("Age"));
		
		Date = (TextView) findViewById(R.id.tvdate);
		Date.setText(this.getIntent().getStringExtra("Date"));
		
		
		patientID.setText(this.getIntent().getStringExtra("ID"));
		backbtn = (Button) findViewById(R.id.backbtn);
		backbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

}
