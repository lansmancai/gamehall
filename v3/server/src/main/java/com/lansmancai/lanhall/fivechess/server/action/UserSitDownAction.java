package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.commons.util.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 玩家坐下的Action
 * 
 */
public class UserSitDownAction implements ServerAction {
	
	public void execute(Request request, Response response, Socket socket) {
		//得到桌子编号
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		String side = (String)request.getParameter("side");
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		//得到刚坐下的玩家
		String userId = (String)request.getParameter("userId");
		ChessUser user = ChessContext.users.get(userId);
		//如果玩家已经在座位上, 则返回错误信息
		if (user.hasSitDown(ChessContext.tables)) {
			response.setErrorCode(FiveChessErrorCode.HAS_SIT_DOWN);
			//user.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(user.getId()).println(XStreamUtil.toXML(response));
			return;
		}
		//得到座位
		Seat seat = table.getSeat(side);
		//判断座位上是否有人
		if (seat.getUser() != null) {
			//座位上有人, 发送错误信息
			response.setErrorCode(FiveChessErrorCode.SEAT_HAS_USER);
			//user.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(user.getId()).println(XStreamUtil.toXML(response));
		} else {
			seat.setUser(user);
			//告诉所有的客户端, 刚坐下的玩家在哪张桌子哪个位置坐下了
			response.setData("tableNumber", table.getTableNumber());
			response.setData("side", side);
			response.setData("user", user.getId());
			//向所有玩家发送信息, 有新玩家坐下
			printResponse(user, response);
			//得到启动游戏的客户端类
			String beginClass = (String)request.getParameter("beginClass");
			response.setActionClass(beginClass);
			//告诉客户端, 需要启动游戏界面
			//user.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(user.getId()).println(XStreamUtil.toXML(response));
		}
	}
	
	/**
	 * 向所有玩家发送信息, 参数的user坐下了
	 * @param user
	 */
	private void printResponse(ChessUser user, Response response) {
		for (String id : ChessContext.users.keySet()) {
			ChessUser u = ChessContext.users.get(id);
			if (u.getId().equals(user.getId())) continue;
			//u.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(u.getId()).println(XStreamUtil.toXML(response));
		}
	}
	

}
