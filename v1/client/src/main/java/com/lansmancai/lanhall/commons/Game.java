package com.lansmancai.lanhall.commons;

import java.net.Socket;
/**
 * ��Ϸ�ӿ�, �������뵽����е���Ϸ�����ṩһ���ýӿڵ�ʵ����
 * 
 */
public interface Game {

	/**
	 * ��ʼ��Ϸ�ķ���
	 * @param user
	 */
	void start(User user, Socket socket);
}
