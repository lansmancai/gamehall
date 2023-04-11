package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 处理求和的Action
 *
 */
public class DrawAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		//得到请求人
		String userId = (String)request.getParameter("userId");
		//得到桌子
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		ChessUser user = ChessContext.users.get(userId);
		//找到对手
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		ChessUser opponent = table.getAnotherUser(user);
		if (opponent != null) {
			response.setData("userName", user.getName());
			//opponent.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(opponent.getId()).println(XStreamUtil.toXML(response));
		}
	}

}
