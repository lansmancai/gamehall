package com.lansmancai.lanhall.commons;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.*;
import com.thoughtworks.xstream.annotations.*;

public class XStreamUtil {

	private static XStream xstream = new XStream();
	
	/**
	 * 将XML转换成对象
	 * @param xml
	 * @return
	 */
	public static Object fromXML(String xml) {
		xstream.addPermission(AnyTypePermission.ANY);
		//xstream.processAnnotations(FaultInfo.class);
		return xstream.fromXML(xml);
	}
	
	/**
	 * 将对象转换成XML字段串
	 * @param obj
	 * @return
	 */
	public static String toXML(Object obj) {
		String xml = xstream.toXML(obj);
		//去掉换行
		String a = xml.replaceAll("\n", "");
		String s = a.replaceAll("\r", "");
		return s;
	}

}
