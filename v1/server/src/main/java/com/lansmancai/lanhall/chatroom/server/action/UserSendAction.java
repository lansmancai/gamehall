package com.lansmancai.lanhall.chatroom.server.action;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.lansmancai.lanhall.chatroom.server.ChatContext;
import com.lansmancai.lanhall.commons.*;



/**
 * 用户发送信息的Action
 * 
 */
public class UserSendAction implements ServerAction {
	public void execute(Request request, Response response, Socket socket) {
		String content = (String)request.getParameter("content");
		String receiverId = (String)request.getParameter("receiverId");
		String senderId = (String)request.getParameter("senderId");
		//得到发送人
		User sender = ChatContext.users.get(senderId);
		if ("all".equals(receiverId)) {
			//向所有人发
			sendToAll(content, sender, response);
		} else {
			//向一个人发
			sendToOne(content, receiverId, sender, response);
		}
	}
	
	//向全部人发送
	private void sendToAll(String content, User sender, Response response) {
		response.setData("senderName", sender.getName());
		for (String key : ChatContext.users.keySet()) {
			User user = ChatContext.users.get(key);
			if (user.getId() != sender.getId()) {
				try {
					System.out.println(user.getId());
					StoreSocket.getOutStream(user.getId()).println(getResponseXML(response));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//向具体的一个人发送
	private void sendToOne(String content, String receiverId, User sender, 
			Response response) {
		User receiver = ChatContext.users.get(receiverId);
		response.setData("senderName", sender.getName());
		try {
			System.out.println(receiver.getId());
			StoreSocket.getOutStream(receiver.getId()).println(getResponseXML(response));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getResponseXML(Response response) {
		return XStreamUtil.toXML(response);
	}

}
