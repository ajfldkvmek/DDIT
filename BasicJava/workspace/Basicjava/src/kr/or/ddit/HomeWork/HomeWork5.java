package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		/*
		 * 멤버 클래스를 5명 배열을 선언 후
		 * 배열에 5명 저장 할것.
		 * 
		 */
		Member[] mArr = new Member[5];
		
		
		/*
		 * 멤버중 한명 선택후 
		 * 아이디와 비밀번호를 입력해서 맞을 경우 
		 * -> 로그인 성공
		 * 실패 할경우 
		 * -> 아이디 , 비밀번호 일치 하지 않음 출력 
		 * 
		 */
		//id pass name
		mArr[0] = new Member("id0", "12345", "강xx");
		mArr[1] = new Member("id1", "13579", "김xx");
		mArr[2] = new Member("id2", "24680", "민xx");
		mArr[3] = new Member("id3", "11111", "박xx");
		mArr[4] = new Member("id4", "12321", "서xx");
		
		// 멤버 이름 출력 
		for(int i=0; i<mArr.length;i++) {
			System.out.println(i+1 + ": " +mArr[i].name);
		}
		
		
		// 멤버 배열 선택
		System.out.println("1~5 까지 중 입력");
		int select = sc.nextInt();
		select--;
		while(true) {
			// 아이디 
			System.out.print("id: ");
			String id = sc.next();
			// 비밀번호 
			System.out.print("pass :");
			String pass = sc.next();
			// 비교문 통과 여부 확인.
			/*
			 * if("")
			 */
			
			boolean bid = id.equals(mArr[select].id);
			boolean pid = pass.equals(mArr[select].pass);
			
			if(bid && pid) {
				System.out.println("로그인 성공!");
				break;
			}
			
			else System.out.println("로그인 실패");
		}		
		sc.close();
		System.out.println(mArr[select]);
	}

}

class Member {
	String nation; //한국 고정
	String group; //403 고정
	String id;
	String pass;
	String name;
	
	/*
	 * 국가 = 한국 
	 * group = 403호	 를 기본으로 하고 
	 * id , pass, name를 입력 가능하도록 하는    
	 * Member 생성자를 만들자.
	 * 
	 */
	public Member(String nation, String group, String id, String pass, String name) {
		this.nation = nation;
		this.group = group;
		this.id = id;
		this.pass = pass;
		this.name = name;				
	}
	
	public Member(String id, String pass, String name) {
		this("한국", "403", id, pass, name);
	}
	
	/*
	 * toString 메소드를 통해 값을 바로 출력하도록 할것.
	 */
	
	@Override
	public String toString() {
		return "Member [nation=" + nation + ", group=" + group + ", id=" + id + ", pass=" + pass + ", name=" + name
				+ "]";
	}
}
