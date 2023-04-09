package com.lansmancai.lanhall.client;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.net.Socket;

import com.lansmancai.lanhall.commons.*;

/**
 * 客户端引擎线程, 处理客户端接收服务器响应
 */
public class ClientThread extends Thread {

	private User user;

	private Socket usok;
	private String line;
	
	private Map<String, ClientAction> actions = new HashMap<String, ClientAction>();
	
	public ClientThread(User user,Socket usocket) {
		this.user = user;
		this.usok = usocket;
	}
	
	public void run() {
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(Usocket.is));
		while ((this.line = br.readLine()) != null) {
			Response response = getResponse(this.line);
			//得到客户端的处理类
			ClientAction action = getClientAction(response.getActionClass());
			//执行客户端处理类
			action.execute(response);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
	//得到服务器响应中的客户端处理类
	private ClientAction getClientAction(String className) {
		try {
			if (actions.get(className) == null) {
				ClientAction action = (ClientAction)Class.forName(className).newInstance();
				actions.put(className, action);
			}
			return actions.get(className);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//将服务器响应的xml转换成Response对象
	private Response getResponse(String xml) {
		return (Response)XStreamUtil.fromXML(xml);
	}

}
