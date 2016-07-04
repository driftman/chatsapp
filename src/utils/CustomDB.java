package utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CustomDB {
	
	public static List<Message> messages = new ArrayList<Message>() {{
		add(new Message(1L, 1L, new Date(), "Hello Jane !"));
		add(new Message(2L, 2L, new Date(), "Hi John !"));
	}};
	
	public static HashMap<Long, Person> people = new HashMap<Long, Person>(){{
		put(1L, new Person(1L, "user1", "John", "DOE"));
		put(2L, new Person(2L, "user2", "Jane", "DOE"));
	}};
	
	
	public static List<PairChat> pairChats = new ArrayList<PairChat>(){{
		add(new PairChat(1L, 2L, new Date(), new Long[]{1L, 2L}));
	}};
	
	public static Person setTemporarySessionId(Long id, String sessionId) {
		Person connectedUser = getPersonById(id);
		connectedUser.setTemporarySessionId(sessionId);
		people.put(id, connectedUser);
		return connectedUser;
	}
	
	public static Person getPersonById(Long id) {
		System.out.println("The requested id: " + id);
		for(Long keyId : people.keySet()) {
			if(keyId == id) {
				return people.get(keyId);
			}
		}
		return null;
	}
	
	public static Person getPersonBySessionId(String sessionId) {
		for(Long keyId : people.keySet()) {
			Person person = people.get(keyId);
			if(person.getTemporarySessionId() == sessionId) {
				return person;
			}
		}
		return null;
	}
	
}
