
import java.io.DataInputStream;
import java.net.*;

public class ServerMsg {

    public static void main(String[] args) throws Exception {
        String s = "";
                    // Instanciar un ServerSocket en el port 7000
        ServerSocket server = new ServerSocket(7000);
        System.out.println("Server is started");
        while (true) {
            System.out.println("Servidor esperant connexió dels clients....");
            Socket socket = server.accept();
            System.out.println("Usuari connectat des de la IP: " + socket.getRemoteSocketAddress());

            // obtenim el InputStream del Socket (per rebre info del client), i utilitzem el DataInputStream
            DataInputStream din = new DataInputStream(socket.getInputStream());
            while (!".".equals(s)) {
                //llegim amb metode readUTF
                s = din.readUTF();
                if (!".".equals(s)) {
                    System.out.println("Missatge:" + s);
                }
            }
            System.out.println("Usuari desconnectat (rebut un .)");
            socket.close();
        }
    }
}

