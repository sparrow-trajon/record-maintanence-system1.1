package com.trajon.sparrow.bean;

public class Employee {

	private int id;
	private String name;
	private String emailAddress;
	private String gender;
	private int mobileNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Employee(int id, String name,String emailAddress, String gender, int mobileNumber ) {

		this.id=id;
		this.gender=gender;
		this.name=name;
		this.emailAddress= emailAddress;
		this.mobileNumber= mobileNumber;
	}
	public Employee()
	{

	}
}
