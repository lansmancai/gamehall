package com.lansmancai.lanhall.chatroom.client.action;

import com.lansmancai.lanhall.chatroom.client.ClientContext;
import com.lansmancai.lanhall.chatroom.client.ui.MainFrame;
import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;

/**
 * �����������ݵ�Action
 * 
 */
public class ReceiveMessageAction implements ClientAction {

	public void execute(Response response) {
		String content = (String)response.getData("content");
		String senderName = (String)response.getData("senderName");
		MainFrame mainFrame = ClientContext.mainFrame;
		mainFrame.appendContent(senderName + " ����˵: " + content);
	}

}
