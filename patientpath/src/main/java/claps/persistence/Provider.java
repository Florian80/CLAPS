package claps.persistence;

import java.io.Serializable;

public class Provider implements Serializable {

	int providerID;
	int providerinfoID;
	String providerName;
	
	public Provider() {
		
	}
	
	public Provider(int providerID, int providerinfoID, String providerName) {
		
		this.providerID = providerID;
		this.providerinfoID = providerinfoID;
		this.providerName = providerName;
		
	}

	public int getProviderID() {
		return providerID;
	}

	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}

	public int getProviderinfoID() {
		return providerinfoID;
	}

	public void setProviderinfoID(int providerinfoID) {
		this.providerinfoID = providerinfoID;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
}
