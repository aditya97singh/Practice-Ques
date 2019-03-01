package com.capgemini.service;

import com.capgemini.beans.Patient;

import com.capgemini.repo.PatientRepo;
import com.capgemini.exception.*;

public class PatientServiceImpl implements PatientService {

    PatientRepo repo;
	
	public PatientServiceImpl(PatientRepo repo)
	{
		this.repo=repo;
	}
	public int addDoctorAppointmentDetail(Patient patient)
	{
		System.out.println("add success");
		return repo.save(patient);
	}
	public Patient getDoctorAppointementDetail(int appointmentid) throws AppointementIdNotNullException,InvalidAppointementId
	{
		if(appointmentid==0)
		{
			throw new AppointementIdNotNullException("Id not enter");
		}
		
		Patient p=repo.findOne(appointmentid);
		if(p!=null)
		{
			String s=p.getProbname();
			if(s.equals("Heart"))
			{
				System.out.println("Patient name:  "+ p.getPatientname());
				p.setAppointmentstatus("Approved");
				System.out.println("Appointement status:  " + p.getAppointmentstatus());
				p.setDoctorname("Dr. Brajesh Kumar");
				System.out.println("Doctor name:  " + p.getDoctorname());
			}
			if(s.equals("Gyoecology"))
			{
				System.out.println("Patient name:  "+ p.getPatientname());
				p.setAppointmentstatus("Approved");
				System.out.println("Appointement status:  " + p.getAppointmentstatus());
				p.setDoctorname("Dr. Shardha Singh");
				System.out.println("Doctor name:  " + p.getDoctorname());
			}
			if(s.equals("Dentist"))
			{
				System.out.println("Patient name:  "+ p.getPatientname());
				p.setAppointmentstatus("Approved");
				System.out.println("Appointement status:  " + p.getAppointmentstatus());
				p.setDoctorname("Dr. Heejan Khan");
				System.out.println("Doctor name:  " + p.getDoctorname());
			}
			if(s.equals("Ent"))
			{
				System.out.println("Patient name:  "+ p.getPatientname());
				p.setAppointmentstatus("Approved");
				System.out.println("Appointement status:  " + p.getAppointmentstatus());
				p.setDoctorname("Dr. Paras Mal");
				System.out.println("Doctor name:  " + p.getDoctorname());
			}
			if(s.equals("Fever"))
			{
				System.out.println("Patient name:  "+ p.getPatientname());
				p.setAppointmentstatus("Approved");
				System.out.println("Appointement status:  " + p.getAppointmentstatus());
				p.setDoctorname("Dr. Renuka Kher");
				System.out.println("Doctor name:  " + p.getDoctorname());
			}
		}
		else
		{
		throw new InvalidAppointementId("Wrong appointement id");
		}
		return null;
		/*System.out.println("id runs");
		return repo.findOne(appointmentid);*/
	}
}