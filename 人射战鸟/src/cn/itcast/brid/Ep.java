package cn.itcast.brid;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Ep extends EpObject{
	
	BufferedImage[] b =new BufferedImage[2];
	
	
	int bb=0;
	Random r=new Random();
	public Ep()
	{			
	x=1250-r.nextInt(400);
	for (int i = 1; i < b.length+1; i++) {
		b[i-1]= Readimage.getImg("/image/0"+(i)+".png");
	}
	y=r.nextInt(900)-w;
		w=b[0].getWidth();
		h=b[0].getHeight();
	}
	int index = 0;
	int Time = 0;
	public BufferedImage getImage(){
		//·ÉÐÐ³á°òËÙ¶È
		if(Time++%7==0){
			index++;
		}
		return b[index%b.length];
	}
	
	public void move(int x,int y)
	{
		this.x=x;
		this.y=y;
	
	}
	public void up()
	{
		y-=0;
		
	}
	public void down()
	{
		y+=0;
	}
	public void left()
	{
		x-=5;
		
	}
	public void right()
	{
		x+=0;
	}
	
	public boolean shootBy(skill b)
	{
		boolean hit= x<=b.x+b.w&&x>=b.x-w && y<=b.y+b.h &&y>=b.y-h;
		
		return hit;
		
		
	}


	public boolean hit(player b) {

			boolean hit= x<=b.x+b.w&&x>=b.x-w && y<=b.y+b.h &&y>=b.y-h;
			
			return hit;
			
			
		}
	int e=1;
	public void score()
	{
		GamePanel.score+=e;
	}
	}

