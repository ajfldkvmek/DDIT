package hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hotel {

	static Scanner sc = new Scanner(System.in);
	static Map<String, String> room = new HashMap<String, String>();

	public static void main(String[] args) {
	
		Hotel h = new Hotel();
		int select = 0;
		
		System.out.println(
				"**************************\r\n" + "호텔 문을 열었습니다.\r\n" + "**************************\r\n" + "\r\n");
		// 파일에 저장된 맵 데이터 불러와서 room에 입력
		h.opening();
		while (true) {
			System.out.println("*******************************************\r\n" + "어떤 업무를 하시겠습니까?\r\n"
					+ "1.체크인  2.체크아웃 3.객실상태 4.업무종료\r\n" + "*******************************************");

			select = sc.nextInt();

			switch (select) {
			case 1: // 체크인 put
				h.checkIn();
				break;
			case 2: // 체크아웃 remove
				h.checkOut();
				break;
			case 3: // 객실상태(맵 전체 출력)
				h.checkRoom();
				break;
			case 4:
				break;
			default:
				System.out.println("잘못입력함");
				break;
			}
			if(select == 4) {
				h.closing();
				break;
			}
		}
		System.out.println("**************************\r\n" + "호텔 문을 닫았습니다.\r\n" + "**************************");
	}

	public void closing() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("D:/D_Other/room.txt");
			bw = new BufferedWriter(fw);
			if (room.isEmpty()) {
				System.out.println("전부 공실임");
			} else {
				Iterator<String> keys = room.keySet().iterator();
				while (keys.hasNext()) {
					String key = keys.next();
					String value = room.get(key);
					bw.write(key + " " + value+"\n");
				}
			}
			System.out.println("작업 끝");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void opening() {
		//room파일 없으면 생성하고 시작
		File f = new File("D:/D_Other/room.txt");
		if (f.exists()) {
			System.out.println("이전 사용 기록을 불러옵니다");
		} else {
			try {
				if (f.createNewFile()) {
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileReader fr = null;
		BufferedReader br = null;
		String str = "";
		StringTokenizer st;
		String key = "";
		String value = "";
		try {
			fr = new FileReader("D:/D_Other/room.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		try {
			while ((str = br.readLine()) != null) {
				st = new StringTokenizer(str);
				while (st.hasMoreTokens()) {
					key = st.nextToken();
					value = st.nextToken();
					room.put(key, value);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkOut() {
		System.out.print("몇번방 체크아웃?>> ");
		String roomNo = sc.next();
		if (room.containsKey(roomNo)) {
			room.remove(roomNo);
		} else {
			System.out.println("빈 방임");
		}
	}

	public void checkRoom() {
		if (room.isEmpty()) {
			System.out.println("전부 공실임");
		} else {
			Iterator<String> keys = room.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				System.out.printf("방번호: %s, 사용자: %s\n", key, room.get(key));
			}
		}
	}

	public void checkIn() {
		System.out.print("어느방에 체크인 하시겠습니까?>> ");
		String roomno = sc.next();
		if (room.containsKey(roomno)) {
			System.out.print("이미 사용중인 방입니다. 다시 입력해주세요");
			System.out.println();
			checkIn();
		} else {
			System.out.print("누구를 체크인 하시겠습니까?>> ");
			String name = sc.next();
			room.put(roomno, name);
		}
	}
}
