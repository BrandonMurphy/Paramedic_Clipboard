package com.home.paramedicclipboard;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.home.dbcontroller.JsonParser;
import com.home.dbcontroller.PostJson;
import com.home.reports.Report;

public class ReviewActivity extends Activity{

	private final boolean DEBUG = false;
	private Report report = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(DEBUG)Log.i("DetailsACtivity","Passes in the oncreate method");
		setContentView(R.layout.review);
		initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.details, menu);
		return true;
	}

	@Override
	protected void onResume()
	{
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
		//String string = "It has loaded !!!. The report name is : " + report.getName() + report.getEthnicity() + report.getSex() + report.getDate_created();
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

		//set the on click listener for the submit button
		Button review = (Button)findViewById(R.id.submit);
		review.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new ProgressTask(ReviewActivity.this).execute();
			}
		});
	}

	//This method handles the click on the Action Bar buttons ( both return and Add New Report + )
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; go home
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
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
			this.dialog.setMessage("Sending data...");
			this.dialog.show();
		}
		
		@Override
		protected void onPostExecute(final Boolean success) {
			if (dialog.isShowing()) {
				dialog.dismiss();
			}

			if (success) {
				//Toast.makeText(context, "Data Loaded", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, "Error Loading Data", Toast.LENGTH_LONG).show();
			}
			
		}

		//this is done in the background to load data.
		protected Boolean doInBackground(final String... args) {   
			PostJson parser = null;	
			try {
				parser = new PostJson();
			} catch (Exception e)
			{
				Log.i("Inside reviewACtivity right after json post request","Did not send the json object");
			}
			parser.postReport(report);
			return true;
		}
	}

}

