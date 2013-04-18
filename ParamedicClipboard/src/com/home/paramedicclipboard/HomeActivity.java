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
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


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
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();

		try {
			/* Create an object of type JsonParser and populate the Arraylist */
			reportList = new JsonParser().getArrayList();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize();
	}

	/**
	 * This method initializes all the components needed for the activity
	 */
	private void initialize()
	{
		
		/* Get a reference of the listview in our xml view */
		listview = (ListView) findViewById(R.id.reportsList);
		
		/**
		 * Create the customer adapter and pass the current Context and the layout that it should use.
		 *  Look in class MyCustomArrayAdapter 
		 */
		adapter = new MyCustomArrayAdapter(this, R.layout.single_listview_row);
        
        // Populate the list, through the adapter
        for(final List_Item entry : getListEntries()) {
        	adapter.add(entry);
        	if(DEBUG)Log.i("HomeActivity","in adding List_Item entries to the adapter");
        }
        
        listview.setAdapter(adapter);
    
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
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	/* Create the list of objects of type List_Item, in our case it will be Decks */
	private List<List_Item> getListEntries(){
		
		/* Create an ArrayList of List_Items */
		final ArrayList<List_Item> entries = new ArrayList<List_Item>();
		
		if(reportList.isEmpty())
			return null;
		
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

}
