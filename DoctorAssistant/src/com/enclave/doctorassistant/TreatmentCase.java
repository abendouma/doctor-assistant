package com.enclave.doctorassistant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TreatmentCase extends Activity implements  OnClickListener{

	
	TableLayout tlrecent;
	Button BackBtn;
	TextView patientID,drug,allergy,chronic,age;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.treatment_case);
		tlrecent=(TableLayout)findViewById(R.id.tab);
		BackBtn=(Button)findViewById(R.id.backbtn2);
		BackBtn.setOnClickListener(this);
		
		patientID=(TextView)findViewById(R.id.tvPatientID);
		age=(TextView)findViewById(R.id.tvPatientAge);
		drug=(TextView)findViewById(R.id.drug);
		allergy=(TextView)findViewById(R.id.allergy);
		chronic=(TextView)findViewById(R.id.chronic);
		
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, 1);
		
		
	
		
	}
	
	@Override
	 public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	   if (requestCode == 1) {
	      if (resultCode == RESULT_OK) {
	         // Handle successful scan
	    	  String result=intent.getStringExtra("SCAN_RESULT").toString();
	    	  try {
	    			JSONObject json=new JSONObject(result);
	    			
	    	JSONArray patient = json.getJSONArray("patient");
				JSONObject c = patient.getJSONObject(0);
			this.patientID.setText(c.getString("id"));
			String allergys =c.getString("allergy").replace("|", "<br/>");
			String chronic=c.getString("chronic").replace("|", "<br/>");
			String taking =c.getString("taking").replace("|", "<br/>");
			this.age.setText(c.getString("age"));
			this.allergy.setText(Html.fromHtml(allergys));
			this.chronic.setText(Html.fromHtml(chronic));
			this.drug.setText(Html.fromHtml(taking));
			for(int i=0;i<9;i++)
			{
			TextView tv=new TextView(this);
			TableRow trDetail=new TableRow(this);
			TextView tvAction=new TextView(this);
			tvAction.setText("Xray Scan");
			tv.setText("0"+(i+1)+"/02/2012");
			
			tv.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,25));
			tv.setGravity(Gravity.CENTER);
			
			tvAction.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,75));
			tvAction.setGravity(Gravity.CENTER);
			
			trDetail.addView(tv);
			trDetail.addView(tvAction);
			tlrecent.addView(trDetail,new TableLayout.LayoutParams(
	                LayoutParams.FILL_PARENT,
	                LayoutParams.WRAP_CONTENT,100));
			}
				  
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  
	        
	    
	      } else if (resultCode == RESULT_CANCELED) {
	      //  finish();
	    		for(int i=0;i<9;i++)
				{
				final TextView tv=new TextView(this);
				final TableRow trDetail=new TableRow(this);
				TextView tvAction=new TextView(this);
				tvAction.setText("Xray Scan");
				tv.setText("0"+(i+1)+"/02/2012");
				
				tv.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,25));
				tv.setGravity(Gravity.CENTER);
				tvAction.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT,75));
				tvAction.setGravity(Gravity.CENTER);
				
				trDetail.addView(tv);
				trDetail.addView(tvAction);
				if(i%2!=0) {trDetail.setBackgroundColor(Color.GRAY);
				tvAction.setText("Blood test");}
				trDetail.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						 Intent in=new Intent(getApplicationContext(), BloodTestDetail.class);
						 in.putExtra("Date", tv.getText());
						 startActivity(in);
			        	
					}
				});
				tlrecent.addView(trDetail,new TableLayout.LayoutParams(
		                LayoutParams.FILL_PARENT,
		                LayoutParams.WRAP_CONTENT,100));
				}
	      }
	   }
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	switch(v.getId())
	{
	case R.id.backbtn2:
		finish();
		break;
	}
	}


	
	
}
