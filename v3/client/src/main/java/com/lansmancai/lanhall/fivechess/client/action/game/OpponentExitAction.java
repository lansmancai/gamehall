package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.HallPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.ChessFrame;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;

/**
 * 对手退出游戏, 服务器告诉剩下的玩家, 对手退出了
 * 
 */
public class OpponentExitAction implements ClientAction {

	public void execute(Response response) {
		//得到退出的玩家Id
		String exitUserId = (String)response.getData("userId");
		//得到大厅对象
		HallPanel hallPanel = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		//得到退出的玩家
		ChessUser exitUser = hallPanel.getUser(exitUserId);
		//告诉没有退出的玩家, 让其刷新界面
		ChessFrame cf = (ChessFrame)UIContext.modules.get(UIContext.GAME_FRAME);
		cf.userExit(exitUser);
	}

}
