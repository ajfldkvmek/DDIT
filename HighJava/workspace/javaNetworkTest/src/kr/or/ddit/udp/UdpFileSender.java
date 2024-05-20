package kr.or.ddit.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpFileSender {

	private DatagramSocket ds;
	private DatagramPacket dp;

	private InetAddress receiverAddr;
	private int receiverPort;
	
	private File file;
	
	public UdpFileSender(String reveiverIP, int port) throws SocketException, UnknownHostException {
		
		ds = new DatagramSocket();
		this.receiverPort = port;
		receiverAddr = InetAddress.getByName(reveiverIP);
		
		file = new File("d:/D_Other/Tulips.jpg");
		
		if(!file.exists()) {
			System.out.println("파일없덩");
			System.exit(0);
		}
	}
	
	public void start() throws Exception {
		long fileSize = file.length();
		long totalReadBytes = 0;
		
		long startTime = System.currentTimeMillis();
		
		sendData("start".getBytes()); //전송 시작을 알려주기 위한 문자열 전송
		sendData(file.getName().getBytes()); //전솔할 파일명 전송
		sendData(String.valueOf(fileSize).getBytes()); //총 파일크기 전송
		
		////////////////////////////////////////////////////////////////
		
		FileInputStream fis = new FileInputStream(file);
		
		byte[] buffer = new byte[1000];
		while(true) {
			
			Thread.sleep(10); //패킷전송에 간격줌
			
			int readBytes = fis.read(buffer, 0, buffer.length);
			
			if(readBytes == -1) { //더 이상 읽을 데이터가 없음
				break;
			}
			
			sendData(buffer, readBytes); //읽은 바이트배열 전송
		
			totalReadBytes += readBytes;
			
			System.out.println("진행상태: " + totalReadBytes + " / "
							+ fileSize + "Byte(s) ("
							+ (totalReadBytes * 100 / fileSize) + "%)");
		}
		
		long endTime = System.currentTimeMillis();
		long diffTime = endTime = startTime;
		double transferSpeed =  fileSize / diffTime;
		
		System.out.println("전송시간: " + diffTime + " (ms)");
		System.out.println("평균 전송속도: " + transferSpeed + " bytes/ms");
		
		System.out.println("전송 완료");
		
		fis.close();
		ds.close();
		
	}
	
	/**
	 * 바이트배열 데이터 전송하기
	 * @param bytes  - 전송할 바이트 배열
	 * @throws IOException 
	 */
	private void sendData(byte[] bytes) throws IOException {
		sendData(bytes, bytes.length);
	}

	/**
	 * 바이트배열 데이터 전송하기
	 * @param bytes  - 전송할 바이트 배열
	 * @param length
	 * @throws IOException 
	 */
	private void sendData(byte[] bytes, int length) throws IOException {
		dp = new DatagramPacket(bytes, length, receiverAddr, receiverPort);
		ds.send(dp);
	}

	public static void main(String[] args) throws Exception {
		new UdpFileSender("192.168.143.19", 8888).start();
	}
}
