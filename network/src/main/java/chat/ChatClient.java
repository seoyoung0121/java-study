package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + encode(nickname));
			pw.flush();

			String data = br.readLine();
			String[] tokens = data.split(":");

			while (!"ok".equals(tokens[1])) {
				System.out.println("닉네임을 다시 입력하세요.");
				System.out.print("닉네임>>");
				nickname = scanner.nextLine();
				pw.println("join:" + encode(nickname));
				pw.flush();
				data = br.readLine();
				tokens = data.split(":");
			}

			new ChatClientThread(br).start();

			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				if ("quit".equals(input) == true) {
					pw.println("quit");
					pw.flush();
					break;
				} else if (!"".equals(input)) {
					pw.println("message:" + encode(input));
					pw.flush();
				}
			}

		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static String encode(String str) {
		return Base64.getEncoder().encodeToString(str.getBytes());
	}

	public static void log(String message) {
		System.out.println("[Chat Client] " + message);
	}

}
