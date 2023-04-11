package com.lansmancai.lanhall.server;

import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import com.lansmancai.lanhall.server.exception.ServerException;

/**
 * 服务器对象
 * 
 */
public class Server {

	ServerSocket serverSocket;
	
	public Server() {
		try {
			//创建ServerSocket对象, 端口为12000
			this.serverSocket = new ServerSocket(12000);
			while(true) {
				//监听Socket的连接
				Socket s = this.serverSocket.accept();
				//启动服务器线程
				new ServerThread(s).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("创建服务器异常: " + e.getMessage());
		}
	}

}
