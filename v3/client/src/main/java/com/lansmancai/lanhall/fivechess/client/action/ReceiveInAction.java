package com.lansmancai.lanhall.fivechess.client.action;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.ChatPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.UserTable;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;

/**
 * 所有玩家接收新玩家进入大厅的Action处理类
 * 
 */
public class ReceiveInAction implements ClientAction {

	
	public void execute(Response response) {
		//得到新进入的玩家
		ChessUser newUser = (ChessUser)response.getData("newUser");
		//向玩家列表中加入一个新玩家
		UserTable userTable = (UserTable)UIContext.modules.get(UIContext.HALL_USER_TABLE);
		userTable.addUser(newUser);
		//向聊天内容中添加
		ChatPanel chatPanel = (ChatPanel)UIContext.modules.get(UIContext.HALL_CHAT_PANEL);
		chatPanel.appendContent(newUser.getName() + " 进来了");
		chatPanel.refreshJComboBox();
	}

}
