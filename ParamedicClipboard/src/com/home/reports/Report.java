package com.home.reports;
import java.io.Serializable;

import android.text.Html;

public class Report implements Serializable, Comparable<Report> {
	
	private String date_created;
	private String destination;
	private String disposition;
	private String ethnicity;
	private int id;
	private String location_of_incident;
	private String name;
	private String sex;
	private String type_of_incident;
	private String updated_at;
	private String DOB;
	private String SSN;
	private String address;
	private String phone;
	private String beginning_odometer;
	private String ending_odometer;
	private String alternate_contact;
	private String employer;
	private String insurance_1;
	private String insurance_2;
	private String Past_Medical_History;
	private String Medications;
	private String Allergies;
	private String Blood_Pressure;
	private String Pulse; 
	private String Respiratory_rate; 
	private String GCS; 
	private String Blood_sugar; 
	private String SpO2; 
	private String EtCO2; 
	private String HEENT; 
	private String Neck;
	private String Chest;
	private String Abdomen; 
	private String Back; 
	private String Extremities; 
	private String Neurologic; 
	private String Treatment_Time; 
	private String Treatment_Modality; 
	private String Treatment_Dose; 
	private String Route; 
	private String Authority; 
	private String Narrative; 
	private String Exam_Notes;
	
	private final static int number_of_fields = 44;
	
	public String getLocation_of_incident() {
		return location_of_incident;
	}

