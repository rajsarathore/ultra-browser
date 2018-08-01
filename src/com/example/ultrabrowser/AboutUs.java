package com.example.ultrabrowser;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;

import android.widget.TextView;

public class AboutUs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		getActionBar().setTitle("Aboout Us");
		Typeface tf=Typeface.createFromAsset(getAssets(), "FORTE.TTF");
		((TextView)findViewById(R.id.aboutus_developtedby)).setTypeface(tf);
		((TextView)findViewById(R.id.about_developer)).setTypeface(tf);
	}

	
}
