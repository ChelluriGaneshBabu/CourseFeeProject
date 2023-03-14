package com.tmf.SMS.fee.services;

import java.sql.Date;
import java.util.List;

import com.tmf.SMS.fee.dao.FeeDAO;
import com.tmf.SMS.fee.dao.FeeDAOImpl;
import com.tmf.SMS.fee.model.CourseFee;

public interface FeeServices {
	FeeDAO dao = new FeeDAOImpl();
	
	public boolean addFee(CourseFee fee);
	List<CourseFee> displayPendingFeeRecords();
	List<CourseFee> displayFeeByReceivingDate(Date receivedOn);
	List<CourseFee> displayZeroBalanceFee();          
	public double displayFeeCollectedOnDate(Date collectedOn);
	public double calculateBalanceFee(int sId,double feePaid);
}