package com.example.ultrabrowser;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class History extends Activity implements OnClickListener {
    Button[] buttonview;
    TextView[] time;//date;
   // LinearLayout[] linearlayout;
    
    LinearLayout layout;
    SQLiteDatabase sqlitedatabase;
    int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		layout=(LinearLayout)findViewById(R.id.history_layout);
		MyDatabase mydatabase=new MyDatabase(getApplicationContext());
		sqlitedatabase=mydatabase.getReadableDatabase();
		try{
		Cursor cursor=sqlitedatabase.rawQuery("select * from history", null);
		
		buttonview=new Button[cursor.getCount()];
		time=new TextView[cursor.getCount()];
		/*date=new TextView[cursor.getCount()];
		linearlayout=new LinearLayout[cursor.getCount()];*/
		while(cursor.moveToNext()){
			
			buttonview[i]=new Button(this);
	        buttonview[i].setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));			        
            buttonview[i].setBackgroundResource(R.drawable.buttonfire);
            buttonview[i].setId(i);
            
       /*     linearlayout[i]=new LinearLayout(this);
            linearlayout[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
            linearlayout[i].setOrientation(LinearLayout.HORIZONTAL);
            linearlayout[i].setBackgroundColor(Color.GREEN);
            */
            
			time[i]=new TextView(this);
			time[i].setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));			        
            time[i].setGravity(Gravity.CENTER);
            time[i].setBackgroundColor(Color.GREEN);
            
           /* date[i]=new TextView(this);
			date[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));			        
            date[i].setGravity(Gravity.CENTER);
            
            linearlayout[i].addView(date[i]);
            linearlayout[i].addView(time[i]);
            */
            
			
			buttonview[i].setText(cursor.getString(0));
		//	date[i].setText("Date "+cursor.getString(1)+"      ");
			time[i].setText("Time   "+cursor.getString(1)+"       ");
			
			layout.addView(buttonview[i]);
			layout.addView(time[i]);
			//layout.addView(linearlayout[i]);
				
			buttonview[i].setOnClickListener(this);
			i++;
				
		    }
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Button btn;
		
		btn=(Button)findViewById(v.getId());
		String str=btn.getText()+"";
		//Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(this,MainActivity.class);
		intent.putExtra("address",str);
		startActivity(intent);
		finish();
		
	}
public void History_clear(View v){
	try{
	MyDatabase mydatabase=new MyDatabase(getApplicationContext());
	sqlitedatabase=mydatabase.getWritableDatabase();
	sqlitedatabase.execSQL("delete from history");
	Toast.makeText(this, "history cleared", Toast.LENGTH_LONG).show();
	finish();
	}
	catch(Exception e){
		Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
	}
}
	
	
}
