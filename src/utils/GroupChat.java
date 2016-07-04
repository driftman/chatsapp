package utils;

import java.util.List;

public class GroupChat {
	
	private List<Person> recipients;
	
	private List<Message> messages;
	
	public List<Person> getRecipients() {
		return recipients;
	}
	public void setRecipients(List<Person> recipients) {
		this.recipients = recipients;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
}
