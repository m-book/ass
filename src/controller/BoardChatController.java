package controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class BoardChatController {

	 private static Set<Session> ses = new CopyOnWriteArraySet<>();

	    @OnOpen
	    public void onOpen(Session session) {
	        System.out.println("onOpen : " + session);
	        ses.add(session);
	    }

	    @OnSet
	    public void onSet(String text) {

	    }

	    @OnMessage
	    public void onMessage(String text) {
	    	for (Session ses : ses) {
	            text += ses;
	        }
	    	for (Session ses : ses) {
	            ses.getAsyncRemote().sendText(text);
	        }
	        //return "echo => " + text;
	    }

	    @OnClose
	    public void onClose(Session session) {
	        System.out.println("onClose : " + session);
	        ses.remove(session);
	    }

	    public static void sendMessage(String msg) {
	        for (Session ses : ses) {
	            ses.getAsyncRemote().sendText(msg);
	        }
	    }

	    @Retention(RetentionPolicy.RUNTIME)
	    @Target({ java.lang.annotation.ElementType.METHOD })
	    public @interface OnSet {
	    	long maxMessageSize() default -1L;
	    }


}
