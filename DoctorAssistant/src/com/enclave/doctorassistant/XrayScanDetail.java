package com.enclave.doctorassistant;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class XrayScanDetail extends Activity {
	private Gallery gallery;
	private ImageView imgView;
	TextView Date,Age, patientID;
	Button backbtn;
	private Integer[] Imgid = { R.drawable.xray_1, R.drawable.xray_3 };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xray_detail);
		
		TextView title=(TextView) findViewById(android.R.id.title);
	    View titleBar = (View) title.getParent();
        titleBar.setBackgroundColor(Color.RED);
		
		Date = (TextView) findViewById(R.id.tvdate);
		Date.setText(this.getIntent().getStringExtra("Date"));
		
		
		Age=(TextView)findViewById(R.id.tvPatientAge);
		Age.setText(this.getIntent().getStringExtra("Age"));
		
		patientID=(TextView)findViewById(R.id.tvPatientID);
		patientID.setText(this.getIntent().getStringExtra("ID"));
		
		
		imgView = (ImageView) findViewById(R.id.ImageView01);
		imgView.setImageResource(Imgid[0]);
		backbtn = (Button) findViewById(R.id.backbtn);

		backbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		gallery = (Gallery) findViewById(R.id.gallery1);
		gallery.setAdapter(new AddImgAdp(this));

		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position,
					long id) {
				imgView.setImageResource(Imgid[position]);
			}
		});

	}

	public class AddImgAdp extends BaseAdapter {
		int GalItemBg;
		private Context cont;

		public AddImgAdp(Context c) {
			cont = c;
			TypedArray typArray = obtainStyledAttributes(R.styleable.GalleryTheme);
			GalItemBg = typArray.getResourceId(
					R.styleable.GalleryTheme_android_galleryItemBackground, 0);
			typArray.recycle();
		}

		public int getCount() {
			return Imgid.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imgView = new ImageView(cont);

			imgView.setImageResource(Imgid[position]);
			imgView.setLayoutParams(new Gallery.LayoutParams(150,
					LayoutParams.MATCH_PARENT));

			imgView.setScaleType(ImageView.ScaleType.FIT_XY);
			imgView.setBackgroundResource(GalItemBg);

			return imgView;
		}
	}

}