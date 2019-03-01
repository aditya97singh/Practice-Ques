package com.capgemini.dao;

import com.capgemini.beans.Patient;

public interface PatientDAO {
	
		int addDoctorAppointment(Patient patient);
		Patient getAppointmentDetails(int appointmentid);
		
	}
