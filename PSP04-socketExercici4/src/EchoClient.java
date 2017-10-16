import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class EchoClient {

    public static void main(String[] args) throws Exception {

        String entrada = "";
        int c;

        Socket socket = new Socket("localhost", 7000);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("Entra les frases que vulguis enviar");

        while (!".".equals(entrada)) {
            Scanner scan = new Scanner(System.in);
            entrada = scan.nextLine();
            dos.writeUTF(entrada);
        }
    }

}
