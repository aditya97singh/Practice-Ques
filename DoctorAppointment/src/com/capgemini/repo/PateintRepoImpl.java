package com.capgemini.repo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.beans.*;
import com.capgemini.beans.*;

public class PateintRepoImpl implements PatientRepo
{
	
	Map<Integer,Patient> patientdetail=new HashMap<>();
	
	public int save(Patient p)
	{
		patientdetail.put(p.getAppointmentid(),p);
		return p.getAppointmentid();
	}
	
	public Patient findOne(int appointmentid)
	{
		if(patientdetail.containsKey(appointmentid))
		{
			Patient pe=patientdetail.get(appointmentid);
			return pe;
		}
		return null;
	}
	
	
		
		
		
		
	
}