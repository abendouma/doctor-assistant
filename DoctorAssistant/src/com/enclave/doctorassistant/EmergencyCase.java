package com.enclave.doctorassistant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmergencyCase extends Activity implements OnClickListener {

	Button backbtn,rescanbtn;

	TextView tv, patientID, chronic, allergy, drug, age;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emergency_case);
		backbtn = (Button) findViewById(R.id.backbtn);
		backbtn.setOnClickListener(this);
		rescanbtn=(Button)findViewById(R.id.rescanbtn);
		rescanbtn.setOnClickListener(this);
		
		TextView title=(TextView) findViewById(android.R.id.title);
	    View titleBar = (View) title.getParent();
        titleBar.setBackgroundColor(Color.RED);
		
		chronic = (TextView) findViewById(R.id.chronic);
		allergy = (TextView) findViewById(R.id.allergy);
		drug = (TextView) findViewById(R.id.drug);
		age = (TextView) findViewById(R.id.tvPatientAge);
		patientID = (TextView) findViewById(R.id.tvPatientID);

		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, 1);

	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				// Handle successful scan
				String result = intent.getStringExtra("SCAN_RESULT").toString();
				try {
					JSONObject c = new JSONObject(result);
					this.patientID.setText(c.getString("id"));
					String allergys = c.getString("allergy").replace("|",
							"<br/>");
					String chronic = c.getString("chronic").replace("|",
							"<br/>");
					String taking = c.getString("taking").replace("|", "<br/>");
					this.age.setText(c.getString("age"));
					this.allergy.setText(Html.fromHtml(allergys));
					this.chronic.setText(Html.fromHtml(chronic));
					this.drug.setText(Html.fromHtml(taking));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
				finish();
			}
		}
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.backbtn:
			finish();
			break;
		case R.id.rescanbtn:
			Intent intent = new Intent("com.google.zxing.client.android.SCAN");
			intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			startActivityForResult(intent, 1);
			break;
		}
	}

}
