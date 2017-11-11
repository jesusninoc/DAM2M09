
import java.io.*;
import org.apache.commons.net.pop3.*;

public class POP3_Test {

//    static String server = "pop3.server";
//    static String username = "user";
//    static String password = "password";

    static String server = "localhost";
    static String username = "myuser@mydomain.tld";
    static String password = "mypassword";
    public static void main(String[] args) {
        String line;

        POP3Client pop3;
        pop3 = new POP3Client();
        pop3.setDefaultTimeout(60000);

        // Connectem al servidor
        try {
            pop3.connect(server);
        } catch (IOException e) {
            System.err.println("Could not connect to server.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            // Ens identifiquem amb les nostres credencials

            if (!pop3.login(username, password)) {
                System.err.println("Could not login to server.  Check password.");
                pop3.disconnect();
                System.exit(1);
            }

            // Obtenim els missatges de la bústia POP3
            POP3MessageInfo[] messages = pop3.listMessages();

            if (messages == null) {
                System.err.println("Could not retrieve message list.");
                pop3.disconnect();
                return;
            } else if (messages.length == 0) {
                System.out.println("No messages");
                pop3.logout();
                pop3.disconnect();
                return;
            }
            System.out.println("Total missatges = " + messages.length);
            // Recorrem els missatges
            for (POP3MessageInfo msginfo : messages) {
                System.out.println("----------------------------");
                // Obtenim el missatge
                BufferedReader reader = (BufferedReader) pop3.retrieveMessage(msginfo.number);

                if (reader == null) {
                    System.err.println("Could not retrieve message.");
                    pop3.disconnect();
                    System.exit(1);
                }

                // Mostro el missatge
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            }

            pop3.logout();
            pop3.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

}
