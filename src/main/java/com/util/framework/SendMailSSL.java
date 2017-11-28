package com.util.framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;

public class SendMailSSL {
	private final static Logger logger = Logger.getLogger(SendMailSSL.class);
	
	public static void main(String[] args) {
		sendReport("Test mail", "C://Users//Ashu//Desktop//ExportEngineInput.xlsx");
	}

	public static  Session createConnection() throws MessagingException {
		// Create IMAPSSLStore object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// All sysout statements are used for testing, have to remove them
		// while implementation
		logger.info("Connecting to gmail...");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("onlineweekend.diningedge@gmail.com", "edge2016");// change
																								// accordingly
			}
		});
		return session;
	}

	/*
	 * public static IMAPSSLStore createConnection() throws MessagingException {
	 * // Create IMAPSSLStore object Properties props = System.getProperties();
	 * props.setProperty("mail.store.protocol", "imaps");
	 * 
	 * Session session = Session.getDefaultInstance(props, new
	 * javax.mail.Authenticator() { protected PasswordAuthentication
	 * getPasswordAuthentication() { return new
	 * PasswordAuthentication(Constant.GmailUser, Constant.GmailPassword);//
	 * change // accordingly } }); URLName urlName = new
	 * URLName("imap.gmail.com"); IMAPSSLStore store = new IMAPSSLStore(session,
	 * urlName);
	 * 
	 * // All sysout statements are used for testing, have to remove them //
	 * while implementation logger.info("Connecting to gmail...");
	 * 
	 * // Connect to GMail, enter user name and password here
	 * store.connect("imap.gmail.com", Constant.GmailUser,
	 * Constant.GmailPassword);
	 * 
	 * logger.info("Connected to - " + store);
	 * 
	 * sendMailAction(session, Constant.GmailUser, Constant.GmailPassword);
	 * 
	 * logger.info("send mail success"); return store; }
	 */

	public static void sendMailAction(String PurveyorName, String Restaurantname ) {
		try {
			Properties Constant = new Properties();
			Constant.load(new FileInputStream("Config.properties"));
			String to = Constant.getProperty("sendMailTo");
			String user = Constant.getProperty("sendMailFrom");// change
																		// accordingly
			// get connection
			Session session = createConnection();
			//String filepath = RandomAction.setdownloadDir();
			File GFS_OG = PageAction.getLatestFilefromDir("C:\\Users\\Edge\\Downloads\\");
			String filename = GFS_OG.getAbsolutePath();
			logger.info(filename);
			
			MimeMessage message = new MimeMessage(session);
		//	message.setFrom(new InternetAddress(user));
		//	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//	message.setSubject("Message Alert");

			MimeMessage messageBodyPart1 = new MimeMessage(session);
			messageBodyPart1.setFrom(new InternetAddress(user));// change
			// accordingly
			messageBodyPart1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			//smessageBodyPart1.addRecipient(Message.RecipientType.CC, new InternetAddress("teamesave@gmail.com"));

			// Subject of mails
			message.setSubject("OnLineMacro :: " + PurveyorName + " :: " + Restaurantname);
			// Body of mails
			message.setContent("GFS OG export- date & time : " + PageAction.getDate(), "text/html");

			//message.setText();

			// 4) create new MimeBodyPart object and set DataHandler object to
			// this object
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

			// 5) create Multipart object and add MimeBodyPart objects to this
			// object
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart2);

			// 6) set the multiplart object to the message object
			message.setContent(multipart);

			// send message
			/*
			 * Transport transport = session.getTransport("smtp");
			 * transport.connect(Constant.GmailURL,Constant.GmailUser ,
			 * Constant.GmailPassword); transport.sendMessage(message,
			 * messageBodyPart1.getAllRecipients());
			 */
			Transport.send(message, messageBodyPart1.getAllRecipients());

			logger.info("Message send success");

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info(e.getMessage());
			// TODO: handle exception
		}

	}
	public static void sendReport(String Subject, String filename ) {
		try {
			Properties Constant = new Properties();
			Constant.load(new FileInputStream("C://Users//Ashu//git//masterCheney//src//test//resources//Config.properties"));
			String to = Constant.getProperty("reportTo");
			String user = Constant.getProperty("sendMailFrom");// change
																		// accordingly
			// get connection
			Session session = createConnection();
		
			MimeMessage message = new MimeMessage(session);
		

			MimeMessage messageBodyPart1 = new MimeMessage(session);
			messageBodyPart1.setFrom(new InternetAddress(user));// change
			// accordingly
			messageBodyPart1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


			// Subject of mails
			message.setSubject(Subject);
			// Body of mails
			message.setContent("Attached is the report for the OG export on : " + PageAction.getDate(), "text/html");

			//message.setText();

			// 4) create new MimeBodyPart object and set DataHandler object to
			// this object
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
			logger.info("Attached file - " +filename);

			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart2);

			message.setContent(multipart);

			Transport.send(message, messageBodyPart1.getAllRecipients());

			logger.info("Message send success");

		} catch (AddressException e) {
			e.printStackTrace();
			logger.info("Technical issue in sending reporting");
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.info("Technical issue in sending reporting");
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info("Technical issue in sending reporting");
		}

	}

}