/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.serveis.pop3;

import java.io.BufferedReader;
import java.io.IOException;
import org.apache.commons.net.pop3.*;

/**
 *
 * @author mercedes
 */
public class POP3_Test2 {

//    static String server = "pop3.server";
//    static String username = "user";
//    static String password = "password";
    static String server = "localhost";
    static String username = "user01@james.local";
    static String password = "1234";

    public static void main(String[] args) {
        String line;

        POP3Client pop3;
        pop3 = new POP3Client();
        pop3.setDefaultTimeout(60000);

        // Connectem al servidor
        try {
            pop3.connect(server);
        } catch (IOException e) {
            System.err.println("Could not connect to server." + e);
            //e.printStackTrace();
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
                String missatge = "";
                Boolean esMsgProva = true;
                
                System.out.println("Llegint missatge " + msginfo.number);
                // Mostro el missatge
                while ((line = reader.readLine()) != null && esMsgProva) {                  
                    missatge = missatge + line + "\n";
                    if (line.startsWith("Subject:")) {
                        if (!line.toLowerCase().contains("apachelib")) {
                            System.out.println("Missatge " + msginfo.number + " descartat. Subject line --> " + line);
                            esMsgProva = false;
                        }
                    }
                }
                if (esMsgProva) {
                    System.out.println("MISSATGE " + msginfo.number + " TROBAT!!!!!!");
                    System.out.println(missatge);
                }
                reader.close();
            }

            pop3.logout();
            pop3.disconnect();
        } catch (IOException e) {
            System.out.println("Error de E/S" + e);           
            //e.printStackTrace();
        }

    }

}
