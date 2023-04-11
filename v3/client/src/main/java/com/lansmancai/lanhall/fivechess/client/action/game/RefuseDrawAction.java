package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.GamePanel;

/**
 * 接收对方拒绝求和的Action
 * 
 */
public class RefuseDrawAction implements ClientAction {

	public void execute(Response response) {
		String userName = (String)response.getData("userName");
		GamePanel gamePanel = (GamePanel)UIContext.modules.get(UIContext.GAME_PANEL);
		gamePanel.handleRefuseDraw(userName);
	}

}
