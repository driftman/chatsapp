package utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.parser.ParserDelegator;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.common.collect.Maps;

@ServerEndpoint(value="/chat")
public class SocketServer {
	
	// will hold all the connected clients
	public static Set<Session> sessions = 
			Collections.synchronizedSet(new HashSet<Session>());
	
	private HashMap<String, String> nameValuePair = new HashMap<String, String>();
	
	private JSONUtils jsonUtils = new JSONUtils();
	
	public HashMap<String, String> getParams(String queryString) {
		HashMap<String, String> map = new HashMap<String, String>();
		String params[] = queryString.split("&");
		for(String param : params) {
			String values[] = param.split("=");
			map.put(values[0], values[1]);
		}
		return map;
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("Connection closed from: " + session.getId());
		sessions.remove(session);
		String username = nameValuePair.get(session.getId());
		sendMessageToAll(username, username + " left the Vikings room", 
				session.getId(), JSONUtils.FLAG_EXIT);
		nameValuePair.remove(session.getId());
		
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("A new message received: " + message);
		Message messageObject = jsonUtils.deserializeMessage(message);
		String username = messageObject.getUsername();
		String messageText = messageObject.getMessage();
		sendMessageToAll(username, messageText, session.getId(), JSONUtils.FLAG_MESSAGE);
	}
	
	@OnOpen
	public void onOpen(Session session) {
		String username = "";
		sessions.add(session);
		String queryString = session.getQueryString();
		HashMap<String, String> queryParams = getParams(queryString);
		if(queryParams.containsKey("username")) {
			username = queryParams.get("username");
			nameValuePair.put(session.getId(), username);
			sendMessageNewConnected(session, username);
			sendMessageToAll(username, username + ", joined the Vikings room", session.getId(), JSONUtils.FLAG_NEW);
		}
		
	}
	
	public void sendMessageNewConnected(Session session, String username) {
		Message message = new Message();
		message.setMessage("You joined the Vikings room (More you are rude more respect you'll gain)");
		message.setSessionId(session.getId());
		message.setTimestamp(new Date().getTime());
		message.setUsername(username);
		String serializedMessage = jsonUtils.serializeMessage(message, JSONUtils.FLAG_INFO);
		try {
			session.getBasicRemote().sendText(serializedMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessageToAll(String username, String textMessage, String sessionId, String flag) {
		Message message = new Message();
		message.setMessage(textMessage);
		message.setSessionId(sessionId);
		message.setTimestamp(new Date().getTime());
		message.setUsername(username);
		String serializedMessage = jsonUtils.serializeMessage(message, flag);
		for(Session session : sessions) {
			if(!sessionId.equals(session.getId())) {
				try {
					session.getBasicRemote().sendText(serializedMessage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
