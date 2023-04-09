package com.lansmancai.lanhall.server;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

import com.lansmancai.lanhall.commons.*;

/**
 * �����������߳�, ���ڴ������������������������Ӧ
 * 
 */
public class ServerThread extends Thread {

	private Socket socket;
	private BufferedReader br;
	private String line;
	//���汻������Action����
	public Map<String, ServerAction> actions = new HashMap<String, ServerAction>();
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			while((this.line = br.readLine()) != null) {
				//�õ��������
				Request request = getRequest(this.line);
				//��request�еõ��ͻ��˴�����, ���ҹ���Response����

				User user = (User)request.getParameter("user");
				StoreSocket.setsSocket(user.getId(), this.socket);
				//StoreSocket.setInputStream(user.getId(), new PrintStream(sss));
				StoreSocket.setOutputStream(user.getId(), new PrintStream(this.socket.getOutputStream()) );
				Response response = new Response(request.getClientActionClass());
				//������Ĳ��������õ�Response��
				copyParameters(request, response);
				//����ַ�������ת����Request����, �����ô����벢����
				if (request == null) {
					response.setErrorCode(ErrorCode.REQUEST_ERROR);
					StoreSocket.getOutStream(user.getId()).println(getResponseXML(response));
					break;
				}
				//�õ�Server������
				ServerAction action = getAction(request.getServerActionClass());
				//����Ҳ�����Ӧ��Action, ���ش�����Ϣ, �ҵ���ִ��Action
				if (action == null) {
					response.setErrorCode(ErrorCode.COMMAND_NOT_FOUND);
					StoreSocket.getOutStream(user.getId()).println(getResponseXML(response));
				} else {
					action.execute(request, response, this.socket);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String getResponseXML(Response response) {
		return XStreamUtil.toXML(response);
	}
	//��Request�еĲ���map���õ�Response��data��
	private void copyParameters(Request request, Response response) {
		Map<String, Object> parameters = request.getParameters();
		for (String key : parameters.keySet()) {
			response.setData(key, parameters.get(key));
		}
	}

	//���ַ���ת����һ��Request����
	private Request getRequest(String xml) {
		try {
			Request r = (Request)XStreamUtil.fromXML(xml);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//��Map�еõ�Action����, ����ò���, �򴴽�
	private ServerAction getAction(String className) {
		try {
			if (actions.get(className) == null) {
				ServerAction action = (ServerAction)Class.forName(className).newInstance();
				actions.put(className, action);
			}
			return actions.get(className);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
