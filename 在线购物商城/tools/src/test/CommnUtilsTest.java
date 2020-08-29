package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;

/**
 * 娴嬭瘯CommonUtils
 * @author qdmmy6
 *
 */
public class CommnUtilsTest {
	/**
	 * 闅忔満鐢熸垚32浣嶉暱鐨勫瓧绗︿覆锛岄�氬父鐢ㄦ潵鍋氬疄浣撶被鐨処D
	 */
	@Test
	public void testUuid() {
		String s = CommonUtils.uuid();//鐢熸垚闅忔満32浣嶉暱鐨勫瓧绗︿覆
		System.out.println(s);
	}
	
	/**
	 * 鎶奙ap绫诲瀷鏄犲皠鎴怋ean绫诲瀷銆�
	 * 瑕佹眰map涓敭鐨勫悕绉颁笌Person绫荤殑灞炴�у悕绉扮浉鍚屻��
	 * 鍗砿ap鐨刱ey鍒嗗埆涓猴細pid銆乶ame銆乤ge銆乥irthday锛宲erson鐨勫睘鎬у悕绉颁篃鏄痯id銆乶ame銆乤ge銆乥irthday
	 */
	@Test
	public void testToBean() {
		Map<String,String> map = new HashMap<String,String>();
		/*
		 * map鐨刱ey锛歱id銆乤ge銆乥irthday銆乵yname
		 * person鐨勫睘鎬э細pid銆乤ge銆乥irthday銆乶ame
		 * map涓病鏈夊悕涓簄ame鐨勯敭鍊硷紝鑰屽鍑轰竴涓悕涓簃yname鐨勯敭鍊硷紝鎵�浠ユ槧灏勫悗鐨刾erson瀵硅薄鐨刵ame灞炴�у�间负null銆�
		 * map涓殑age鍜宐irthday閮芥槸瀛楃涓茬被鍨嬶紝鑰宲erson鐨刟ge鏄痠nt绫诲瀷銆乥irthday鏄疍ate绫诲瀷锛屼絾toBean()鏂规硶浼氳嚜鍔ㄥMap涓�艰繘琛岀被鍨嬭浆鎹€��
		 */
		map.put("pid", CommonUtils.uuid());
		map.put("age", "18");
		map.put("birthday", "1970-01-01");
		map.put("myname", "张三");
		
		Person p = CommonUtils.toBean(map, Person.class);
		System.out.println(p);
	}
}
