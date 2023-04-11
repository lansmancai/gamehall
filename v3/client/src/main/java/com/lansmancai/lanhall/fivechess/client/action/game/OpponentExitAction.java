package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.HallPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.ChessFrame;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;

/**
 * �����˳���Ϸ, ����������ʣ�µ����, �����˳���
 * 
 */
public class OpponentExitAction implements ClientAction {

	public void execute(Response response) {
		//�õ��˳������Id
		String exitUserId = (String)response.getData("userId");
		//�õ���������
		HallPanel hallPanel = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		//�õ��˳������
		ChessUser exitUser = hallPanel.getUser(exitUserId);
		//����û���˳������, ����ˢ�½���
		ChessFrame cf = (ChessFrame)UIContext.modules.get(UIContext.GAME_FRAME);
		cf.userExit(exitUser);
	}

}
