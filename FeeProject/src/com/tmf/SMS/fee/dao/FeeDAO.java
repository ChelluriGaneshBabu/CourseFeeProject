package com.tmf.SMS.fee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tmf.SMS.fee.congif.DBConfigForFee;
import com.tmf.SMS.fee.model.CourseFee;

public interface FeeDAO {
	List<CourseFee> fees=new ArrayList<CourseFee>();
	Connection con = DBConfigForFee.getConnection();

	public boolean addFee(CourseFee fee);
	List<CourseFee> displayPendingFeeRecords();
	List<CourseFee> displayFeeByReceivingDate(Date receivedOn);
	List<CourseFee> displayZeroBalanceFee();          
	public double displayFeeCollectedOnDate(Date collectedOn);
	public double calculateBalanceFee(int sId,double feePaid);
}