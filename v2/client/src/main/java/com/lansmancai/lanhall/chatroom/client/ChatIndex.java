package com.lansmancai.lanhall.chatroom.client;

import java.io.PrintStream;
import java.net.Socket;
import java.io.*;
import com.lansmancai.lanhall.commons.*;



public class ChatIndex implements Game {

	public void start(User user, Socket usock) {
		ClientContext.user = user;
		//进入聊天室, 告诉服务器用户有用户进入
		Request request = new Request("com.lansmancai.lanhall.chatroom.server.action.UserInAction",
				"com.lansmancai.lanhall.chatroom.client.action.StartAction");
		request.setParameter("userInAction",
				"com.lansmancai.lanhall.chatroom.client.action.NewUserInAction");
		request.setParameter("user", user);
		Usocket.usket = usock;
		try {
			Usocket.os = Usocket.usket.getOutputStream();
			Usocket.is = Usocket.usket.getInputStream();
			Usocket.ps = new PrintStream(Usocket.os);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Usocket.ps.println(XStreamUtil.toXML(request));
	}
	
	public String toString() {
		return "chatroom";
	}

}
