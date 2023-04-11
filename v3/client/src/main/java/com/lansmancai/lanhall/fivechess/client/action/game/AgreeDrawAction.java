package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.GamePanel;

/**
 * ͬ������Ŀͻ��˴�����
 * 
 */
public class AgreeDrawAction implements ClientAction {

	public void execute(Response response) {
		GamePanel gamePanel = (GamePanel)UIContext.modules.get(UIContext.GAME_PANEL);
		gamePanel.draw();
	}

}