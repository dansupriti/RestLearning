package uidgenarator;

import java.util.UUID;

public class UID {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		System.out.println("uuid = " + uuid);
	}
	
}
