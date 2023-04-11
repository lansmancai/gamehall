package com.lansmancai.lanhall.fivechess.commons.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误信息
 * 
 */
public class FiveChessErrorCode {

	public static final String HAS_SIT_DOWN = "has sit down";
	
	public static final String SEAT_HAS_USER = "seat has user";
	
	public static Map<String, String> errorMessages = new HashMap<String, String>();
	
	static {
		errorMessages.put(HAS_SIT_DOWN, "你已经坐下了");
		errorMessages.put(SEAT_HAS_USER, "该座位已经有人");
	}
	
	public static String getMessage(String code) {
		return errorMessages.get(code);
	}
}
