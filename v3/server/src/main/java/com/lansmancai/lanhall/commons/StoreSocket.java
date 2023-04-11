package com.lansmancai.lanhall.commons;

import java.net.Socket;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class StoreSocket {
	public static Map<String, Socket> smap = new HashMap<>();
	public static Map<String, PrintStream> sInput = new HashMap<>();
	public static Map<String, PrintStream> sOutput = new HashMap<>();

	public static void setsSocket(String id, Socket socket) {
		smap.put(id, socket);
	}
	public static Socket getsSocket(String id) {
		return smap.get(id);
	}

	public static void setInputStream(String id, PrintStream ois) {
		sInput.put(id, ois);
	}
	public static PrintStream getInputStream(String id) {
		return sInput.get(id);
	}

	public static void setOutputStream(String id, PrintStream oos) {
		sOutput.put(id, oos);
	}
	public static PrintStream getOutStream(String id) {
		return sOutput.get(id);
	}

}