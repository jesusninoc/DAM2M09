import java.io.IOException;
import java.net.*;

public class main {
	public static void main(String[] args) throws IOException {
        //error 1 (compilació): el constructor ha de ser de la classe ServerSocket
        //       ServerSocket server = new Socket(90);
		ServerSocket server = new ServerSocket(90);
		while(true){
            //error 2 (compilació): el metode accept de ServerSocket retorna un Socket
            //      server.accept();
			Socket s= server.accept();
			System.out.println("Client connectat");
            //error 3 (execució)- si tanquem aquí el ServerSocket, 
            // acceptem només la primera connexió. 
            // Ja que quan entrem al while per segona vegada
            // la crida a server.accept provoca una excepció
            // perque el ServerSocket ja esta tancat
            //Ho hem de canviar per tancar el Socket de la connexió amb el client
            // server.close();
			s.close();
		}		
	}
}

