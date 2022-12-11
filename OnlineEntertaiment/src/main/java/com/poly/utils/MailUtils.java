package com.poly.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailUtils {
	

	public static void sendMail(HttpServletRequest request, HttpServletResponse response,
			String to, String subject, String content ) {
			final String userName = "dongtrieuit@gmail.com";
			final String passWord = "eyetolnvszqpgtrd";
			Properties pro = new Properties();
			pro.put("mail.smtp.host","smtp.gmail.com");
			pro.put("mail.smtp.port","587");
			pro.put("mail.smtp.auth","true");
			pro.put("mail.smtp.starttls.enable","true");
			Session session = Session.getInstance(pro,new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, passWord);
				}
			});

			Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(userName));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(content);
				Transport.send(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("loi gui mail");
				response.setStatus(400);
			} 
		}

}
