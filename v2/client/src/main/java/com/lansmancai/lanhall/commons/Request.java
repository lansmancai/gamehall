package com.lansmancai.lanhall.commons;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * �������, ��ʾ�ͻ������������һ������
 * 
 */
public class Request implements Serializable {

	//����
	private Map<String, Object> parameters;
	
	//������������
	private String serverActionClass;
	
	private String clientActionClass;

	public Request(String serverActionClass, String clientActionClass) {
		this.serverActionClass = serverActionClass;
		this.parameters = new HashMap<String, Object>();
		this.clientActionClass = clientActionClass;
	}
	
	public Map<String, Object> getParameters() {
		return this.parameters;
	}
	
	public void setParameter(String key, Object value) {
		this.parameters.put(key, value);
	}
	
	public Object getParameter(String key) {
		return this.parameters.get(key);
	}

	public String getServerActionClass() {
		return serverActionClass;
	}

	public void setServerActionClass(String serverActionClass) {
		this.serverActionClass = serverActionClass;
	}

	public String getClientActionClass() {
		return clientActionClass;
	}

	public void setClientActionClass(String clientActionClass) {
		this.clientActionClass = clientActionClass;
	}

	@Override
	public String toString() { return serverActionClass + clientActionClass;}
}
