/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.employee;


/**
 * User class, a session object.
 * 
 * @author x076553
 */
public class User {
	
	private String ID;
	private String firstName;
	private String lastName;
	private String Address;
	private String lang;
    private String loggedInUserCaasId;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	/**
	 * @return the loggedInUserCaasId
	 */
	public String getLoggedInUserCaasId() {
		return loggedInUserCaasId;
	}
	/**
	 * @param loggedInUserCaasId the loggedInUserCaasId to set
	 */
	public void setLoggedInUserCaasId(String loggedInUserCaasId) {
		this.loggedInUserCaasId = loggedInUserCaasId;
	}
	
}
