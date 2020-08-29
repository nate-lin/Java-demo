package com.ossjk.ossjkssm.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreadNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		creadLS("S20190099");
		creadDJS("DJS20190099");
	}

	public static String creadLS(String code) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String newCode = "S"+sdf.format(new Date());
		String s = code.substring(5,code.length());
		int num = Integer.parseInt(s);
		    num += 1;//在原来的基础是加1
		    String n = num+"";//转换成Stirng类型
		    if(n.length() == 1) {
		    	newCode = newCode +"000" +n;
		    }else if(n.length() == 2) {
		    	newCode = newCode +"00" +n;
		    }else if(n.length() == 3) {
		    	newCode = newCode +"0" +n;
		    }else if(n.length() == 4) {
		    	newCode = newCode +n;
		    }
		System.out.println(newCode);
		return newCode;
	}
	
	
	public static String creadDJS(String sno) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String newSno = "DJS"+sdf.format(new Date());
		String s = sno.substring(7,sno.length());
		int num = Integer.parseInt(s);
		    num += 1;//在原来的基础是加1
		    String n = num+"";//转换成Stirng类型
		    if(n.length() == 1) {
		    	newSno = newSno +"000" +n;
		    }else if(n.length() == 2) {
		    	newSno = newSno +"00" +n;
		    }else if(n.length() == 3) {
		    	newSno = newSno +"0" +n;
		    }else if(n.length() == 4) {
		    	newSno = newSno +n;
		    }
		System.out.println(newSno);
		return newSno;
	}
	
	
	
}
