package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;
import java.io.*;
import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * 玩家进入游戏大厅（服务器调用）
 * 
 */
public class LoginAction implements ServerAction {

	
	public void execute(Request request, Response response, Socket socket) {
		//从请求参数中得到新登录的玩家对象
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
		//将玩家设置到响应中
		response.setData("user", cu);
		//将所有玩家信息设置到响应中
		response.setData("users", ChessContext.users);
		//将所有的桌子信息返回到客户端
		response.setData("tables", ChessContext.tables);
		//将大厅中桌子的列数和行数返回到客户端
		response.setData("tableColumnSize", ChessContext.TABLE_COLUMN_SIZE);
		response.setData("tableRowSize", ChessContext.TABLE_ROW_SIZE);
		//返回给登录玩家, 登录成功
		StoreSocket.getOutStream(cu.getId()).println(XStreamUtil.toXML(response));
	}
	
}
