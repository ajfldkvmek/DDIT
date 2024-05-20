package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {

	private DatagramSocket ds;
	private DatagramPacket dp;
	private byte[] msg;
	public UdpServer(int port) {
		try {
			//메세지 송수신을 위한 포트번호 설정
			ds = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void start() throws IOException {
		
		while(true) {
			msg = new byte[1];
			dp = new DatagramPacket(msg, msg.length);
			
			System.out.println("패킷 수신 대기중");
			
			ds.receive(dp);
			
			System.out.println("패킷수신완료");
			
			//수신한 패킷으로 부터 클라이언트의 ip, 포트번호 알아낸다
			InetAddress addr = dp.getAddress();
			int port = dp.getPort();
			
			//현재시간 시분초 형태로 변환
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			msg = time.getBytes();//시간문자열을 바이트배열로 변환
			
			//패킷을 생성해서 클라이언트에게 전송한다.
			dp = new DatagramPacket(msg, msg.length, addr, port);
			ds.send(dp); //전송시작
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		new UdpServer(8888).start();
	}
}
