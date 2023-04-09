package com.lansmancai.lanhall.commons;

import java.net.Socket;

/**
 * 客户端处理服务器响应的接口
 * 
 */
public interface ClientAction {

	void execute(Response response);
}
