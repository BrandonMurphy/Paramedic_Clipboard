package com.home.paramedicclipboard;

import com.home.paramedicclipboard.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.home.reports.Report;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddReportActivity extends Activity{
	
	Report new_report;
	TextView editText1;
	TextView editText2;
	TextView editText3;
	TextView editText4;
	TextView editText5;
	TextView editText6;
	TextView editText7;
	TextView editText8;
	TextView editText9;
	TextView editText10;
	TextView editText11;
	TextView editText12;
	TextView editText13;
	TextView editText14;
	TextView editText15;
	TextView editText16;
	TextView editText17;
	TextView editText18;
	TextView editText19;
	TextView editText20;
	TextView editText22;
	TextView editText23;
	TextView editText24;
	TextView editText25;
	TextView editText26;
	TextView editText27;
	TextView editText28;
	TextView editText29;
	TextView editText30;
	TextView editText31;
	TextView editText32;
	TextView editText33;
	TextView editText34;
	TextView editText35;
	TextView editText36;
	TextView editText37;
	TextView editText38;
	TextView editText39;
	TextView editText40;
	TextView editText41;
	TextView editText42;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_report);		
		
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		//new ProgressTask(AddReportActivity.this).execute();
		
		editText1 = (TextView)findViewById(R.id.editText1);
		editText2 = (TextView)findViewById(R.id.editText2);
		editText3 = (TextView)findViewById(R.id.editText3);
		editText4 = (TextView)findViewById(R.id.editText4);
		editText5 = (TextView)findViewById(R.id.editText5);
		editText6 = (TextView)findViewById(R.id.editText6);
		editText7 = (TextView)findViewById(R.id.editText7);
		editText8 = (TextView)findViewById(R.id.editText8);
		editText9 = (TextView)findViewById(R.id.editText9);
		editText10 = (TextView)findViewById(R.id.editText10);
		editText11 = (TextView)findViewById(R.id.editText11);
		editText12 = (TextView)findViewById(R.id.editText12);
		editText13 = (TextView)findViewById(R.id.editText13);
		editText14 = (TextView)findViewById(R.id.editText14);
		editText15 = (TextView)findViewById(R.id.editText15);
		editText16 = (TextView)findViewById(R.id.editText16);
		editText17 = (TextView)findViewById(R.id.editText17);
		editText18 = (TextView)findViewById(R.id.editText18);
		editText19 = (TextView)findViewById(R.id.editText19);
		editText20 = (TextView)findViewById(R.id.editText20);
		editText22 = (TextView)findViewById(R.id.editText22);
		editText23 = (TextView)findViewById(R.id.editText23);
		editText24 = (TextView)findViewById(R.id.editText24);
		editText25 = (TextView)findViewById(R.id.editText25);
		editText26 = (TextView)findViewById(R.id.editText26);
		editText27 = (TextView)findViewById(R.id.editText27);
		editText28 = (TextView)findViewById(R.id.editText28);
		editText29 = (TextView)findViewById(R.id.editText29);
		editText30 = (TextView)findViewById(R.id.editText30);
		editText31 = (TextView)findViewById(R.id.editText31);
		editText32 = (TextView)findViewById(R.id.editText32);
		editText33 = (TextView)findViewById(R.id.editText33);
		editText34 = (TextView)findViewById(R.id.editText34);
		editText35 = (TextView)findViewById(R.id.editText35);
		editText36 = (TextView)findViewById(R.id.editText36);
		editText37 = (TextView)findViewById(R.id.editText37);
		editText38 = (TextView)findViewById(R.id.editText38);
		editText39 = (TextView)findViewById(R.id.editText39);
		editText40 = (TextView)findViewById(R.id.editText40);
		editText41 = (TextView)findViewById(R.id.editText41);
		editText42 = (TextView)findViewById(R.id.editText42);	
		
        //TODO: start new activity to preview report and add it to a Report object
        //and then pass that object to the next activity that will make the HTTP request call to post the data to the DB
		Button review = (Button)findViewById(R.id.button2);
	    review.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	try{
        			new_report = new Report(
        					"1",
        					editText10.getText().toString(),
        					editText11.getText().toString(),
        					editText3.getText().toString(),
        					"1",
        					editText8.getText().toString(),
        					editText1.getText().toString(),
        					editText2.getText().toString(),
        					editText9.getText().toString(),
        					"1",
        					editText4.getText().toString(),
        					editText5.getText().toString(),
        					editText6.getText().toString(),
        					editText7.getText().toString(),
        					editText12.getText().toString(),
        					editText13.getText().toString(),
        					editText14.getText().toString(),
        					editText15.getText().toString(),
        					editText16.getText().toString(),
        					editText17.getText().toString(),
        					editText18.getText().toString(),
        					editText19.getText().toString(),
        					editText20.getText().toString(),
        					editText22.getText().toString(),
        					editText23.getText().toString(),
        					editText24.getText().toString(),
        					editText25.getText().toString(),
        					editText26.getText().toString(),
        					editText27.getText().toString(),
        					editText28.getText().toString(),
        					editText29.getText().toString(),
        					editText30.getText().toString(),
        					editText31.getText().toString(),
        					editText32.getText().toString(),
        					editText33.getText().toString(),
        					editText34.getText().toString(),
        					editText35.getText().toString(),
        					editText36.getText().toString(),
        					editText37.getText().toString(),
        					editText38.getText().toString(),
        					editText39.getText().toString(),
        					editText40.getText().toString(),
        					editText41.getText().toString(),
        					editText42.getText().toString()
        					);
        		}catch (Exception e)
        		{
        			Log.i("Inside AddReport on click", e.toString());
        		}
            	
            	
            	//Toast.makeText(AddReportActivity.this, new_report.getHTMLString(), Toast.LENGTH_LONG).show();
            
            	//Class to assist us in loading the activity 
				Class editClass = null;
				try {
					editClass = Class.forName("com.home.paramedicclipboard.ReviewActivity");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 //create bundle to pass the ID of the deck that was clicked 
				Bundle reportPassed = new Bundle();
				//reportPassed.putInt("Report", reportList.get(4).getId());
				reportPassed.putSerializable("report", new_report);

				// Start the new intent and also pass a bundle that will contain the name of the card that was clicked 
				Intent ourIntent = new Intent(AddReportActivity.this, editClass);
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
	    inflater.inflate(R.menu.details, menu);
	    return true;
	}
	
	/*//This class is an Async class that handles the data downloading + showing the loading little view
		private class ProgressTask extends AsyncTask<String, Void, Boolean> {
			private ProgressDialog dialog;
			private Activity activity;
			
			public ProgressTask(Activity activity) {
				this.activity = activity;
				context = activity;
				dialog = new ProgressDialog(context);
			}

			*//** progress dialog to show user that the backup is processing. *//*

			*//** application context. *//*
			private Context context;
			
			//this executes whenever the view is started.
			protected void onPreExecute() {
				
				//if the data has already been loaded, 
				//when coming back to the app, the loading window will not show again
				this.dialog.setMessage("Preparing the data");
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

			@Override
			protected Boolean doInBackground(String... params) {
				// TODO Auto-generated method stub
				
				TextView editText1 = (TextView)findViewById(R.id.editText1);
				TextView editText2 = (TextView)findViewById(R.id.editText2);
				TextView editText3 = (TextView)findViewById(R.id.editText3);
				TextView editText4 = (TextView)findViewById(R.id.editText4);
				TextView editText5 = (TextView)findViewById(R.id.editText5);
				TextView editText6 = (TextView)findViewById(R.id.editText6);
				TextView editText7 = (TextView)findViewById(R.id.editText7);
				TextView editText8 = (TextView)findViewById(R.id.editText8);
				TextView editText9 = (TextView)findViewById(R.id.editText9);
				TextView editText10 = (TextView)findViewById(R.id.editText10);
				TextView editText11 = (TextView)findViewById(R.id.editText11);
				TextView editText12 = (TextView)findViewById(R.id.editText12);
				TextView editText13 = (TextView)findViewById(R.id.editText13);
				TextView editText14 = (TextView)findViewById(R.id.editText14);
				TextView editText15 = (TextView)findViewById(R.id.editText15);
				TextView editText16 = (TextView)findViewById(R.id.editText16);
				TextView editText17 = (TextView)findViewById(R.id.editText17);
				TextView editText18 = (TextView)findViewById(R.id.editText18);
				TextView editText19 = (TextView)findViewById(R.id.editText19);
				TextView editText20 = (TextView)findViewById(R.id.editText20);
				TextView editText22 = (TextView)findViewById(R.id.editText22);
				TextView editText23 = (TextView)findViewById(R.id.editText23);
				TextView editText24 = (TextView)findViewById(R.id.editText24);
				TextView editText25 = (TextView)findViewById(R.id.editText25);
				TextView editText26 = (TextView)findViewById(R.id.editText26);
				TextView editText27 = (TextView)findViewById(R.id.editText27);
				TextView editText28 = (TextView)findViewById(R.id.editText28);
				TextView editText29 = (TextView)findViewById(R.id.editText29);
				TextView editText30 = (TextView)findViewById(R.id.editText30);
				TextView editText31 = (TextView)findViewById(R.id.editText31);
				TextView editText32 = (TextView)findViewById(R.id.editText32);
				TextView editText33 = (TextView)findViewById(R.id.editText33);
				TextView editText34 = (TextView)findViewById(R.id.editText34);
				TextView editText35 = (TextView)findViewById(R.id.editText35);
				TextView editText36 = (TextView)findViewById(R.id.editText36);
				TextView editText37 = (TextView)findViewById(R.id.editText37);
				TextView editText38 = (TextView)findViewById(R.id.editText38);
				TextView editText39 = (TextView)findViewById(R.id.editText39);
				TextView editText40 = (TextView)findViewById(R.id.editText40);
				TextView editText41 = (TextView)findViewById(R.id.editText41);
				TextView editText42 = (TextView)findViewById(R.id.editText42);
				
				Calendar c = Calendar.getInstance();
		        System.out.println("Current time => "+c.getTime());

		        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String formattedDate = df.format(c.getTime());
				
				try{
					new_report = new Report(
							formattedDate, 
							editText11.toString(),
							editText10.toString(),
							editText3.toString(),
							null ,
							editText8.toString(),
							editText1.toString(),
							editText2.toString(),
							editText9.toString(),
							formattedDate,
							editText4.toString(),
							editText5.toString(),
							editText6.toString(),
							editText7.toString(),
							editText12.toString(),
							editText13.toString(),
							editText14.toString(),
							editText15.toString(),
							editText16.toString(),
							editText17.toString(),
							editText18.toString(),
							editText19.toString(),
							editText20.toString(),
							editText22.toString(),
							editText23.toString(),
							editText24.toString(),
							editText25.toString(),
							editText26.toString(),
							editText27.toString(),
							editText28.toString(),
							editText29.toString(),
							editText30.toString(),
							editText31.toString(),
							editText32.toString(),
							editText33.toString(),
							editText34.toString(),
							editText35.toString(),
							editText36.toString(),
							editText37.toString(),
							editText38.toString(),
							editText39.toString(),
							editText40.toString(),
							editText41.toString(),
							editText42.toString()
							);
								
					return true;
				}catch(Exception e){
					return false;
				}
			}
		}*/
}
