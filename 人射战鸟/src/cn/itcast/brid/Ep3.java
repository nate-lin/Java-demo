package cn.itcast.brid;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Ep3 extends EpObject{
	
	BufferedImage[] b =new BufferedImage[2];
	
	Random r=new Random();
	public Ep3()
	{	
	x=1250-r.nextInt(400);
	b[0]= Readimage.getImg("/image/0"+(5)+".png");
	b[1]= Readimage.getImg("/image/0"+(6)+".png");
	y=r.nextInt(900)-w;
		w=b[0].getWidth();
		h=b[0].getHeight();
	}
	int index = 0;
	int Time = 0;
	public BufferedImage getImage(){
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
	int e=3;
	public void score()
	{
		GamePanel.score+=e;
	}
	}

