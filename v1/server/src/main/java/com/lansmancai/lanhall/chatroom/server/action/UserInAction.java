package com.lansmancai.lanhall.chatroom.server.action;

import java.io.*;
import java.net.Socket;

import com.lansmancai.lanhall.chatroom.server.ChatContext;
import com.lansmancai.lanhall.commons.*;

/**
 * �û����������ҵķ�����������
 * 
 */
public class UserInAction implements ServerAction {
	public void execute(Request request, Response response, Socket socket) {
		//�õ��½��������ҵ��û�
		User user = (User)request.getParameter("user");
		//�ŵ���������
		ChatContext.users.put(user.getId(), user);
		//����ԭ�����û�, ����������, ���������е��û���Ϣ
		response.setData("users", ChatContext.users);
		try {
			StoreSocket.getOutStream(user.getId()).println(getResponseXML(response));
			System.out.println(response);
			//����ȫ���û�, �����û�����
			String receiveUserInAction = (String) request.getParameter("userInAction");
			//�ÿͻ��˴��������˽��������ҵ�Action
			response.setActionClass(receiveUserInAction);
			response.setData("newUser", user);
			//�������û�����
			for (String key : ChatContext.users.keySet()) {
				User u = ChatContext.users.get(key);
				if (u.getId() != user.getId()) {
				    System.out.println("------");
					System.out.println(u.getId());
					System.out.println(response);
					StoreSocket.getOutStream(u.getId()).println(getResponseXML(response));
					System.out.println("------");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String getResponseXML(Response response) {
		return XStreamUtil.toXML(response);
	}

}
