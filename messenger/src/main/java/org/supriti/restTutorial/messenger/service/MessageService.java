package org.supriti.restTutorial.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.supriti.restTutorial.messenger.database.DatabaseClass;
import org.supriti.restTutorial.messenger.model.Message;

public class MessageService {
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1, "HEllo USA", "Tara"));
		messages.put(2L, new Message(2, "HEllo Tokyo", "Mamon"));
	}
	
	public List<Message> getAllMessage(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessageByAuthor(String authorName){
		List<Message> listOfMessageByAuthor =  new ArrayList();
		if(authorName.isEmpty()){
			return null;
		} else{
			//listOfMessageByAuthor = messages.values();
			for(Message message : messages.values()){
				if(message.getAuthor().equalsIgnoreCase(authorName)){
					listOfMessageByAuthor.add(message);
				}
			}
			
		}
		return listOfMessageByAuthor;
	} 
	
	public List<Message> getAllMessageByPagination(List<Message> listOfMessageByAuthor, int start, int size){
		if(start + size > listOfMessageByAuthor.size()){
			return listOfMessageByAuthor;
		}else{
			return listOfMessageByAuthor.subList(start, start + size);
		}
	} 
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setMessageID(messages.size()+1);
		messages.put(message.getMessageID(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getMessageID() <= 0){
			return null;
		}else{
			messages.put(message.getMessageID(), message);
			return message;
		}
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}
