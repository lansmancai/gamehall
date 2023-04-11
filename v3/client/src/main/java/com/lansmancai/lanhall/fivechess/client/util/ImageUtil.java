package com.lansmancai.lanhall.fivechess.client.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ͼƬ������
 * 
 */
public class ImageUtil {

	
	public static BufferedImage getImage(String imagePath) {
    	try {
    		//ʹ��ImageIO��ȡͼƬ
    		return ImageIO.read(new File(imagePath));
    	} catch (IOException e) {
    		e.printStackTrace();
    		return null;
    	}
	}
	
}
