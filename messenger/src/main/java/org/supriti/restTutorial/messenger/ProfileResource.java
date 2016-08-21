package org.supriti.restTutorial.messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.supriti.restTutorial.messenger.service.MessageService;
import org.supriti.restTutorial.messenger.service.ProfileService;
import org.supriti.restTutorial.messenger.service.XMLMessageService;
import org.supriti.restTutorial.messenger.model.Message;
import org.supriti.restTutorial.messenger.model.Profile;

@Path("profile")
public class ProfileResource {

	ProfileService profileService = new ProfileService();
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Profile> getProfiles() {
    	System.out.println("hiii0000");
    	return profileService.getAllProfile();
    }
    
    @GET
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getMessagesbyID(@PathParam("profileName") String profileName) {
    	System.out.println("hiii00001 :::::" + profileName);
        return profileService.getProfileByName(profileName);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile) {
    	System.out.println("hiii00001 :::::" + profile);
        return profileService.addProfile(profile);
    }
    
    @PUT
    @Path("/{profileName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
    	System.out.println("hiii00001 :::::" + profile);
    	profile.setFirstName(profileName);
        return profileService.updateProfile(profile);
    }
    
    @DELETE
    @Path("/{profileName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile deleteMessagesbyID(@PathParam("profileName") String profileName) {
    	System.out.println("hiii00001 :::::" + profileName);
        return profileService.removeProfile(profileName);
    }
}
