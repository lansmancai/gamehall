package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * ������͵�Action
 *
 */
public class DrawAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		//�õ�������
		String userId = (String)request.getParameter("userId");
		//�õ�����
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		ChessUser user = ChessContext.users.get(userId);
		//�ҵ�����
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		ChessUser opponent = table.getAnotherUser(user);
		if (opponent != null) {
			response.setData("userName", user.getName());
			//opponent.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(opponent.getId()).println(XStreamUtil.toXML(response));
		}
	}

}
