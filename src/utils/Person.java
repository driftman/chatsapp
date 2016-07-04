package utils;

import java.util.Date;
import java.util.List;

public class Person {
	
	private Long id;
	private String userName;
	private String name;
	private String secondName;
	private Date lastAppearance;
	private Integer nbFriends;
	private List<Person> friends;
	private String temporarySessionId;
	
	public Person(Long id, String userName, String name, String secondName) {
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.secondName = secondName;
		this.temporarySessionId = null;
	}
	
	public Person() {
		
	}
	
	
	public String getTemporarySessionId() {
		return temporarySessionId;
	}

	public void setTemporarySessionId(String temporarySessionId) {
		this.temporarySessionId = temporarySessionId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Date getLastAppearance() {
		return lastAppearance;
	}
	public void setLastAppearance(Date lastAppearance) {
		this.lastAppearance = lastAppearance;
	}
	public Integer getNbFriends() {
		return nbFriends;
	}
	public void setNbFriends(Integer nbFriends) {
		this.nbFriends = nbFriends;
	}
	public List<Person> getFriends() {
		return friends;
	}
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", userName=" + userName + ", name=" + name + ", secondName=" + secondName
				+ ", lastAppearance=" + lastAppearance + ", nbFriends=" + nbFriends + ", friends=" + friends + ", sessionId=" + temporarySessionId + "]";
	}
	
	
}
