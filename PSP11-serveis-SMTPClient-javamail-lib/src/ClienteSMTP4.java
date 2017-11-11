/*
 * SMTP Client using library JavaMail
 */
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;

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
        String to = "myuser@mydomain.tld";
        String subject = "prova Hola";
        //String from = "me@me.com";
        //String to = "you@you.com";
        
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSentDate(new Date());
            msg.setSubject(subject);
            msg.setText("Hola,\n\n mail de prova2");

            // Send the message.
            Transport.send(msg);

        } catch (MessagingException e) {
            // Error.
            System.out.println("Excepció:" + e);
        }
    }

}
