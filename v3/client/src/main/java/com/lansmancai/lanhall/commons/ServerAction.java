package com.lansmancai.lanhall.commons;

import java.net.Socket;
import java.io.*;

/**
 * 服务器处理请求的接口
 * 
 */
public interface ServerAction {

	void execute(Request request, Response response,  ObjectOutputStream oos, ObjectInputStream ios);
}
