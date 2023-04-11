package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;
import java.io.*;
import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * ��ҽ�����Ϸ���������������ã�
 * 
 */
public class LoginAction implements ServerAction {

	
	public void execute(Request request, Response response, Socket socket) {
		//����������еõ��µ�¼����Ҷ���
		ChessUser cu = (ChessUser)request.getParameter("user");
		try {
				StoreSocket.setsSocket(cu.getId(), socket);
				//StoreSocket.setInputStream(user.getId(), new PrintStream(sss));
				StoreSocket.setOutputStream(cu.getId(), new PrintStream(socket.getOutputStream()) );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ChessContext.users.put(cu.getId(), cu);
		//��������õ���Ӧ��
		response.setData("user", cu);
		//�����������Ϣ���õ���Ӧ��
		response.setData("users", ChessContext.users);
		//�����е�������Ϣ���ص��ͻ���
		response.setData("tables", ChessContext.tables);
		//�����������ӵ��������������ص��ͻ���
		response.setData("tableColumnSize", ChessContext.TABLE_COLUMN_SIZE);
		response.setData("tableRowSize", ChessContext.TABLE_ROW_SIZE);
		//���ظ���¼���, ��¼�ɹ�
		StoreSocket.getOutStream(cu.getId()).println(XStreamUtil.toXML(response));
	}
	
}
