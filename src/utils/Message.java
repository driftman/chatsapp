package utils;

/**
 * Created by admin on 01/07/2016.
 */
public class Message {

    private String username;
    private String message;
    private Long timestamp;
    private Boolean self;
    private String tag;
    private String sessionId;

    public Message() {
    }

    public Message(String username, Boolean self, String message, Long timestamp) {
        this.username = username;
        this.self = self;
        this.message = message;
        this.timestamp = timestamp;
    }
    

    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSelf() {
        return self;
    }

    public void setSelf(Boolean self) {
        this.self = self;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
