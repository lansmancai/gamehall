package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.ChatPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;

/**
 * 游戏中接收聊天信息的类
 * 
 */
public class ReceiveMessageAction implements ClientAction {

	public void execute(Response response) {
		//得到聊天的界面组件
		ChatPanel chatPanel = (ChatPanel)UIContext.modules.get(UIContext.GAME_CHAT_PANEL);
		//从服务器响应中得到内容
		String content = (String)response.getData("content");
		chatPanel.appendContent(content);
	}

}
