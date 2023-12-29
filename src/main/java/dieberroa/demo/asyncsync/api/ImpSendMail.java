package dieberroa.demo.asyncsync.api;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class ImpSendMail {

    public Boolean sendEmail(String recipient, String subject, String content) {
        // Configuración de las propiedades del servidor SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.example.com"); // Cambiar al host de tu servidor SMTP
        properties.put("mail.smtp.port", "587"); // Cambiar al puerto del servidor SMTP
        properties.put("mail.smtp.ssl.trust", "smtp.example.com"); // Cambiar al host de tu servidor SMTP

        // Credenciales del remitente
        final String username = "tu_usuario@example.com"; // Cambiar por tu dirección de correo
        final String password = "tu_contraseña"; // Cambiar por tu contraseña

        // Crear una sesión con las propiedades y las credenciales
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear un mensaje con el contenido y el destinatario
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(content);

            // Enviar el correo
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
