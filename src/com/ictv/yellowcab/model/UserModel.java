package com.ictv.yellowcab.model;

import java.io.Serializable;

public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usernameStr;
	private String passwordStr;
	private String firstNameStr;
	private String middleNameStr;
	private String lastNameStr;
	private String addressStr;
	private String mobileNumberStr;
	private String dateOfBirth;
	private String professionStr;
	private String affilStr;
	private String emailStr;
	private String tokenStr;
	private String socialTokenFromStr;
	
	public String getUsernameStr() {
		return usernameStr;
	}
	public void setUsernameStr(String usernameStr) {
		this.usernameStr = usernameStr;
	}
	public String getPasswordStr() {
		return passwordStr;
	}
	public void setPasswordStr(String passwordStr) {
		this.passwordStr = passwordStr;
	}
	public String getFirstNameStr() {
		return firstNameStr;
	}
	public void setFirstNameStr(String firstNameStr) {
		this.firstNameStr = firstNameStr;
	}
	public String getMiddleNameStr() {
		return middleNameStr;
	}
	public void setMiddleNameStr(String middleNameStr) {
		this.middleNameStr = middleNameStr;
	}
	public String getLastNameStr() {
		return lastNameStr;
	}
	public void setLastNameStr(String lastNameStr) {
		this.lastNameStr = lastNameStr;
	}
	public String getAddressStr() {
		return addressStr;
	}
	public void setAddressStr(String addressStr) {
		this.addressStr = addressStr;
	}
	public String getMobileNumberStr() {
		return mobileNumberStr;
	}
	public void setMobileNumberStr(String mobileNumberStr) {
		this.mobileNumberStr = mobileNumberStr;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getProfessionStr() {
		return professionStr;
	}
	public void setProfessionStr(String professionStr) {
		this.professionStr = professionStr;
	}
	public String getAffilStr() {
		return affilStr;
	}
	public void setAffilStr(String affilStr) {
		this.affilStr = affilStr;
	}
	public String getEmailStr() {
		return emailStr;
	}
	public void setEmailStr(String emailStr) {
		this.emailStr = emailStr;
	}
	public String getTokenStr() {
		return tokenStr;
	}
	public void setTokenStr(String tokenStr) {
		this.tokenStr = tokenStr;
	}
	public String getSocialTokenFromStr() {
		return socialTokenFromStr;
	}
	public void setSocialTokenFromStr(String socialTokenFromStr) {
		this.socialTokenFromStr = socialTokenFromStr;
	}
	
	
}


