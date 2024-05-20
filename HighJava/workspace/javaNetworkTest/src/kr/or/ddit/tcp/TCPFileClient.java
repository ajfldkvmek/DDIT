package kr.or.ddit.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//클라이언트는 서버에 접속하여 원하는 파일명을 전송하여 다운받는다
public class TCPFileClient {

	private Socket socket;
	private FileOutputStream fis;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Scanner scan;

	public TCPFileClient() {
		scan = new Scanner(System.in);
	}

	public void ClientStart() {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			
			socket = new Socket("192.168.143.3", 7777);
			System.out.println("파일 서버에 연결됨");
			
			//소켓접속이 성공하면 받고싶은 파일명을 전송한다.
			System.out.print("파일명>> ");
			String fileName = scan.next();
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(fileName);
			
			dis = new DataInputStream(socket.getInputStream());
			String resultMsg = dis.readUTF();
			
//			String downDir = "D:/D_Ohter/download/";
			
			if(resultMsg.equalsIgnoreCase("OK")) {
				
				File downDir = new File("D:/D_Other/download");
				if(!downDir.exists()) {
					downDir.mkdir(); //없으면 폴더생성
				}
				
				File file = new File(downDir +"/" + fileName);
				
				bos = new BufferedOutputStream(new FileOutputStream(file));
				bis = new BufferedInputStream(socket.getInputStream());
				
				int data = 0;
				while( ( data = bis.read() ) != -1) {
					bos.write(data);
				}
				System.out.println("다운 완료");
			} else {
				System.out.println(resultMsg);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new TCPFileClient().ClientStart();
	}
}
