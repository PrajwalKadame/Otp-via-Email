package com.SangamOne.dao.utility;

import java.io.IOException;
import org.springframework.stereotype.Service;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
public class UtilityMethods {
	
	public String generatedRandomOtp() {
		return String.valueOf((int)(Math.random() * 900000) + 100000);
	}
	
	
	public void sendMail(String email , String oneTimePassword ) {
		try {
			String from = "noreply@sangamone.com";
			String pass="ApnaKhata$3";
			String to = email;
			String host="mail34.mailservice25.com";

			String cc="";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
	   	    prop.put("mail.smtp.user", from);
	   	    prop.put("mail.smtp.password", pass);
	   	    prop.put("mail.smtp.port", "587");
	   	    prop.put("mail.smtp.auth", "true");

   	   Session session = Session.getDefaultInstance(prop);
   	   try{
   	      MimeMessage message1 = new MimeMessage(session);
   	      message1.setFrom(new InternetAddress(from));
   	      message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
   	    message1.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
   	      message1.setSubject("Testing mail from SangamOne Connected Services(Prajwal)");
   	      message1.setContent(
   	    		"<body>"+
   	    		  "<p>This is just For Testing mail from SangamOne Connected Services(Prajwal). Otp:  <b>"+ oneTimePassword+" </b></p>"+
   	    		
   	    		"</div"+
   	    		  "</body>" ,"text/html");

   	      Transport transport = session.getTransport("smtp");
   	      transport.connect(host, from, pass);
   	      transport.sendMessage(message1, message1.getAllRecipients());
   	      transport.close();
   	      System.out.println("12346");
   	      }catch (MessagingException e) {
   	      e.printStackTrace();	
   	      }
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	
	
	
	
	
}
