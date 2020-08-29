package cn.itcast.brid;
import java.awt.image.BufferedImage;
public class skill {
	BufferedImage b=Readimage.getImg("/image/skill_s.png");
	int x;
	int y;
	int w;
	int h;
	int k=0;
	public skill(int x,int y)
	{		
		w=b.getWidth()/2;
		h=b.getHeight()/2;
		this.x=x;
		this.y=y;
	}	
	public void move()
	{
		if(k==1)
		{
			b=Readimage.getImg("/image/skill_s.png");
		y-=30;
		return;
		}
		if(k==2)
		{b=Readimage.getImg("/image/skill_x.png");
		y+=30;
		return;
		}
		if(k==3)
		{
		b=Readimage.getImg("/image/skill_z.png");
		x-=30;
		return;
		}
		if(k==4)
		{
			b=Readimage.getImg("/image/skill_y.png");
		x+=30;
		return;
		}
	}
	public void setk(int k)
	{
		this.k=k;
	}
}
