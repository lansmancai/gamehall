package com.lansmancai.lanhall.fivechess.client.action;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.ChatPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.UserTable;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;

/**
 * ������ҽ�������ҽ��������Action������
 * 
 */
public class ReceiveInAction implements ClientAction {

	
	public void execute(Response response) {
		//�õ��½�������
		ChessUser newUser = (ChessUser)response.getData("newUser");
		//������б��м���һ�������
		UserTable userTable = (UserTable)UIContext.modules.get(UIContext.HALL_USER_TABLE);
		userTable.addUser(newUser);
		//���������������
		ChatPanel chatPanel = (ChatPanel)UIContext.modules.get(UIContext.HALL_CHAT_PANEL);
		chatPanel.appendContent(newUser.getName() + " ������");
		chatPanel.refreshJComboBox();
	}

}
