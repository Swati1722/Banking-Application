package com.techlab.entity;

import java.sql.Date;

public class Transaction {

	private int transactionid;
	private String transactionType;
	private int accountNo;
	private int receiverAcNo;
	private double amount;
	private Date date;
	
	
	public Transaction(int transactionid, String transactionType, int accountNo, int receiverAcNo, double amount,
			Date date) {
		super();
		this.transactionid = transactionid;
		this.transactionType = transactionType;
		this.accountNo = accountNo;
		this.receiverAcNo = receiverAcNo;
		this.amount = amount;
		this.date = date;
	}
	public Transaction(String transactionType, int accountNo, double amount, Date date) {
		super();
		this.transactionType = transactionType;
		this.accountNo = accountNo;
		this.amount = amount;
		this.date = date;
	}
	public Transaction(String transactionType, int accountNo, int receiverAcNo, double amount, Date date) {
		super();
		
		this.transactionType = transactionType;
		this.accountNo = accountNo;
		this.receiverAcNo = receiverAcNo;
		this.amount = amount;
		this.date = date;
	}
	public Transaction(int transactionid, String transactionType, int accountNo,  double amount,
			Date date) {
		super();
		this.transactionid = transactionid;
		this.transactionType = transactionType;
		this.accountNo = accountNo;
		
		this.amount = amount;
		this.date = date;
	}
	
	
	
	public int getReceiverAcNo() {
		return receiverAcNo;
	}
	public void setReceiverAccno(int receiverAcNo) {
		this.receiverAcNo = receiverAcNo;
	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactionType=" + transactionType + ", accountNo="
				+ accountNo + ", receiverAcNo=" + receiverAcNo + ", amount=" + amount + ", date=" + date + "]";
	}
	
	
	
}
