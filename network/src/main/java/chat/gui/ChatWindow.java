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
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// 소켓 생성
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
				if(keyChar==KeyEvent.VK_ENTER) {
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

		// 1. 서버 연결 작업
		// 2. IO Stream Set
		// 3. join 프로토콜
		// 4. ChatClientThread 생성

	}

	private void sendMessage() {
		String message = textField.getText();
		System.out.println("message: " + message);
		textField.setText("");
		textField.requestFocus();
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish(boolean socketClosed) {
		
		//서버가 죽으면 종료 
		if(socketClosed) {
			
		}
		//퇴장하였습니다 프로토콜,, quit ok 오면 종료 
		else {
			
		}
		System.exit(0);
	}
	
	private class ChatClientThread extends Thread{
		// 이너클래스로 만들면 updateTextArea 인자 전달 없이 쓸 수 있음
		@Override
		public void run() {
			updateTextArea("dd");
		}
	}
	
	
	
	
}
