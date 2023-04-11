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
 * 对手进入游戏, 由本类接收对手进入游戏的信息(服务器发送), 这里说的对手是指后进入游戏的玩家
 * 该Action由第一个进入游戏的玩家接收
 */
public class OpponentEnterAction implements ClientAction {

	public void execute(Response response) {
		//得到大厅对象
		HallPanel gameHall = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		
		//得到对手的ChessUser对象
		String opponentId = (String)response.getData("opponentId");
		//从大厅中得到对手的信息
		ChessUser opponent = gameHall.getUser(opponentId);
		ChessFrame cf = (ChessFrame)UIContext.modules.get(UIContext.GAME_FRAME);
		cf.newUserIn(opponent);

	}

}
