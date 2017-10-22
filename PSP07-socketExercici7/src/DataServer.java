
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.*;
import java.util.*;

/**
 *
 * @author alumne
 */
public class DataServer {

    /**
     * Funció que mostra el menú i retorna l'ordre entrada per teclat
     *
     */
    private static String demanaOrdre() {
        Scanner scan = new Scanner(System.in);
        String seleccio = "";
        do {
            System.out.println("1 - Demana un enter");
            System.out.println("2 - Demana un double");
            System.out.println("3 - Demana un char");
            System.out.println(". - Per acabar");
            seleccio = scan.nextLine();
        } while (!"1".equalsIgnoreCase(seleccio) && !"2".equalsIgnoreCase(seleccio)
                && !"3".equalsIgnoreCase(seleccio) && !".".equalsIgnoreCase(seleccio));

        return seleccio;
    }

    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String entradaTeclat = "";
        String ordre = "";

        try {
            ServerSocket server = new ServerSocket(7000);
            System.out.println("Server is started");

            while (true) {

                // Esperem que es connecti un client
                System.out.println("Esperant nou client... ");
                Socket socket = server.accept();

                System.out.println("Client connectat: " + socket.getRemoteSocketAddress());

                // Creem els streams d'entrada i sortida
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                try {

                    while (!".".equals(ordre)) {

                        // Mostrem el menú i demanem ordre per teclat
                        ordre = demanaOrdre();

                        // Enviem l'ordre al client
                        dos.writeUTF(ordre);

                        if (!".".equals(ordre)) {
                            // Rebrem la dada del client i la mostrarem per pantalla
                            // Depenent de l'ordre rebrem un tipus de dada o un altre
                            switch (ordre) {
                                case "1":
                                    int i = dis.readInt();
                                    System.out.println("Enter: " + i);
                                    break;

                                case "2":
                                    double d = dis.readDouble();
                                    System.out.println("Double: " + d);
                                    break;

                                case "3":
                                    char c = dis.readChar();
                                    System.out.println("Caracter: " + c);
                                    break;
                            }
                        }
                        else {
                           System.out.println("Fi de connexió"); 
                        }

                    }

                } catch (SocketException | EOFException ex) {
                    System.out.println("Client desconnectat");
                }

                socket.close();
            }

        } catch (BindException ex) {
            System.out.println("El port ja està agafat");

        }
    }

}
