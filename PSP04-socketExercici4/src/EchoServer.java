
import java.io.DataInputStream;
import java.net.*;

public class EchoServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(7000);
        System.out.println("Server is started");
        while (true) {

            Socket socket = server.accept();
            String s = "";

            while (!".".equals(s)) {
                DataInputStream din = new DataInputStream(socket.getInputStream());
                s = din.readUTF();

                if (!".".equals(s)) {
                    System.out.println("Missatge:" + s);
                }

            }
            
            System.out.println("Ultim missatge rebut. Tanquem connexio");
            socket.close();
        }
    }
}
