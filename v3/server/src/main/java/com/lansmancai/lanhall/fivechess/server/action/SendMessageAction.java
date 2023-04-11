package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import com.lansmancai.lanhall.fivechess.server.ChessContext;
/**
 * 发送信息的服务器处理类
 * 
 */
public class SendMessageAction implements ServerAction {
	
	public void execute(Request request, Response response, Socket socket) {
		String receiverId = (String)request.getParameter("receiverId");
		String senderId = (String)request.getParameter("senderId");
		ChessUser sender = ChessContext.users.get(senderId);
		String content = (String)request.getParameter("content");
		if (receiverId == null) {
			//向所有人发
			for (String id : ChessContext.users.keySet()) {
				if (id.equals(senderId)) continue;
				ChessUser cu = ChessContext.users.get(id);
				response.setData("content", sender.getName() + " 对 所有人 说：" + content);
				//cu.getPrintStream().println(XStreamUtil.toXML(response));
				StoreSocket.getOutStream(cu.getId()).println(XStreamUtil.toXML(response));
			}
		} else {
			//得到接收人
			ChessUser receiver = ChessContext.users.get(receiverId);
			if (receiver.getId().equals(sender.getId())) return; 
			response.setData("content", sender.getName() + " 对你说：" + content);
			//receiver.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(receiver.getId()).println(XStreamUtil.toXML(response));
		}
	}

}
