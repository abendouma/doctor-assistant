package com.enclave.doctorassistant;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class BloodTestDetail extends Activity {

	TableLayout tblResult;
	Button BackBtn;
	TextView patientID, date, age;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blood_test_detail);
		BackBtn = (Button) findViewById(R.id.backbtn);
		BackBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		tblResult = (TableLayout) findViewById(R.id.tab);
		patientID = (TextView) findViewById(R.id.tvPatientID);
		age = (TextView) findViewById(R.id.tvPatientAge);
		age.setText(this.getIntent().getStringExtra("Age"));
		date = (TextView) findViewById(R.id.tvDateTest);
		date.setText(this.getIntent().getStringExtra("Date"));
		patientID.setText(this.getIntent().getStringExtra("ID"));
		
		
		String[] components = { "WBC Count", "Red Blood Cells Count", "HGB",
				"Hematocrit", "MCV", "RDW, RBC", "Platelets Count" };
		String[] values = { "6.3", "5.01", "14.5", "44.8", "89", "13.6", "155" };
		String[] Standards = { "3.5-12.5 K/uL", "4.10-5.70 M/uL",
				"13.0-17.0 g/uL", "39.0-51.0 %", "80-100 Fl", "11.9-14.3 %",
				"140-400 K/uL" };
		for (int i = 0; i < 7; i++) {
			TableRow trDetail = new TableRow(this);
			TextView tvcomponent = new TextView(this);
			TextView tvvalue = new TextView(this);
			TextView tvStandard = new TextView(this);
			tvStandard.setText(Standards[i]);
			tvcomponent.setText(components[i]);
			tvvalue.setText(values[i]);
			
			LayoutParams params=new LayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,30));
			params.rightMargin=1;
			
			if (i % 2 != 0)
				trDetail.setBackgroundColor(Color.parseColor("#09FF00"));
			//tvvalue.setLayoutParams(params);
			tvvalue.setGravity(Gravity.CENTER);
			
			//tvcomponent.setLayoutParams(params);

			tvStandard.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 40));
			tvStandard.setGravity(Gravity.CENTER);
			
			trDetail.addView(tvcomponent,params);
			trDetail.addView(tvvalue,params);
			trDetail.addView(tvStandard);
			tblResult.addView(trDetail, new TableLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 100));
		}

	}

}
