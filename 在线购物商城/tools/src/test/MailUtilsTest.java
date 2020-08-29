package test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Test;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

public class MailUtilsTest {
	/**
	 * 测试发送普通邮件
	 * @throws IOException 
	 * @throws MessagingException 
	 */
	@Test
	public void fun() throws MessagingException, IOException {
		Session session = MailUtils.createSession("smtp.qq.com", "1724342055", "tmtraebsysrkcbca");//创建session
		Mail mail = new Mail("1724342055@qq.com", "1724342055@qq.com", "测试MailUtils", "这是正文！");//创建邮箱对象，参数分别为：发件人、收件人、主题、正文
		MailUtils.send(session, mail);// 发送邮件
	}

}
