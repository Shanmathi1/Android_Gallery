
/*
 * Project : CS478 - Software Development for Mobile Platforms
 * Developed By : Shanmathi Mayuram Krithivasan (smayur3@uic.edu)
 * Developed On : 20th Febraury 2015
 */

package edu.uic.cs478.shanmathi;

import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.GridView;



public class MainActivity extends Activity {

	// Postion of the image in the GridView
	protected static final String EXTRA_RES_ID = "POS";
	
	// Declare an ArrayList of Car images which appears as thumbnails in the GridView
	private ArrayList<Integer> mThumbNailsCars = new ArrayList<Integer>(
			Arrays.asList(R.drawable.image1, R.drawable.image2,
					R.drawable.image3, R.drawable.image4, R.drawable.image5,
					R.drawable.image6, R.drawable.image7, R.drawable.image8,
					R.drawable.image9, R.drawable.image10, R.drawable.image11,
					R.drawable.image12, R.drawable.image13, R.drawable.image14, 
					R.drawable.image15));
	
	// Create an Object of ImageAdapter class
	final ImageAdapter imageadapter = new ImageAdapter(this, mThumbNailsCars);
	
	/*
	 * onCreate(Bundle) is where the activity is initailized. It calls
	 * setContentView(int) with a layout resource defining the UI and using
	 * findViewById(int) to retrieve the widgets in that UI that you need to
	 * interact with programmatically.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		// Call onCreate(savedInstanceState) from Activity class
		super.onCreate(savedInstanceState);
		
		// Set the activity content from a layout activity_main
		setContentView(R.layout.main);

		// Finds a view that was identified by the id attribute 
		GridView gridview = (GridView) findViewById(R.id.gridview);
	
		
		// Create a new ImageAdapter and set it as the Adapter for this GridView
		gridview.setAdapter(imageadapter);
		registerForContextMenu(gridview);
	
		// Set an setOnItemClickListener on the GridView
		gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(MainActivity.this,
						ImageViewActivity.class);
				
				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(EXTRA_RES_ID, (int) id);
				
				// Start the ImageViewActivity
				startActivity(intent); 
			}
		});
	
	}

		// Called when a context menu for the view is about to be shown
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
			super.onCreateContextMenu(menu, v, menuInfo);
			
			// This class is used to instantiate menu XML files into Menu objects
			MenuInflater inflater = getMenuInflater();
			
			// Inflate a menu hierarchy from the specified XML resource.
			inflater.inflate(R.menu.context_menu, menu);
		}
		
		@Override
		public boolean onContextItemSelected(MenuItem item) {
			
			// Extra menu information provided to callback when a context menu is brought up for this AdapterView.
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
			
			// Operations are performed based on the menu selected in the ContextMenu
			switch (item.getItemId()) {
			
			// Operation to be performed if View Image menu option is selected in the ContextMenu
			case R.id.view:
				  
				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(MainActivity.this,
						ImageViewActivity.class);
				
				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(EXTRA_RES_ID, (int) info.id);
			
				// Start the ImageViewActivity
				startActivity(intent); 

				return true;
			
			// Operation to be performed if View WebPage option is selected in the ContextMenu
			case R.id.page: 

				String url = null;
				
				/* WebPage is opened based on the GridView image that is selected 
				 * 0 to 13 are the image positions in the GridView
				 * Based on the position the appropriate web page appears in the Web Browser
				 */
				
				switch(info.position) {
				
				// Image 1 is clicked in the GridView
				case 0:					
					url = "http://www.audiusa.com/models/audi-r8";
					break;
				// Image 2 is clicked in the GridView
				case 1: 
					url = "http://www.landroverusa.com/our-story/news/range-rover-sport-svr.html";
					break;
				// Image 3 is clicked in the GridView
				case 2:
					url = "http://www.jaguarusa.com/all-models/f-type/overview";
					break;
				// Image 4 is clicked in the GridView
				case 3:
					url = "http://www.bmw.com/com/en/newvehicles/i/i8/2014/showroom/";
					break;
				// Image 5 is clicked in the GridView
				case 4:
					url = "http://www.peugeot.com/en/design/concept-cars/peugeot-onyx-car";
					break;
				// Image 6 is clicked in the GridView
				case 5: 
					url = "http://www.porsche.com/usa/models/boxster/boxster/";
					break;
				// Image 7 is clicked in the GridView
				case 6:
					url = "http://www.cadillac.com/vehicle-lineup.html";
					break;
				// Image 8 is clicked in the GridView
				case 7:
					url = "http://www.bugatti.com/en/les-legendes/ettore-bugatti.html";
					break;
				// Image 9 is clicked in the GridView
				case 8:
					url = "http://cars.mclaren.com/12c.html";
					break;
				// Image 10 is clicked in the GridView
				case 9: 
					url = "http://www.astonmartin.com/en-us/cars/the-new-vanquish";
					break;
				// Image 11 is clicked in the GridView
				case 10:
					url = "http://auto.ferrari.com/en_EN/sports-cars-models/car-range/laferrari/";
					break;
				// Image 12 is clicked in the GridView
				case 11:
					url = "http://www.lamborghini.com/en/models/aventador-lp-700-4/overview/";
					break;
				// Image 13 is clicked in the GridView
				case 12:
					url = "http://auto.ferrari.com/en_EN/sports-cars-models/car-range/f12-berlinetta/";
					break;
				// Image 14 is clicked in the GridView
				case 13:
					url = "http://www.bmwusa.com/standard/content/vehicles/2015/bmwi/default.aspx";
					break;			
				// Image 15 is clicked in the GridView
				case 14:
					url = "http://www.porsche.com/usa/models/918/918-spyder/";
					break;
				
				}
				
				// Create an Intent to start open the Web Browser and the appropriate URL
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				
				// Start the activity
				startActivity(i); 
				
				return true;
			
			default:
				return false;
			}	
			  
	}
		
}
