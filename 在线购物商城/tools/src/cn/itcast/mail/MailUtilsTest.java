package cn.itcast.mail;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Test;

public class MailUtilsTest {
	/**
	 * 测试发送普通邮件
	 * @throws IOException 
	 * @throws MessagingException 
	 */
	@Test
	public void fun() throws MessagingException, IOException {
		Session session = MailUtils.createSession("smtp.163.com", "itcast_cxf", "itcastitcast");//创建session
		Mail mail = new Mail("1724342055@qq.com", "itcast_cxf@126.com", "测试MailUtils", "这是正文！");//创建邮箱对象，参数分别为：发件人、收件人、主题、正文
		MailUtils.send(session, mail);// 发送邮件
	}

}
