package com.lansmancai.lanhall.commons;

import java.net.Socket;
import java.io.*;

/**
 * ��������������Ľӿ�
 * 
 */
public interface ServerAction {

	void execute(Request request, Response response,  ObjectOutputStream oos, ObjectInputStream ios);
}
