package com.example.newsfragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class DetailsActivity extends FragmentActivity{
	
	private static String TAG = "DetailsActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		Log.i(TAG, "onCreate");
		
		if(getResources().getConfiguration().orientation 
				== Configuration.ORIENTATION_LANDSCAPE){
			// If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
			finish();
			return;
		}
		if(savedInstanceState == null){
			// During initial setup, plug in the details fragment.
            DetailsFragment details = new DetailsFragment();
            details.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(
                    android.R.id.content, details).commit();
		}
	}

}
