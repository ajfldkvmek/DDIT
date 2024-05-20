package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultichatClient {

	// 시작메서드
	public void clientStart() {
		Socket socket = null;

		try {
			socket = new Socket("192.168.143.3", 7777);
			System.out.println("채팅 서버에 연결됨");
			
//			송/수신용 쓰레드 생성 및 실행
			ClientSender sender = new ClientSender(socket);
			sender.start();
			ClientReceiver receiver = new ClientReceiver(socket);
			receiver.start();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	class ClientSender extends Thread {
		
		private DataOutputStream dos;
		private Scanner scan;
		
		public ClientSender(Socket socket) {
			
			scan = new Scanner(System.in);
			
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		@Override
		public void run() {
			
			if(dos != null) {
				//시작하면 서버로 대화명 전송하기
				System.out.println("대화명>> ");
				try {
					dos.writeUTF(scan.nextLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			while(dos!= null) {
				try {
					dos.writeUTF(scan.nextLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class ClientReceiver extends Thread {
		
		private DataInputStream dis;
		
		public ClientReceiver(Socket socket) {
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			while(dis != null) {
				try {
					//서버로부터 수신한 메세제 콘솔창에 출력
					System.out.println(dis.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new MultichatClient().clientStart();
	}
}
