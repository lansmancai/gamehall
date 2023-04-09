package com.lansmancai.lanhall.chatroom.server.action;

import java.io.*;
import java.net.Socket;

import com.lansmancai.lanhall.chatroom.server.ChatContext;
import com.lansmancai.lanhall.commons.*;

/**
 * 用户进入聊天室的服务器处理类
 * 
 */
public class UserInAction implements ServerAction {
	public void execute(Request request, Response response, Socket socket) {
		//得到新进入聊天室的用户
		User user = (User)request.getParameter("user");
		//放到上下文中
		ChatContext.users.put(user.getId(), user);
		//告诉原来的用户, 启动聊天室, 并发送所有的用户信息
		response.setData("users", ChatContext.users);
		try {
			StoreSocket.getOutStream(user.getId()).println(getResponseXML(response));
			System.out.println(response);
			//告诉全部用户, 有新用户进入
			String receiveUserInAction = (String) request.getParameter("userInAction");
			//让客户端处理有新人进入聊天室的Action
			response.setActionClass(receiveUserInAction);
			response.setData("newUser", user);
			//向所有用户发送
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
