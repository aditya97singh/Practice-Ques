package com.capgemini.service;

import com.capgemini.beans.Patient;

public interface PatientService {

	int addDoctorAppointment(Patient patient);
	Patient getAppointmentDetails(int appointmentid);
}
