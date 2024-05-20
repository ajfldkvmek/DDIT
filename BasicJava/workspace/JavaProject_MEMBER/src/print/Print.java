package print;

import java.util.List;

import util.ScanUtil;
import vo.Mem;

public class Print {
	
	public void printVar() {
		System.out.println("------------------------------------");
	}
	
	public void printLn(int num) {
		for(int i=0; i<num; i++) System.out.println();
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 관리자");
		System.out.println("2. 일반회원");
		printLn(4);
		printVar();
	}
	
	public void printMemberHome() {
		System.out.println("1. 정보수정");
		System.out.println("2. 탈퇴");
	}
	
	public void printMemberMenu() {
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 정보수정");
		System.out.println("4. 탈퇴");
	}
	
	public void printMemberList(List<Mem> list) {
		for (Mem mem : list) 
			System.out.println(mem);
	}
	
	public void printAdminMenu() {
		System.out.println("1. 전체조회");
	}
	
	public void loginFail() {
		System.out.println("로그인 정보 잘못됨");
	}
	
	public void printUpdateMenu() {
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 이름 수정");
		System.out.println("3. 나이 수정");
		System.out.println("4. 전체 수정");
	}
//	public void printBusList(List<Mem> busList) {
//		System.out.println("출발지\t도착지\t시간\t등급\t가격\t좌석수");
//		for (Mem mem : busList) {
//			System.out.printf("%s\t%s\t%s\t%s\t%d\t%d", mem.getSt_bus(), mem.getEd_bus(), mem.getTime(), mem.getClass(),mem.getPrice(),mem.getSit_no());
//		}
//	}
//	
//	public void printReserveMenu() {
//		System.out.println("1. 예매");
//		System.out.println("2. 출발/행선지 변경");
//		System.out.println("3. 홈");
//	}
	
}
