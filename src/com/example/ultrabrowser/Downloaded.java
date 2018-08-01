package com.example.ultrabrowser;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Downloaded extends Fragment {


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		/* We inflate the xml which gives us a view */
		 return inflater.inflate(
		            R.layout.downloaded, container, false);	}
    
}
