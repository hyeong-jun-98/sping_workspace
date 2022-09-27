package com.academy.shopping.model.util;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.academy.shopping.exception.EmailException;

import javax.mail.Message;
import javax.mail.MessagingException;


// 우리 회사 운영 서버가 아닌, 구글의 서버를 빌려서 메일을 보내자.

public class MailSender {

	String host = "smtp.gmail.com";
	String user ="yanghjun98@gmail.com";
	String password="kanvugnajyllvimp";
	
	Properties props = new Properties();		// map의 자식 객체
	
	public void send(String content) throws EmailException{
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ss.trust", "smtp.gmail.com");
	
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
				
			}
			
		});
		
		Message message = new MimeMessage(session);
		
		try {
			
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("bellehee98@naver.com"));
			message.setSubject("고객님의 주문이 완료되었습니다.");
			message.setContent(content, "text/html;charset=utf-8");
			
			Transport.send(message);
			System.out.println("메일 발송 성공");
		} catch (AddressException e) {
			e.printStackTrace();
			throw new EmailException("메일 발송 실패", e);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new EmailException("메일 발송 실패", e);
		}
	
	}
}
