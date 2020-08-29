package cn.itcast.txz.ui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



//用作显示的主窗体
//需要继承Frame类-----继承	
//出现红色波浪线代表出现错误，前方有一个红色叉
public class MainFrame extends JFrame implements KeyListener {
	Boolean isClose=true;

	// 1.最起码应该设置一下窗口最基本的信息
	// 1.1窗口是否显示
	// 构造方法
	public MainFrame() {
		// 由于添加图片组件的时候存在顺序，因此要根据需要调整
		// 添加图片组件的顺序
		// 背景图片由于其是最大的图片，因此最后添加，其他内容
		// 都要在背景图片之前添加
		
		// 添加各种各样要显示的东西。。。
		// 做笼子（目的地）
		targetInit();
		// 做小新（人物）
		roleInit();
		// 做小白（箱子）
		boxInit();
		// 做树（障碍物）
		barrierInit();
		// 制作一个背景，并将背景添加到窗体中
		backgroundInit();
		// 设置整个窗体
		setMainFrameUI();
		start();
		
		// 使窗口能够监督用户是不是点了键盘
		this.addKeyListener(this);
		
	}

	// 当前操作的组件是JLabel，JLabel现在无法判断到底在什么位置
	// 设定一个与数据存储对应着的JLabel存储数组
	JLabel[][] box = new JLabel[12][16];
	// 当前数组创建出来后，JLabel数组中没有任何东西
	// 制作的箱子应该放到这个数组中
	// 需要在箱子进行初始化的地方，将那三个箱子对应的组件放到这个数组中

