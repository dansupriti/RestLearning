package org.supriti.restTutorial.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("messages")
public class MessegeResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessege(){
		return "JOY MAA";
	}

}
