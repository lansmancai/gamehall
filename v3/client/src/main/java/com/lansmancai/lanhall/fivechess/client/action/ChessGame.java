package com.lansmancai.lanhall.fivechess.client.action;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.client.ChessClientContext;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import java.net.Socket;
import java.io.*;
/**
 * ʵ�ֿ���е�Game�ӿ�, ��������Ϸ�����
 *
 */
public class ChessGame implements Game {

	public String toString() {
		return "������";
	}

	public void start(User user, Socket socket) {
		//�õ�������Ϸ�������Ϣ
		ChessUser cu = convertUser(user);
		ChessClientContext.chessUser = cu;
		//����һ������, ���߷�������ҽ������, ��������Ӧ��������LoginAction
		Request req = new Request("com.lansmancai.lanhall.fivechess.server.action.LoginAction", 
				"com.lansmancai.lanhall.fivechess.client.action.ClientInAction");
		req.setParameter("user", cu);
		//System.out.println("reached");
		//�õ���ҵ�Socket����������, ���߷�������ҽ����˴���
		Usocket.usket = socket;
		try {
			Usocket.os = Usocket.usket.getOutputStream();
			Usocket.is = Usocket.usket.getInputStream();
			Usocket.ps = new PrintStream(Usocket.os);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Usocket.ps.println(XStreamUtil.toXML(req));
	}
	
	//��Userת����ChessUser����
	private ChessUser convertUser(User user) {
		ChessUser cu = new ChessUser();
		cu.setHeadImage(user.getHeadImage());
		cu.setId(user.getId());
		cu.setName(user.getName());
		cu.setSex(user.getSex());
		//cu.setSocket(user.getSocket());
		return cu;
	}

}
