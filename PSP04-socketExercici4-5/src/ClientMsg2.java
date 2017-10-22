
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

public class ClientMsg2 {

    public static void main(String[] args) throws Exception {
        String entrada = "";

        try {
            // connectem al Servidor en la pròpia màquina i al port 7000
            Socket socket = new Socket("localhost", 7000);
            
            //utilitzem un DataOutputStream per escriure en el Socket
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            try {
                System.out.println("Entra les frases que vulguis enviar. Per acabar escriu un punt.");

                //utilitzem Scanner per llegir de l'entrada estàndard
                Scanner scan = new Scanner(System.in);

                while (!".".equals(entrada)) {
                    //llegir una linia
                    entrada = scan.nextLine();
                    //enviar al servidor
                    dos.writeUTF(entrada);
                }

            } catch (SocketException ex) {
                System.out.println("Connexió finalitzada");
            }
            
        } catch (SocketException ex) {
            System.out.println("No s'ha trobat el servidor");
        }
    }

}
