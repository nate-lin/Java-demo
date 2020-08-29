package cn.itcast.brid;

import java.awt.image.BufferedImage;
public class player {
	BufferedImage b=Readimage.getImg("/image/filly-x.gif");
	int x;
	int y;
	int w;
	int h;	
	public player()
	{
		x=450;
		y=450;
		w=b.getWidth();
		h=b.getHeight();
	}	
	public void move(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void up()
	{
		y-=50;
	}
	public void down()
	{
		y+=50;
	}
	public void left()
	{
		x-=50;		
	}
	public void right()
	{
		x+=50;
	}
}
