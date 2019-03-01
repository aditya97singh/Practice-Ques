package com.capgemini.dao;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.beans.Patient;

public class PatientDAOImpl implements PatientDAO{
	
	static HashMap<Integer,Patient> hm=new HashMap<>();

	@Override
	public int addDoctorAppointment(Patient patient) {
       //int i=(int)(Math.random()*1000);
       hm.put(patient.getId(),patient);
       return patient.getId();
	}

	@Override
	public Patient getAppointmentDetails(int appointmentid) {
		
		 HashMap<Integer,Patient> rt=new HashMap<>();
		    
			for(Map.Entry<Integer,Patient> entry : hm.entrySet())
			{
				if(entry.getValue().getId()== appointmentid){
					rt.put(entry.getKey(),entry.getValue());
				}
			}
		
		return rt.get(rt);
	}

}
