package com.techlab.entity;

public class Account {

	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", balance=" + balance + ", custid=" + custid + "]";
	}
	private int accountno;
	private double balance;
	private int custid;
	public Account(int accountno, double balance, int custid) {
		super();
		this.accountno = accountno;
		this.balance = balance;
		this.custid = custid;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	
}
