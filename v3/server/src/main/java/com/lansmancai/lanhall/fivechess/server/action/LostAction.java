package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * �������ִ�еķ�����Action
 * 
 */
public class LostAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		String userId = (String)request.getParameter("userId");
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		ChessUser user = ChessContext.users.get(userId);
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		ChessUser opponent = table.getAnotherUser(user);
		//����˫����״̬
		user.setReady(false);
		opponent.setReady(false);
		//���߶���Ӯ��
		//opponent.getPrintStream().println(XStreamUtil.toXML(response));
		StoreSocket.getOutStream(opponent.getId()).println(XStreamUtil.toXML(response));
	}

}
