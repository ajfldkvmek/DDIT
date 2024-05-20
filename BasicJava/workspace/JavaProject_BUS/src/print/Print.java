package print;

import java.util.List;

import javax.sound.midi.Soundbank;

import util.View;
import vo.Bus;

public class Print {

	public void printVar() {
		System.out.println("----------------------------------");
	}

	public void println(int num) {
		for (int i = 0; i < num; i++)
			System.out.println();
	}


	public void printHome() {
		printVar();
		System.out.println("1. 버스목록"); // 신규등록, 업데이트, 삭제
		System.out.println("2. 홈");
		println(5);
		printVar();
	}

	public void printBusList(List<Bus> l) {
		// 게시판 내용 출력"\t"
		printVar();
		System.out.println("번호\t회사\t등급\t출발지 \t도착지\t시간\t\t\t가격\t좌석");
		for (Bus bus : l) 
			System.out.println(
					bus.getId()+"\t"+bus.getCompany()+"\t"+bus.getGrade()+"\t"
							+bus.getOrig()+"\t"+bus.getDest()+"\t"+bus.getTime()+"\t"
							+bus.getPrice()+"\t"+bus.getSeat_resv()+"/"+bus.getSeat());

		println(1);
		printVar();
	}
	public void printList(List<Bus> l) {
		printVar();
		System.out.println();
		for (Bus bus : l) 
			System.out.println(
					bus.getId()+"\t"+bus.getCompany()+"\t"+bus.getGrade()+"\t"
							+bus.getOrig()+"\t"+bus.getDest()+"\t"+bus.getTime()+"\t"
							+bus.getPrice()+"\t"+bus.getSeat_resv()+"/"+bus.getSeat());

		println(1);
		printVar();
	}
	
	public void printReserve(Bus b) {
		printVar();

		System.out.println();
		println(1);
		printVar();
	}
}
