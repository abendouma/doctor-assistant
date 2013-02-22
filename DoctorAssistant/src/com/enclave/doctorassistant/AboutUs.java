package com.enclave.doctorassistant;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AboutUs extends Activity{

	Button backbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_us);
		
		TextView title=(TextView) findViewById(android.R.id.title);
	    View titleBar = (View) title.getParent();
        titleBar.setBackgroundColor(Color.RED);
        
		backbtn=(Button)findViewById(R.id.backbtn);
		backbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	

}
