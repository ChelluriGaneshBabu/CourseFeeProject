package com.tmf.SMS.fee.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;


import com.tmf.SMS.fee.model.CourseFee;

public class FeeDAOImpl implements FeeDAO {
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	@Override
	public boolean addFee(CourseFee fee) {
		boolean result=false;
		try {
			query="Insert into CourseFee(fee,sId,cId,bId,FeePaid,ReceivedOn,ReceiptNumber,BalanceFee) Values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setDouble(1,fee.getFee());
			ps.setInt(2, fee.getsId());
			ps.setInt(3, fee.getcId());
			ps.setInt(4, fee.getbId());
			ps.setDouble(5, fee.getFeePaid());
			ps.setDate(6, fee.getReceivedOn());
			ps.setString(7, fee.getReceiptNumber());
			ps.setDouble(8, fee.getBalanceFee());
			ps.execute();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<CourseFee> displayPendingFeeRecords() {
		fees.clear();
		try {
			query = "select * from CourseFee where balanceFee>0";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				double fullFee=rs.getDouble("fee");
				int sid=rs.getInt("sId");
				int cid= rs.getInt("cId");
				int bid=rs.getInt("bId");
				double paid=rs.getDouble("feePaid");
				Date date= rs.getDate("ReceivedOn");
				String receipt = rs.getString("receiptNumber");
				double balance=rs.getDouble("balanceFee");
				
				CourseFee fee = new CourseFee(fullFee,paid,balance,sid,cid,bid, receipt, date);
					fees.add(fee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fees;
	}
	@Override
	public List<CourseFee> displayFeeByReceivingDate(Date receivedOn) {
		fees.clear();
		try{
			query="Select * from CourseFee where receivedOn=?";
			ps=con.prepareStatement(query);
			ps.setDate(1,new java.sql.Date(receivedOn.getTime()));
			rs=ps.executeQuery();
			while(rs.next()) {
				double fullFee = rs.getDouble("fee");
				int sid = rs.getInt("sId");
				int cid = rs.getInt("cId");
				int bid = rs.getInt("bId");
				double paid = rs.getDouble("feePaid");
				Date date = rs.getDate("receivedOn");
				String receipt = rs.getString("receiptNumber");
				double balance=rs.getDouble("balanceFee");

				CourseFee fee = new CourseFee(fullFee,paid,balance,sid,cid,bid, receipt, date);
				fees.add(fee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fees;
	}
	@Override
	public List<CourseFee> displayZeroBalanceFee() {
		fees.clear();
		
		try{
			query="Select * From CourseFee where BalanceFee=0";
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				double fullFee = rs.getDouble("fee");
				int sid = rs.getInt("sId");
				int cid = rs.getInt("cId");
				int bid = rs.getInt("bId");
				double paid = rs.getDouble("feePaid");
				Date date = rs.getDate("receivedOn");
				String receipt = rs.getString("receiptNumber");
				double balance=rs.getDouble("balanceFee");
				
				CourseFee fee = new CourseFee(fullFee,paid,balance,sid,cid,bid, receipt, date);
				fees.add(fee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fees;
	}
	@Override
	public double displayFeeCollectedOnDate(Date collectedOn) {
		double collectedFee=0;
		try{
			query="Select * from CourseFee where receivedOn=?";
			ps=con.prepareStatement(query);
			ps.setDate(1,new java.sql.Date(collectedOn.getTime()));
			rs=ps.executeQuery();
			while(rs.next()) {
				double paid = rs.getDouble("feePaid");
				collectedFee+=paid;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collectedFee;
	}
	@Override
	public double calculateBalanceFee(int sId, double feePaid) {
		double balance=0;
		try {
			query ="Select sum(fee-feePaid) AS balanceFee from CourseFee where sId=?";
			ps=con.prepareStatement(query);
			ps.setInt(1,sId);
			rs=ps.executeQuery();
			if(rs.next()) {
				balance=rs.getDouble("balanceFee");
			}
			balance=balance-feePaid;
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
}