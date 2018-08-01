package com.example.ultrabrowser;




import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper{

	public MyDatabase(Context context) {
		super(context, "browser", null, 124);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
     db.execSQL("create table history(url String,time String )");	
     db.execSQL("create table bookmark(title String,url String,time String )");
     
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//db.execSQL("create table question(qno String,question String,option1 string,option2 string,option3 string,option4 string)");
		
	}

}
