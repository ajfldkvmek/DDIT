package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04ListSortTest {

	public static void main(String[] args) {
		
		List<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(2, "김길동", "010-2222-1111"));
		memList.add(new Member(3, "박길동", "010-3333-1111"));
		
		for(Member m : memList)
			System.out.println(m);
		
		Collections.sort(memList);
		for(Member m : memList)
			System.out.println(m);
		
		Collections.sort(memList, new SortNumDesc());
		for(Member m : memList)
			System.out.println(m);
	}
}

//Member객체의 번호를 기준으로 내림차순으로 정렬하기
class SortNumDesc implements Comparator<Member> {
	@Override
	public int compare(Member mem1, Member mem2) {
		
		if(mem1.getNum() > mem2.getNum()) {
			return -1;
		} 
		else if(mem1.getNum() == mem2.getNum()) {
			return 0;
		} else {
			return 1;
		}
	}
}



//회원정보를 담기위한 클래스 정의
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	@Override
	//회원 이름 기준으로 오름차순 정렬
	public int compareTo(Member mem) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(mem.getName());
	}
	
}

