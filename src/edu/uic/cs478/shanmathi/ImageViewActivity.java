package edu.uic.cs478.shanmathi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;

// ImageViewActivity class extends Activity
public class ImageViewActivity extends Activity {
	
	// onCreate is called when the activity is starting
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	
		// Get the Intent used to start this Activity
		Intent intent = getIntent();
		
		// Make a new ImageView
		ImageView imageView = new ImageView(getApplicationContext());
		
		// Get the ID of the image to display and set it as the image for this ImageView
		imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0));
		
		// Set the activity content to an explicit view - imageView in this case
		setContentView(imageView);
	}
}