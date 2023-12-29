package dieberroa.demo.asyncsync.api;

public interface SendEmail {

    Boolean sendEmail(String recipient, String subject, String content);

}
