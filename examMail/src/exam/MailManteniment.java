/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author mercedes
 */
public class MailManteniment {

    private String smtpServer;
    private String sender;
    private String destinatari;
    private Properties props;

    public MailManteniment(String smtpServer, String sender, String destinatari) {
        this.smtpServer = smtpServer;
        this.sender = sender;
        this.destinatari = destinatari;
        
        // Properties to set up the SMTP server
        this.props = new Properties();
        props.put("mail.smtp.host", smtpServer);
        //props.put("mail.debug", "true");
    }
    
    public Boolean enviarMail(Exception exc) {
        //obtener instancia de session
        Session session = Session.getDefaultInstance(props, null);

        // Construct the message with the MimeMessage class        
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(sender));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatari));
            msg.setSentDate(new Date());
            msg.setSubject("Error a l'aplicació EchoServer");
            msg.setText("Hola,\n\n error a l'aplicació EchoServer: \n " + exc.getLocalizedMessage());

            // Send the message.
            Transport.send(msg);

        } catch (MessagingException e) {
            // Error.
            System.out.println("Excepció:" + e);
            return false;
        }
        return true;
    }
    
       
             
}
