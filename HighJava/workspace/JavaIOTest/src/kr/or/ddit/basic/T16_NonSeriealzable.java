package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 *  자식은 serial이지만 부모는 아닐 경우 정상적으로 저장되지않음
 *  
 *  1. 부모도 implement serialzable 해주기
 *  2. 자식클래스에 write/readObject 선언
 */
public class T16_NonSeriealzable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(
								new FileOutputStream("D:/D_Other/notSerial.bin"));
	
		Child child = new Child();
		child.setParetName("부모명");
		child.setChildName("자식명");
		
		oos.writeObject(child); 
		oos.close();
		
		ObjectInputStream ois = 
				new ObjectInputStream(
						new FileInputStream("D:/D_Other/notSerial.bin"));
		
		child = (Child) ois.readObject();
		System.out.println("부모이름>> " + child.getParetName());
		System.out.println("자식이름>> " + child.getChildName());
		
		ois.close();
		
	}
}

//class Parent implements Serializable{
class Parent {
	private String paretName;

	public String getParetName() {
		return paretName;
	}

	public void setParetName(String paretName) {
		this.paretName = paretName;
	}
}

@SuppressWarnings("serial")
class Child extends Parent implements Serializable {
	
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	
	/*	
	 * 	write/read 둘 모두 해당
	 *  직렬화 될 때 자동으로 호출됨
	 *  접근제한자가 private가 아니면 호출되지 않음
	 */
	private void writeObject(ObjectOutputStream out) throws IOException {
//		System.out.println("writeObject호출");
		out.writeUTF(getParetName());
		out.defaultWriteObject(); //기본기능호출
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//		System.out.println("readObject호출");
		setParetName(in.readUTF());
		in.defaultReadObject(); //기본기능호출
	}
	
}