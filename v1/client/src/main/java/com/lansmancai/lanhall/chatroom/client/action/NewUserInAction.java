package com.lansmancai.lanhall.chatroom.client.action;

import com.lansmancai.lanhall.chatroom.client.ClientContext;
import com.lansmancai.lanhall.chatroom.client.ui.MainFrame;
import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.commons.User;

/**
 * 接收新用户进入的处理类
 */
public class NewUserInAction implements ClientAction {

	public void execute(Response response) {
		User newUser = (User)response.getData("newUser");
		System.out.println(newUser);
		MainFrame mainFrame = ClientContext.mainFrame;
		mainFrame.addUser(newUser);
	}

}
