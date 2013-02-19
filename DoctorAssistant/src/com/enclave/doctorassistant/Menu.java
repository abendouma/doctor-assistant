package com.enclave.doctorassistant;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Menu extends Activity{

	ListView lvMenu;
	  final static ArrayList<HashMap<String, ?>> menuArray=new ArrayList<HashMap<String,?>>();
	static {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("Icon",R.drawable.emergency_icon);
		map.put("Title", "Emergency");
		map.put("Hint", "Use for emergency case");
		menuArray.add(map);

		map=new HashMap<String, Object>();
		map.put("Icon",R.drawable.treatment_ico);
		map.put("Title", "Treatment");
		map.put("Hint", "Use for treatment case");
		menuArray.add(map);
		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		lvMenu=(ListView)findViewById(R.id.lvMenu);
		SimpleAdapter  ad = new SimpleAdapter (this,menuArray, 
                   R.layout.menu_list, new String[]{"Icon","Title","Hint"},new int[]{R.id.imgTop,R.id.tvTitle,R.id.tvHint} ); 
		lvMenu.setAdapter(ad);
		lvMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				 Intent in;
				// TODO Auto-generated method stub
				switch(position){
				case 0: in=new Intent(getApplicationContext(),EmergencyCase.class);
						startActivity(in);
						break;
				case 1: in=new Intent(getApplicationContext(),TreatmentCase.class);
				startActivity(in);
				break;
		
				}
				
				
				
			}
			
		});

	}

	
	
}
