package com.capgemini.dao;

import java.util.HashMap;
import java.util.Map;


import com.capgemini.beans.Trainer;
import com.capgemini.util.DBUtil;

public class FeedbackDAOImpl implements FeedbackDAO{

	static HashMap<Integer, Trainer> hm=DBUtil.getTrainerList();
	
	@Override
	public void addFeedback(Trainer trainer)
	{
		HashMap<Integer,Trainer> hm=DBUtil.getTrainerList();
		hm.put(DBUtil.getId(),trainer);
		
	}
	
	@Override
	public HashMap<Integer,Trainer> getTrainerList(int r)
	{
	    HashMap<Integer, Trainer> rt=new HashMap<>();
	    
		for(Map.Entry<Integer,Trainer> entry : hm.entrySet())
		{
			if(entry.getValue().getRating()== r) {
				rt.put(entry.getKey(),entry.getValue());
			}
		}
		return rt;
	} 
}
