package org.supriti.restTutorial.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private long  messageID;
	private Date messageCreationDate;
	private String message;
	private String author;
	
	public Message(){
		
	}
	
	public Message(long messageID, String message, String author){
		this.messageID = messageID;
		this.message = message;
		this.author = author;
	}
	public long getMessageID() {
		return messageID;
	}
	public void setMessageID(long messageID) {
		System.out.println(messageID);
		this.messageID = messageID;
	}
	public Date getMessageCreationDate() {
		return messageCreationDate;
	}
	public void setMessageCreationDate(Date messageCreationDate) {
		this.messageCreationDate = messageCreationDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
