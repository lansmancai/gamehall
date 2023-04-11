package com.lansmancai.lanhall.fivechess.client.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图片工具类
 * 
 */
public class ImageUtil {

	
	public static BufferedImage getImage(String imagePath) {
    	try {
    		//使用ImageIO读取图片
    		return ImageIO.read(new File(imagePath));
    	} catch (IOException e) {
    		e.printStackTrace();
    		return null;
    	}
	}
	
}
