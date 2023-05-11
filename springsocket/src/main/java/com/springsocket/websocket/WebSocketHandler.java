package com.springsocket.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
	  private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<String, WebSocketSession>();
		
	    @Override
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    	System.out.println("웹소켓시작");
	        CLIENTS.put(session.getId(), session);
	    }

	    
	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	    	System.out.println("웹소켓종료");
	        CLIENTS.remove(session.getId());
	    }

	    @Override
	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	    	/*
	       String msg = message.getPayload();
	       for(String key : CLIENTS.keySet()) {
	    	   WebSocketSession ws = CLIENTS.get(key);
	    	   
	    	   try {
	    		   ws.sendMessage(new TextMessage(msg));
	    	   }catch(Exception e) {
	    		   e.printStackTrace();
	    	   }
	       }
	    	*/

	    	String id = session.getId(); 
	        CLIENTS.entrySet().forEach( arg->{
	            if(!arg.getKey().equals(id)) { 
	                try {
	                    arg.getValue().sendMessage(message);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	       
	    }
}
