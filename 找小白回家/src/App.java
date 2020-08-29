import java.io.File;

import cn.itcast.txz.ui.MainFrame;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

//执行程序用的入口类
public class App {
	public static void main(String[] args){
		File f1 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\background.mp3");//背景音乐
		File f2 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\begin.mp3");//点击音乐
		File f3 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\merge.mp3");//碰撞音乐
		File f4 = new File("D:\\MyDownloads\\Desktop\\11\\最新版--找小白回家\\music\\finish.mp3");//游戏开始音乐
		
		Media _media1 = new Media(f1.toURI().toString());
		Media _media2 = new Media(f2.toURI().toString());
		Media _media3 = new Media(f3.toURI().toString());
		Media _media4 = new Media(f4.toURI().toString());

		// 必须有这一行，并且要在MediaPlayer创建之前w
		final JFXPanel fxPanel = new JFXPanel();
		MediaPlayer _mediaPlayer1 = new MediaPlayer(_media1);
		MediaPlayer _mediaPlayer2 = new MediaPlayer(_media2);
		MediaPlayer _mediaPlayer3 = new MediaPlayer(_media3);
		MediaPlayer _mediaPlayer4 = new MediaPlayer(_media4);

		
		_mediaPlayer1.play();
		//alt+/
		new MainFrame();
	}

}
