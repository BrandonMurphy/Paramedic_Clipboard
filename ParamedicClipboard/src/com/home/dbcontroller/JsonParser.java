package com.home.dbcontroller;

/*
 * This class sends out an HttpRequest to an online URL and it
 * receives a JSON object which is then parsed and creates an ArrayList
 * of Report objects. This class can be called to get the list of Reports
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import android.util.Log;

import com.home.reports.Report;

public final class JsonParser {

	private static ArrayList<Report> reportList;
	private String[] titles;
	private String[] subtitles;
	public String myURI = "http://paramedic-clipboard.herokuapp.com/report_data.json";

	//The constructor simply calls the getHttpResponse()
	public JsonParser() throws UnsupportedEncodingException, IllegalStateException, IOException, JSONException
	{
		getHttpResponse();
	}
	/*
	 *  This method returns an HttpResponse
	 */
	public void getHttpResponse(){
		HttpResponse response = null;
		HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet();
        try {
			request.setURI(new URI("http://paramedic-clipboard.herokuapp.com/report_data.json"));
			response = client.execute(request);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(response!= null)
			Log.i(response.toString(), "testing response.toString()");
        
        //call to populate the list
        try {
			populateList(response);
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
	}
	
	/*
	 * This method receives as parameters an HttpResponse variable.
	 * It grabs that response and creates JSON array from it, then populates an array list with it.
	 */
	public void populateList(HttpResponse response) throws UnsupportedEncodingException, IllegalStateException, IOException, JSONException
	{	
		/* create buffer reader */
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));

		/* create String Builder to build our string from the HttpResponse */
		StringBuilder builder = new StringBuilder();

		/*  Create the string by appending each line with a \n symbol. */
		for (String line = null; (line = reader.readLine()) != null;) {
		    builder.append(line).append("\n");
		}

		/* convert the String builder variable to a JSONtokener 
		 * look at : http://www.json.org/javadoc/org/json/JSONTokener.html
		 * */
		JSONTokener tokener = new JSONTokener(builder.toString());

		/* Create the array */
		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(tokener);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* Call the method to initialize the ArrayList from the data given by the JSONArray -> jsonArray */
		initializeList(jsonArray);
	}

	/* This method will handle the parsing of the JSONArray and it will handle the populating of the ArrayList reportList
	 * Parameters: JSONArray array -> json array that holds 
	 * 
	 * */
	private void initializeList(JSONArray array) throws JSONException
	{
		/* The ArrayList that will hold all the Reports objects */
		reportList = new ArrayList<Report>();

		/* The String array for Titles initialization */
		titles = new String[array.length() + 1];

		/* The String array for Subtitles initialization */
		subtitles = new String[array.length() + 1];

		/* Loop through each array element of the JSONArray and get that JSONobject  */
		for(int i=0; i<array.length(); i++)
		{	
			/* Add the report to the ArrayList of Reports. 
			 * For each report, fill in the data.
			 * */
			reportList.add( new Report(
					array.getJSONObject(i).getString("created_at").toString(),
					array.getJSONObject(i).getString("destination").toString(),
					array.getJSONObject(i).getString("disposition").toString(),
					array.getJSONObject(i).getString("ethnicity").toString(),
					array.getJSONObject(i).getString("id").toString(),
					array.getJSONObject(i).getString("location_of_incident").toString(),
					array.getJSONObject(i).getString("name").toString(),
					array.getJSONObject(i).getString("sex").toString(),
					array.getJSONObject(i).getString("type_of_incident").toString(),
					array.getJSONObject(i).getString("updated_at").toString(),

					array.getJSONObject(i).getString("DOB").toString(),
					array.getJSONObject(i).getString("SSAN").toString(),
					array.getJSONObject(i).getString("address").toString(),
					array.getJSONObject(i).getString("phone").toString(),

					array.getJSONObject(i).getString("beginning_odometer").toString(),
					array.getJSONObject(i).getString("ending_odometer").toString(),
					array.getJSONObject(i).getString("alternate_Contact").toString(),
					array.getJSONObject(i).getString("employer").toString(),
					array.getJSONObject(i).getString("insurance_1").toString(),
					array.getJSONObject(i).getString("insurance_2").toString(),
					array.getJSONObject(i).getString("Past_Medical_History").toString(),

					array.getJSONObject(i).getString("Medications").toString(),
					array.getJSONObject(i).getString("Allergies").toString(),
					array.getJSONObject(i).getString("Blood_Pressure").toString(),
					array.getJSONObject(i).getString("Pulse").toString(),
					array.getJSONObject(i).getString("Respiratory_rate").toString(),
					array.getJSONObject(i).getString("GCS").toString(),
					array.getJSONObject(i).getString("Blood_sugar").toString(),

					array.getJSONObject(i).getString("SpO2").toString(),
					array.getJSONObject(i).getString("EtCO2").toString(),
					array.getJSONObject(i).getString("HEENT").toString(),
					array.getJSONObject(i).getString("Neck").toString(),
					array.getJSONObject(i).getString("Chest").toString(),
					array.getJSONObject(i).getString("Abdomen").toString(),
					array.getJSONObject(i).getString("Back").toString(),

					array.getJSONObject(i).getString("Extremities").toString(),
					array.getJSONObject(i).getString("Neurologic").toString(),
					array.getJSONObject(i).getString("Treatment_Time").toString(),
					array.getJSONObject(i).getString("Treatment_Modality").toString(),
					array.getJSONObject(i).getString("Treatment_Dose").toString(),
					array.getJSONObject(i).getString("Route").toString(),
					array.getJSONObject(i).getString("Authority").toString(),
					array.getJSONObject(i).getString("Narrative").toString(),
					array.getJSONObject(i).getString("Exam_Notes").toString()
					));

			/* Depending on this, this is what the title will display in the Listview */
			titles[i] = array.getJSONObject(i).getString("type_of_incident").toString();
			subtitles[i] = array.getJSONObject(i).getString("id").toString();
		}
	}

	/* This method returns the ArrayList that holds all the reports. */
	public ArrayList<Report> getArrayList()
	{
		return reportList;
	}
	
	/* This method will send a single report to the Database by HTTP post request */
	public void sendToDB(Report report)
	{
		
	}

	/* Used to populate the titles on the ListView */
	public String[] getTitles(){
		return this.titles;
	}

	/* Used to populate the subtitles on the ListView */
	public String[] getSubtitles(){
		return this.subtitles;
	}
}