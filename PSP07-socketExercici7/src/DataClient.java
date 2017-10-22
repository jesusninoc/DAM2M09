
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;

import java.net.*;
import java.util.*;

/**
 *
 * @author alumne
 */
public class DataClient {

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
            Socket socket = new Socket("localhost", 7000);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());


            // Esperem rebre una ordre del Servidor
            ordre = dis.readUTF();
            
            while (!".".equals(ordre)) {

                // Demanarem a l'usuari que entri el tipus de dada corresponent
                // L'enviarem al servidor fent la conversió
                // Controlem que la dada entrada sigui del tipus correcte
                try {
                    switch (ordre) {
                        case "1":
                            System.out.println("Entra un enter:");
                            entradaTeclat = scan.nextLine();
                            dos.writeInt(Integer.parseInt(entradaTeclat));
                            break;

                        case "2":
                            System.out.println("Entra un double:");
                            entradaTeclat = scan.nextLine();
                            dos.writeDouble(Double.parseDouble(entradaTeclat));
                            break;

                        case "3":
                            System.out.println("Entra un carácter:");
                            entradaTeclat = scan.nextLine();
                            dos.writeChar(entradaTeclat.charAt(0));
                            break;

                    }

                    // Esperem següent ordre
                    ordre = dis.readUTF();

                } catch (NumberFormatException ex) {
                    System.out.println("La dada entrada no es valida. Try again...");

                }

            }
            System.out.println("Fi de connexió");

        } catch (SocketException | EOFException ex) {
            System.out.println("Servidor desconnectat");
        }

    }

}
