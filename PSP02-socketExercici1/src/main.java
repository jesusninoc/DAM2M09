//error 1: faltava fer l'import de java.net.Socket
import java.io.IOException;
import java.net.Socket;


public class main {
	public static void main(String[] args) {
        //error 2: faltava tractar l'excepció capturant-la o fent un throw
            try {
                Socket s = new Socket("127.0.0.1", 90);
                s.close();
            } catch (IOException ex) {
                System.out.println("error d'E/S: " + ex.getLocalizedMessage());
            }
	}
}
