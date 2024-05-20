package hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
문제) 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고, 이 Phone클래스를 이용하여 
	  전화번호 정보를 관리하는 프로그램을 완성하시오.
	  이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
	  
	  전체의 전화번호 정보는 Map을 이용하여 관리한다.
	  (key는 '이름'으로 하고 value는 'Phone클래스의 인스턴스'로 한다.)


실행예시)
===============================================
   전화번호 관리 프로그램(파일로 저장되지 않음)
===============================================

  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 1  <-- 직접 입력
  
  새롭게 등록할 전화번호 정보를 입력하세요.
  이름 >> 홍길동  <-- 직접 입력
  전화번호 >> 010-1234-5678  <-- 직접 입력
  주소 >> 대전시 중구 대흥동 111  <-- 직접 입력
  
  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 5  <-- 직접 입력
  
  =======================================
  번호   이름       전화번호         주소
  =======================================
   1    홍길동   010-1234-5678    대전시
   ~~~~~
   
  =======================================
  출력완료...
  
  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 0  <-- 직접 입력
  
  프로그램을 종료합니다...
  
*/
public class PhoneBookTest {
	private Scanner scan;
	private static Map<String, Phone> phoneBookMap = new HashMap<String, Phone>();

	public static void main(String[] args) {
		PhoneBookTest t = new PhoneBookTest();

		t.phoneBookStart();
	}

	public PhoneBookTest() {
		scan = new Scanner(System.in);
	}

	// 메뉴를 출력하는 메서드
	public void displayMenu() {
		System.out.println();
		System.out.println("메뉴를 선택하세요.");
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 0. 프로그램 종료");
		System.out.print(" 번호입력 >> ");
	}

	// 프로그램을 시작하는 메서드
	public void phoneBookStart() {
		System.out.println("===============================================");
		System.out.println("   전화번호 관리 프로그램(파일로 저장되지 않음)");
		System.out.println("===============================================");
		opening();
		while (true) {

			displayMenu(); // 메뉴 출력

			int menuNum = scan.nextInt(); // 메뉴 번호 입력

			switch (menuNum) {
			case 1:
				insert(); // 등록
				break;
			case 2:
				update(); // 수정
				break;
			case 3:
				delete(); // 삭제
				break;
			case 4:
				search(); // 검색
				break;
			case 5:
				displayAll(); // 전체 출력
				break;
			case 0:
				closing();
				System.out.println("프로그램을 종료합니다...");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}
	
	

	public void closing() {
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("D:/D_Other/phone.bin"));
			// 객체저장
//			oos.writeObject(mem1); 형태
			Iterator<String> it = phoneBookMap.keySet().iterator();
			while(it.hasNext()) {
				String str = it.next();
				Phone p = phoneBookMap.get(str);
				oos.writeObject(p);
			}
			System.out.println("저장 완료");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void opening() {
		//phone파일 없으면 생성하고 시작
		File f = new File("D:/D_Other/phone.bin");
		if (f.exists()) {
			System.out.println("이전 정보를 불러옵니다");
		} else {
			try {
				if (f.createNewFile()) {
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("D:/D_Other/phone.bin"));
			Object obj = null;

			while ((obj = ois.readObject()) != null) { //역직렬화 --> (객체를) 불러올 때
				//읽어온 데이터를 원래의 객체타입으로 캐스팅 후 사용
				Phone phone = (Phone) obj;
//				System.out.println("이름: " +phone.getName());
//				System.out.println("주소: " + phone.getAddress());
//				System.out.println("번호: " +phone.getNumber());
//				System.out.println("-----------------------");
				
				phoneBookMap.put(phone.getName(),phone);
			}

			System.out.println("읽기작업 끝");
		} catch (IOException e) {
//			e.printStackTrace();
			//더이상 읽어올 객체 없으면 예외발생
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// close는 스트림을 닫는 것, flush는 버퍼를 비우는 기능
				ois.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	
	private void displayAll() {
		System.out.println("====================================");
		System.out.println("번호\t이름\t전화번호\t주소");
		
		Set<String> keySet = phoneBookMap.keySet();
		Iterator<String> it = keySet.iterator();
		int count = 1;
		while(it.hasNext()) {
//			System.out.println(it.next());
			String key = it.next();
			Phone p = phoneBookMap.get(key);
			
			System.out.println(count+"\t"+p.getName()+"\t"
						+p.getNumber()+"\t"+p.getAddress());
			count++;
		}
		System.out.println("====================================");
	}

	private void search() {
		System.out.print("찾을 사람 이름은?>> ");
		String name = scan.next();
		Phone p = phoneBookMap.get(name);
		
		if(p != null) {
			System.out.println(p);
		} else {
			System.out.println("그럼사람없");
		}
	}

	private void delete() {
		System.out.print("삭제할 사람의 이름 입력>> ");
		String name = scan.next();
//		if (phoneBookMap.get(name) == null) {
//			System.out.println("이런 사람 없엉요");
//			return;
//		}
		if(phoneBookMap.remove(name) == null) {
			System.out.println("없는 사람임");
		} else {
			System.out.println("삭제 완료");
		}
	}

	private void update() {
		System.out.print("수정할 사람의 이름 입력>> ");
		String name = scan.next();
		if (phoneBookMap.get(name) == null) {
			System.out.println("이런 사람 없엉요");
			return;
		}

		System.out.print("전화번호>> ");
		String phone = scan.next();
		scan.nextLine();// 버퍼에 남은 엔터 지우기위해
		System.out.print("주소>> ");
		String addr = scan.nextLine();

		phoneBookMap.put(name, new Phone(name, addr, phone));

		System.out.println("수정완료");
	}

	private void insert() {
		System.out.println();
		System.out.println("새로 등록할 정보를 입력하세요");
		System.out.print("이름>> ");
		String name = scan.next();
		// 등록된 사람인지 체크
		if (phoneBookMap.get("name") != null) {
			System.out.println(name + "는 이미 등록된 사람");
			return; // 메서드종료
		}
		System.out.print("전화번호>> ");
		String phone = scan.next();
		scan.nextLine();// 버퍼에 남은 엔터 지우기위해
		System.out.print("주소>> ");
		String addr = scan.nextLine();

//		Phone p = new Phone(name, addr, phone);
//		phoneBookMap.put(name, p); >>
		phoneBookMap.put(name, new Phone(name, addr, phone));
//		System.out.println(phoneBookMap);
		System.out.println("등록완료");
	}
}

@SuppressWarnings("serial")
//VO Class
class Phone implements Serializable {
//	이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고이 Phone클래스를 이용하여 
//	  전화번호 정보를 관리하는 프로그램을 완성하시오.
//	  이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.

	private String name;
	private String address;
	private String number;

	public Phone(String name, String address, String number) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone [이름=" + name + ", 주소=" + address + ", 전화번호=" + number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

}
