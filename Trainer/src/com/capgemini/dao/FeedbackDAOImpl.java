package com.capgemini.dao;

import java.util.HashMap;
import com.capgemini.beans.Trainer;
import com.capgemini.util.DBUtil;

public class FeedbackDAOImpl implements FeedbackDAO{

	public HashMap<Integer, Trainer> addFeedback(Trainer trainer)
	{
		HashMap<Integer,Trainer> hm=DBUtil.getTrainerList();
		hm.put(DBUtil.getId(),trainer);
		return hm;
	}
	
	public HashMap<Integer,Trainer> getTrainerList()
	{
		return DBUtil.getTrainerList();
	} 
}
