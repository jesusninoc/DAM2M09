import java.io.DataInputStream;
import java.net.*;
public class ServerMsg {
	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(7000);
		System.out.println("Server is started");		
		while(true) {
                        System.out.println("Server waiting client connection...");		
                        
			Socket socket = server.accept();
                        System.out.println("Usuari connectat des de la IP:" + socket.getRemoteSocketAddress());

                        String s="";		
			while(!".".equals(s)) {
			DataInputStream din = new DataInputStream(socket.getInputStream());
			s = din.readUTF();			
				
				if (!".".equals(s))
				{
					System.out.println("Missatge:" + s);	
				}
			
			
			}
                        
			System.out.println("Missatge final:" + s);				
					
			socket.close();			
		}	
	}
}
