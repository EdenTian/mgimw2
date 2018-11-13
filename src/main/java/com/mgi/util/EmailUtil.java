package com.mgi.util;

import org.springframework.core.io.ClassPathResource;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {
	private static Properties properties = new Properties();
	static{
		try {
			properties.load(new ClassPathResource("properties/email.properties").getInputStream());
		} catch (IOException e) {
		}
	}
	public static    String SMTPSERVER = properties.getProperty("smtp.server");
	public static  String SMTPPORT = properties.getProperty("smtp.port");
	public  static  String ACCOUT = properties.getProperty("smtp.account");
	public  static  String PWD = properties.getProperty("smtp.pwd");

	public static String users = properties.getProperty("email.users");
	public static void  sendEmail(String title,String content){
		try {
		// 创建邮件配置
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址
		props.setProperty("mail.smtp.port", SMTPPORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		props.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl
		// 根据邮件配置创建会话，注意session别导错包
		Session session = Session.getDefaultInstance(props);
		// 开启debug模式，可以看到更多详细的输入日志
		session.setDebug(true);
		//创建邮件
		MimeMessage message = createEmail(session,users,content,title);
		//获取传输通道
		Transport transport = session.getTransport();
		transport.connect(SMTPSERVER,ACCOUT, PWD);
		//连接，并发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	public static MimeMessage createEmail(Session session,String users,String content,String title){
		MimeMessage msg = null;
		try {
			// 根据会话创建邮件
			msg = new MimeMessage(session);
			// address邮件地址, personal邮件昵称, charset编码方式
			InternetAddress fromAddress = new InternetAddress(ACCOUT,
					"中间件推送", "utf-8");
			// 设置发送邮件方
			msg.setFrom(fromAddress);

//        InternetAddress receiveAddress = new InternetAddress();
			// 设置邮件接收方
			Address[] internetAddressTo = new InternetAddress().parse(users);
			msg.setRecipients(MimeMessage.RecipientType.TO,  internetAddressTo);
			// 设置邮件标题
			msg.setSubject(title, "utf-8");
			msg.setText(content);
			// 设置显示的发件时间
			msg.setSentDate(new Date());
			// 保存设置
			msg.saveChanges();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return msg;
	}

}
