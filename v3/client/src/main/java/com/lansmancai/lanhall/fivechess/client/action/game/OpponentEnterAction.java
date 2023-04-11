package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.ChatPanel;
import com.lansmancai.lanhall.fivechess.client.ui.HallPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.UserTable;
import com.lansmancai.lanhall.fivechess.client.ui.game.ChessFrame;
import com.lansmancai.lanhall.fivechess.client.ui.game.GamePanel;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;

/**
 * ���ֽ�����Ϸ, �ɱ�����ն��ֽ�����Ϸ����Ϣ(����������), ����˵�Ķ�����ָ�������Ϸ�����
 * ��Action�ɵ�һ��������Ϸ����ҽ���
 */
public class OpponentEnterAction implements ClientAction {

	public void execute(Response response) {
		//�õ���������
		HallPanel gameHall = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		
		//�õ����ֵ�ChessUser����
		String opponentId = (String)response.getData("opponentId");
		//�Ӵ����еõ����ֵ���Ϣ
		ChessUser opponent = gameHall.getUser(opponentId);
		ChessFrame cf = (ChessFrame)UIContext.modules.get(UIContext.GAME_FRAME);
		cf.newUserIn(opponent);

	}

}
