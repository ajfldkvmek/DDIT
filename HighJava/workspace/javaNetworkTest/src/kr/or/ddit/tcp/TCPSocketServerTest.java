package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServerTest {
	/*
	       소캣이란?
	 	두 호스트간 통신을 하기 위한 양 끝단
	 	TCP소켓통신을 위한 serversocket객체 생성하기
	 */
	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(7777);

		System.out.println("접속대기중");
		
		//accept()는 클라이언트에서 연결요청이 올 때 까지 계속 기다린다
		//연결 요청이 오면 socket객체를 생성하여 client의 socket과 연결한다
		Socket socket = server.accept();

		System.out.println("접속한 클라이언트 정보");
		System.out.println("주소: " + socket.getInetAddress());
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("어서어쇼");
		
		System.out.println("메세지 보냄");
		dos.close();
		server.close();
		
	}
}
