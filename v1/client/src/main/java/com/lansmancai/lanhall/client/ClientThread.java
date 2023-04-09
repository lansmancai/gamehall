package com.lansmancai.lanhall.client;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.net.Socket;

import com.lansmancai.lanhall.commons.*;

/**
 * �ͻ��������߳�, ����ͻ��˽��շ�������Ӧ
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
			//�õ��ͻ��˵Ĵ�����
			ClientAction action = getClientAction(response.getActionClass());
			//ִ�пͻ��˴�����
			action.execute(response);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
	//�õ���������Ӧ�еĿͻ��˴�����
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
	//����������Ӧ��xmlת����Response����
	private Response getResponse(String xml) {
		return (Response)XStreamUtil.fromXML(xml);
	}

}
