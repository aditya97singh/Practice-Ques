package com.capgemini.service;

import com.capgemini.beans.Patient;
import com.capgemini.exception.*;
public interface PatientService {
	int addDoctorAppointmentDetail(Patient patient);
	Patient getDoctorAppointementDetail(int appointmentid) throws AppointementIdNotNullException, InvalidAppointementId;

}
