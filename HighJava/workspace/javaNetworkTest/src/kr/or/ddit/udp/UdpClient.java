package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {

	private DatagramSocket ds;
	private DatagramPacket dp;
	private byte[] msg;
	
	public UdpClient() {
		try {
			msg = new byte[100];
			
			//소캣생성시 포트번호를 명시하지 않으면 이용가능한 임의의 포트번호로 할당됨
			ds = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void start() throws IOException {
		InetAddress serverAddr = InetAddress.getByName("192.168.143.3");
		
		//보낼때는 상대방 ip, port필요
		dp = new DatagramPacket(msg, 1, serverAddr, 8888);
		ds.send(dp);
		
		//받는건 불필요
		dp = new DatagramPacket(msg, msg.length);		
		ds.receive(dp);
		
		System.out.println("현재 서버 시간: " + new String(dp.getData()));
	}
	
	public static void main(String[] args) throws Exception {
		
		new UdpClient().start();
	}
}
