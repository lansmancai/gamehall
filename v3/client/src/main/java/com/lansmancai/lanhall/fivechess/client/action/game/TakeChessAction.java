package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.GamePanel;

/**
 * ����������, ���շ��������͵���Ӧ
 * 
 */
public class TakeChessAction implements ClientAction {

	public void execute(Response response) {
		//�õ�����
		Integer i = (Integer)response.getData("i");
		Integer j = (Integer)response.getData("j");
		String color = (String)response.getData("color");
		GamePanel gamePanel = (GamePanel)UIContext.modules.get(UIContext.GAME_PANEL);
		gamePanel.getChessArray()[i][j].setColor(color);
		gamePanel.myTurn();
	}

}
