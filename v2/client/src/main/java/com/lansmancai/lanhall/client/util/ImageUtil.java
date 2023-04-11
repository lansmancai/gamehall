package com.lansmancai.lanhall.client.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import com.lansmancai.lanhall.client.exception.ClientException;

/**
 * 图片工具类
 * 
 */
public class ImageUtil {

	//头像图片存放目录
	public final static String HEAD_FOLDER = "images/heads";
	
	//返回一个Map, key是文件的路径
	public static Map<String, ImageIcon> getHeads() {
		try {
			File folder = new File(HEAD_FOLDER);
			File[] files = folder.listFiles();
			Map<String, ImageIcon> heads = new HashMap<String, ImageIcon>();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				//System.out.println(file.getPath());
				heads.put(file.getPath(), new ImageIcon(file.getAbsolutePath()));
			}
			return heads;
		} catch (Exception e) {
			throw new ClientException("读取头像文件出错");
		}
	}
}
