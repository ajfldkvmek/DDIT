package print;

import java.util.List;

import vo.Bus;

public class Print {
	
	public void printVar() {
		System.out.println("------------------------------------");
	}
	
	public void printLn(int num) {
		for(int i=0; i<num; i++) System.out.println();
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 버스예매");
		System.out.println("2. 예매내역 조회");
		System.out.println("3. 예매취소");
		printLn(4);
		printVar();
	}
	
	public void printBusList(List<Bus> busList) {
		System.out.println("출발지\t도착지\t시간\t등급\t가격\t좌석수");
		for (Bus bus : busList) {
			System.out.printf("%s\t%s\t%s\t%s\t%d\t%d", bus.getSt_bus(), bus.getEd_bus(), bus.getTime(), bus.getClass(),bus.getPrice(),bus.getSit_no());
		}
	}
	
	public void printReserveMenu() {
		System.out.println("1. 예매");
		System.out.println("2. 출발/행선지 변경");
		System.out.println("3. 홈");
	}
	
}
