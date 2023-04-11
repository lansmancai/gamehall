package com.lansmancai.lanhall.fivechess.client.action;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.client.ChessClientContext;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import java.net.Socket;
import java.io.*;
/**
 * 实现框架中的Game接口, 五子棋游戏入口类
 *
 */
public class ChessGame implements Game {

	public String toString() {
		return "五子棋";
	}

	public void start(User user, Socket socket) {
		//得到进入游戏的玩家信息
		ChessUser cu = convertUser(user);
		ChessClientContext.chessUser = cu;
		//构造一次请求, 告诉服务器玩家进入大厅, 服务器响应处理类是LoginAction
		Request req = new Request("com.lansmancai.lanhall.fivechess.server.action.LoginAction", 
				"com.lansmancai.lanhall.fivechess.client.action.ClientInAction");
		req.setParameter("user", cu);
		//System.out.println("reached");
		//得到玩家的Socket并发送请求, 告诉服务器玩家进入了大厅
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
	
	//将User转换成ChessUser对象
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
