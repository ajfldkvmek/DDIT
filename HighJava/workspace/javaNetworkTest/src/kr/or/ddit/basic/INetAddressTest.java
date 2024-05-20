package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class INetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		
		//InetAddress클래스=> ip주소정보를 다루기 위한 클래스
		
		// getByName()은 www.naver.com 또는 PC05와 같은 머신 이름이나 ip주소를
		// 파라메터로 제공하여 유효한 InetAddress객체를 생성한다
		
		
		// 네이버사이트의 ip정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		
		System.out.println("HostName: " + naverIp.getHostName());
		System.out.println("HostAddress: " + naverIp.getHostAddress());
		System.out.println();
		
		//자기 자신 컴퓨터의 ip정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Name" + localIp.getHostName());
		System.out.println("내 컴퓨터의 Address" + localIp.getHostAddress());
		System.out.println();
		
		
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for (InetAddress inetAddressp : naverIps) {
			System.out.println(inetAddressp.toString());
		}
	}
}
