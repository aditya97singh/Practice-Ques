package com.capgemini.beans;

import java.time.LocalDate;

public class Patient {
	private int appointmentid;
	private String patientname;
	private String phonno;
	private String email;
	private String gender; 
	private String appointementdate;
	private int age;
	private String probname;
	private String doctorname;
	private String appointmentstatus; 
	
	
	public Patient(int appointmentid, String patientname, String phonno, String email, String gender,
			String appointementdate, int age, String probname) {
		super();
		this.appointmentid = appointmentid;
		this.patientname = patientname;
		this.phonno = phonno;
		this.email = email;
		this.gender = gender;
		this.appointementdate = appointementdate;
		this.age = age;
		this.probname = probname;
		
		
	}
	
	
	public Patient() {
		
	}


	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPhonno() {
		return phonno;
	}
	public void setPhonno(String phonno) {
		this.phonno = phonno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAppointementdate() {
		return appointementdate;
	}
	public void setAppointementdate(String appointementdate) {
		this.appointementdate = appointementdate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProbname() {
		return probname;
	}
	public void setProbname(String probname) {
		this.probname = probname;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getAppointmentstatus() {
		return appointmentstatus;
	}
	public void setAppointmentstatus(String appointmentstatus) {
		this.appointmentstatus = appointmentstatus;
	}
	
	
	
}
