package kr.or.ddit.HomeWork;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork6 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork6 obj = new HomeWork6();
		obj.score_test();
	}

	private void score_test() {

		String[] stuName = { "홍길동", "강감찬", "이성계", "이순신", "정몽주" };
		int[][] score = { { 91, 83, 97, 0, 0, 0 }, { 99, 99, 97, 0, 0, 0 }, { 89, 87, 83, 0, 0, 0 },
				{ 99, 99, 99, 0, 0, 0 }, { 97, 79, 97, 0, 0, 0 } };

		for (int i = 0; i < score.length; i++) {
			for (int sc = 0; sc < 3; sc++) {
				score[i][3] += score[i][sc];
			}
			score[i][4] = score[i][3] / 3;
		}

		for (int a = 0; a < score.length; a++) {
			for (int b = 0; b < score.length; b++) {
				if (score[a][4] <= score[b][4])
					score[a][5]++;
			}
		}

//		System.out.println("기존 배열");
//		for(int i = 0; i < stuName.length; i++) System.out.println(stuName[i] +": "+ Arrays.toString(score[i]));


		for (int a = 0; a < score.length - 1; a++) {
			for (int b = 0; b < score.length - 1; b++) {
				if (score[b][3] < score[b + 1][3]) {

					int[] stemp = score[b];
					score[b] = score[b + 1];
					score[b + 1] = stemp;

					String str_temp = stuName[b];
					stuName[b] = stuName[b + 1];
					stuName[b + 1] = str_temp;
				}
			}
		}

//		System.out.println("정렬후 배열");
		for (int i = 0; i < stuName.length; i++) {
			System.out.println(stuName[i] + ": " + Arrays.toString(score[i]));
		}

	}
}
