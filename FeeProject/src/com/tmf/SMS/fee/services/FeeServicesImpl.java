package com.tmf.SMS.fee.services;

import java.sql.Date;
import java.util.List;

import com.tmf.SMS.fee.model.CourseFee;

public class FeeServicesImpl implements FeeServices {

	@Override
	public boolean addFee(CourseFee fee) {
		// TODO Auto-generated method stub
		return dao.addFee(fee);
	}

	@Override
	public List<CourseFee>displayPendingFeeRecords() {
		// TODO Auto-generated method stub
		return dao.displayPendingFeeRecords();
	}

	@Override
	public List<CourseFee> displayFeeByReceivingDate(Date receivedOn) {
		// TODO Auto-generated method stub
		return dao.displayFeeByReceivingDate(receivedOn);
	}

	@Override
	public List<CourseFee> displayZeroBalanceFee() {
		// TODO Auto-generated method stub
		 return dao.displayZeroBalanceFee();
	}

	@Override
	public double displayFeeCollectedOnDate(Date collectedOn) {
		// TODO Auto-generated method stub
		return dao.displayFeeCollectedOnDate(collectedOn);
	}

	@Override
	public double calculateBalanceFee(int sId, double feePaid) {
		// TODO Auto-generated method stub
		return dao.calculateBalanceFee(sId, feePaid);
	}
	
}