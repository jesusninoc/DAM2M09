package cat.proven;

/**
 *
 * @author mercedes
 */
public class TestSMTPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//            SMTPClient sender = new SMTPClient("alt1.gmail-smtp-in.l.google.com", 25);
            SMTPClient sender = new SMTPClient("localhost", 25);
            sender.addRecipient("user01@james.local");
//            sender.addRecipient("your_mail@yopmail.com");
            sender.setSender("nobody@yopmail.com");
            sender.setSubject("PROVA 2");
            sender.setBody("Això és una prova");
            if (sender.sendMail()) {
                System.out.println("OK");
            } else {
                System.out.println("KO");
            }
    }

}
