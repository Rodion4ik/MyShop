/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop;

import com.eshop.model.EMailMessage;
import com.eshop.model.MyAuthenticator;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

    static final String ENCODING = "UTF-8";

    public static void sendMail(final EMailMessage mail) throws Exception {
 Authenticator auth = new MyAuthenticator(mail.getUser(), mail.getPassword());
 Properties props = System.getProperties();
        //if (validtor.validate(mail.getReceipient())) {
     //   Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mail.ru");
        // props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.mime.charset", ENCODING);

        
        Session session = Session.getDefaultInstance(props, auth);
try{
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(mail.getUser()));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getRecepient()));
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getBody());
        Transport.send(msg);

}
         catch (MessagingException e) {
            throw e;
        }}
//        } else {
//            throw new MailException("Email address not valid.");
//        }
    }

