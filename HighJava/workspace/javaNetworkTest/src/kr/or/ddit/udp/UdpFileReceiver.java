package kr.or.ddit.udp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpFileReceiver {

	private DatagramPacket dp;
	private DatagramSocket ds;
	private byte[] buffer;
	
	public UdpFileReceiver(int port) {
		try {
			ds = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void start() throws IOException {
		long fileSize = 0;
		long totalReadBytes = 0;
		
		int readBytes = 0;
		
		System.out.println("파일 수신 대기중...");
		
		String str = new String(receiveData()).trim();
		
		if(str.equals("start")) {
			//파일명 받기
			str = new String(receiveData()).trim();
			FileOutputStream fos = new FileOutputStream("D:/D_Other/" + str);
			
			//파일크기 받기
			str = new String(receiveData()).trim();
			fileSize = Long.parseLong(str);
			
			long startTime = System.currentTimeMillis();
			
			while(true) {
				
				byte[] data = receiveData();
				readBytes = dp.getLength();
				
				fos.write(data, 0, readBytes);
				
				totalReadBytes += readBytes;
				
//				System.out.println("진행상태: " + totalReadBytes + " / "
//								+ fileSize + "Byte(s) ("
//								+ (totalReadBytes * 100 / fileSize) + "% )");
				System.out.println("진행상태: " + totalReadBytes + " / " + fileSize + " Byte(s) ("
						+ (totalReadBytes *100 /fileSize) + " %)");
				if(totalReadBytes >= fileSize) break;
			}
			
			long endTime = System.currentTimeMillis();
			long diffTime = endTime - startTime;
			double transferSpeed =  fileSize / diffTime;
			
			System.out.println("수신 시간: " + diffTime + " (ms)");
			System.out.println("평균 수신속도: " + transferSpeed + " bytes/ms");
			
			System.out.println("전송 완료");
			fos.close();
			ds.close();
			
		} else {
			System.out.println("ㅁㅇ마ㅣㄴㅇㅁ임ㅁㄹ");
			ds.close();
		}
	}

	/**
	 * 데이터 수신
	 * @return byte[] (수신된 바이트 배열)
	 * @throws IOException 
	 */
	private byte[] receiveData() throws IOException {
		
		buffer = new byte[1000];
		
		dp = new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);
		
		return dp.getData();
	}
	
	public static void main(String[] args) throws IOException {
		new UdpFileReceiver(8888).start();
	}
}
