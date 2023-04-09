package com.lansmancai.lanhall.client.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import com.lansmancai.lanhall.client.exception.ClientException;

/**
 * ͼƬ������
 * 
 */
public class ImageUtil {

	//ͷ��ͼƬ���Ŀ¼
	public final static String HEAD_FOLDER = "images/heads";
	
	//����һ��Map, key���ļ���·��
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
			throw new ClientException("��ȡͷ���ļ�����");
		}
	}
}
