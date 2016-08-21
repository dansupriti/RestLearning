package org.supriti.restTutorial.messenger;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.supriti.restTutorial.messenger.resources.CommentResource;
import org.supriti.restTutorial.messenger.service.MessageService;
import org.supriti.restTutorial.messenger.service.XMLMessageService;
import org.supriti.restTutorial.messenger.bean.MessageFilterBean;
import org.supriti.restTutorial.messenger.model.Message;

@Path("myresource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

	MessageService messageService = new MessageService();
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Message> getMessages() {
//    	System.out.println("hiii0000");
//    	return messageService.getAllMessage();
//    }
    
    @GET
    public List<Message> getMessagesByAuthor(@BeanParam MessageFilterBean messageFilterBean
    										) {
    	//System.out.println("hiii0000 ::::" + author + start + size);
    	System.out.println("Example of bean param");
    	List<Message> listOfMessageByAuthor;
    	List<Message> listOfMessageAfterPagination = null;
    	if(messageFilterBean.getAuthor().isEmpty()){
			return null;
		}else{
			listOfMessageByAuthor = messageService.getAllMessageByAuthor(messageFilterBean.getAuthor());
		}
    	if(messageFilterBean.getStart() > 0 && messageFilterBean.getSize() > 0){
    		listOfMessageAfterPagination = messageService.getAllMessageByPagination(listOfMessageByAuthor, messageFilterBean.getStart(), messageFilterBean.getSize());
    		
    	} else{
    		System.out.println("in else" + listOfMessageByAuthor.size());
    		return listOfMessageByAuthor;
    	}
    	return listOfMessageAfterPagination;
    }
    
    @GET
    @Path("/{messageID}")
    public Message getMessagesbyID(@PathParam("messageID") long id) {
    	System.out.println("hiii00001 :::::" + id);
        return messageService.getMessage(id);
    }
    
    @POST
    public Message addMessagesbyID(Message message) {
    	System.out.println("hiii00001 :::::" + message);
        return messageService.addMessage(message);
    }
    
    @PUT
    @Path("/{messageID}")
    public Message updateMessagesbyID(@PathParam("messageID") long id, Message message) {
    	System.out.println("hiii00001 :::::" + id);
    	message.setMessageID(id);
        return messageService.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageID}")
    public Message deleteMessagesbyID(@PathParam("messageID") long id) {
    	System.out.println("hiii00001 :::::" + id);
        return messageService.removeMessage(id);
    }
    
    @GET
    @Path("/{messageID}/comments")
    public CommentResource getCommentResource(){
    	System.out.println("within myresource");
    	return new CommentResource();
    }
    
}