	public void setLocation_of_incident(String location_of_incident) {
		this.location_of_incident = location_of_incident;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBeginning_odometer() {
		return beginning_odometer;
	}

	public void setBeginning_odometer(String beginning_odometer) {
		this.beginning_odometer = beginning_odometer;
	}

	public String getEnding_odometer() {
		return ending_odometer;
	}

	public void setEnding_odometer(String ending_odometer) {
		this.ending_odometer = ending_odometer;
	}

	public String getAlternate_contact() {
		return alternate_contact;
	}

	public void setAlternate_contact(String alternate_contact) {
		this.alternate_contact = alternate_contact;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getInsurance_1() {
		return insurance_1;
	}

	public void setInsurance_1(String insurance_1) {
		this.insurance_1 = insurance_1;
	}

	public String getInsurance_2() {
		return insurance_2;
	}

	public void setInsurance_2(String insurance_2) {
		this.insurance_2 = insurance_2;
	}

	public String getPast_Medical_History() {
		return Past_Medical_History;
	}

	public void setPast_Medical_History(String past_Medical_History) {
		Past_Medical_History = past_Medical_History;
	}

	public String getMedications() {
		return Medications;
	}

	public void setMedications(String medications) {
		Medications = medications;
	}

	public String getAllergies() {
		return Allergies;
	}

	public void setAllergies(String allergies) {
		Allergies = allergies;
	}

	public String getBlood_Pressure() {
		return Blood_Pressure;
	}

	public void setBlood_Pressure(String blood_Pressure) {
		Blood_Pressure = blood_Pressure;
	}

	public String getPulse() {
		return Pulse;
	}

	public void setPulse(String pulse) {
		Pulse = pulse;
	}

	public String getRespiratory_rate() {
		return Respiratory_rate;
	}

	public void setRespiratory_rate(String respiratory_rate) {
		Respiratory_rate = respiratory_rate;
	}

	public String getGCS() {
		return GCS;
	}

	public void setGCS(String gCS) {
		GCS = gCS;
	}

	public String getBlood_sugar() {
		return Blood_sugar;
	}

	public void setBlood_sugar(String blood_sugar) {
		Blood_sugar = blood_sugar;
	}

	public String getSpO2() {
		return SpO2;
	}

	public void setSpO2(String spO2) {
		SpO2 = spO2;
	}

	public String getEtCO2() {
		return EtCO2;
	}

	public void setEtCO2(String etCO2) {
		EtCO2 = etCO2;
	}

	public String getHEENT() {
		return HEENT;
	}

	public void setHEENT(String hEENT) {
		HEENT = hEENT;
	}

	public String getNeck() {
		return Neck;
	}

	public void setNeck(String neck) {
		Neck = neck;
	}

	public String getChest() {
		return Chest;
	}

	public void setChest(String chest) {
		Chest = chest;
	}

	public String getAbdomen() {
		return Abdomen;
	}

	public void setAbdomen(String abdomen) {
		Abdomen = abdomen;
	}

	public String getBack() {
		return Back;
	}

	public void setBack(String back) {
		Back = back;
	}

	public String getExtremities() {
		return Extremities;
	}

	public void setExtremities(String extremities) {
		Extremities = extremities;
	}

	public String getNeurologic() {
		return Neurologic;
	}

	public void setNeurologic(String neurologic) {
		Neurologic = neurologic;
	}

	public String getTreatment_Time() {
		return Treatment_Time;
	}

	public void setTreatment_Time(String treatment_Time) {
		Treatment_Time = treatment_Time;
	}

	public String getTreatment_Modality() {
		return Treatment_Modality;
	}

	public void setTreatment_Modality(String treatment_Modality) {
		Treatment_Modality = treatment_Modality;
	}

	public String getTreatment_Dose() {
		return Treatment_Dose;
	}

	public void setTreatment_Dose(String treatment_Dose) {
		Treatment_Dose = treatment_Dose;
	}

	public String getRoute() {
		return Route;
	}

	public void setRoute(String route) {
		Route = route;
	}

	public String getAuthority() {
		return Authority;
	}

	public void setAuthority(String authority) {
		Authority = authority;
	}

	public String getNarrative() {
		return Narrative;
	}

	public void setNarrative(String narrative) {
		Narrative = narrative;
	}

	public String getExam_Notes() {
		return Exam_Notes;
	}

	public void setExam_Notes(String exam_Notes) {
		Exam_Notes = exam_Notes;
	}

	public Report(String name)
	{
		this.setName(name);
	}

	public Report(
			String date_created, 
			String destination,
			String disposition, 
			String ethnicity, 
			String id, 
			String location_of_incident, 
			String name, 
			String sex, 
			String type_of_incident, 
			String updated_at,
			String DOB,
			String SSN,
			String address,
			String phone,
			String beginning_odometer,
			String ending_odometer,
			String alternate_contact,
			String employer,
			String insurance_1,
			String insurance_2,
			String Past_Medical_History,
			String Medications,
			String Allergies,
			String Blood_Pressure,
			String Pulse, 
			String Respiratory_rate, 
			String GCS, 
			String Blood_sugar, 
			String SpO2, 
			String EtCO2, 
			String HEENT, 
			String Neck,
			String Chest,
			String Abdomen, 
			String Back, 
			String Extremities, 
			String Neurologic, 
			String Treatment_Time, 
			String Treatment_Modality, 
			String Treatment_Dose, 
			String Route, 
			String Authority, 
			String Narrative, 
			String Exam_Notes
			)
	{
		
		//TODO: I  MUST CALL ALL THE SET METHODS !!!!!!!!!!!!!
		this.setDate_created(date_created);
		this.setDestination(destination);
		this.setDisposition(disposition);
		this.setEthnicity(ethnicity);
		this.setId(Integer.parseInt(id));
		this.setLocation_of_incident(location_of_incident);
		this.setName(name);
		this.setSex(sex);
		this.setType(type_of_incident);
		this.setUpdated_at(updated_at);
		this.setDOB(DOB);
		this.setSSN(SSN);
		this.setAddress(address);
		this.setPhone(phone);
		this.setBeginning_odometer(beginning_odometer);
		this.setEnding_odometer(ending_odometer);
		this.setDate_created(date_created);
		this.setDestination(destination);
		this.setDisposition(disposition);
		this.setEthnicity(ethnicity);
		this.setId(Integer.parseInt(id));
		this.setLocation_of_incident(location_of_incident);
		this.setName(name);
		this.setSex(sex);
		this.setType(type_of_incident);
		this.setUpdated_at(updated_at);
		this.setDOB(DOB);
		this.setSSN(SSN);
		this.setAddress(address);
		this.setPhone(phone);
		this.setBeginning_odometer(beginning_odometer);
        this.setEnding_odometer(ending_odometer);
        this.setAlternate_contact(alternate_contact);
        this.setEmployer(employer);
        this.setInsurance_1(insurance_1);
        this.setInsurance_2(insurance_2);
        this.setPast_Medical_History(Past_Medical_History);
        this.setMedications(Medications);
        this.setAllergies(Allergies);
        this.setBlood_Pressure(Blood_Pressure);
        this.setPulse(Pulse);
        this.setRespiratory_rate(Respiratory_rate);
        this.setGCS(GCS);
        this.setBlood_sugar(Blood_sugar);
        this.setSpO2(SpO2);
        this.setEtCO2(EtCO2);
        this.setHEENT(HEENT);
        this.setNeck(Neck);
        this.setChest(Chest);
        this.setAbdomen(Abdomen);
        this.setBack(Back);
        this.setExtremities(Extremities);
        this.setNeurologic(Neurologic);
        this.setTreatment_Time(Treatment_Time);
        this.setTreatment_Modality(Treatment_Modality);
		this.setTreatment_Dose(Treatment_Dose);
        this.setRoute(Route);
        this.setAuthority(Authority);
        this.setNarrative(Narrative);
        this.setExam_Notes(Exam_Notes);
		
	}
	
	private void setDate_created(String date_created) {
		// TODO Auto-generated method stub
		this.date_created = date_created;
	}
	
	public String getDate_created() {
		// TODO Auto-generated method stub
		return this.date_created;
	}


	// Set Name
	private void setName(String name) {
		this.name = name;
	}

	// Get Name
	public String getName() {
		return this.name;
	}
	
	// Set Sex
	private void setSex(String sex) {
		this.sex = sex;
	}
	
	// Get Sex
	public String getSex() {
		return this.sex;
	}
	
	// Set Ethnicity
	private void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	
	// Get Ethnicity
	public String getEthnicity() {
		return this.ethnicity;
	}

	// Set Location of Incident
	private void setType(String type) {
		this.type_of_incident = type;
	}

	// Get Location of Incident
	public String getType() {
		return this.type_of_incident;

	}
	
	// Set Disposition
	private void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	// Get Disposition
	public String getDisposition() {
		return this.disposition;
	}

	// Set Destination
	private void setDestination(String destination) {
		this.destination = destination;
	}

	// Get Destination
	public String getDestination() {
		return this.destination;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	private void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	/**
	 * This method will return a list of all the Titles for each item in the report.
	 * This will be used in the DetailsActivity.java class. That class will also call
	 * getAllSubtitles() down bellow to get the actually information for each Report item.
	 */
	public String[] getAllTitles(){
		//TODO: implement method getAllTitles
		String titles[] = new String[number_of_fields];
		titles[0] = "";
		titles[1] = "";
		titles[2] = "";
		titles[3] = "";
		titles[4] = "";
		titles[5] = "";
		titles[6] = "";
		titles[7] = "";
		titles[8] = "";
		titles[9] = "";
		titles[10] = "";
		titles[11] = "";
		titles[12] = "";
		titles[13] = "";
		titles[14] = "";
		
		
		return null;
	}
	
	public String[] getAllSubtitles(){
		//TODO: implement method getAllTitles
		return null;
	}
	
	
	/**
	 * TODO: IMPLEMENT THIS TO DISPLAY THE EACH REPORT AS A STRING !!!!
	 * 
	 */
	public String getHTMLString() {
		// TODO Auto-generated method stub
		String string = "<font color=\"white\"><b>Name: </b>" + " " + this.getName() + "<br/><br/>"
						+ "<b>Sex: </b>" + " " + this.getSex() + "<br/><br/>"
						+ "<b>Ethnicity: </b>" + " " + this.getEthnicity() + "<br/><br/>"
						+ "<b>DOB: </b>" + " " + this.getDOB() + "<br/><br/>"
						+ "<b>SSAN: </b>" + " " + this.getSSN() + "<br/><br/>"
						+ "<b>Address: </b>" + " " + this.getAddress() + "<br/><br/>"
						+ "<b>Phone: </b>" + " " + this.getPhone() + "<br/><br/>"
						+ "<b>Location of incident: </b>" + " " + this.getLocation_of_incident() + "<br/><br/>"
						+ "<b>Type of incident: </b>" + " " + this.getType() + "<br/><br/>"
						+ "<b>Disposition: </b>" + " " + this.getDisposition() + "<br/><br/>"
						+ "<b>Destination: </b>" + " " + this.getDestination() + "<br/><br/>"
						+ "<b>Beginning odometer: </b>" + " " + this.getBeginning_odometer() + "<br/><br/>"
						+ "<b>Ending odometer: </b>" + " " + this.getEnding_odometer() + "<br/><br/>"
						+ "<b>Alternate contact: </b>" + " " + this.getAlternate_contact() + "<br/><br/>"
						+ "<b>Employer: </b>" + " " + this.getEmployer() + "<br/><br/>"
						+ "<b>Insurance 1: </b>" + " " + this.getInsurance_1() + "<br/><br/>"
						+ "<b>Insurance 2: </b>" + " " + this.getInsurance_2() + "<br/><br/>"
						+ "<b>Past medical history: </b>" + " " + this.getPast_Medical_History() + "<br/><br/>"
						+ "<b>Medications: </b>" + " " + this.getMedications() + "<br/><br/>"
						+ "<b>Allergies: </b>" + " " + this.getAllergies() + "<br/><br/>"
						+ "<b>Blood pressure: </b>" + " " + this.getBlood_Pressure() + "<br/><br/>"
						+ "<b>Respiratory rate: </b>" + " " + this.getRespiratory_rate() + "<br/><br/>"
						+ "<b>GCS: </b>" + " " + this.getGCS() + "<br/><br/>"
						+ "<b>Blood sugar: </b>" + " " + this.getBlood_sugar() + "<br/><br/>"
						+ "<b>SPo2: </b>" + " " + this.getSpO2() + "<br/><br/>"
						+ "<b>ETCo2: </b>" + " " + this.getEtCO2() + "<br/><br/>"
						+ "<b>Heent: </b>" + " " + this.getHEENT() + "<br/><br/>"
						+ "<b>Neck: </b>" + " " + this.getNeck() + "<br/><br/>"
						+ "<b>Chest: </b>" + " " + this.getChest() + "<br/><br/>"
						+ "<b>Abdomen: </b>" + " " + this.getAbdomen() + "<br/><br/>"
						+ "<b>Back: </b>" + " " + this.getBack() + "<br/><br/>"
						+ "<b>Extremities: </b>" + " " + this.getExtremities() + "<br/><br/>"
						+ "<b>Neurologic: </b>" + " " + this.getNeurologic() + "<br/><br/>"
						+ "<b>Treatment time: </b>" + " " + this.getTreatment_Time() + "<br/><br/>"
						+ "<b>Treatment modality: </b>" + " " + this.getTreatment_Modality() + "<br/><br/>"
						+ "<b>Treatment dose: </b>" + " " + this.getTreatment_Dose() + "<br/><br/>"
						+ "<b>Route: </b>" + " " + this.getRoute() + "<br/><br/>"
						+ "<b>Authority: </b>" + " " + this.getAuthority() + "<br/><br/>"
						+ "<b>Narrative: </b>" + " " + this.getNarrative() + "<br/><br/>"
						+ "<b>Exam notes: </b>" + " " + this.getExam_Notes() + "<br/><br/>"
						+ "</font>";
		return string;
	}

	@Override
	public int compareTo(Report arg0) {
		// TODO Auto-generated method stub
		return this.getDate_created().compareTo(arg0.getDate_created());
	}
}
