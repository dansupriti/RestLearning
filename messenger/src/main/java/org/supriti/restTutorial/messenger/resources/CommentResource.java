package org.supriti.restTutorial.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class CommentResource {
	
//	public CommentResource(){
//		
//	}
	
	@GET
	//@Path("/{messageID}")
	public String test(){
		System.out.println("within subresource ::");
		return "new subresource";
	}
	
}
