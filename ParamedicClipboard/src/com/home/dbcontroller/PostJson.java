package com.home.dbcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.home.reports.Report;

public class PostJson {
	
	/* This method will send a single report to the Database by HTTP post request */
	public boolean postReport(Report report)
	{
		boolean success = false;
		
		try{
			JSONObject json = getJson(report);
			HttpPostRequest(json);
			success = true;
		}catch(Exception e){
			
		}
		//returns the result of the httprequest
		return success;
	}
	
	//this method handles the parsing of the report and making it into a JSONobject
	private JSONObject getJson(Report report){
		JSONObject json = new JSONObject();
		
		try {
			json.put("destination" , report.getDestination());
			json.put("disposition" , report.getDisposition());
			json.put("ethnicity" , report.getEthnicity());
			json.put("location_of_incident" , report.getLocation_of_incident());
			json.put("name" , report.getName());
			json.put("sex", report.getSex());
			json.put("type_of_incident" , report.getType());
			json.put("DOB" , report.getDOB());
			json.put("SSAN" , report.getSSN());
			json.put("address" , report.getAddress());
			json.put("phone" , report.getPhone());
			json.put("beginning_odometer" , report.getBeginning_odometer());
			json.put("ending_odometer" , report.getEnding_odometer());
			json.put("alternate_Contact" , report.getAlternate_contact());
			json.put("employer" , report.getEmployer());
			json.put("insurance_1" , report.getInsurance_1());
			json.put("insurance_2" , report.getInsurance_2());
			json.put("Past_Medical_History" , report.getPast_Medical_History());
			json.put("Medications" , report.getMedications());
			json.put("Blood_Pressure", report.getBlood_Pressure());
			json.put("Pulse", report.getPulse());
			json.put("Respiratory_rate", report.getRespiratory_rate());
			json.put("GCS", report.getGCS());
			json.put("SpO2", report.getSpO2());
			json.put("EtCO2", report.getEtCO2());
			json.put("HEENT", report.getHEENT());
			json.put("Neck", report.getNeck());
			json.put("Chest", report.getChest());
			json.put("Abdomen", report.getAbdomen());
			json.put("Back", report.getBack());
			json.put("Extremities", report.getExtremities());
			json.put("Neurologic", report.getNeurologic());
			json.put("Treatment_Time", report.getTreatment_Time());
			json.put("Treatment_Modality", report.getTreatment_Modality());
			json.put("Treatment_Dose", report.getTreatment_Dose());
			json.put("Route", report.getRoute());
			json.put("Authority", report.getAuthority());
			json.put("Narrative", report.getNarrative());
			json.put("Exam_Notes", report.getExam_Notes());			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
	
	//this method simply puts data into the heroku app
	private void HttpPostRequest(JSONObject json)
	{
		try {
			HttpPost httpPost = new HttpPost(new URI("http://paramedic-clipboard.herokuapp.com/report_data"));
			httpPost.setEntity(new StringEntity(json.toString()));
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			new DefaultHttpClient().execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("inside HtthPost", "sending post request");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("inside HtthPost", "sending post request");
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Log.i("inside HtthPost", "sending post request");
		}
	}
	
	
}
