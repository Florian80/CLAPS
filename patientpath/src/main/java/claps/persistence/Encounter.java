package claps.persistence;

import java.io.Serializable;

//A simple Bean class for "Encounter" containing the encounterId and encounterAll as a String
public class Encounter implements Serializable {
	
	int encounterID;
	String encounterAll;
	
	public Encounter() {
		
	}
	
	public Encounter(int encounterID, String encounterAll) {
		
		this.encounterID = encounterID;
		this.encounterAll = encounterAll;
		
	}

	public int getEncounterID() {
		return encounterID;
	}

	public void setEncounterID(int encounterID) {
		this.encounterID = encounterID;
	}

	public String getEncounterAll() {
		return encounterAll;
	}

	public void setEncounterAll(String encounterAll) {
		this.encounterAll = encounterAll;
	}
	
}
