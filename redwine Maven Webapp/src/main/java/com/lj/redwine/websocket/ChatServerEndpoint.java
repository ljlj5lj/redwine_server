package com.lj.redwine.websocket;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket/{user}")
public class ChatServerEndpoint {

	private static Set<Session> sessions = new HashSet<Session>();
	private Session session;

	@OnOpen
	public void open(Session session, @PathParam(value = "user") String user) {

		this.session = session;
		sessions.add(this.session);

		sendToAll(user + " 已进入咨询室");

		System.out.println(user + " 已进入咨询室 ！");
	}

	@OnClose
	public void close() {

		sessions.remove(session);

		sendToAll(session.getRequestURI() + " 离开咨询室 ！");

		System.out.println(session.getRequestURI() + " 离开咨询室  ！");
	}

	@OnMessage
	public void message(String message) {

		sendToAll(message);

		System.out.println(message);
	}

	// 发送给所有的聊天者
	private void sendToAll(String text) {

		for (Session client : sessions) {
			synchronized (client) {
				client.getAsyncRemote().sendText(text);
			}
		}
	}

}
