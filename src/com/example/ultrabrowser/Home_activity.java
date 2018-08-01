package com.example.ultrabrowser;

import java.util.HashMap;
import com.google.android.gms.appindexing.AndroidAppUri;

import android.R.layout;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Home_activity extends Activity implements OnClickListener {
 EditText site_search,google_search;
 SharedPreferences prefs;
 HashMap<String,String> hmsites_button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_activity);
		Typeface tf=Typeface.createFromAsset(getAssets(), "FORTE.TTF");
		LinearLayout l=(LinearLayout)findViewById(R.id.linearlayout_sitelist);
		setAppFont(l, tf);
		
		//education sites
		hmsites_button=new HashMap<String, String>();
		hmsites_button.put("w3school", "www.w3schools.com/");
		hmsites_button.put("TutorialsPoint", "www.tutorialspoint.com/");
		hmsites_button.put("NPTEL", "www.nptel.ac.in/");
		hmsites_button.put("java point", "www.javatpoint.com/");
		hmsites_button.put("Coursera","www.coursera.org");
		
		//News sites
		hmsites_button.put("ABP News", "www.abpnews.abplive.in/");
		hmsites_button.put("Jagran", "www.jagran.com/");
		hmsites_button.put("Patrika", "www.patrika.com");
		hmsites_button.put("Times of India", "www.timesofindia.indiatimes.com");
		hmsites_button.put("dailywhatz", "www.dailywhatz.com/");
		hmsites_button.put("Crunch69", "crunch69.com/");
		
		//sport sites
		hmsites_button.put("Crickbuzz", "www.cricbuzz.com/");
		hmsites_button.put("Hotstar sports", "www.hotstar.com/sports");
		hmsites_button.put("Sportskeeda", "www.sportskeeda.com");
		
		//travel sites
		hmsites_button.put( "IndianRail", "www.indianrail.gov.in");
		hmsites_button.put("Makemytrip", "www.makemytrip.com");
		hmsites_button.put("HappyTrips", "www.happytrips.com");
		hmsites_button.put("RedBus", "www.redbus.in");
		hmsites_button.put("Uber", "www.uber.com");
		hmsites_button.put("Ola", "www.olacabs.com");
		
		//social media sites..
		hmsites_button.put("Facebook", "www.facebook.com");
		hmsites_button.put("Twitter", "twitter.com");
		hmsites_button.put("LinkedIn", "in.linkedin.com");
		hmsites_button.put("Google Plus", "plus.google.com");
		hmsites_button.put("Instagram", "www.instagram.com");
		hmsites_button.put("Hike", "hike.in");
		
		//email sites..
		hmsites_button.put("Yahoo", "yahoo.com");
		hmsites_button.put("Gmail", "www.gmail.com");
		hmsites_button.put("Outlook", "outlook.live.com");
		hmsites_button.put("Yandex Mail", "www.mail.yandex.com");
		
		//job sites
		hmsites_button.put("Naukri", "www.naukri.com/");
		hmsites_button.put("Indeed", "www.indeed.co.in");
		hmsites_button.put("CareerBuilder", "www.careerbuilder.com");
		hmsites_button.put("Monster India", "www.monsterindia.com");
		
		//buy and sell
		hmsites_button.put("Amazon", "www.amazon.in");
		hmsites_button.put("Ebay", "www.ebay.in");
		hmsites_button.put("Flipkart", "www.flipkart.com");
		hmsites_button.put("ShopClues", "www.shopclues.com");
		hmsites_button.put("OLX", "www.olx.in");
		hmsites_button.put("Quikr", "www.quikr.com");
		
		//Exam Result site..
		hmsites_button.put("IndiaResult", "www.indiaresults.com");
		hmsites_button.put("CBSE", "cbseresults.nic.in/");
		hmsites_button.put("Results.gov.in", "results.gov.in/");
		hmsites_button.put("RTU Result", "www.esuvidha.info/");
		
		//video 
		hmsites_button.put("Youtube", "www.youtube.com");
		hmsites_button.put("Tubidy", "tubidy.mobi");
		hmsites_button.put("DailyMotion", "www.dailymotion.com");
		hmsites_button.put("Vuclip", "vuclip.com/?mobile");
		
		//movie sites
		hmsites_button.put("MovieWatcher", "moviewatcher.is/");
		hmsites_button.put("MyDownloadtube", "mydownloadtube.to");
		
		//software site..
		hmsites_button.put("Cnet", "download.cnet.com/");
		hmsites_button.put("Softpedia", "www.softpedia.com");
		hmsites_button.put("Softonic", "www.softonic.com");
		hmsites_button.put("Brothersoft", "www.brothersoft.com");
		
		//games sits
		hmsites_button.put("Y8 Games", "www.y8.com");
		hmsites_button.put("yahoo games", "yahoogames.tumblr.com");
		
		//song and ringtone site..
		hmsites_button.put("IndiaMp3", "indiamp3.com");
		hmsites_button.put("SongsPK", "songs.pk/browse/bollywood-albums");
		
		//amazing sites
		hmsites_button.put("Internet Map", "internet-map.net");
		hmsites_button.put("Zoomquilt", "zoomquilt.org/");
		
		
		
		
		
		site_search=(EditText)findViewById(R.id.textViewhttp);
		google_search=(EditText)findViewById(R.id.textView_google);
		findViewById(R.id.button_site).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String site;
				site=site_search.getText()+"";
				Intent intent=new Intent(Home_activity.this,MainActivity.class);
				intent.putExtra("address","https://"+site);
				startActivity(intent);
				
			}
		});
		findViewById(R.id.button_google).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String site;
				site=(google_search.getText()+"").replaceAll(" ", "+");
				
				Intent intent=new Intent(Home_activity.this,MainActivity.class);
				intent.putExtra("address","https://www.google.co.in/search?q="+site);
				startActivity(intent);
			}
		});
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		findViewById(R.id.button_education).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_education);
				if (!prefs.getBoolean("firstTime", false)) {
					layout.removeAllViews();
					LinearLayout l=new LinearLayout(Home_activity.this);
			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
			        l.setOrientation(LinearLayout.HORIZONTAL);
			        Button b=new Button(Home_activity.this);
			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			        b.setText("w3school");
			        b.setOnClickListener(Home_activity.this);
			        l.addView(b);
			        Button b1=new Button(Home_activity.this);
				       b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				       b1.setText("TutorialsPoint");
				       b1.setOnClickListener(Home_activity.this);
				       l.addView(b1);
				   Button b2=new Button(Home_activity.this);
				   b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				   b2.setText("NPTEL");
				   b2.setOnClickListener(Home_activity.this);
				   l.addView(b2);
				   
				   LinearLayout la=new LinearLayout(Home_activity.this);
			        la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
			        la.setOrientation(LinearLayout.HORIZONTAL);
				        Button b3=new Button(Home_activity.this);
					       b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
					        b3.setText("java point");
					        b3.setOnClickListener(Home_activity.this);
					        la.addView(b3);
					     Button b4=new Button(Home_activity.this);
						       b4.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
						        b4.setText("Coursera");
						        b4.setOnClickListener(Home_activity.this);
						        la.addView(b4);
					         
				    layout.addView(l);
				    layout.addView(la);
				    SharedPreferences.Editor editor = prefs.edit();
				    editor.putBoolean("firstTime", true);
				    editor.commit();
				}
				else{
					SharedPreferences.Editor editor = prefs.edit();
				    editor.putBoolean("firstTime", false);
				    editor.commit();
					layout.removeAllViews();
				}
				
			}
		});
		
		findViewById(R.id.button_newss).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_news);
				if (!prefs.getBoolean("firstTime", false)) {
					layout.removeAllViews();
					LinearLayout l=new LinearLayout(Home_activity.this);
			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
			        l.setOrientation(LinearLayout.HORIZONTAL);
			        Button b=new Button(Home_activity.this);
			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			        b.setText("ABP News");
			        b.setOnClickListener(Home_activity.this);
			        l.addView(b);
			        Button b1=new Button(Home_activity.this);
				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				    b1.setText("Jagran");
				    b1.setOnClickListener(Home_activity.this);
				    l.addView(b1);
				       
				    LinearLayout la=new LinearLayout(Home_activity.this);
				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
				    la.setOrientation(LinearLayout.HORIZONTAL);
				    Button b2=new Button(Home_activity.this);
				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				    b2.setText("Patrika");
				    b2.setOnClickListener(Home_activity.this);
				    la.addView(b2);
				    Button b3=new Button(Home_activity.this);
					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
					b3.setText("Times of India");
					b3.setOnClickListener(Home_activity.this);
					la.addView(b3);
					
					LinearLayout lb=new LinearLayout(Home_activity.this);
				    lb.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
				    lb.setOrientation(LinearLayout.HORIZONTAL);
				    Button b4=new Button(Home_activity.this);
				    b4.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				    b4.setText("dailywhatz");
				    b4.setOnClickListener(Home_activity.this);
				    lb.addView(b4);
				    Button b5=new Button(Home_activity.this);
					b5.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
					b5.setText("Crunch69");
					b5.setOnClickListener(Home_activity.this);
					lb.addView(b5);
				       
				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
				   layout.addView(l);
				   layout.addView(la);
				   layout.addView(lb);
				   SharedPreferences.Editor editor = prefs.edit();
				   editor.putBoolean("firstTime", true);
				   editor.commit();
				}
				else{
					SharedPreferences.Editor editor = prefs.edit();
				    editor.putBoolean("firstTime", false);
				    editor.commit();
					layout.removeAllViews();
				}
			}
		});
		
           findViewById(R.id.button_sport).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_sport);
				if (!prefs.getBoolean("firstTime", false)) {
					layout.removeAllViews();
					LinearLayout l=new LinearLayout(Home_activity.this);
			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
			        l.setOrientation(LinearLayout.HORIZONTAL);
			        Button b=new Button(Home_activity.this);
			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			        b.setText("Crickbuzz");
			        b.setOnClickListener(Home_activity.this);
			        l.addView(b);
			        Button b1=new Button(Home_activity.this);
				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				    b1.setText("Hotstar sports");
				    b1.setOnClickListener(Home_activity.this);
				    l.addView(b1);
				       
				    LinearLayout la=new LinearLayout(Home_activity.this);
				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
				    la.setOrientation(LinearLayout.HORIZONTAL);
				    Button b2=new Button(Home_activity.this);
				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				    b2.setText("Sportskeeda");
				    b2.setOnClickListener(Home_activity.this);
				    la.addView(b2);
				    
					
				       
				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
				   layout.addView(l);
				   layout.addView(la);
				   
				   SharedPreferences.Editor editor = prefs.edit();
				   editor.putBoolean("firstTime", true);
				   editor.commit();
				}
				else{
					SharedPreferences.Editor editor = prefs.edit();
				    editor.putBoolean("firstTime", false);
				    editor.commit();
					layout.removeAllViews();
				}
			}
		});
           findViewById(R.id.button_travel).setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View v) {
   				// TODO Auto-generated method stub
   				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
   				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_travel);
   				if (!prefs.getBoolean("firstTime", false)) {
   					layout.removeAllViews();
   					LinearLayout l=new LinearLayout(Home_activity.this);
   			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
   			        l.setOrientation(LinearLayout.HORIZONTAL);
   			        Button b=new Button(Home_activity.this);
   			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
   			        b.setText("IndianRail");
   			        b.setOnClickListener(Home_activity.this);
   			        l.addView(b);
   			        Button b1=new Button(Home_activity.this);
   				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
   				    b1.setText("Makemytrip");
   				    b1.setOnClickListener(Home_activity.this);
   				    l.addView(b1);
   				       
   				    LinearLayout la=new LinearLayout(Home_activity.this);
   				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
   				    la.setOrientation(LinearLayout.HORIZONTAL);
   				    Button b2=new Button(Home_activity.this);
   				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
   				    b2.setText("HappyTrips");
   				    b2.setOnClickListener(Home_activity.this);
   				    la.addView(b2);
   				    Button b3=new Button(Home_activity.this);
   					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
   					b3.setText("RedBus");
   					b3.setOnClickListener(Home_activity.this);
   					la.addView(b3);
   					
   					LinearLayout lb=new LinearLayout(Home_activity.this);
   				    lb.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
   				    lb.setOrientation(LinearLayout.HORIZONTAL);
   				    Button b4=new Button(Home_activity.this);
   				    b4.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
   				    b4.setText("Uber");
   				    b4.setOnClickListener(Home_activity.this);
   				    lb.addView(b4);
   				    Button b5=new Button(Home_activity.this);
   					b5.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
   					b5.setText("Ola");
   					b5.setOnClickListener(Home_activity.this);
   					lb.addView(b5);
   				       
   				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
   				   layout.addView(l);
   				   layout.addView(la);
   				   layout.addView(lb);
   				   SharedPreferences.Editor editor = prefs.edit();
   				   editor.putBoolean("firstTime", true);
   				   editor.commit();
   				}
   				else{
   					SharedPreferences.Editor editor = prefs.edit();
   				    editor.putBoolean("firstTime", false);
   				    editor.commit();
   					layout.removeAllViews();
   				}
   			}
   		});
           
           findViewById(R.id.button_socialmedia).setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View v) {
      				// TODO Auto-generated method stub
      				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_socialmedia);
      				if (!prefs.getBoolean("firstTime", false)) {
      					layout.removeAllViews();
      					LinearLayout l=new LinearLayout(Home_activity.this);
      			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      			        l.setOrientation(LinearLayout.HORIZONTAL);
      			        Button b=new Button(Home_activity.this);
      			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      			        b.setText("Facebook");
      			        b.setOnClickListener(Home_activity.this);
      			        l.addView(b);
      			        Button b1=new Button(Home_activity.this);
      				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b1.setText("Twitter");
      				    b1.setOnClickListener(Home_activity.this);
      				    l.addView(b1);
      				       
      				    LinearLayout la=new LinearLayout(Home_activity.this);
      				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      				    la.setOrientation(LinearLayout.HORIZONTAL);
      				    Button b2=new Button(Home_activity.this);
      				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b2.setText("LinkedIn");
      				    b2.setOnClickListener(Home_activity.this);
      				    la.addView(b2);
      				    Button b3=new Button(Home_activity.this);
      					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      					b3.setText("Google Plus");
      					b3.setOnClickListener(Home_activity.this);
      					la.addView(b3);
      					
      					LinearLayout lb=new LinearLayout(Home_activity.this);
      				    lb.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      				    lb.setOrientation(LinearLayout.HORIZONTAL);
      				    Button b4=new Button(Home_activity.this);
      				    b4.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b4.setText("Instagram");
      				    b4.setOnClickListener(Home_activity.this);
      				    lb.addView(b4);
      				    Button b5=new Button(Home_activity.this);
      					b5.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      					b5.setText("Hike");
      					b5.setOnClickListener(Home_activity.this);
      					lb.addView(b5);
      				       
      				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				   layout.addView(l);
      				   layout.addView(la);
      				   layout.addView(lb);
      				   SharedPreferences.Editor editor = prefs.edit();
      				   editor.putBoolean("firstTime", true);
      				   editor.commit();
      				}
      				else{
      					SharedPreferences.Editor editor = prefs.edit();
      				    editor.putBoolean("firstTime", false);
      				    editor.commit();
      					layout.removeAllViews();
      				}
      			}
      		});
           
           findViewById(R.id.button_email).setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View v) {
      				// TODO Auto-generated method stub
      				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_email);
      				if (!prefs.getBoolean("firstTime", false)) {
      					layout.removeAllViews();
      					LinearLayout l=new LinearLayout(Home_activity.this);
      			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      			        l.setOrientation(LinearLayout.HORIZONTAL);
      			        Button b=new Button(Home_activity.this);
      			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      			        b.setText("Yahoo");
      			        b.setOnClickListener(Home_activity.this);
      			        l.addView(b);
      			        Button b1=new Button(Home_activity.this);
      				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b1.setText("Gmail");
      				    b1.setOnClickListener(Home_activity.this);
      				    l.addView(b1);
      				       
      				    LinearLayout la=new LinearLayout(Home_activity.this);
      				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      				    la.setOrientation(LinearLayout.HORIZONTAL);
      				    Button b2=new Button(Home_activity.this);
      				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b2.setText("Outlook");
      				    b2.setOnClickListener(Home_activity.this);
      				    la.addView(b2);
      				    Button b3=new Button(Home_activity.this);
      					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      					b3.setText("Yandex Mail");
      					b3.setOnClickListener(Home_activity.this);
      					la.addView(b3);
      					
      					
      				       
      				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				   layout.addView(l);
      				   layout.addView(la);
      				   
      				   SharedPreferences.Editor editor = prefs.edit();
      				   editor.putBoolean("firstTime", true);
      				   editor.commit();
      				}
      				else{
      					SharedPreferences.Editor editor = prefs.edit();
      				    editor.putBoolean("firstTime", false);
      				    editor.commit();
      					layout.removeAllViews();
      				}
      			}
      		});
           
           findViewById(R.id.button_job).setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View v) {
      				// TODO Auto-generated method stub
      				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_job);
      				if (!prefs.getBoolean("firstTime", false)) {
      					layout.removeAllViews();
      					LinearLayout l=new LinearLayout(Home_activity.this);
      			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      			        l.setOrientation(LinearLayout.HORIZONTAL);
      			        Button b=new Button(Home_activity.this);
      			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      			        b.setText("Nokri");
      			        b.setOnClickListener(Home_activity.this);
      			        l.addView(b);
      			        Button b1=new Button(Home_activity.this);
      				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b1.setText("Indeed");
      				    b1.setOnClickListener(Home_activity.this);
      				    l.addView(b1);
      				       
      				    LinearLayout la=new LinearLayout(Home_activity.this);
      				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      				    la.setOrientation(LinearLayout.HORIZONTAL);
      				    Button b2=new Button(Home_activity.this);
      				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b2.setText("CareerBuilder");
      				    b2.setOnClickListener(Home_activity.this);
      				    la.addView(b2);
      				    Button b3=new Button(Home_activity.this);
      					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      					b3.setText("Monster India");
      					b3.setOnClickListener(Home_activity.this);
      					la.addView(b3);
      					
      					
      				       
      				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				   layout.addView(l);
      				   layout.addView(la);
      				   SharedPreferences.Editor editor = prefs.edit();
      				   editor.putBoolean("firstTime", true);
      				   editor.commit();
      				}
      				else{
      					SharedPreferences.Editor editor = prefs.edit();
      				    editor.putBoolean("firstTime", false);
      				    editor.commit();
      					layout.removeAllViews();
      				}
      			}
      		});
           
           findViewById(R.id.button_buy_and_sell).setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View v) {
      				// TODO Auto-generated method stub
      				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_buy_and_sell);
      				if (!prefs.getBoolean("firstTime", false)) {
      					layout.removeAllViews();
      					LinearLayout l=new LinearLayout(Home_activity.this);
      			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      			        l.setOrientation(LinearLayout.HORIZONTAL);
      			        Button b=new Button(Home_activity.this);
      			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      			        b.setText("Amazon");
      			        b.setOnClickListener(Home_activity.this);
      			        l.addView(b);
      			        Button b1=new Button(Home_activity.this);
      				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b1.setText("Flipkart");
      				    b1.setOnClickListener(Home_activity.this);
      				    l.addView(b1);
      				       
      				    LinearLayout la=new LinearLayout(Home_activity.this);
      				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      				    la.setOrientation(LinearLayout.HORIZONTAL);
      				    Button b2=new Button(Home_activity.this);
      				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b2.setText("Ebay");
      				    b2.setOnClickListener(Home_activity.this);
      				    la.addView(b2);
      				    Button b3=new Button(Home_activity.this);
      					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      					b3.setText("ShopClues");
      					b3.setOnClickListener(Home_activity.this);
      					la.addView(b3);
      					
      					LinearLayout lb=new LinearLayout(Home_activity.this);
      				    lb.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      				    lb.setOrientation(LinearLayout.HORIZONTAL);
      				    Button b4=new Button(Home_activity.this);
      				    b4.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b4.setText("OLX");
      				    b4.setOnClickListener(Home_activity.this);
      				    lb.addView(b4);
      				    Button b5=new Button(Home_activity.this);
      					b5.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      					b5.setText("Quikr");
      					b5.setOnClickListener(Home_activity.this);
      					lb.addView(b5);
      				       
      				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				   layout.addView(l);
      				   layout.addView(la);
      				   layout.addView(lb);
      				   SharedPreferences.Editor editor = prefs.edit();
      				   editor.putBoolean("firstTime", true);
      				   editor.commit();
      				}
      				else{
      					SharedPreferences.Editor editor = prefs.edit();
      				    editor.putBoolean("firstTime", false);
      				    editor.commit();
      					layout.removeAllViews();
      				}
      			}
      		});
           findViewById(R.id.button_result).setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View v) {
      				// TODO Auto-generated method stub
      				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_result);
      				if (!prefs.getBoolean("firstTime", false)) {
      					layout.removeAllViews();
      					LinearLayout l=new LinearLayout(Home_activity.this);
      			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      			        l.setOrientation(LinearLayout.HORIZONTAL);
      			        Button b=new Button(Home_activity.this);
      			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      			        b.setText("IndiaResult");
      			        b.setOnClickListener(Home_activity.this);
      			        l.addView(b);
      			        Button b1=new Button(Home_activity.this);
      				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b1.setText("CBSE");
      				    b1.setOnClickListener(Home_activity.this);
      				    l.addView(b1);
      				       
      				    LinearLayout la=new LinearLayout(Home_activity.this);
      				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      				    la.setOrientation(LinearLayout.HORIZONTAL);
      				    Button b2=new Button(Home_activity.this);
      				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b2.setText("Results.gov.in");
      				    b2.setOnClickListener(Home_activity.this);
      				    la.addView(b2);
      				    Button b3=new Button(Home_activity.this);
      					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      					b3.setText("RTU Result");
      					b3.setOnClickListener(Home_activity.this);
      					la.addView(b3);
      					
      					
      				       
      				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				   layout.addView(l);
      				   layout.addView(la);
      				   SharedPreferences.Editor editor = prefs.edit();
      				   editor.putBoolean("firstTime", true);
      				   editor.commit();
      				}
      				else{
      					SharedPreferences.Editor editor = prefs.edit();
      				    editor.putBoolean("firstTime", false);
      				    editor.commit();
      					layout.removeAllViews();
      				}
      			}
      		});
           
           findViewById(R.id.button_video).setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View v) {
      				// TODO Auto-generated method stub
      				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_video);
      				if (!prefs.getBoolean("firstTime", false)) {
      					layout.removeAllViews();
      					LinearLayout l=new LinearLayout(Home_activity.this);
      			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      			        l.setOrientation(LinearLayout.HORIZONTAL);
      			        Button b=new Button(Home_activity.this);
      			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      			        b.setText("Youtube");
      			        b.setOnClickListener(Home_activity.this);
      			        l.addView(b);
      			        Button b1=new Button(Home_activity.this);
      				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b1.setText("Tubidy");
      				    b1.setOnClickListener(Home_activity.this);
      				    l.addView(b1);
      				       
      				    LinearLayout la=new LinearLayout(Home_activity.this);
      				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
      				    la.setOrientation(LinearLayout.HORIZONTAL);
      				    Button b2=new Button(Home_activity.this);
      				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      				    b2.setText("DailyMotion");
      				    b2.setOnClickListener(Home_activity.this);
      				    la.addView(b2);
      				    Button b3=new Button(Home_activity.this);
      					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
      					b3.setText("Vuclip");
      					b3.setOnClickListener(Home_activity.this);
      					la.addView(b3);
      					
      					
      				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
      				   layout.addView(l);
      				   layout.addView(la);
      				   SharedPreferences.Editor editor = prefs.edit();
      				   editor.putBoolean("firstTime", true);
      				   editor.commit();
      				}
      				else{
      					SharedPreferences.Editor editor = prefs.edit();
      				    editor.putBoolean("firstTime", false);
      				    editor.commit();
      					layout.removeAllViews();
      				}
      			}
      		});
           findViewById(R.id.button_movie).setOnClickListener(new OnClickListener() {
     			
     			@Override
     			public void onClick(View v) {
     				// TODO Auto-generated method stub
     				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
     				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_movie);
     				if (!prefs.getBoolean("firstTime", false)) {
     					layout.removeAllViews();
     					LinearLayout l=new LinearLayout(Home_activity.this);
     			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
     			        l.setOrientation(LinearLayout.HORIZONTAL);
     			        Button b=new Button(Home_activity.this);
     			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     			        b.setText("MovieWatcher");
     			        b.setOnClickListener(Home_activity.this);
     			        l.addView(b);
     			        Button b1=new Button(Home_activity.this);
     				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     				    b1.setText("MyDownloadtube");
     				    b1.setOnClickListener(Home_activity.this);
     				    l.addView(b1);
     				       
     				    
     				       
     				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
     				   layout.addView(l);
     				   SharedPreferences.Editor editor = prefs.edit();
     				   editor.putBoolean("firstTime", true);
     				   editor.commit();
     				}
     				else{
     					SharedPreferences.Editor editor = prefs.edit();
     				    editor.putBoolean("firstTime", false);
     				    editor.commit();
     					layout.removeAllViews();
     				}
     			}
     		});
           findViewById(R.id.button_software).setOnClickListener(new OnClickListener() {
     			
     			@Override
     			public void onClick(View v) {
     				// TODO Auto-generated method stub
     				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
     				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_software);
     				if (!prefs.getBoolean("firstTime", false)) {
     					layout.removeAllViews();
     					LinearLayout l=new LinearLayout(Home_activity.this);
     			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
     			        l.setOrientation(LinearLayout.HORIZONTAL);
     			        Button b=new Button(Home_activity.this);
     			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     			        b.setText("Cnet");
     			        b.setOnClickListener(Home_activity.this);
     			        l.addView(b);
     			        Button b1=new Button(Home_activity.this);
     				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     				    b1.setText("Softpedia");
     				    b1.setOnClickListener(Home_activity.this);
     				    l.addView(b1);
     				       
     				    LinearLayout la=new LinearLayout(Home_activity.this);
     				    la.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
     				    la.setOrientation(LinearLayout.HORIZONTAL);
     				    Button b2=new Button(Home_activity.this);
     				    b2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     				    b2.setText("Softonic");
     				    b2.setOnClickListener(Home_activity.this);
     				    la.addView(b2);
     				    Button b3=new Button(Home_activity.this);
     					b3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     					b3.setText("Brothersoft");
     					b3.setOnClickListener(Home_activity.this);
     					la.addView(b3);
     					
     					
     				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
     				   layout.addView(l);
     				   layout.addView(la);
     				   SharedPreferences.Editor editor = prefs.edit();
     				   editor.putBoolean("firstTime", true);
     				   editor.commit();
     				}
     				else{
     					SharedPreferences.Editor editor = prefs.edit();
     				    editor.putBoolean("firstTime", false);
     				    editor.commit();
     					layout.removeAllViews();
     				}
     			}
     		});
           findViewById(R.id.button_games).setOnClickListener(new OnClickListener() {
     			
     			@Override
     			public void onClick(View v) {
     				// TODO Auto-generated method stub
     				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
     				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_games);
     				if (!prefs.getBoolean("firstTime", false)) {
     					layout.removeAllViews();
     					LinearLayout l=new LinearLayout(Home_activity.this);
     			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
     			        l.setOrientation(LinearLayout.HORIZONTAL);
     			        Button b=new Button(Home_activity.this);
     			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     			        b.setText("Y8 Games");
     			        b.setOnClickListener(Home_activity.this);
     			        l.addView(b);
     			        Button b1=new Button(Home_activity.this);
     				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     				    b1.setText("yahoo games");
     				    b1.setOnClickListener(Home_activity.this);
     				    l.addView(b1);
     				       
     				    
     				       
     				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
     				   layout.addView(l);
     				   SharedPreferences.Editor editor = prefs.edit();
     				   editor.putBoolean("firstTime", true);
     				   editor.commit();
     				}
     				else{
     					SharedPreferences.Editor editor = prefs.edit();
     				    editor.putBoolean("firstTime", false);
     				    editor.commit();
     					layout.removeAllViews();
     				}
     			}
     		});
           findViewById(R.id.button_song).setOnClickListener(new OnClickListener() {
     			
     			@Override
     			public void onClick(View v) {
     				// TODO Auto-generated method stub
     				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
     				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_song);
     				if (!prefs.getBoolean("firstTime", false)) {
     					layout.removeAllViews();
     					LinearLayout l=new LinearLayout(Home_activity.this);
     			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
     			        l.setOrientation(LinearLayout.HORIZONTAL);
     			        Button b=new Button(Home_activity.this);
     			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     			        b.setText("IndiaMp3");
     			        b.setOnClickListener(Home_activity.this);
     			        l.addView(b);
     			        Button b1=new Button(Home_activity.this);
     				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
     				    b1.setText("SongsPK");
     				    b1.setOnClickListener(Home_activity.this);
     				    l.addView(b1);
     				       
     				    
     				       
     				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
     				   layout.addView(l);
     				   SharedPreferences.Editor editor = prefs.edit();
     				   editor.putBoolean("firstTime", true);
     				   editor.commit();
     				}
     				else{
     					SharedPreferences.Editor editor = prefs.edit();
     				    editor.putBoolean("firstTime", false);
     				    editor.commit();
     					layout.removeAllViews();
     				}
     			}
     		});
           findViewById(R.id.button_amazing_site).setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				//Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
    				LinearLayout layout=(LinearLayout)findViewById(R.id.layout_amazing_site);
    				if (!prefs.getBoolean("firstTime", false)) {
    					layout.removeAllViews();
    					LinearLayout l=new LinearLayout(Home_activity.this);
    			        l.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
    			        l.setOrientation(LinearLayout.HORIZONTAL);
    			        Button b=new Button(Home_activity.this);
    			        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
    			        b.setText("Internet Map");
    			        b.setOnClickListener(Home_activity.this);
    			        l.addView(b);
    			        Button b1=new Button(Home_activity.this);
    				    b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
    				    b1.setText("Zoomquilt");
    				    b1.setOnClickListener(Home_activity.this);
    				    l.addView(b1);
    				       
    				    
    				       
    				   //Toast.makeText(Home_activity.this, "test news", Toast.LENGTH_SHORT).show();
    				   layout.addView(l);
    				   SharedPreferences.Editor editor = prefs.edit();
    				   editor.putBoolean("firstTime", true);
    				   editor.commit();
    				}
    				else{
    					SharedPreferences.Editor editor = prefs.edit();
    				    editor.putBoolean("firstTime", false);
    				    editor.commit();
    					layout.removeAllViews();
    				}
    			}
    		});
           
		
		}

	
	private void setAppFont(LinearLayout l, Typeface tf) {
		// TODO Auto-generated method stub
		if (l == null || tf == null)
		return;

	    final int mCount = l.getChildCount();

	    // Loop through all of the children.
	    for (int i = 0; i < mCount; ++i) {
	        final View mChild = l.getChildAt(i);
	        if (mChild instanceof TextView) {
	            // Set the font if it is a TextView.
	            ((TextView) mChild).setTypeface(tf);
	        } else if (mChild instanceof ViewGroup) {
	            // Recursively attempt another ViewGroup.
	            setAppFont( (LinearLayout)mChild, tf);
	        }

	    }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_activity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.home) {
			return true;
		}
		if (id == R.id.download) {
			Intent startDM=new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
            startActivity(startDM);
			
			/*Intent intent=new Intent(this,Download.class);
			startActivity(intent);*/
			
			return true;
		}
		if (id == R.id.bookmark) {
			startActivity(new Intent(this,Bookmark.class));
			return true;
		}if (id == R.id.history) {
			startActivity(new Intent(this,History.class));
			return true;
		}if (id == R.id.share) {
			Intent sendIntent = new Intent();
        	sendIntent.setAction(Intent.ACTION_SEND);
        	sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my url");
        	sendIntent.setType("text/plain");
        	startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
			
			return true;
		}
		if (id == R.id.action_settings) {
			//startActivity(new Intent(this,SettingsActivity.class));
			return true;
		}
		if (id == R.id.action_aboutUs) {
			startActivity(new Intent(this,AboutUs.class));
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Button btn=(Button)v;
		String site=btn.getText()+"";
		Toast.makeText(this, site, Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(Home_activity.this,MainActivity.class);
		intent.putExtra("address","https://"+hmsites_button.get(site));
		startActivity(intent);
	}
}
