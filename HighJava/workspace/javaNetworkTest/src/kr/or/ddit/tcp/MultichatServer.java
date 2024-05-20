package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultichatServer {

	// 대화명, 클라이언트 소캣을 저장하기위한 MAP변수 추가
	private Map<String, Socket> client;

	public MultichatServer() {
		// 동기화처리 가능하도록

		client = Collections.synchronizedMap(new HashMap<String, Socket>());
	}

	public void serverStart() {

		ServerSocket server = null;
		Socket socket = null;

		try {
			server = new ServerSocket(7777);

			System.out.println("서버 on");

			while (true) {
				socket = server.accept();

				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + " 에서 접속함");
				// 메세지 전송 처리를 위한 스레드 생성 및 실행
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 대화방 즉, Map에 저장된 전체 유저에게 안내메세지를 전송하기 위한 메서드
	 * 
	 * @param msg 안내 메세지
	 */
	public void sendMessage(String msg) {
		//Map에 저장된 모든 소켓을 꺼내 메세지보내기
		Iterator<String> it = client.keySet().iterator();
		while(it.hasNext()) {
			String name = it.next(); //대화명 꺼내기
			Socket socket = client.get(name);
			
			try {
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * 대화방 즉, Map에 저장된 전체 유저에세 안내메세지를 전송하기 위한 메서드
	 * 
	 * @param msg
	 * @param from
	 */
	public void sendMessage(String msg, String from) {
		sendMessage("[" + from + "]: " + msg);
	}

	// inner class의 장점?
	// outer클래스 멤버들을 직접 접근할 수 있음
	// 외부에 노출이 안됨
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream dis;
		private String name;

		public ServerReceiver(Socket socket) {
			this.socket = socket;

			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void run() {

			try {
//				서버에서는 클라이언트가 보내는 최초의 메세지 즉, 대화명을 수신해야한다
				name = dis.readUTF();
//				대화명을 받아서 다른 모든 클라이언트에게 대화방 참여 메세지 전송
				sendMessage("#" + name + "님이 입장했습니다");

//				대화명과 소캣정보를 맵에 저장
				client.put(name, socket);
				System.out.println("헌재 접속자 수는 " + client.size() + "명 입니다.");

//				이 후의 메세지처리는 반복문으로

//				클라이언트가 보낸 메세지를 다른 모든 클라이언트에게 전송한다 
				
				while (dis != null) {
					sendMessage(dis.readUTF(), name);
				}
				
			} catch (IOException ex) {
			} finally {
//				여기가 실행된다는 것은 클라이언트의 접속 종료를 말함
				sendMessage(name + "님이 나감");
				client.remove(name);

				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + " 에서 접속종료");
				System.out.println("헌재 접속자 수는 " + client.size() + "명 입니다.");

			}
//			map에서 해당 클라삭제
		}
	}
	public static void main(String[] args) {
		new MultichatServer().serverStart();
	}
}
