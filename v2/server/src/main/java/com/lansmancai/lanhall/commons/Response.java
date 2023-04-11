package com.lansmancai.lanhall.commons;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

/**
 * ��������Ӧ����
 * 
 */
public class Response implements Serializable{

	//���������صĸ�����ֵ
	private Map<String, Object> datas;
	
	//�������
	private String errorCode;
	
	//�ͻ��˴�����, ��ֵ������Request�����������Map��
	private String actionClass;
	
	public Response(String actionClass) {
		this.datas = new HashMap<String, Object>();
		this.actionClass = actionClass;
	}
	
	public void setData(String key, Object value) {
		this.datas.put(key, value);
	}
	
	public Object getData(String key) {
		return this.datas.get(key);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getActionClass() {
		return actionClass;
	}

	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}

	@Override
	public String toString() { return getActionClass() + "-" + getErrorCode(); }



}
