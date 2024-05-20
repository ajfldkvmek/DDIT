package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSocketClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "127.0.0.1";
		//자신의 컴퓨터 나타내는 방법
		//ip: 127.0.0.1
		//name: localhost
		
		System.out.println(serverIp + " 서버에 접속시도 중");
		
		//소캣을 생성해서 서버에 연결으 요청한다
		Socket socket = new Socket(serverIp, 7777);
		
		//연결이 되면 이후 명령이 실행
		System.out.println("서버와 연결되었습니다.");
		
		//서버에서 보내온 메세지 받기
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		//서버로부터 받은 메세지 출력
		System.out.println("서버로부터 받은 메세지: " + dis.readUTF());
		
		System.out.println("연결 종료");
		
		dis.close();
		socket.close();
	}
}
