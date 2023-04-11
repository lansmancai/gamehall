package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 在游戏中发送聊天信息, 服务器处理类
 * 
 */
public class GameMessageAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		String senderId = (String)request.getParameter("senderId");
		ChessUser sender = ChessContext.users.get(senderId);
		String content = (String)request.getParameter("content");
		//得到发送人所在的桌子
		Table table = ChessContext.getTable(senderId);
		if (table != null ) {
			//向对手发送
			ChessUser receiver = table.getAnotherUser(sender);
			if (receiver != null) {
				response.setData("content", sender.getName() + " 对你说：" + content);
				//receiver.getPrintStream().println(XStreamUtil.toXML(response));
				StoreSocket.getOutStream(receiver.getId()).println(XStreamUtil.toXML(response));
			}
		}
	}

}
