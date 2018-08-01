package com.example.ultrabrowser;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;


public class MyBrowser extends WebViewClient {
	
	EditText edittext;
	Activity activity;
	ProgressBar progressbar;
	SQLiteDatabase sqlitedatabase;
	
	public MyBrowser(MainActivity mainActivity) {
		// TODO Auto-generated constructor stub
		activity=mainActivity;
		MyDatabase mydatabase=new MyDatabase(activity.getApplicationContext());
		sqlitedatabase=mydatabase.getWritableDatabase();
	}
     
   @Override
     public void onPageStarted(WebView view, String url, Bitmap favicon) {
         	// TODO Auto-generated method stub
        	super.onPageStarted(view, url, favicon);
        	progressbar=(ProgressBar)activity.findViewById(R.id.progressBar1);
        	
        	progressbar.setProgress(100);
        	
        	
        	
     }
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		edittext=(EditText)activity.findViewById(R.id.editText1);
		edittext.setText(url);
		
		
		Calendar c = Calendar.getInstance();
		 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = df.format(c.getTime());
		
		view.loadUrl(url);
		sqlitedatabase.execSQL("insert into history values('"+url+"','"+formattedDate+"')");
		
		return super.shouldOverrideUrlLoading(view, url);
	}
	
	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		
		super.onPageFinished(view, url);
		
	}
	

}
