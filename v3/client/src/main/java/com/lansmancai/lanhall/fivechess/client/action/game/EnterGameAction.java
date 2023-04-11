package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.client.ChessClientContext;
import com.lansmancai.lanhall.fivechess.client.ui.HallPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.ChessFrame;
import com.lansmancai.lanhall.fivechess.commons.*;

/**
 * 进入五子棋游戏的Action
 * 
 */
public class EnterGameAction implements ClientAction {

	
	public void execute(Response response) {
		HallPanel hallPanel = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		//从服务器呼应中得到桌子编号
		Integer tableNumber = (Integer)response.getData("tableNumber");
		String side = (String)response.getData("side");
		//根据桌子编号得到桌子信息
		Table table = Table.getTable(tableNumber, hallPanel.getTables());
		//显示界面
		ChessFrame cf = new ChessFrame(table, ChessClientContext.chessUser);
		cf.setVisible(true);
		//告诉对方进入游戏(如果有对方玩家的话)
		Seat seat = table.getSeat(side);
		//得到对方座位
		Seat otherSeat = table.getAnotherSeat(seat);
		if (otherSeat.getUser() != null) {
			//有对手, 向服务器发送请求
			Request request = new Request(
					"com.lansmancai.lanhall.fivechess.server.action.OpponentEnterAction", 
					"com.lansmancai.lanhall.fivechess.client.action.game.OpponentEnterAction");
			//firstUserId是对手的ID(第一个进入游戏的玩家)
			request.setParameter("firstUserId", otherSeat.getUser().getId());
			//secondUserId是自己的ID(后进入游戏的玩家)
			request.setParameter("secondUserId", seat.getUser().getId());
			Usocket.ps.println(XStreamUtil.toXML(request));
		}
	}

}
