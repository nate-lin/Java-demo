package cn.itcast.brid;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Readimage {
	public static BufferedImage getImg(String s)
	{
		BufferedImage bi = null;
		try {
			bi=ImageIO.read(Readimage.class.getResource(s));
			return bi;
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return bi;		
	}	
}
