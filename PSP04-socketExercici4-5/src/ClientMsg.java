import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class ClientMsg {

    public static void main(String[] args) throws Exception {
        String entrada = "";

        // connectem al Servidor en la pròpia màquina i al port 7000
        Socket socket = new Socket("localhost", 7000);

        //utilitzem un DataOutputStream per escriure en el Socket
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        System.out.println("Entra les frases que vulguis enviar. Per acabar escriu un punt.");

        //utilitzem Scanner per llegir de l'entrada estàndard
        Scanner scan = new Scanner(System.in);

        while (!".".equals(entrada)) {
            entrada = scan.nextLine();
            dos.writeUTF(entrada);
        }
    }

}
