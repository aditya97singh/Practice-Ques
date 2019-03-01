package com.capgemini.beans;

public class Patient {
	
	private int id;
	private String name;
	private String phonno;
	private String email;
	private String gender; 
	private String appointementdate;
	private int age;
	private String probname;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int id, String name, String phonno, String email, String gender, String appointementdate, int age,
			String probname) {
		super();
		this.id = id;
		this.name = name;
		this.phonno = phonno;
		this.email = email;
		this.gender = gender;
		this.appointementdate = appointementdate;
		this.age = age;
		this.probname = probname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	

}
