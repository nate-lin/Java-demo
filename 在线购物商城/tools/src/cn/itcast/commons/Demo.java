package cn.itcast.commons;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Demo {
	/**
	 * 鍐欎竴涓狹ap锛宮ap涓殑String瑕佸皝瑁呭埌User鐨刟ge涓�
	 * BeanUtils鍙互鎶奡tring杞崲鎴恑nt
	 */
	@Test
	public void fun1(){
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("username", "lisi");
		map.put("password", "123");
		map.put("age", "55");
		
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user);
	}
	
	@Test
	public void fun2(){
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("username", "zhangsan");
		map.put("password", "123");
		map.put("age", "55");
		map.put("birthday", "2013-01-29");
		
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user);
	}
}
