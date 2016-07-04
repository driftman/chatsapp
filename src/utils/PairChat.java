package utils;

import java.util.Date;
import java.util.List;

public class PairChat {
	
	private Long firstPerson;
	private Long secondPerson;
	private Long messages[];
	private Date lastAction;
	
	
	public PairChat(Long firstPerson, Long secondPerson, Date lastAction, Long messages[]) {
		super();
		this.firstPerson = firstPerson;
		this.secondPerson = secondPerson;
		this.lastAction = lastAction;
		this.messages = messages;
	}
	public Long getFirstPerson() {
		return firstPerson;
	}
	public void setFirstPerson(Long firstPerson) {
		this.firstPerson = firstPerson;
	}
	public Long getSecondPerson() {
		return secondPerson;
	}
	public void setSecondPerson(Long secondPerson) {
		this.secondPerson = secondPerson;
	}
	public Long[] getMessages() {
		return messages;
	}
	public void setMessages(Long messages[]) {
		this.messages = messages;
	}
	public Date getLastAction() {
		return lastAction;
	}
	public void setLastAction(Date lastAction) {
		this.lastAction = lastAction;
	}
	
	
}
