package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	private Socket socket;
	
	public EchoRequestHandler(Socket socket){
		this.socket=socket;
	}

	@Override
	public void run() {
		try {
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			EchoServer.log("connected by client [" + remoteHostAddress + ":" + remotePort + "]");


			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // true 안하면 안감
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			//보조스트림에게 byte <-> String 작업 맡김 
			
			while (true) {

				String data = br.readLine();
				if (data == null) {
					// closed by client
					EchoServer.log("closed by client");
					break;
				}

				EchoServer.log("receive: " + data);

				pw.println(data);

			}

		} catch (SocketException e) {
			EchoServer.log("Socket Exception: " + e);
		} catch (IOException e) {
			EchoServer.log("error: " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	

}
