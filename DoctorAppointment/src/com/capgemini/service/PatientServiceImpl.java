package com.capgemini.service;

import com.capgemini.beans.Patient;
import com.capgemini.dao.PatientDAO;
import com.capgemini.dao.PatientDAOImpl;

public class PatientServiceImpl implements PatientService {
	
	PatientDAO prepo;

	public PatientServiceImpl() {
		super();
		prepo=new PatientDAOImpl();
	}

	@Override
	public int addDoctorAppointment(Patient patient) {
		int i=prepo.addDoctorAppointment(patient);
		return i;
	}

	@Override
	public Patient getAppointmentDetails(int appointmentid) {
		// TODO Auto-generated method stub
		return null;
	}

}
