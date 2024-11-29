package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChatServerThread extends Thread {

	private String nickName;
	private Socket socket;
	private List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		// 1. Remote Host Information

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);

			
			while (true) {
				String request = br.readLine();
				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}

				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}

			}

		} catch (IOException e) {
			ChatServer.log("error: " + e);
		}

	}

	private void doJoin(String nickName, Writer writer) {
		PrintWriter pw = (PrintWriter)writer;
		if (" ".equals(nickName)) {
			pw.println("join:error");
			pw.flush();
			return;
		}
		this.nickName = nickName;
		broadcast(nickName + "님이 입장 하였습니다.");
		addWriter(writer);
		// ack
		pw.println("join:ok");
		pw.flush();

	}

	private void doMessage(String string) {
		broadcast(nickName + ":" +string);
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		broadcast(nickName + "님이 퇴장 하였습니다.");
	}
	
	private void addWriter(Writer writer) {
	   synchronized(listWriters) {
	      listWriters.add(writer);
	   }
	}
	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
	    }
	}
	
	private void broadcast(String data) {
	   synchronized(listWriters) {
		   for( Writer writer : listWriters ) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println( data );
				printWriter.flush();
		   }

	   }
	}

}
