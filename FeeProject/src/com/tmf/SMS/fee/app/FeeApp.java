package com.tmf.SMS.fee.app;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.tmf.SMS.fee.model.CourseFee;
import com.tmf.SMS.fee.services.FeeServicesImpl;

public class FeeApp {
	static FeeServicesImpl service=new FeeServicesImpl();
	static Scanner scan=new Scanner(System.in);
	public static void main(String args[]) {
		menu();
	}
	public static void menu() {
		while(true) {
			System.out.println("========================Fees Module=====================");
			System.out.println("Press 1 for Add Fee");
			System.out.println("Press 2 for Display Pending Fee Records");
			System.out.println("Press 3 for Display Fees By Receiving Date");
			System.out.println("Press 4 for Display Zero Balance Fees List");
			System.out.println("Press 5 for Display Fee Collected On Date");
			System.out.println("Press 6 for Calculate Balance Fee List");
			System.out.println("Press 0 for Exit");
			System.out.println("Please Enter your choice ");
			int choice = scan.nextInt();
			scan.nextLine();	
			switch(choice) {
			case 0 : System.exit(choice);
			case 1 :addFee();break;
			case 2 :displayPendingFeeRecords();break;
			case 3 :displayFeesByReceivingDate();break;
			case 4 :displayZeroBalanceFee();break;
			case 5 :displayFeeCollectedOnDate();break;
			case 6 :calculateBalanceFee();break;
			default : System.out.println("Sorry!!!! You have entered a wrong choice...");
			}
		}                                 
	}
	private static void addFee() {
		// TODO Auto-generated method stub
		System.out.println("Enter Course Fee ");
		double cFee=scan.nextDouble();
		System.out.println("Enter Student Id ");
		int studentId=scan.nextInt();
		System.out.println("Enter Course Id ");
		int courseId=scan.nextInt();
		System.out.println("Enter Batch Id ");
		int batchId=scan.nextInt();
		System.out.println("Enter Fee Paid");
		double feePaid=scan.nextDouble();
		System.out.println("Enter received Date yyyy-mm-dd ");
		String receivedOn=scan.next();
		Date rdate=Date.valueOf(receivedOn);
		System.out.println("Enter receipt Number ");
		String receipt=scan.next();
		double balanceFee=cFee-feePaid;
		CourseFee fee = new CourseFee(cFee,feePaid,balanceFee, studentId, courseId, batchId, receipt, rdate);
		try {
			boolean result=service.addFee(fee);
			if(result) {
				System.out.println("Fee added Successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void displayPendingFeeRecords() {
		// TODO Auto-generated method stub
		try{
			List<CourseFee> pendingFee=service.displayPendingFeeRecords();
			for(CourseFee pendingFees: pendingFee) {
				System.out.println(pendingFees);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void displayFeesByReceivingDate() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Date yyyy-mm-dd");
		String receivedOn=scan.next();
		Date rdate=Date.valueOf(receivedOn);
		try {
			List<CourseFee> rfee=service.displayFeeByReceivingDate(rdate);
			for(CourseFee feeRecords: rfee) {
				System.out.println(feeRecords);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void displayZeroBalanceFee() {
		// TODO Auto-generated method stub
		
		try {
			
			List<CourseFee> zfee=service.displayZeroBalanceFee();
			
			if(zfee!=null)
				{
				System.out.println("The zero balance Fee records are");
				for(CourseFee zeroFee: zfee) {
					System.out.println(zeroFee);
				}
				}
			else {
				System.out.println("There are no Zero Balance Fee Records to Display");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void displayFeeCollectedOnDate() {
		// TODO Auto-generated method stub
		System.out.println("Enter Fee collected Date(yyyy-mm-dd)");
		String receivedOn=scan.next();
		Date rdate=Date.valueOf(receivedOn);
		try {
			double collectedFee=service.displayFeeCollectedOnDate(rdate);
			System.out.println(collectedFee);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void calculateBalanceFee() {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Id ");
		int studentId=scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Fee Paid ");
		double feePaid=scan.nextDouble();
		try {
			double balanceFee=service.calculateBalanceFee(studentId, feePaid);
			if(balanceFee>=0) {
			System.out.println("Balance Fee of "+studentId+" is "+balanceFee);
			}
			else {
				System.out.println(studentId+" has paid extra amount of "+Math.abs(balanceFee));
			}
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
}