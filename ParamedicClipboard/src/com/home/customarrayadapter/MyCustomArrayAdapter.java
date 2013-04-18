package com.home.customarrayadapter;

/*
 * This class is going to be implemented in any activity that uses a listview.
 * This adapter helps us to customize the way the listview items are presented.
 * This adapter displays a title and subtitle for each listview item. It can be
 * customized to show even more elements for each listview items.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adapts objects onto views for lists
 */
public final class MyCustomArrayAdapter extends ArrayAdapter<List_Item> {

	private final int itemLayoutResource;
	private final boolean DEBUG = false;

	public MyCustomArrayAdapter(final Context context, final int itemLayoutResource) {
		super(context, 0);
		this.itemLayoutResource = itemLayoutResource;
		if(DEBUG)Log.i("MyCustomArrayAdapter", "I am in the constructor after asigning newsItemsLayouResource");
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {

		// We need to get the best view (re-used if possible) and then
		// retrieve its corresponding ViewHolder, which optimizes lookup efficiency
		final View view = getWorkingView(convertView);
		final ViewHolder viewHolder = getViewHolder(view);

		if(DEBUG)Log.i("MyCustomArrayAdapter", "Viewholder.toString is " + viewHolder.toString());
		final List_Item entry = getItem(position);


		if(DEBUG)Log.i("MyCustomArrayAdapter", "Viewholder.toString is " + viewHolder.titleView.toString());

		// Set the title
		try{
			viewHolder.titleView.setText(entry.getTitle());
		}catch(Exception e)
		{
			Log.i("THE ERROR IS","" + e);
		}

		try{
			viewHolder.subTitleView.setText(entry.getSubtitle());
		}catch(Exception e)
		{
			Log.i("THE ERROR IS","" + e);
		}

		return view;
	}

	private View getWorkingView(final View convertView) {
		// The workingView is basically just the convertView re-used if possible
		// or inflated new if not possible
		View workingView = null;

		if(null == convertView) {
			final Context context = getContext();
			final LayoutInflater inflater = (LayoutInflater)context.getSystemService
					(Context.LAYOUT_INFLATER_SERVICE);

			workingView = inflater.inflate(itemLayoutResource, null);
		} else {
			workingView = convertView;
		}

		return workingView;
	}

	/*  Viewholder is the xml file that will represent each row */
	private ViewHolder getViewHolder(final View workingView) {
		// The viewHolder allows us to avoid re-looking up view references
		// Since views are recycled, these references will never change
		final Object tag = workingView.getTag();
		ViewHolder viewHolder = null;


		if(null == tag || !(tag instanceof ViewHolder)) {
			viewHolder = new ViewHolder();
			if(DEBUG)Log.i("MyCustomArrayAdapter", "getViewHolder gets called this many times");
			viewHolder.titleView = (TextView) workingView.findViewById(com.home.paramedicclipboard.R.id.title);
			viewHolder.subTitleView = (TextView) workingView.findViewById(com.home.paramedicclipboard.R.id.subtitle);
			workingView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) tag;
		}

		return viewHolder;
	}

	/**
	 * ViewHolder allows us to avoid re-looking up view references
	 * Since views are recycled, these references will never change
	 */
	private static class ViewHolder {
		public TextView titleView;
		public TextView subTitleView;
	}
}
