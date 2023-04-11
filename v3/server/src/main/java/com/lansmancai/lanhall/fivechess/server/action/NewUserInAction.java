package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 接收玩家进入时发送的请求, 该Action向所有玩家发送信息, 有新玩家进入
 * 
 */
public class NewUserInAction implements ServerAction {
	
	public void execute(Request request, Response response, Socket socket) {
		//得到新登录的玩家
		String userId = (String)request.getParameter("userId");
		ChessUser user = ChessContext.users.get(userId);
		//将新玩家信息放到响应中
		response.setData("newUser", user);
		//向所有玩家发送信息
		for (String id : ChessContext.users.keySet()) {
			ChessUser hasLogin = ChessContext.users.get(id);
			//不必发送给自己
			if (id.equals(user.getId())) continue;
			//hasLogin.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(hasLogin.getId()).println(XStreamUtil.toXML(response));
		}
	}

}
