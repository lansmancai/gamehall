package com.lansmancai.lanhall.commons;

import java.net.Socket;
/**
 * 游戏接口, 各个加入到框架中的游戏必须提供一个该接口的实现类
 * 
 */
public interface Game {

	/**
	 * 开始游戏的方法
	 * @param user
	 */
	void start(User user, Socket socket);
}
