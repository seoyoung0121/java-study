package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import chat.ChatServer;

public class ChatWindow {
	private static final String SERVER_IP = "127.0.0.1";
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private PrintWriter pw;
	private Socket socket;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// 소켓 생성
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			pw.println("join:" + encode(frame.getTitle()));
			String data = br.readLine();
			String[] tokens = data.split(":");
			if (!"ok".equals(tokens[1])) {
				log("대화명이 잘못되어 종료합니다.");
				finish(false);
			} else {
				new ChatClientThread(br).start();
			}
			// 1. 서버 연결 작업
			// 2. IO Stream Set
			// 3. join 프로토콜
			// 4. ChatClientThread 생성

		} catch (IOException e) {
			log("error: " + e);
		}

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});
		// buttonSend.addActionListener((ActionEvent actionEvent) -> {}); 함수를 파라미터로 돌리는게
		// 아닌 객체 생성해주는 것

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish(false);
			}
		});
		frame.setVisible(true);
		frame.pack();

	}

	private void sendMessage() {
		String message = textField.getText();

		if (!"".equals(message)) {
			pw.println("message:" + encode(message));
		}

		textField.setText("");
		textField.requestFocus();

	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish(boolean socketClosed) {
		// 서버가 죽으면 그냥 종료
		if (!socketClosed) {
			pw.println("quit");
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				log("error:" + e);
			}
		}
		System.exit(0);
	}

	private class ChatClientThread extends Thread {
		private BufferedReader br;

		public ChatClientThread(BufferedReader br) {
			this.br = br;
		}

		// 이너클래스로 만들면 updateTextArea 인자 전달 없이 쓸 수 있음
		@Override
		public void run() {
			try {
				while (true) {
					String data = br.readLine();
					if (data == null) {
						log("closed by server");
						finish(true);
						return;
					}
					updateTextArea(data);
				}
			} catch (IOException e) {
				log("error: " + e);
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
