package com.home.paramedicclipboard;

import com.home.reports.Report;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends Activity {

	private final boolean DEBUG = false;
	private Report report = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(DEBUG)Log.i("DetailsACtivity","Passes in the oncreate method");
		setContentView(R.layout.reportdetails);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.home, menu);
	    initialize();
	    return true;
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	//Initializes all components
	private void initialize()
	{
		Intent intent = getIntent();
		report = (Report)intent.getSerializableExtra("report");
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.details);
		
		TextView text = new TextView(this);

		// function call to get the string in HTML format
		String string = report.getHTMLString();
		
		// error check
		if(string == null || string == "")
		{
			string = "This report is currently unavailable. We apologize for the inconvinience";
		}
		
		// pass the html string we got and display it as the text
		text.setText(Html.fromHtml(string));
		//set the parameters of the textview
		text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
		//add the textview to the view.
		linearLayout.addView(text);
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    actionBar.setTitle("Report Details");
	}
	
	//This method handles the click on the Action Bar buttons ( both return and Add New Report + )
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            finish();
	            return true;
	        case R.id.add_report:
	        	/* Class to assist us in loading the activity */
				Class editClass = null;
				try {
					editClass = Class.forName("com.home.paramedicclipboard.AddReportActivity");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/* Start the new intent */
				Intent ourIntent = new Intent(DetailsActivity.this, editClass);
				//start the activity
				startActivity(ourIntent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}
