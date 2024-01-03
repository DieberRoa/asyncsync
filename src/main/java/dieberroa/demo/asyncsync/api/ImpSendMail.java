package dieberroa.demo.asyncsync.api;
import javax.mail.*;
import javax.mail.internet.*;

import dieberroa.demo.asyncsync.common.EmailConstants;

import java.util.Properties;

public class ImpSendMail {

    public Boolean sendEmail(String recipient, String subject, String content) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", EmailConstants.SMTP_HOST);
        properties.put("mail.smtp.port", EmailConstants.SMTP_PORT);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailConstants.SENDER_EMAIL, EmailConstants.SENDER_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailConstants.SENDER_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            System.out.println("Correo enviado con éxito a " + recipient);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
