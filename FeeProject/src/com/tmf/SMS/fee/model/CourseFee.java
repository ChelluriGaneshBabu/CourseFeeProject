package com.tmf.SMS.fee.model;

import java.sql.Date;


public class CourseFee {
	private double fee,feePaid,balanceFee;
	private int sId,cId,bId;
	private String receiptNumber;
	private Date receivedOn;
	/**
	 * @return the fee
	 */
	public double getFee() {
		return fee;
	}
	/**
	 * @param fee the fee to set
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}
	/**
	 * @return the feePaid
	 */
	public double getFeePaid() {
		return feePaid;
	}
	/**
	 * @param feePaid the feePaid to set
	 */
	public void setFeePaid(double feePaid) {
		this.feePaid = feePaid;
	}
	/**
	 * @return the balanceFee
	 */
	public double getBalanceFee() {
		return balanceFee;
	}
	/**
	 * @param balanceFee the balanceFee to set
	 */
	public void setBalanceFee(double balanceFee) {
		this.balanceFee = balanceFee;
	}
	/**
	 * @return the sId
	 */
	public int getsId() {
		return sId;
	}
	/**
	 * @param sId the sId to set
	 */
	public void setsId(int sId) {
		this.sId = sId;
	}
	/**
	 * @return the cId
	 */
	public int getcId() {
		return cId;
	}
	/**
	 * @param cId the cId to set
	 */
	public void setcId(int cId) {
		this.cId = cId;
	}
	/**
	 * @return the bId
	 */
	public int getbId() {
		return bId;
	}
	/**
	 * @param bId the bId to set
	 */
	public void setbId(int bId) {
		this.bId = bId;
	}
	/**
	 * @return the receiptNumber
	 */
	public String getReceiptNumber() {
		return receiptNumber;
	}
	/**
	 * @param receiptNumber the receiptNumber to set
	 */
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	/**
	 * @return the receivedOn
	 */
	public Date getReceivedOn() {
		return receivedOn;
	}
	/**
	 * @param receivedOn the receivedOn to set
	 */
	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}
	@Override
	public String toString() {
		return "CourseFee [fee=" + fee + ", feePaid=" + feePaid + ", balanceFee=" + balanceFee + ", sId=" + sId + ", cId="
				+ cId + ", bId=" + bId + ", receiptNumber=" + receiptNumber + ", receivedOn=" + receivedOn + "]";
	}
	public CourseFee() {

	}
	public CourseFee(double fee, double feePaid, double balanceFee, int sId, int cId, int bId, String receiptNumber,
			Date receivedOn) {
		this.fee = fee;
		this.feePaid = feePaid;
		this.balanceFee = balanceFee;
		this.sId = sId;
		this.cId = cId;
		this.bId = bId;
		this.receiptNumber = receiptNumber;
		this.receivedOn = receivedOn;
	}

}