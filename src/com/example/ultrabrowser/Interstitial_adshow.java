package com.example.ultrabrowser;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;

public class Interstitial_adshow {
	InterstitialAd mInterstitialAd;
	public Interstitial_adshow(Activity aptitude, InterstitialAd mInterstitialAds) {
		// TODO Auto-generated constructor stub
		mInterstitialAd=mInterstitialAds;
		mInterstitialAd = new InterstitialAd(aptitude);
		
        mInterstitialAd.setAdUnitId("5a1052e2a30c3b1c882dc8d5");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
       
        mInterstitialAd.setAdListener(new AdListener() {

			@Override
			public void onAdLoaded() {
				// TODO Auto-generated method stub
				super.onAdLoaded();
				mInterstitialAd.show();
				
				
			}
			 
		});
        
	}

}
