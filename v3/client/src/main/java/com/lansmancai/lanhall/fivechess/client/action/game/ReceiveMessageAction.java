package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.ChatPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;

/**
 * ��Ϸ�н���������Ϣ����
 * 
 */
public class ReceiveMessageAction implements ClientAction {

	public void execute(Response response) {
		//�õ�����Ľ������
		ChatPanel chatPanel = (ChatPanel)UIContext.modules.get(UIContext.GAME_CHAT_PANEL);
		//�ӷ�������Ӧ�еõ�����
		String content = (String)response.getData("content");
		chatPanel.appendContent(content);
	}

}
