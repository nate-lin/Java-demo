package cn.itcast.brid;

import java.io.File;
import javax.swing.JFrame;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class Main extends JFrame {
	static Main m;
	private static final long serialVersionUID = 1L;
	public Main() {
		this.setTitle("yx");
		this.setSize(1250, 950);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		
	
		m= new Main();
		GamePanel gp = new GamePanel();
		m.add(gp);
		gp.action();
		m.setVisible(true);
		gp.requestFocus();
		
		File f1 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\background.mp3");//背景音乐
		File f2 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\skill.mp3");//技能音乐
		File f3 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\fall.mp3");
		File f4 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\begin.mp3");//游戏开始音乐
		File f5 = new File("D:\\MyDownloads\\Desktop\\最新版--人射战鸟\\music\\finish.mp3");//游戏结束音乐
		Media _media1 = new Media(f1.toURI().toString());
		Media _media2 = new Media(f2.toURI().toString());
		Media _media3 = new Media(f3.toURI().toString());
		Media _media4 = new Media(f4.toURI().toString());
		Media _media5 = new Media(f5.toURI().toString());
		// 必须有这一行，并且要在MediaPlayer创建之前w
		final JFXPanel fxPanel = new JFXPanel();
		MediaPlayer mediaPlayer1 = new MediaPlayer(_media1);
		MediaPlayer _mediaPlayer2 = new MediaPlayer(_media2);
		MediaPlayer _mediaPlayer3 = new MediaPlayer(_media3);
		MediaPlayer _mediaPlayer4 = new MediaPlayer(_media4);
		MediaPlayer _mediaPlayer5 = new MediaPlayer(_media5);
		mediaPlayer1.play();
		
	}
	public void closed() {
		this.setVisible(false);
		this.dispose();
	}
}
