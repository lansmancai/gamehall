package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.GamePanel;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;

/**
 * 对手准备好, 接收服务器响应的Action
 * 
 */
public class OpponentReadyAction implements ClientAction {

	
	public void execute(Response response) {
		GamePanel gamePanel = (GamePanel)UIContext.modules.get(UIContext.GAME_PANEL);
		//得到对手
		ChessUser opponent = gamePanel.getOtherChessUser();
		if (opponent != null) {
			opponent.setReady(true);
		}
		gamePanel.repaint();
	}

}
