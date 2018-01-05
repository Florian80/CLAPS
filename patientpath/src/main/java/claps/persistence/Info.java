package claps.persistence;

import java.io.Serializable;

//Bean class for Info, containing a lot of variables (peek 2 lines below)
public class Info implements Serializable {
	
	int infoID;
	String infoName;
	String infoImageURL;
	String addressLineOne;
	String addressLineTwo;
	String addressLineThree;
	String addressLineFour;
	String telefon;
	String fax;
	String website;
	String eMail;
	String infoText;
	
	public Info() {
		
	}
	
	public Info(int infoID, String infoName, String infoImageURL, String addressLineOne, String addressLineTwo, 
			String addressLineThree, String addressLineFour, String telefon, String fax, String website, String eMail, 
			String infoText) {
		
	this.infoID = infoID;
	this.infoName = infoName;
	this.infoImageURL = infoImageURL;
	this.addressLineOne = addressLineOne;
	this.addressLineTwo = addressLineTwo;
	this.addressLineThree = addressLineThree;
	this.addressLineFour = addressLineFour;
	this.telefon = telefon;
	this.fax = fax;
	this.website = website;
	this.eMail = eMail;
	this.infoText = infoText;	
		
	}

	public int getInfoID() {
		return infoID;
	}

	public void setInfoID(int infoID) {
		this.infoID = infoID;
	}

	public String getInfoImageURL() {
		return infoImageURL;
	}

	public void setInfoImageURL(String infoImageURL) {
		this.infoImageURL = infoImageURL;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAddressLineThree() {
		return addressLineThree;
	}

	public void setAddressLineThree(String addressLineThree) {
		this.addressLineThree = addressLineThree;
	}

	public String getAddressLineFour() {
		return addressLineFour;
	}

	public void setAddressLineFour(String addressLineFour) {
		this.addressLineFour = addressLineFour;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getInfoText() {
		return infoText;
	}

	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}
	
}
