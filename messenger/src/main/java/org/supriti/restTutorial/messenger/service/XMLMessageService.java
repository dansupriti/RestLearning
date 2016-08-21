package org.supriti.restTutorial.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.supriti.restTutorial.messenger.model.Message;

public class XMLMessageService {
	public List<Message> getAllMessage(){
		Message m1 = new Message(1, "HEllo USA", "Tara");
		Message m2 = new Message(1, "HEllo Tokyo", "Mamon");
		List<Message> allMessage = new ArrayList<Message>();
		allMessage.add(m1);
		allMessage.add(m2);
		return allMessage;
	}
}