	// 场景数据的模拟，使用二维数组模拟
	// 1代表树（障碍），0代表空地
	// 2代表小新（人物）
	// 4代表小白（箱子）
	int[][] datas = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,1,1,0,0,0,1,1,0,0,0,1},
			{1,0,1,1,0,0,1,0,0,0,1,1,0,0,0,1},
			{1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1},
			{1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1},
			{1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};
	// 代表小新（人物）横向的位置
	int rx;
	// 代表小新（人物）纵向的位置
	int ry;
	// 代表当前有多少个小白（箱子）移动到了笼子（目的地）
	int num = 0;
	// 代表小白（箱子）的总数
	int total = 3;

	// 找小白回家：树（障碍）的初始化
	private void barrierInit() {
		// 1.创建图片
		Icon ic = new ImageIcon("tree.png");// 障碍物图片及后缀*
		// 遍历二维数组
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				// 判断一下原始数据里面的值如果是1，做树（障碍）
				if (datas[i][j] == 1) {
					// 树（障碍）的初始化
					// 2.创建JLabel
					JLabel lab_barrier = new JLabel(ic);
					// 3.设置大小位置
					lab_barrier.setBounds(50 * j,50 * i, 50, 50);
					// 4.添加到窗体中
					this.add(lab_barrier);
				}
			}
		}
	}

	// 找小白回家：笼子（目的地）的初始化
	private void targetInit() {
		// 制作笼子（目的地）方式同小新（人物）或者小白（箱子）的制作
		// 1.创建图片
		Icon i = new ImageIcon("cage.png");
		// 2.JLabel
		JLabel lab_target1 = new JLabel(i);
		// 3.设位置
		lab_target1.setBounds(700, 200, 50, 50);
		// 4.添加进窗体
		this.add(lab_target1);
		//修改目标对应位置上的数据为8
		datas[4][14] = 8;

		// 制作其他两个笼子（目的地）
		JLabel lab_target2 = new JLabel(i);
		lab_target2.setBounds(700, 250, 50, 50);
		this.add(lab_target2);
		datas[5][14] = 8;

		JLabel lab_target3 = new JLabel(i);
		lab_target3.setBounds(700, 300, 50, 50);
		this.add(lab_target3);
		datas[6][14] = 8;
	}

	// 找小白回家：小白（箱子）的初始化
	private void boxInit() {
		  // 制作一个小白（箱子）按照下面的方式进行
		  // 制作小白（箱子）的模型
		  // 1.创建一张图片，小白（箱子）图片
		  Icon i = new ImageIcon("White.png");
		  // 2.使用JLabel组件模拟箱子
		  JLabel lab_box1 = new JLabel(i);
		  // 3.设置箱子的位置
		  lab_box1.setBounds(250, 150, 50, 50);
		  // 4.把这个人物放到窗体里面
		  this.add(lab_box1);
		  // 修改箱子对应位置上的数据为4
		  datas[3][5] = 4;
		  // 把这个JLabel组件放入到box的数组中
		  box[3][5] = lab_box1;

		  // 制作第二个小白（箱子），图片不需要制作了
		  // 第二个小白（箱子）制作时，只需要修改对应的显示位置就行了
		  JLabel lab_box2 = new JLabel(i);
		  lab_box2.setBounds(150, 250, 50, 50);
		  this.add(lab_box2);
		  datas[5][3] = 4;
		  box[5][3] = lab_box2;

		  // 制作第三个小白（箱子），图片不需要制作了
		  // 第三个小白（箱子）制作时，只需要修改对应的显示位置就行了
		  JLabel lab_box3 = new JLabel(i);
		  lab_box3.setBounds(200, 450, 50, 50);
		  this.add(lab_box3);
		  datas[9][4] = 4;
		  box[9][4] = lab_box3;
	}

	// 找小白回家：小新（人物）的初始化
	private void roleInit() {
				// 小新（人物）最初位置在哪里？
				rx = 2;
				ry = 8;
				// 使用一张图片来模拟小新（人物）
				// 1。创建一张图片，小新（人物）图片
				Icon i = new ImageIcon("Figure_Front.png");// 小新（人物）图片名及后缀*正面图片
				// 2.使用JLabel组件模拟小新（人物）
				lab_role = new JLabel(i);
				// 3.设置小新（人物）在屏幕上的显示位置
				// 小新（人物）的显示位置放置在何处较为合理？
				lab_role.setBounds(rx * 50, ry * 50, 50, 50);
				// 4.把这个小新（人物）放到窗体里面
				this.add(lab_role);
				// 把小新（人物）的数据添加到数组中
				// 将小新（人物）对应的位置上的数据改成2
				// datas[6][4] = 2;
	}

	JLabel lab_role;// 让变量的作用范围变大，由方法变到类里面

	// 背景初始化
	private void backgroundInit() {
		// 背景是如何实现的？如何做背景？
		// 想使用图片作为JLabel内部显示的内容
		// 创建一个图片
		Icon i = new ImageIcon("Background.png");// 背景图片名及后缀*
		// 使用JLable制作背景
		JLabel lab_bg = new JLabel(i);
		// 设置要添加的组件的位置与大小
		lab_bg.setBounds(0, 0, 800, 600);
		// 将这个东西添加到窗体里面
		this.add(lab_bg);
	}

	// 设置主窗体界面显示效果
	private void setMainFrameUI() {
		// 设置整个窗体的布局模式为自由布局
		this.setLayout(null);
		// 设置窗口的标题
		this.setTitle("找小白回家--原创作品");
		// 设置窗口位置
		this.setLocation(110,30);
		// 设置窗口尺寸，多长400，多宽300
		this.setSize(805, 625);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		// 设置窗口显示处理
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public void close()
	{
		
		this.dispose();
	}
	
	public void start()
	{
		
		JDialog victory = new JDialog(this,"游戏开始！",true);
		victory.setSize(813,638);
		victory.setLocationRelativeTo(null);
		victory.setLayout(null);
		
		JLabel info = new JLabel(new ImageIcon("start.png"));
		info.setBounds(-1, -10, 800, 620);
		JButton button = new JButton("我是按钮",new ImageIcon("start.png"));
		
		button.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				File f2 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\begin.mp3");//点击开始游戏播放音乐
				Media _media2 = new Media(f2.toURI().toString());
				MediaPlayer _mediaPlayer2 = new MediaPlayer(_media2);
				_mediaPlayer2.play();
			victory.dispose();
			isClose=false;
			}		
			});		
		button.setBounds(300, 380, 250, 50);//开始游戏的按钮的位置	
		button.setMargin(new Insets(0,0,0,0));//将边框外的上下左右空间设置为0         
		button.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0          
		button.setBorderPainted(false);//不打印边框          
		button.setBorder(null);//除去边框  //        
		button.setText(null);//除去按钮的默认名称         
		button.setFocusPainted(false);//除去焦点的框          
		button.setContentAreaFilled(false);//除去默认的背景填充 	
		if(isClose)
		{
		victory.addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent e) {
             close();
            }
        });
		}
		
		victory.add(info);
		victory.add(button);
		victory.setVisible(true);
		
		
	}
	
	private void victory() {
		
		// 如果num的值等于了total的值，胜利
		if (num == total) {
			File f4 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\finish.mp3");//游戏结束音乐
			Media _media4 = new Media(f4.toURI().toString());
			MediaPlayer _mediaPlayer4 = new MediaPlayer(_media4);
			_mediaPlayer4.play();
			System.out.println("胜利");
			this.removeKeyListener(this);
			JDialog victory = new JDialog(this,"恭喜你取得了胜利！",true);
			victory.setSize(416,347);
			victory.setLocationRelativeTo(null);
			victory.setLayout(null);
			
			JLabel info = new JLabel(new ImageIcon("win.png"));
			info.setBounds(-2, -50, 400, 400);//12+2，36+2
			victory.add(info);
			victory.setVisible(true);
		}
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		// 点击键盘后现在程序有动作执行了
				// 如何分辨用户点击的是键盘上的某个按键？
				// 通过键码值分辨是哪一个按键
				// 获取键码值的方式
				// 左 37
				// 上 38
				// 右 39
				// 下 40
				int key = e.getKeyCode();

				if (key == 37) {

					// 让小新（人物）向左移动
					// 方向上第一位的坐标是 ry rx-1
					// 方向上第二位的坐标是 ry rx-2
					if (datas[ry][rx - 1] == 0) {
						rx = rx - 1;
						int x = (int) lab_role.getLocation().getX();
						int y = (int) lab_role.getLocation().getY();
						lab_role.setLocation(x - 50, y);
						Icon i = new ImageIcon("Figure_Left.png");// 人物图片名及后缀*左面图片
						lab_role.setIcon(i);
						return;
					}
					if (datas[ry][rx - 1] == 1) {
						return;
					}
					if (datas[ry][rx - 1] == 4 && datas[ry][rx - 2] == 1) {
						return;
					}
					if (datas[ry][rx - 1] == 4 && datas[ry][rx - 2] == 4) {
						return;
					}
					if (datas[ry][rx - 1] == 4 && datas[ry][rx - 2] == 12) {
						return;
					}
					if (datas[ry][rx - 1] == 12 && datas[ry][rx - 2] == 1) {
						return;
					}
					if (datas[ry][rx - 1] == 12 && datas[ry][rx - 2] == 4) {
						return;
					}
					if (datas[ry][rx - 1] == 12 && datas[ry][rx - 2] == 12) {
						return;
					}

					if (datas[ry][rx - 1] == 8) {
						rx = rx - 1;
						int x = (int) lab_role.getLocation().getX();
						int y = (int) lab_role.getLocation().getY();
						lab_role.setLocation(x - 50, y);
						Icon i = new ImageIcon("Figure_Left.png");// 人物图片名及后缀*左面图片
						lab_role.setIcon(i);
						return;
					}

					if (datas[ry][rx - 1] == 4 && datas[ry][rx - 2] == 0) {
						datas[ry][rx - 1] = 0;
						datas[ry][rx - 2] = 4;
					}

					if (datas[ry][rx - 1] == 4 && datas[ry][rx - 2] == 8) {
						datas[ry][rx - 1] = 0;
						datas[ry][rx - 2] = 12;
						File f3 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\merge.mp3");//小白和笼子合并音乐
						Media _media3 = new Media(f3.toURI().toString());
						MediaPlayer _mediaPlayer3 = new MediaPlayer(_media3);
						_mediaPlayer3.play();
						num++;
					}

					if (datas[ry][rx - 1] == 12 && datas[ry][rx - 2] == 0) {
						datas[ry][rx - 1] = 8;
						datas[ry][rx - 2] = 4;
						num--;
					}

					if (datas[ry][rx - 1] == 12 && datas[ry][rx - 2] == 8) {
						datas[ry][rx - 1] = 8;
						datas[ry][rx - 2] = 12;
					}
					box[ry][rx - 1].setLocation(rx * 50 - 100,  ry * 50);
					box[ry][rx - 2] = box[ry][rx - 1];
					box[ry][rx - 1] = null;
					rx = rx - 1;
					int x = (int) lab_role.getLocation().getX();
					int y = (int) lab_role.getLocation().getY();
					lab_role.setLocation(x - 50, y);
					Icon i = new ImageIcon("Figure_Left.png");// 人物图片名及后缀*左面图片
					lab_role.setIcon(i);
					// 判断胜利
					victory();
					return;

				}
				if (key == 38) {

					// 让小新（人物）向上移动
					// 方向上第一位的坐标是 ry-1 rx
					// 方向上第二位的坐标是 ry-2 rx
					if (datas[ry - 1][rx] == 0) {
						ry = ry - 1;
						int x = (int) lab_role.getLocation().getX();
						int y = (int) lab_role.getLocation().getY();
						lab_role.setLocation(x, y - 50);
						Icon i = new ImageIcon("Figure_Behind.png");// 人物图片名及后缀*上面图片
						lab_role.setIcon(i);
						return;
					}
					if (datas[ry - 1][rx] == 1) {
						return;
					}
					if (datas[ry - 1][rx] == 4 && datas[ry - 2][rx] == 1) {
						return;
					}
					if (datas[ry - 1][rx] == 4 && datas[ry - 2][rx] == 4) {
						return;
					}
					if (datas[ry - 1][rx] == 4 && datas[ry - 2][rx] == 12) {
						return;
					}
					if (datas[ry - 1][rx] == 12 && datas[ry - 2][rx] == 1) {
						return;
					}
					if (datas[ry - 1][rx] == 12 && datas[ry - 2][rx] == 4) {
						return;
					}
					if (datas[ry - 1][rx] == 12 && datas[ry - 2][rx] == 12) {
						return;
					}

					if (datas[ry - 1][rx] == 8) {
						ry = ry - 1;
						int x = (int) lab_role.getLocation().getX();
						int y = (int) lab_role.getLocation().getY();
						lab_role.setLocation(x, y - 50);
						Icon i = new ImageIcon("Figure_Behind.png");// 人物图片名及后缀*上面图片
						lab_role.setIcon(i);
						return;
					}

					if (datas[ry - 1][rx] == 4 && datas[ry - 2][rx] == 0) {
						datas[ry - 1][rx] = 0;
						datas[ry - 2][rx] = 4;
					}

					if (datas[ry - 1][rx] == 4 && datas[ry - 2][rx] == 8) {
						datas[ry - 1][rx] = 0;
						datas[ry - 2][rx] = 12;
						File f3 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\merge.mp3");//小白和笼子合并音乐
						Media _media3 = new Media(f3.toURI().toString());
						MediaPlayer _mediaPlayer3 = new MediaPlayer(_media3);
						_mediaPlayer3.play();
						num++;
					}

					if (datas[ry - 1][rx] == 12 && datas[ry - 2][rx] == 0) {
						datas[ry - 1][rx] = 8;
						datas[ry - 2][rx] = 4;
						num--;
					}

					if (datas[ry - 1][rx] == 12 && datas[ry - 2][rx] == 8) {
						datas[ry - 1][rx] = 8;
						datas[ry - 2][rx] = 12;
					}
					box[ry - 1][rx].setLocation(rx * 50, ry * 50 - 100);
					box[ry - 2][rx] = box[ry - 1][rx];
					box[ry - 1][rx] = null;
					ry = ry - 1;
					int x = (int) lab_role.getLocation().getX();
					int y = (int) lab_role.getLocation().getY();
					lab_role.setLocation(x, y - 50);
					Icon i = new ImageIcon("Figure_Behind.png");// 人物图片名及后缀*上面图片
					lab_role.setIcon(i);
					// 判断胜利
					victory();
					return;

				}

				if (key == 39) {
					// 让小新（人物）向右移动
					// 方向上第一位的坐标是 ry rx+1
					// 方向上第二位的坐标是 ry rx+2
					if (datas[ry][rx + 1] == 0) {
						rx = rx + 1;
						int x = (int) lab_role.getLocation().getX();
						int y = (int) lab_role.getLocation().getY();
						lab_role.setLocation(x + 50, y);
						Icon i = new ImageIcon("Figure_Right.png");// 人物图片名及后缀*右面图片
						lab_role.setIcon(i);
						return;
					}
					if (datas[ry][rx + 1] == 1) {
						return;
					}
					if (datas[ry][rx + 1] == 4 && datas[ry][rx + 2] == 1) {
						return;
					}
					if (datas[ry][rx + 1] == 4 && datas[ry][rx + 2] == 4) {
						return;
					}
					if (datas[ry][rx + 1] == 4 && datas[ry][rx + 2] == 12) {
						return;
					}
					if (datas[ry][rx + 1] == 12 && datas[ry][rx + 2] == 1) {
						return;
					}
					if (datas[ry][rx + 1] == 12 && datas[ry][rx + 2] == 4) {
						return;
					}
					if (datas[ry][rx + 1] == 12 && datas[ry][rx + 2] == 12) {
						return;
					}

					if (datas[ry][rx + 1] == 8) {
						rx = rx + 1;
						int x = (int) lab_role.getLocation().getX();
						int y = (int) lab_role.getLocation().getY();
						lab_role.setLocation(x + 50, y);
						Icon i = new ImageIcon("Figure_Right.png");// 人物图片名及后缀*右面图片
						lab_role.setIcon(i);
						return;
					}

					if (datas[ry][rx + 1] == 4 && datas[ry][rx + 2] == 0) {
						datas[ry][rx + 1] = 0;
						datas[ry][rx + 2] = 4;
					}

					if (datas[ry][rx + 1] == 4 && datas[ry][rx + 2] == 8) {
						datas[ry][rx + 1] = 0;
						datas[ry][rx + 2] = 12;
						File f3 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\merge.mp3");//小白和笼子合并音乐
						Media _media3 = new Media(f3.toURI().toString());
						MediaPlayer _mediaPlayer3 = new MediaPlayer(_media3);
						_mediaPlayer3.play();
						num++;
					}

					if (datas[ry][rx + 1] == 12 && datas[ry][rx + 2] == 0) {
						datas[ry][rx + 1] = 8;
						datas[ry][rx + 2] = 4;
						num--;
					}

					if (datas[ry][rx + 1] == 12 && datas[ry][rx + 2] == 8) {
						datas[ry][rx + 1] = 8;
						datas[ry][rx + 2] = 12;
					}
					box[ry][rx + 1].setLocation(rx * 50 + 100,  ry * 50);
					box[ry][rx + 2] = box[ry][rx + 1];
					box[ry][rx + 1] = null;
					rx = rx + 1;
					int x = (int) lab_role.getLocation().getX();
					int y = (int) lab_role.getLocation().getY();
					lab_role.setLocation(x + 50, y);
					Icon i = new ImageIcon("Figure_Right.png");// 人物图片名及后缀*右面图片
					lab_role.setIcon(i);
					// 判断胜利
					victory();
					return;

				}

				if (key == 40) {
					// 让小新（人物）向下移动
					// 方向上第一位的坐标是 ry+1 rx
					// 方向上第二位的坐标是 ry+2 rx
					if (datas[ry + 1][rx] == 0) {
						ry = ry + 1;
						int x = (int) lab_role.getLocation().getX();
						int y = (int) lab_role.getLocation().getY();
						lab_role.setLocation(x, y + 50);
						Icon i = new ImageIcon("Figure_Front.png");// 人物图片名及后缀*下面图片
						lab_role.setIcon(i);
						return;
					}
					if (datas[ry + 1][rx] == 1) {
						return;
					}
					if (datas[ry + 1][rx] == 4 && datas[ry + 2][rx] == 1) {
						return;
					}
					if (datas[ry + 1][rx] == 4 && datas[ry + 2][rx] == 4) {
						return;
					}
					if (datas[ry + 1][rx] == 4 && datas[ry + 2][rx] == 12) {
						return;
					}
					if (datas[ry + 1][rx] == 12 && datas[ry + 2][rx] == 1) {
						return;
					}
					if (datas[ry + 1][rx] == 12 && datas[ry + 2][rx] == 4) {
						return;
					}
					if (datas[ry + 1][rx] == 12 && datas[ry + 2][rx] == 12) {
						return;
					}

					if (datas[ry + 1][rx] == 8) {
						ry = ry + 1;
						int x = (int) lab_role.getLocation().getX();
						int y = (int) lab_role.getLocation().getY();
						lab_role.setLocation(x, y + 50);
						Icon i = new ImageIcon("Figure_Front.png");// 人物图片名及后缀*下面图片
						lab_role.setIcon(i);
						return;
					}

					if (datas[ry + 1][rx] == 4 && datas[ry + 2][rx] == 0) {
						datas[ry + 1][rx] = 0;
						datas[ry + 2][rx] = 4;
					}

					if (datas[ry + 1][rx] == 4 && datas[ry + 2][rx] == 8) {
						datas[ry + 1][rx] = 0;
						datas[ry + 2][rx] = 12;
						File f3 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\merge.mp3");//小白和笼子合并音乐
						Media _media3 = new Media(f3.toURI().toString());
						MediaPlayer _mediaPlayer3 = new MediaPlayer(_media3);
						_mediaPlayer3.play();
						num++;
					}

					if (datas[ry + 1][rx] == 12 && datas[ry + 2][rx] == 0) {
						datas[ry + 1][rx] = 8;
						datas[ry + 2][rx] = 4;
						num--;
					}

					if (datas[ry + 1][rx] == 12 && datas[ry + 2][rx] == 8) {
						datas[ry + 1][rx] = 8;
						datas[ry + 2][rx] = 12;
					}
					box[ry + 1][rx].setLocation(rx * 50, ry * 50 + 100);
					box[ry + 2][rx] = box[ry + 1][rx];
					box[ry + 1][rx] = null;
					ry = ry + 1;
					int x = (int) lab_role.getLocation().getX();
					int y = (int) lab_role.getLocation().getY();
					lab_role.setLocation(x, y + 50);
					Icon i = new ImageIcon("Figure_Front.png");// 人物图片名及后缀*下面图片
					lab_role.setIcon(i);
					// 判断胜利
					victory();
					return;
				}
	}
}
