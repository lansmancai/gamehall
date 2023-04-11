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
 * ����������
 * 
 */
public class Server {

	ServerSocket serverSocket;
	
	public Server() {
		try {
			//����ServerSocket����, �˿�Ϊ12000
			this.serverSocket = new ServerSocket(12000);
			while(true) {
				//����Socket������
				Socket s = this.serverSocket.accept();
				//�����������߳�
				new ServerThread(s).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("�����������쳣: " + e.getMessage());
		}
	}

}
