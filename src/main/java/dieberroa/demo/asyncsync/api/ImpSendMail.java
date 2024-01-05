package dieberroa.demo.asyncsync.api;
import javax.mail.*;
import javax.mail.internet.*;

import dieberroa.demo.asyncsync.common.EmailConstants;
import dieberroa.demo.asyncsync.common.EmailMessages;

import java.util.Properties;

public class ImpSendMail implements SendEmail{

    public Boolean sendEmail(String recipient, String subject, String content) {
        Properties properties = new Properties();
        properties.put(EmailConstants.MAIL_SMTP_AUTH_VALUE, EmailConstants.TRUE_BOOLEAN_VALUE);
        properties.put(EmailConstants.MAIL_SMTP_STARTTLS_ENABLE_VALUE, EmailConstants.TRUE_BOOLEAN_VALUE);
        properties.put(EmailConstants.MAIL_SMTP_HOST_VALUE, EmailConstants.SMTP_HOST_VALUE);
        properties.put(EmailConstants.MAIL_SMTP_PORT_VALUE, EmailConstants.SMTP_PORT_VALUE);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailConstants.SENDER_EMAIL_VALUE, EmailConstants.SENDER_PASSWORD_VALUE);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailConstants.SENDER_EMAIL_VALUE));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            System.out.println(EmailMessages.EMAIL_SENT_SUCCESSFULLY + recipient);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
