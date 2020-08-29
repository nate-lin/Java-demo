package cn.itcast.brid;

import java.awt.image.BufferedImage;

public abstract class EpObject {
	
	int x;
	int y;
	int w;
	int h;
	int bb=0;
	public abstract BufferedImage getImage();
	public abstract void up();
	
	public abstract void down();
	
	public abstract void left();
	
	public abstract void right();
	public abstract boolean shootBy(skill b);
	public abstract boolean hit(player p);
	public void score() {
		// TODO Auto-generated method stub
		
	}
}
