package com.capgemini.dao;

import java.util.HashMap;
import com.capgemini.beans.Trainer;
import com.capgemini.util.DBUtil;

public class FeedbackDAOImpl implements FeedbackDAO{

	@Override
	public void addFeedback(Trainer trainer)
	{
		HashMap<Integer,Trainer> hm=DBUtil.getTrainerList();
		hm.put(DBUtil.getId(),trainer);
		
	}
	
	@Override
	public HashMap<Integer,Trainer> getTrainerList()
	{
		return DBUtil.getTrainerList();
	} 
}
