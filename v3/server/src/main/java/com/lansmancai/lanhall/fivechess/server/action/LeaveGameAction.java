package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 玩家离开游戏时服务器执行的Action
 * 
 */
public class LeaveGameAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		String userId = (String)request.getParameter("userId");
		//得到离开的玩家
		ChessUser user = ChessContext.users.get(userId);
		user.setReady(false);
		//得到桌子
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		//得到玩家的座位
		Seat seat = table.getUserSeat(user);
		//设置座位的玩家为空
		seat.setUser(null);
		response.setData("side", seat.getSide());
		//发送服务器响应, 告诉所有玩家, 该玩家退出
		printResponse(response);
		
		//告诉退出玩家的对手, 他退出了
		Seat otherSeat = table.getAnotherSeat(seat);
		if (otherSeat.getUser() != null) {
			String exitAction = (String)request.getParameter("exitAction");
			response.setActionClass(exitAction);
			//otherSeat.getUser().getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(otherSeat.getUser().getId()).println(XStreamUtil.toXML(response));
		}
	}
	
	private void printResponse(Response response) {
		for (String id : ChessContext.users.keySet()) {
			ChessUser u = ChessContext.users.get(id);
			//u.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(u.getId()).println(XStreamUtil.toXML(response));
		}
	}

}
