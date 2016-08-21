package org.supriti.restTutorial.messenger.bean;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	
	private @QueryParam("author") String author;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
