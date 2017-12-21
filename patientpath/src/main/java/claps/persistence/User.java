package claps.persistence;

import java.io.Serializable;

//Simple Bean for User with UserID, UserName and Password
public class User implements Serializable {

	int userID;
	String userName;
	String password;
	
	public User() {

	}

	public User(int userID, String userName, String password) {
		
		this.userID = userID;
		this.userName = userName;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}