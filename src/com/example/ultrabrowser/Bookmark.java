package com.example.ultrabrowser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast; 

public class Bookmark extends Activity {
	
	EditText title,url;//use for dialog box on edit manu button 
	ListModel tempValues;// use for edit and delete manu button
	
	ListView bookmark_listview;
	CustomAdapter adapter;
    public  Bookmark CustomListView = null;
    public  ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bookmark);
		bookmark_listview=(ListView)findViewById(R.id.bookmark_listview);
		try{
		SQLiteDatabase sqlitedatabase=(new MyDatabase(this)).getReadableDatabase();
		Cursor cursor=sqlitedatabase.rawQuery("select * from bookmark", null);
		CustomListView = this;
        
        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
       
		while(cursor.moveToNext()){
			
			
			final ListModel sched = new ListModel();
            
            /******* Firstly take data in model object ******/
             sched.setTitle(cursor.getString(0));
             sched.setURL(cursor.getString(1));
             sched.setTime(cursor.getString(2));
              
          /******** Take Model Object in ArrayList **********/
          CustomListViewValuesArr.add( sched );
		
		}
		}catch(Exception e){
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		Resources res =getResources();         
        /**************** Create Custom Adapter *********/
        adapter=new CustomAdapter( CustomListView, CustomListViewValuesArr,res );
        bookmark_listview.setAdapter( adapter );
	}
	/*****************  This function used by adapter ****************/
    public void onItemClick(int mPosition)
    {
        ListModel tempValues = ( ListModel ) CustomListViewValuesArr.get(mPosition);


       // SHOW ALERT       
        Intent intent=new Intent(this,MainActivity.class);
		intent.putExtra("address",tempValues.getUrl());
		startActivity(intent);
		

        Toast.makeText(getApplicationContext(), ""+tempValues.getTitle()+"\nUrl:"+tempValues.getUrl()+" \nTime "+tempValues.getTime(), 
        		Toast.LENGTH_LONG).show();
        finish();
    }
	public void onManuClickAction(int pos, int item) {
		// TODO Auto-generated method stub
		tempValues = ( ListModel ) CustomListViewValuesArr.get(pos);
		switch (item) {
		case 0:
			LinearLayout layout;
			layout=new LinearLayout(this);
			layout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			layout.setOrientation(LinearLayout.VERTICAL);
			TextView dialog_title=new TextView(this);
			dialog_title.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			dialog_title.setText("Edit Bookmark");
			dialog_title.setTextSize(25);
			Typeface tf=Typeface.createFromAsset(getAssets(), "FORTE.TTF");
			dialog_title.setTypeface(tf);
			dialog_title.setTextColor(Color.WHITE);
			dialog_title.setBackgroundColor(Color.BLUE);
			layout.addView(dialog_title);
			
			title=new EditText(this);
			url=new EditText(this);
			title.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));;
			url.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));;
			title.setText(tempValues.getTitle());
			url.setText(tempValues.getUrl());
			layout.addView(title);
			layout.addView(url);
			
			AlertDialog dialog=new AlertDialog.Builder(this).create();
			dialog.setView(layout);
			dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Ok", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					SQLiteDatabase sqlitedatabase=(new MyDatabase(Bookmark.this)).getWritableDatabase();
					
					Calendar c = Calendar.getInstance();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String formattedDate = df.format(c.getTime());
					
					try{
					sqlitedatabase.execSQL("delete from bookmark where title='"+tempValues.getTitle()+"' "
							+ "and time='"+tempValues.getTime()+"'");
					
					sqlitedatabase.execSQL("insert into bookmark values('"+title.getText()+"','"+url.getText()+"','"+formattedDate+"')");
					title.getText();
					}catch(Exception e){
					Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
					Log.e("database Error", e.getMessage());
			       
					}
					Intent intent=new Intent(Bookmark.this,Bookmark.class);
					startActivity(intent);
					finish();
				}
			});
			dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Cancel",new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			dialog.show();
			break;
        case 1:
			SQLiteDatabase sqlitedatabase=(new MyDatabase(this)).getWritableDatabase();
			try{
			sqlitedatabase.execSQL("delete from bookmark where title='"+tempValues.getTitle()+"' "
					+ "and time='"+tempValues.getTime()+"'");
			}catch(Exception e){
			Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
			Log.e("database Error", e.getMessage());
	
			}
			
			Toast.makeText(this, tempValues.getTitle()+" is removed from bookmark",Toast.LENGTH_SHORT).show();
			Intent intent=new Intent(this,Bookmark.class);
			startActivity(intent);
			finish();
			break;

		}
		
	}
	
	

	
}
