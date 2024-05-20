package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 	3개의 스레드가 가각 알파벳 대문자를 출력하는데
 	출력이 끝낸 순서대로 결과를 출력하는 프로그램 작성하기
 */
public class T11_DisPlayCharacterTest {

	static int CURRENT_RANK = 1;

	public static void main(String[] args) {

		List<DispalyCharater> list = new ArrayList<>();

		list.add(new DispalyCharater("가나다"));
		list.add(new DispalyCharater("나다라"));
		list.add(new DispalyCharater("다라마"));
		list.add(new DispalyCharater("라마바"));

		for (Thread th : list) {
			th.start();
		}

		for (Thread th : list) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("경기끝...");

		Collections.sort(list);

		System.out.println("------------------------");
		System.out.println("경기결과");
		System.out.println("========================");
		System.out.println("순위\t:\t이름");
		System.out.println("========================");
		for (DispalyCharater dp : list) {
			System.out.println(dp.getRank() + "\t:\t" + dp.getName());
		}
	}
}

//알파벳 대문자 출력을 위한 스레드
class DispalyCharater extends Thread implements Comparable<DispalyCharater> {
	private String name;
	private int rank;

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public DispalyCharater(String name) {
		super(name); // 스레드 이름 지정
		this.name = name;
	}

	public void run() {

		Random rand = new Random();
		int num = (rand.nextInt(3) + 2) * 100;

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(name + "의 출력문자: " + ch);
//			try {
//				// 200 ~ 500의 난수
//				Thread.sleep(num);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		try {
			// 200 ~ 500의 난수
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "출력 끝");
		this.setRank(T11_DisPlayCharacterTest.CURRENT_RANK++);
	}

	@Override
	public int compareTo(DispalyCharater dp) {
		// TODO Auto-generated method stub
//		return new this.getRank();
		return Integer.compare(this.getRank(), dp.getRank());
	}
}