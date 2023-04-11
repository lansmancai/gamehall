package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.GamePanel;

/**
 * ����������ʤ������Ϣ, �ͻ��˴���ʤ��, ���ո���Ϣ��һ����Ϸʤ��
 * 
 */
public class WinAction implements ClientAction {

	public void execute(Response response) {
		GamePanel gamePanel = (GamePanel)UIContext.modules.get(UIContext.GAME_PANEL);
		gamePanel.win();
	}

}
