package kr.or.ddit.tcp;

import java.io.IOException;
import java.net.Socket;

public class TcpChatClient {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("192.168.143.32", 7777);
			System.out.println("서버 연결됨");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
