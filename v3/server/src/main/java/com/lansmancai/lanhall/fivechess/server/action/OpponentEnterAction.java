package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * �ڶ�����ҽ�����Ϸ, ���һ����ҷ�����Ϣ
 * 
 */
public class OpponentEnterAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		//�õ���һ����ҵĶ���(����������˵Ķ���)
		String firstUserId = (String)request.getParameter("firstUserId");
		ChessUser firstUser = ChessContext.users.get(firstUserId);
		//�õ��ڶ�����ҵĶ���
		String secondUserId = (String)request.getParameter("secondUserId");
		response.setData("opponentId", secondUserId);
		//���ߵ�һ��������Ϸ�����, �ж��ֽ���
		//firstUser.getPrintStream().println(XStreamUtil.toXML(response));
		StoreSocket.getOutStream(firstUser.getId()).println(XStreamUtil.toXML(response));
	}

}
