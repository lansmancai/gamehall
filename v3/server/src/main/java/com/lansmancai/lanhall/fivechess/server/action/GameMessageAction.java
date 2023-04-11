package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * ����Ϸ�з���������Ϣ, ������������
 * 
 */
public class GameMessageAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		String senderId = (String)request.getParameter("senderId");
		ChessUser sender = ChessContext.users.get(senderId);
		String content = (String)request.getParameter("content");
		//�õ����������ڵ�����
		Table table = ChessContext.getTable(senderId);
		if (table != null ) {
			//����ַ���
			ChessUser receiver = table.getAnotherUser(sender);
			if (receiver != null) {
				response.setData("content", sender.getName() + " ����˵��" + content);
				//receiver.getPrintStream().println(XStreamUtil.toXML(response));
				StoreSocket.getOutStream(receiver.getId()).println(XStreamUtil.toXML(response));
			}
		}
	}

}
