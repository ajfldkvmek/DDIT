package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//객체 입출력 스트림
//직렬화--> (객체를) 저장할 때
public class T15_ObjectStreamTest {

	public static void main(String[] args) {
		Member mem1 = new Member("홍길동1", 22, "대전");
		Member mem2 = new Member("홍길동2", 22, "대전");
		Member mem3 = new Member("홍길동3", 22, "대전");
		Member mem4 = new Member("홍길동4", 22, "대전");
		Member mem5 = new Member("홍길동5", 22, "대전");

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("D:/D_Other/memObj.bin"));

			// 객체저장
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			oos.writeObject(mem5);
//			>>직렬화

			System.out.println("객체 저장작업 완료");
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

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("D:/D_Other/memObj.bin"));
			Object obj = null;

			while ((obj = ois.readObject()) != null) { //역직렬화 --> (객체를) 불러올 때
				//읽어온 데이터를 원래의 객체타입으로 캐스팅 후 사용
				Member mem = (Member) obj;
				System.out.println("이름: " +mem.getName());
				System.out.println("나이: " +mem.getAge());
				System.out.println("주소: " + mem.getAddr());
				System.out.println("-----------------------");
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
}

//회원정보를 담기위한 VO클래스
@SuppressWarnings("serial")
class Member implements Serializable {

//	transient-> 일시적인<< 유지되지않음(직렬화하는 데이터에서 제외)
	
	private String name;
	private int age;
	private String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
