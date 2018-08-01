package com.example.ultrabrowser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Stack;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	TextView texturl;
	Button btn;
	ProgressBar progressbar;
	WebView webview;
	SQLiteDatabase sqLiteDatabase;
	public static ListActivity lista;
	Button btn_reload,btn_left,btn_right,btn_reload_down;
	
	InterstitialAd mInterstitialAd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		texturl=(TextView)findViewById(R.id.editText1);
		progressbar=(ProgressBar)findViewById(R.id.progressBar1);
		btn=(Button)findViewById(R.id.button1);
		sqLiteDatabase=(new MyDatabase(getApplicationContext())).getWritableDatabase();
		webview=(WebView)findViewById(R.id.webView1);
    	webview.setWebViewClient(new MyBrowser(this));
		
		webview.getSettings().setLoadsImagesAutomatically(true);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
	    texturl.setText(getIntent().getStringExtra("address"));
		webview.loadUrl(getIntent().getStringExtra("address"));
		
		webview.setWebChromeClient(new WebChromeClient(){
			
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				super.onProgressChanged(view, newProgress);
				progressbar.setProgress(newProgress);
			}
		});
		
		webview.setDownloadListener(new DownloadListener() {
			
			@Override
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,
					long contentLength) {
				// TODO Auto-generated method stub
				
				DownloadManager.Request request = new DownloadManager.Request(
	                    Uri.parse(url));

	            request.allowScanningByMediaScanner();
	            request.setMimeType(mimetype);
	            String nameofile=URLUtil.guessFileName(url, null, mimetype);
	            request.setTitle(nameofile);
	            
	            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
	            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,nameofile );
	           
	            DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
	            
	            dm.enqueue(request);
	            registerReceiver(new BroadcastReceiver() {
					
					@Override
					public void onReceive(Context context, Intent intent) {
						// TODO Auto-generated method stub
						 Intent startDM=new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
			            startActivity(startDM);
						
					}
				}, new IntentFilter(dm.ACTION_NOTIFICATION_CLICKED));
	            
	           
	            
	            Toast.makeText(getApplicationContext(), "Downloading File", //To notify the Client that the file is being downloaded
	                    Toast.LENGTH_LONG).show();
				
			}
		});
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = df.format(c.getTime());
		sqLiteDatabase.execSQL("insert into history values('"+getIntent().getStringExtra("address")+"','"+formattedDate+"')");
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str=texturl.getText()+"";
				webview.loadUrl(str);
				Calendar c = Calendar.getInstance();
				 
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String formattedDate = df.format(c.getTime());
				sqLiteDatabase.execSQL("insert into history values('"+str+"','"+formattedDate+"')");
				
			}
		});
		
		btn_left=(Button)findViewById(R.id.button_left);
		btn_reload_down=(Button)findViewById(R.id.button_reloaddown);
		btn_right=(Button)findViewById(R.id.button_right);
		btn_reload=(Button)findViewById(R.id.button_reload);
		
		btn_left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(webview.canGoBack()){
					webview.goBack();
				}
			}
		});
		
        btn_right.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(webview.canGoForward()){
					webview.goForward();
				}
			}
		});
        btn_reload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				webview.reload();
			}
		});
        btn_reload_down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				webview.reload();
			}
		});
		
		getActionBar().hide();
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
			if (keyCode == KeyEvent.KEYCODE_BACK ) {
				if(webview.canGoBack()){
					webview.goBack();
				
				//Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
				return true;
				}
				else
				 finish();
				
			}
				

			
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(id==R.id.forward){
			if(webview.canGoForward()){
				webview.goForward();
			}
		}
		if (id == R.id.prev) {
			if(webview.canGoBack()){
				webview.goBack();
			}
			else
				finish();
			
			return true;
		}
		if(id==R.id.AddBookMark){
			AlertDialog alertDialog = new AlertDialog.Builder(
					this).create();

		             
			          alertDialog.setTitle("Add Bookmark");
                      alertDialog.setMessage("Do you want to add bookmark this page?");
                      alertDialog.setIcon(android.R.drawable.btn_star);
                
			          alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"YES",
					                       new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							try{
								String url=webview.getUrl();
								String titile=webview.getTitle();
								Calendar c = Calendar.getInstance();
								SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String formattedDate = df.format(c.getTime());
								SQLiteDatabase sqlitedatabase;
								MyDatabase mydatabase=new MyDatabase(MainActivity.this);
								sqlitedatabase=mydatabase.getWritableDatabase();
								sqlitedatabase.execSQL("insert into bookmark values('"+titile+"','"+url+"','"+formattedDate+"')");
								Toast.makeText(MainActivity.this,titile+url+ " Page bookmarked...",Toast.LENGTH_LONG).show();
							}
							catch(Exception e){
								Toast.makeText(MainActivity.this, e.getMessage(),Toast.LENGTH_LONG).show();
							}
							
						}
					});
			          alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"NO",
		                       new DialogInterface.OnClickListener() {

			         public void onClick(DialogInterface dialog, int which) {
				           
				            
				            }
		            });

			// Showing Alert Message
			alertDialog.show();

	        return true;
		}
		if (id == R.id.home) {
			/*Intent intent=new Intent(this,Home_activity.class);
			startActivity(intent);*/
			finish();
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
		}if (id == R.id.action_settings) {
			//startActivity(new Intent(this,SettingsActivity.class));
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}

