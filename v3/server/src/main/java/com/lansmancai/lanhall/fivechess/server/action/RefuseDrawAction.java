package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 接收玩家拒绝求和的请求
 * 
 */
public class RefuseDrawAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		//得到发送拒绝信息的人
		String userId = (String)request.getParameter("userId");
		ChessUser user = ChessContext.users.get(userId);
		//得到桌子
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		ChessUser opponent = table.getAnotherUser(user);
		response.setData("userName", user.getName());
		//opponent.getPrintStream().println(XStreamUtil.toXML(response));
		StoreSocket.getOutStream(opponent.getId()).println(XStreamUtil.toXML(response));
	}

}
