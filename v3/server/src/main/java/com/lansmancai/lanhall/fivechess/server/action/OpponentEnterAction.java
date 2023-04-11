package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 第二个玩家进入游戏, 向第一个玩家发送信息
 * 
 */
public class OpponentEnterAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		//得到第一个玩家的对象(发送请求的人的对手)
		String firstUserId = (String)request.getParameter("firstUserId");
		ChessUser firstUser = ChessContext.users.get(firstUserId);
		//得到第二个玩家的对象
		String secondUserId = (String)request.getParameter("secondUserId");
		response.setData("opponentId", secondUserId);
		//告诉第一个进入游戏的玩家, 有对手进入
		//firstUser.getPrintStream().println(XStreamUtil.toXML(response));
		StoreSocket.getOutStream(firstUser.getId()).println(XStreamUtil.toXML(response));
	}

}
