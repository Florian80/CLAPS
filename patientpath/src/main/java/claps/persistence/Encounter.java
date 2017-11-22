package claps.persistence;

import java.io.Serializable;

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
