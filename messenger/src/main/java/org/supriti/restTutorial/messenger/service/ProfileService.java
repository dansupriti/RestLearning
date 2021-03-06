package org.supriti.restTutorial.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.supriti.restTutorial.messenger.database.DatabaseClass;
import org.supriti.restTutorial.messenger.model.Message;
import org.supriti.restTutorial.messenger.model.Profile;

public class ProfileService {
	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Tara", new Profile(1L, "Tara", "San"));
		profiles.put("Mamaon", new Profile(2L, "Mamon", "San"));
	}
	
	public List<Profile> getAllProfile(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	
	public Profile getProfileByName(String name){
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile){
		profile.setProfileID(profiles.size()+1);
		//message.setMessageID(messages.size()+1);
		profiles.put(profile.getFirstName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getFirstName().isEmpty()){
			return null;
		}else{
			profiles.put(profile.getFirstName(), profile);
			return profile;
		}
	}
	
	public Profile removeProfile(String name){
		return profiles.remove(name);
	}
}
