import java.io.IOException;
import java.net.*;

public class main {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(90);
		while(true){
			Socket s= server.accept();
			System.out.println("Client connectat");
                        
			s.close();
		}		
	}
}

