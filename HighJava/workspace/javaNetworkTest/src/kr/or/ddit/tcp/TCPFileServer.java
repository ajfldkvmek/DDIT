package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//서버는에 접속한 클라이언트가 요청한 파일을 전송해보자
public class TCPFileServer {

	public void serverStart() {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버 준비완료");
			
			while(true) {
				Socket socket = server.accept();
				
				FileSender sender = new FileSender(socket);
				sender.start();
			}
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	class FileSender extends Thread {
		
		private Socket socket;
		private FileInputStream fis;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		
		public FileSender(Socket socket) {
			this.socket = socket;
			
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		@Override
		public void run() {
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			
			try {
				String downDir = "D:/D_Other/";
				System.out.println("요청파일 체크중");
				
				File file = new File(downDir + dis.readUTF());
				
				if(!file.exists()) {
					System.out.println("요청파일(" + file.getName() + ")이 존재하지 않음");
					dos.writeUTF("요청파일(" + file.getName() + ")이 존재하지 않음"); 			
				} else {
					dos.writeUTF("OK"); //요청파일 확인완료
					System.out.println("요청파일(" + file.getName()+") 전송 시작");
					
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					bos = new BufferedOutputStream(socket.getOutputStream());
					
					int data = 0;
					while( (data = bis.read()) != -1 ) 	{
						bos.write(data);
					}
					
					System.out.println("요청파일(" + file.getName()+") 전송 완료");
					}
			} catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					bis.close();
					bos.close();
					dis.close();
					dos.close();
					socket.close();
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new TCPFileServer().serverStart();
	}
}
