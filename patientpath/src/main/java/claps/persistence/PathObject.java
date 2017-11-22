package claps.persistence;

import java.io.Serializable;

public class PathObject implements Serializable {

	int pathObjectID;
	int pathObjectinfoID;
	String pathObjectName;

	public PathObject(){
		
	}
	
	public PathObject(int pathObjectID, int pathObjectinfoID, String pathObjectName) {
		
	this.pathObjectID = pathObjectID;
	this.pathObjectinfoID = pathObjectinfoID;
	this.pathObjectName = pathObjectName;
		
	}

	public int getPathObjectID() {
		return pathObjectID;
	}

	public void setPathObjectID(int pathObjectID) {
		this.pathObjectID = pathObjectID;
	}

	public int getPathObjectinfoID() {
		return pathObjectinfoID;
	}

	public void setPathObjectinfoID(int pathObjectinfoID) {
		this.pathObjectinfoID = pathObjectinfoID;
	}

	public String getPathObjectName() {
		return pathObjectName;
	}

	public void setPathObjectName(String pathObjectName) {
		this.pathObjectName = pathObjectName;
	}
	
}