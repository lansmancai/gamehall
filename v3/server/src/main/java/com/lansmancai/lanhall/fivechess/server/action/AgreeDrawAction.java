package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 服务器处理同意求和的Action
 * 
 */
public class AgreeDrawAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		String userId = (String)request.getParameter("userId");
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		ChessUser user = ChessContext.users.get(userId);
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		ChessUser opponent = table.getAnotherUser(user);
		//设置双方的状态(服务器中)
		user.setReady(false);
		opponent.setReady(false);
		//opponent.getPrintStream().println(XStreamUtil.toXML(response));
		StoreSocket.getOutStream(opponent.getId()).println(XStreamUtil.toXML(response));
	}

}
