package org.supriti.restTutorial.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	private long profileID;
	private String firstName;
	private String lastName;
	private Date createdDate;
	
	public Profile(){
		
	}
	
	public Profile(long profileID, String firstName, String lastName){
		this.profileID = profileID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = createdDate;
	}

	public long getProfileID() {
		return profileID;
	}

	public void setProfileID(long profileID) {
		this.profileID = profileID;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
