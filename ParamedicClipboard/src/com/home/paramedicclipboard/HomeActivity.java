package com.home.paramedicclipboard;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

import com.home.customarrayadapter.MyCustomArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import com.home.customarrayadapter.List_Item;
import com.home.dbcontroller.JsonParser;
import com.home.reports.Report;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	/* This ArrayList will hold all the reports of type Report */
	private ArrayList<Report> reportList = null;

	/* This ListView is the one used to display all the Reports */
	ListView listview;

	/* Use as a debug starter/stopper */
	private final boolean DEBUG = true;

	private MyCustomArrayAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);		
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		new ProgressTask(HomeActivity.this).execute();	    
	}

	/**
	 * This method initializes all the components needed for the activity
	 */
	private void initialize()
	{
		listview.setOnItemClickListener(new OnItemClickListener(){	
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

				/* Class to assist us in loading the activity */
				Class editClass = null;
				try {
					editClass = Class.forName("com.home.paramedicclipboard.DetailsActivity");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/* create bundle to pass the ID of the deck that was clicked */
				Bundle reportPassed = new Bundle();
				//reportPassed.putInt("Report", reportList.get(4).getId());
				reportPassed.putSerializable("report", reportList.get(position));

				/* Start the new intent and also pass a bundle that will contain the name of the card that was clicked */
				Intent ourIntent = new Intent(HomeActivity.this, editClass);
				ourIntent.putExtras(reportPassed);//passing the bundle to the activity
				//start the activity
				startActivity(ourIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.home, menu);
	    return true;
	}

	/* Create the list of objects of type List_Item, in our case it will be Decks */
	private List<List_Item> getListEntries(){

		/* Create an ArrayList of List_Items */
		final ArrayList<List_Item> entries = new ArrayList<List_Item>();

		if(reportList == null || reportList.isEmpty())
			loadReportList();

		/* Create the rows for the ListView by adding them into the ArrayList "entries".
		 * reportList is a global ArrayList<Report> that we populate by a method call to the class JsonParser.
		 * Look above.
		 * */
		for(int i = 0; i < reportList.size(); i++) {
			if(DEBUG)Log.i("getListEntries HomeActivity","Passing through reportlistEntries");
			entries.add(
					new List_Item(((Report)reportList.get(i)).getType(), Integer.toString(((Report)reportList.get(i)).getId()), ((Report)reportList.get(i)).getId())
					);
		}
		return entries;
	}

	//This method loads the reportList arraylist with all Report objects
	void loadReportList(){
		try {
			reportList = new JsonParser().getArrayList();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	//This class is an Async class that handles the data downloading + showing the loading little view
	private class ProgressTask extends AsyncTask<String, Void, Boolean> {
		private ProgressDialog dialog;
		private Activity activity;
		
		public ProgressTask(Activity activity) {
			this.activity = activity;
			context = activity;
			dialog = new ProgressDialog(context);
		}

		/** progress dialog to show user that the backup is processing. */

		/** application context. */
		private Context context;
		
		//this executes whenever the view is started.
		protected void onPreExecute() {
			
			//if the data has already been loaded, 
			//when coming back to the app, the loading window will not show again
			if(reportList == null)
			{
				this.dialog.setMessage("Loading Data");
				this.dialog.show();
			}
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			/* Get a reference of the listview in our xml view */
			listview = (ListView) findViewById(R.id.reportsList);

			/**
			 * Create the customer adapter and pass the current Context and the layout that it should use.
			 *  Look in class MyCustomArrayAdapter 
			 */
			adapter = new MyCustomArrayAdapter(HomeActivity.this, R.layout.single_listview_row);

			try{
				// Populate the list, through the adapter	
				for(final List_Item entry : getListEntries()) {
					adapter.add(entry);
					if(DEBUG)Log.i("HomeActivity","in adding List_Item entries to the adapter");
				}
			}catch(Exception e){
				Log.i("In initialize() HomeActivity","Could not load the list with entries");

				loadReportList();
			}

			listview.setAdapter(adapter);

			if (dialog.isShowing()) {
				dialog.dismiss();
			}

			if (success) {
				//Toast.makeText(context, "Data Loaded", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, "Error Loading Data", Toast.LENGTH_LONG).show();
			}

			//call to initialize the rest of the view
			initialize();
		}

		//this is done in the background to load data.
		protected Boolean doInBackground(final String... args) {
			try{    
				reportList = new JsonParser().getArrayList();
				return true;
			} catch (Exception e){
				Log.e("tag", "error", e);
				return false;
			}
		}
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, HomeActivity.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}
