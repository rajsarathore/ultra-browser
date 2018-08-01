package com.example.ultrabrowser;

import android.R.drawable;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Download extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		ActionBar actionBar = getActionBar();
	       ActionBar.Tab t= actionBar.newTab();
	       t.setText("Downloading");
	       t.setIcon(drawable.btn_star_big_on);
	       t.setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "Downloading", 0).show();
			}
			
			@Override
			public void onTabSelected(Tab tab, 
					FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Downlaoding dwnld=new Downlaoding();
				ft.replace(R.id.frm1, dwnld);
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "make new view from tab1", 0).show();
				
			}
		});
	       ActionBar.Tab t1= actionBar.newTab();
	       t1.setText("Downloaded");
	       t1.setIcon(drawable.btn_star_big_on);
	       t1.setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "downloaded", 0).show();
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Downloaded f=new Downloaded();
				ft.replace(R.id.frm1, f);
				
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "make new view from tab2", 0).show();
			}
		});
	       actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	       actionBar.addTab(t);
	       actionBar.addTab(t1);
	       
	      //  actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.download, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
