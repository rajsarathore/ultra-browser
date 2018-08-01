package com.example.ultrabrowser;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Downlaoding extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		/* We inflate the xml which gives us a view */
		 return inflater.inflate(
		            R.layout.downloading, container, false);	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Activity act=getActivity();
	//	act.findViewById(id)
		super.onStart();
	}



    
}
