
import java.io.IOException;
import java.net.Socket;


public class main {
	public static void main(String[] args) {
            try {
                Socket s = new Socket("127.0.0.1", 90);
                s.close();
            } catch (IOException ex) {
//                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}
