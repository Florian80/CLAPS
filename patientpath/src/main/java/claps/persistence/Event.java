package claps.persistence;

import java.io.Serializable;
import java.sql.Timestamp;

//Simple Bean for Event with all Variables needed (peek 2 lines below)
public class Event implements Serializable {
	
	int eventID;
	int userID;
	int pathObjectID;
	int providerID;
	int encounterID;
	int eventinfoID;
	String eventName;
	Timestamp eventDateTime;
	int eventDuration;
	
	public Event() {
		
	}
	
	public Event(int eventID, int userID, int pathObjectID, int providerID, int encounterID,
			int eventinfoID, String eventName, Timestamp eventDateTime, int eventDuration) {
		
		this.eventID = eventID;
		this.userID = userID;
		this.pathObjectID = pathObjectID;
		this.providerID = providerID;
		this.encounterID = encounterID;
		this.eventinfoID = eventinfoID;
		this.eventName = eventName;
		this.eventDateTime = eventDateTime;
		this.eventDuration = eventDuration;	
		
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getPathObjectID() {
		return pathObjectID;
	}

	public void setPathObjectID(int pathObjectID) {
		this.pathObjectID = pathObjectID;
	}

	public int getProviderID() {
		return providerID;
	}

	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}

	public int getEncounterID() {
		return encounterID;
	}

	public void setEncounterID(int encounterID) {
		this.encounterID = encounterID;
	}

	public int getEventinfoID() {
		return eventinfoID;
	}

	public void setEventinfoID(int eventinfoID) {
		this.eventinfoID = eventinfoID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Timestamp getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(Timestamp eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	public int getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(int eventDuration) {
		this.eventDuration = eventDuration;
	}
	
}
