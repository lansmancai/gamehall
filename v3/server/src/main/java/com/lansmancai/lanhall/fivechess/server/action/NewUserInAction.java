package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * ������ҽ���ʱ���͵�����, ��Action��������ҷ�����Ϣ, ������ҽ���
 * 
 */
public class NewUserInAction implements ServerAction {
	
	public void execute(Request request, Response response, Socket socket) {
		//�õ��µ�¼�����
		String userId = (String)request.getParameter("userId");
		ChessUser user = ChessContext.users.get(userId);
		//���������Ϣ�ŵ���Ӧ��
		response.setData("newUser", user);
		//��������ҷ�����Ϣ
		for (String id : ChessContext.users.keySet()) {
			ChessUser hasLogin = ChessContext.users.get(id);
			//���ط��͸��Լ�
			if (id.equals(user.getId())) continue;
			//hasLogin.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(hasLogin.getId()).println(XStreamUtil.toXML(response));
		}
	}

}
