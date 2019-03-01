package com.capgemini.repo;

import com.capgemini.beans.Patient;

public interface PatientRepo {
	int save(Patient patient);
	Patient findOne(int appointmentid);
	

}