package test03_Hotel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
//import java.util.Set;

public class Hotel {

	static Scanner sc = new Scanner(System.in);
	static Map<String, String> room = new HashMap<String, String>();

	public static void main(String[] args) {
		int select = 0;
		System.out.println("**************************\r\n" + "호텔 문을 열었습니다.\r\n" + "**************************\r\n"
					+ "\r\n");
		Hotel h = new Hotel();
		while (select != 4) {
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
		}
		System.out.println("**************************\r\n" + 
				"호텔 문을 닫았습니다.\r\n" + 
				"**************************");
	}
	
	public void checkOut() {
		System.out.print("몇번방 체크아웃?>> ");
		String roomNo = sc.next();
		if(room.containsKey(roomNo)) {
			room.remove(roomNo);
		}
		else {
			System.out.println("빈 방임");
		}
	}

	public void checkRoom() {
		if(room.isEmpty()) {
			System.out.println("전부 공실임");
		} else {
			Iterator<String> keys = room.keySet().iterator();
			while(keys.hasNext()) {
				String key = keys.next();
				System.out.printf("방번호: %s, 사용자: %s\n", key, room.get(key));
			}
			
//			Set<Map.Entry<String,String>> entrySet = room.entrySet();
//			Iterator<Map.Entry<String, String>> it = entrySet.iterator();
//			while(it.hasNext()) {
//				Map.Entry<String, String> entry = it.next();
//				System.out.println("방번호: " + entry.getKey() + " 사용자: " + entry.getValue());
//			}
		}
	}
	
	public void checkIn() {
		System.out.print("어느방에 체크인 하시겠습니까?>> ");
		String roomno = sc.next();
		if(room.containsKey(roomno)) {
			System.out.print("이미 사용중인 방입니다. 다시 입력해주세요");
			System.out.println();
			checkIn();
		} else {
			System.out.print("누구를 체크인 하시겠습니까?>> ");
			String name = sc.next();
			room.put(roomno,name);
		}
	}
	
	
}
