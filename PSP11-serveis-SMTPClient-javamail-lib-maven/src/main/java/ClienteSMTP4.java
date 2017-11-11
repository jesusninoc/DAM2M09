/*
 * SMTP Client using library JavaMail
 * projecte amb maven
 */
import java.util.Date;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author alumne
 */
public class ClienteSMTP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set up the SMTP server.
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", "localhost");
        props.put("mail.debug", "true");

        //obtener instancia de session
        Session session = Session.getDefaultInstance(props, null);

        // Construct the message with the MimeMessage class
        String from = "merceicas@gmail.com";
        String to = "mercem09@mailinator.com";
        String subject = "prova Hola";
        //String from = "me@me.com";
        //String to = "you@you.com";
        
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSentDate(new Date());
            msg.setSubject(subject);
            msg.setText("Hola,\n\nAixò és un mail de prova");

            // Send the message.
            Transport.send(msg);

        } catch (MessagingException e) {
            // Error.
            System.out.println("Excepció:" + e);
        }
    }

}
