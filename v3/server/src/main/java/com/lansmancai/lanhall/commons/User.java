package com.lansmancai.lanhall.commons;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.Icon;
import java.io.Serializable;
/**
 * ��ҳ�����
 * 
 */
public class User implements Serializable {

	//��ҵ�Ψһ��ʶ
	private String id;
	
	//ͷ��ͼƬ
	private String headImage;
	
	//�������
	private String name;
	
	//0��, 1Ů
	private int sex;

	
	public User() {
		
	}
	
	public User(String id, String headImage, String name, int sex) {
		this.id = id;
		this.headImage = headImage;
		this.name = name;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() { return getHeadImage() + "-" + getName() + "-" + getSex() + "-" + getId(); }
	

}
