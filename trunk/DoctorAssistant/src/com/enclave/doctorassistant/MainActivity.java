package com.enclave.doctorassistant;


import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btn;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)findViewById(R.id.btn);
		tv=(TextView)findViewById(R.id.tv1);
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 1);
			}
		});
	}
	@Override
	 public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	   if (requestCode == 1) {
	      if (resultCode == RESULT_OK) {
	         // Handle successful scan
	        String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
	        tv.setText(format+" + "+intent.getStringExtra("SCAN_RESULT").toString());
	        
	    
	      } else if (resultCode == RESULT_CANCELED) {
	         // Handle cancel
	    	  LinearLayout layout = (LinearLayout)findViewById(R.id.mainlayout);
	    	  layout.setOrientation(LinearLayout.VERTICAL);
	    
	      }
	   }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
