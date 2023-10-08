package com.techlab.entity;

public class Customer {

	private int cid;
	private String firstname;
	private String lastname;
	private String password;
	private String username;
	private String mobile;
	public Customer(int cid, String firstname, String lastname, String password, String username, String mobile) {
		super();
		this.cid = cid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
		this.mobile = mobile;
	}
	public Customer( String firstname, String lastname, String password, String username, String mobile) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
		this.mobile = mobile;
	}
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	@Override
	public String toString() {
		return "Customer [firstname=" + firstname + ", lastname=" + lastname + ", password=" + password + ", username="
				+ username + ", mobile=" + mobile + "]";
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
