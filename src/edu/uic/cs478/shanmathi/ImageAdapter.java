package edu.uic.cs478.shanmathi;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/* ImageAdapter class which extends BaseAdapter - Common base 
 * class of common implementation for an Adapter that can be 
 * used in GridView
 */

public class ImageAdapter extends BaseAdapter {
	
	// Padding for the images
	private static final int PADDING = 10;
	
	// Width of images in the GridView
	private static final int WIDTH = 350;
	
	// Height of images in the GridView
	private static final int HEIGHT = 350;
	
	// Context Interface provides global information about an application environment
	private Context mContext;
	
	// List of image thumbnails that appear in the GridView
	private List<Integer> mThumbIds;
	
	// Store the list of image IDs  and Context
	public ImageAdapter(Context c, List<Integer> ids) {
		mContext = c;
		this.mThumbIds = ids;
	}

	// getCount returns the number of items in the Adapter
	@Override
	public int getCount() {
		return mThumbIds.size();
	}

	// getItem returns the data item at position that is passed
	@Override
	public Object getItem(int position) {
        if (mThumbIds != null )
        	
        	// returns the data item at position that is passed
        	return mThumbIds.get(position);
         else 
            return "";
        
	}

	//getItemId is called to provide the ID that is passed to OnItemClickListener.onItemClick()
	@Override
	public long getItemId(int position) {
		return mThumbIds.get(position);
	}

	// getView returns an ImageView for each item referenced by the Adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView = (ImageView) convertView;

		// if convertView's not recycled, initialize some attributes
		if (imageView == null) {
			imageView = new ImageView(mContext);
			
			// Set the layout parameters associated with this view
			imageView.setLayoutParams(new GridView.LayoutParams(WIDTH, HEIGHT));
			
			/* Sets the padding. The view may add on the space required to display 
			 * the scrollbars, depending on the style and visibility of 
			 * the scrollbars
			 */
			imageView.setPadding(PADDING, PADDING, PADDING, PADDING);
			
			/* Controls how the image should be resized or moved to match
			 *  the size of this ImageView
			 */
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		}
		
		// Sets the drawable as the content of this ImageView
		imageView.setImageResource(mThumbIds.get(position));
		
		// Returns the imageView
		return imageView;
	}


}
