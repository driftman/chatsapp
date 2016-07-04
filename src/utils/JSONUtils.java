package utils;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
	
	public final static String 
	FLAG_NEW = "new", 
	FLAG_INFO = "info", 
	FLAG_MESSAGE = "message",
	FLAG_EXIT = "exit";
	
	public String serializeMessage(Message message, String tag) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject();
			jsonObject.put("username", message.getUsername());
			jsonObject.put("message", message.getMessage());
			jsonObject.put("timestamp", message.getTimestamp());
			jsonObject.put("tag", tag);
			jsonObject.put("sessionId", message.getSessionId());
			jsonObject.put("count", SocketServer.sessions.size());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	public Message deserializeMessage(String jsonString) {
		System.out.println(jsonString);
		Message message = null;
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			message = new Message();
			message.setUsername(jsonObject.getString("username"));
			message.setTag(jsonObject.getString("tag"));
			message.setMessage(jsonObject.getString("message"));
			message.setTimestamp(jsonObject.getLong("timestamp"));
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return message;
	}
}