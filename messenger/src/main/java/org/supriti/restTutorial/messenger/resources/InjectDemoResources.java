package org.supriti.restTutorial.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResources {

	@GET
	@Path("annotations")
	public String getParamUsingAnnotation(@MatrixParam("author") String author,
			                              @MatrixParam("country") String country,
			                              @HeaderParam("authSessionID") String authSessionID, 
			                              @CookieParam("name") String name
			){
			return "author is :: " + author + "   country is  ::" + country
					+ "   Headerparam is ::" + authSessionID + "  Cookieparam  ::" + name;
		}
	@GET
	@Path("context")
	public String getParameterUsinContext(@Context UriInfo UriInfo,
			                           @Context HttpHeaders httpHeaders,
			                           @Context SecurityContext secContext
										){
		String path = UriInfo.getAbsolutePath().toString();
		List<String> header = httpHeaders.getRequestHeader("autho");
		// System.out.println("Caller -- "+ secContext.getUserPrincipal().getName());
	      System.out.println("Authentication Scheme -- "+ secContext.getAuthenticationScheme());
	      System.out.println("Over HTTPS ? -- "+ secContext.isSecure());
	     // System.out.println("Belongs to 'admin' role? -- "+ secContext.isUserInRole("admin"));
		return path + " " + header;
		
	}
}
