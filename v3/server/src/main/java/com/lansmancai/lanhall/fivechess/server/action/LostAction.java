package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 玩家认输执行的服务器Action
 * 
 */
public class LostAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		String userId = (String)request.getParameter("userId");
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		ChessUser user = ChessContext.users.get(userId);
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		ChessUser opponent = table.getAnotherUser(user);
		//设置双方的状态
		user.setReady(false);
		opponent.setReady(false);
		//告诉对手赢了
		//opponent.getPrintStream().println(XStreamUtil.toXML(response));
		StoreSocket.getOutStream(opponent.getId()).println(XStreamUtil.toXML(response));
	}

}
