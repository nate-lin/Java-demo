package cn.itcast.brid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class GamePanel extends JPanel implements MouseListener{
	BufferedImage bg;
	BufferedImage room=Readimage.getImg("/image/room.png");
	BufferedImage room2=Readimage.getImg("/image/room2.png");
	BufferedImage bamboo=Readimage.getImg("/image/bamboo.png");
	static int kk=0;
	static int sta=0;
	int m=0;
	int pl=0;
	Ep e=new Ep();
	static int score=0;
	player p=new player();
	skill bsj=new skill(p.x,p.y);
	List<EpObject> eps1=new ArrayList<EpObject>();
	int hp=5;//生命值初始值为5
	List<skill> bs=new ArrayList<skill>();
	/**添加敌人*/
	int Epindex = 0;
	int sum=0;
	int wf=1;
	File f2 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\skill.mp3");//技能音乐
	final JFXPanel fxPanel = new JFXPanel();
	File f4 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\begin.mp3");//游戏开始音乐
	
	public void addEp(){
		
		if(Epindex++%10==0){
			if(sum==50)
			return;
			Random rand = new Random();
			int num = rand.nextInt(20);
			sum++;
			if(num<8){
				eps1.add(new Ep());
			}else if(num>10){
				eps1.add(new Ep2());
			}else{
				eps1.add(new Ep3());
			}
		}		
	}

	public GamePanel()
	{
		
		bg=Readimage.getImg("/image/bk.jpg");
		KeyAdapter k=new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);				
				if(hp==0||m==0)
				{
				return;
				}System.out.println(kk);
				if(e.getKeyCode()==32)
				{	
					Media _media2 = new Media(f2.toURI().toString());
					MediaPlayer _mediaPlayer2 = new MediaPlayer(_media2);
					_mediaPlayer2.play();

					bb=1;					
				}
				System.out.println(e.getKeyCode());
				if(e.getKeyCode()==87)
				{			
				p.b=Readimage.getImg("/image/filly-s.gif");				
							
				if(p.y==200)
				{
					return;
				}
				p.up();
				kk=1;
					repaint();
				}
				if(e.getKeyCode()==83)
				{				
				p.b=Readimage.getImg("/image/filly-x.gif");
				
				if(p.y==800)
				{
					return;
				}
				p.down();
				kk=2;
					repaint();
				}
				if(e.getKeyCode()==65)
				{				
				p.b=Readimage.getImg("/image/filly-z.gif");
				
				if(p.x==0)
				{
					return;
				}
				p.left();
				kk=3;
					repaint();
				}
				if(e.getKeyCode()==68)
				{									
				p.b=Readimage.getImg("/image/filly-y.gif");
				
				if(p.x==1150)
					return;
				p.right();
				kk=4;
					repaint();
				}
			}						
		};
		this.addKeyListener(k);
		this.addMouseListener(this);
	}
	public void action()
	{	
		
		new Thread(){
			public void run()
			{
				while(true)
				{	
					
					if(hp==0)
					{
					win_fall();				
					break;
					}
					if(m>=1)
					{
					addEp();//添加敌人
					}
					bisha();
					shootEp();
					shootPlayer();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					epmove();
					bmove();
					repaint();
					
				}
			}
		}.start();
	}
	public void win_fall()
	{
		wf = 0;
		this.m=1;		
	}
	int bb=0;	
	public void bisha()
	{
		if(bb==1)
		{
		skill b=new skill(p.x+10,p.y);
		bs.add(b);
		bb=0;
		}
	}	
	public void bmove()
	{
		for(int i=0;i<bs.size();i++)
		{
			if(bs.get(i).k==0)
			bs.get(i).setk(kk);
			bs.get(i).move();
		}
	}	
	int t=0;
	int tt=0;
	Random rr=new Random();
	int r;
	int bt;
	public void epmove()
	{		
		for(int i=0;i<eps1.size();i++)
		{			
			 EpObject e=eps1.get(i);
			 r=rr.nextInt(11);	 			
			if(r==0||r==1||r==2)
			{				
				e.left();
			}
			else
			if(r==3||r==4||r==5)
			{				
				e.down();
			}
			else
			if(r==6||r==7||r==8)
			{				
				e.up();
			}
			else
			{				
				e.right();
			}			
		}		
	}	
	public void shootEp()
	{
		for(int i=0;i<bs.size();i++)
		{
			skill b=bs.get(i);			
			bang(b);
		}
	}	
	public void bang(skill b)
	{
		for(int i=0;i<eps1.size();i++)
		{
			EpObject e=eps1.get(i);
			if(e.shootBy(b))
			{
				
				e.score();
				eps1.remove(e);
				bs.remove(b);
				File f2 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\skill.mp3");//技能音乐
				Media _media2 = new Media(f2.toURI().toString());
				MediaPlayer _mediaPlayer2 = new MediaPlayer(_media2);
				_mediaPlayer2.play();
		
				Random rand = new Random();
				int num = rand.nextInt(20);
				sum++;
				if(num<8){
					eps1.add(new Ep());
				}else if(num>10){
					eps1.add(new Ep2());
				}else{
					eps1.add(new Ep3());
				}
				
				
			}
		}
	}	
	public void shootPlayer()
	{
		for(int i=0;i<eps1.size();i++)		
		{
			EpObject e=eps1.get(i);
			if(e.hit(p))
			{
				eps1.remove(e);
				if(hp==0)
				{
				return;
				}
				else
				{
				hp--;
				}
			}
		}
	}
	public void Issta(int sta)
	{
		this.sta=sta;
	}
	Boolean IsClose=true;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		
		if(sta==0)
		{	
			
			g.drawImage(Readimage.getImg("/image/start.png"),0,0,1250, 950,null );
			
			if(m==1)
			{
				
			pl=1;
			g.clearRect(0, 0, 1250, 950);
			sta=1;
			
			}
			return;
		}
		g.drawImage(bg, 0, 0,1250,950,null );	
		g.drawImage(room,755,350,567, 365,null );
		g.drawImage(room2,-10, 125, 567, 429,null );
		g.drawImage(bamboo,1105,500 ,183,199,null );
		for(int i=0;i<eps1.size();i++)
		{
			g.drawImage(eps1.get(i).getImage(), eps1.get(i).x,eps1.get(i).y, null);
		}
		for(int j=0;j<bs.size();j++)
		{
			g.drawImage(bs.get(j).b, bs.get(j).x, bs.get(j).y, bs.get(j).w, bs.get(j).h, null);
		}	
		g.drawImage(p.b,p.x,p.y,p.w,p.h,null);
		g.setColor(Color.red);
		g.drawString("人射战鸟的累加值:"+score, 30, 20);
		g.drawString("人射战鸟的生命值:"+hp, 300, 20);
		if(wf==0)
		{
			File f3 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\fall.mp3");
			Media _media3 = new Media(f3.toURI().toString());
			MediaPlayer _mediaPlayer3 = new MediaPlayer(_media3);
			_mediaPlayer3.play();
			g.drawImage(Readimage.getImg("/image/fall.png"),0,0,1250, 950,null );
			IsClose=false;
		}
		if(score>=100)
		{
			g.drawImage(Readimage.getImg("/image/win.png"),0,0,1250, 950,null );
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(m);
		if(e.getClickCount()==1)			
			m++;
		if(!IsClose)
		{
			Main.m.dispose();
			
		}		
	}
	public void mousePressed(MouseEvent e) {	
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}
