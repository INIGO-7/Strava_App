package server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class FacebookGateway implements ILoginGateway{
	
	private static FacebookGateway facebookGateway;
	
	//args[0] = Server IP
	String serverIP = "127.0.0.1";
	//args[1] = Server socket port
	int serverPort = 8001;
	
	private FacebookGateway() {
		
		
	}
	
	public static FacebookGateway getInstance() {
		if(facebookGateway==null) {
			facebookGateway = new FacebookGateway();
		}
		return facebookGateway;
	}
	
	@Override
	public String register(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(String email, String password) {

		/**
		 * NOTE: try-with resources Statement - https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		 * Try statement that declares one or more resources. A resource is an object that must be closed after the program is 
		 * finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement.
		 * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, 
		 * can be used as a resource.
		 */

		String message = email + "#" + password;
		
			//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
			 //Streams to send and receive information are created from the Socket
		     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
			 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			
			//Send request (a String) to the server
			out.writeUTF(message);
			System.out.println(" - FacebookTCPSocketClient: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + message + "'");
			
			//Read response (a String) from the server
			String data = in.readUTF();			
			System.out.println(" - FacebookTCPSocketClient: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
		} catch (UnknownHostException e) {
			System.err.println("# FacebookTCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# FacebookTCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# FacebookTCPSocketClient: IO error: " + e.getMessage());
		}
		
		return null;
	}

}
