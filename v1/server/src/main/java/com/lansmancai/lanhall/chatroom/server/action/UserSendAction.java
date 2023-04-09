package com.lansmancai.lanhall.chatroom.server.action;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.lansmancai.lanhall.chatroom.server.ChatContext;
import com.lansmancai.lanhall.commons.*;



/**
 * �û�������Ϣ��Action
 * 
 */
public class UserSendAction implements ServerAction {
	public void execute(Request request, Response response, Socket socket) {
		String content = (String)request.getParameter("content");
		String receiverId = (String)request.getParameter("receiverId");
		String senderId = (String)request.getParameter("senderId");
		//�õ�������
		User sender = ChatContext.users.get(senderId);
		if ("all".equals(receiverId)) {
			//�������˷�
			sendToAll(content, sender, response);
		} else {
			//��һ���˷�
			sendToOne(content, receiverId, sender, response);
		}
	}
	
	//��ȫ���˷���
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
	
	//������һ���˷���
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
