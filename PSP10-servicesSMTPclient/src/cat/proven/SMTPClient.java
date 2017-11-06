package cat.proven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mercedes
 */
public class SMTPClient {

    private String smtpServer;
    private int port;
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private PrintWriter out;

    /**
     * Constructor de la classe, li indiquem l'url i el port del servidor SMTP
     * al que ens connectarem
     *
     * @param smtpServer
     * @param port
     */
    public SMTPClient(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    /**
     * Li indiquem el remitent del missatge
     *
     * @param sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Li indiquem que volem afegir un destinatari del correu
     *
     * @param recipient
     */
    public void addRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Li afegim un subject al correu
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Indiquem el text que tindrà el cos del missatge que volem enviar
     *
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    private void sendCommand(String command) {
        System.out.println(command);
        this.out.println(command);
        this.out.flush();
    }

    private void sendMailMessage(String command) {
        System.out.println(command);
        this.out.println(command);
    }

    private void sendEndOfMailMessage() {
        System.out.println();
        System.out.println(".");
        this.out.print("\r\n");
        this.out.print(".\r\n");
        this.out.print("\r\n");
        this.out.flush();
    }

    private void sendStartBody() {
        System.out.println();
        this.out.println();
    }

// LOG d'un enviament de mail amb telnet
//
//alumne@proven:~$ telnet localhost 25
//Trying 127.0.0.1...
//Connected to localhost.
//Escape character is '^]'.
//220 proven ESMTP Sendmail 8.15.2/8.15.2/Debian-3; Fri, 3 Nov 2017 11:12:20 +0100; (No UCE/UBE) logging access from: localhost(OK)-localhost [127.0.0.1]
//HELO localhost
//250 proven Hello localhost [127.0.0.1], pleased to meet you
//MAIL FROM: mcast386@xtec.cat
//250 2.1.0 mcast386@xtec.cat... Sender ok
//rcpt to: merceicas@gmail.com
//250 2.1.5 merceicas@gmail.com... Recipient ok
//data
//354 Enter mail, end with "." on a line by itself
//Subject: Prova
//Hola,
//estic provant el correu sortint
//.
//250 2.0.0 vA3ACKe0012083 Message accepted for delivery
//QUIT
//221 2.0.0 proven closing connection
//Connection closed by foreign host.
//alumne@proven:~$ 
    /**
     *
     * @return
     */
    public boolean sendMail() {
        boolean ok = true;
        String toSend;
        String received;
        try {

            //InetAddress inetAddress = InetAddress.getByName(smtpServer);
            //Socket socket = new Socket(inetAddress, port);
            Socket socket = new Socket(smtpServer, port);
            //socket.setSoTimeout(10000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            // el servidor contesta quan un client es connecta. Similar a:
            //220 proven ESMTP Sendmail 8.15.2/8.15.2/Debian-3; Fri, 3 Nov 2017 11:12:20 +0100; (No UCE/UBE) logging access from: localhost(OK)-localhost [127.0.0.1]
            //
            //llegir el que envia el servidor i mostrar-lo per pantalla
            received = in.readLine();
            System.out.println(received);
            //comprovar que comença per 220
            ok = received.startsWith("220");

            //enviem SMTP ordre HELO i comprovem resposta sigui 2XX
            if (ok) {
                sendCommand("HELO localhost");
                received = in.readLine();
                System.out.println(received);
                ok = received.startsWith("2");
            }
            //enviem SMTP ordre MAIL FROM: i comprovem resposta sigui 2XX
            if (ok) {
                sendCommand("MAIL FROM: <" + sender + ">");
                received = in.readLine();
                System.out.println(received);
                ok = received.startsWith("250");
            }
            //enviem SMTP ordre RCPT TO: i comprovem resposta sigui 2XX
            if (ok) {
                sendCommand("RCPT TO: <" + recipient + ">");
                received = in.readLine();
                System.out.println(received);
                ok = received.startsWith("250");
            }

            //enviem SMTP ordre DATA i comprovem resposta sigui 2XX
            if (ok) {
                sendCommand("DATA");
                received = in.readLine();
                System.out.println(received);
                ok = received.startsWith("354");
            }

            //enviem el contingut del mail, i acabem amb una linia amb un "."
            //comprovem la resposta del servidor sigui "2XX"
            if (ok) {
                SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
                dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
                sendMailMessage("Date: " + dateFormatGmt.format(new Date()));
                sendMailMessage("From: <" + sender + ">");
                sendMailMessage("To: <" + recipient + ">");
                sendMailMessage("Subject: " + subject);
                sendStartBody();
                sendMailMessage(body);
                sendEndOfMailMessage();
                received = in.readLine();
                System.out.println(received);
                ok = received.startsWith("250");
            }

            //finalitzem la connexió
            sendCommand("QUIT");
            received = in.readLine();
            System.out.println(received);

            //tanquem el socket
            socket.close();

        } catch (IOException ex) {
            System.out.println("Error d'E/S: " + ex);
            Logger.getLogger(SMTPClient.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
}
