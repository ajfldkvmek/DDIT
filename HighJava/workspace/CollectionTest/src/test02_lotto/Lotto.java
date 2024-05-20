package test02_lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();

	public static void main(String[] args) {

		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		System.out.println("==========================\r\n" + "Lotto 프로그램\r\n" + "--------------------------\r\n"
				+ "1. Lotto 구입\r\n" + "2. 프로그램 종료\r\n" + "==========================	 ");

		System.out.print("메뉴선택>> ");
		int select = sc.nextInt();

		if (select == 1) {
			System.out.print("(1000원에 로또번호 하나입니다.)\n금액입력>> ");
			int money = sc.nextInt();
			int change = money % 1000;
			int num = money / 1000;
			System.out.printf("받은 금액은 %d원이고 거스름돈은 %d원 입니다\n", money, change);
			
			for(int a = 1; a <= num; a++) {
				list.add(lotto());
			}
		} else if (select == 2) {
			out();
		} else {
			System.out.println("잘못누름");
		}
		
		for(int a = 1; a <= list.size(); a++)
			System.out.println(a+"번 째 게임: " + list.get(a-1));     
	}

	public static Set<Integer> lotto() {

		TreeSet<Integer> set = new TreeSet<Integer>();

		while (true) {
			int lotto = rand.nextInt(45) + 1;
			if (set.size() >= 6) {
				break;
			}
			set.add(lotto);
		}
		return set;
	}

	public static void out() {
		System.out.println("종료");
	}
}
