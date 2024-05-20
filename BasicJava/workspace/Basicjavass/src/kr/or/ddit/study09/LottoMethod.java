package kr.or.ddit.study09;

import java.util.Arrays;

public class LottoMethod {

	public static void main(String[] args) {

		LottoMethod lotto = new LottoMethod();

//		int[][] arr = lotto.lottoPaper();
//		int[] lot = lotto.generateLotto();
//		lotto.printArray(lot);
//		for (int i = 0; i < arr.length; i++) {
//			lotto.printArray(arr[i]);
//		}

		lotto.lottoBundle(13000);

	}

	public int[] generateLotto() {

		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			int ran = (int) (Math.random() * 45) + 1;
			lotto[i] = ran;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		return lotto;
	}

	public int[][] lottoPaper() {
		return lottoPaper(5);
	}

	public int[][] lottoPaper(int n) {
		int paper[][] = new int[n][6];
		for (int line = 0; line < paper.length; line++) {
			paper[line] = generateLotto();
		}
		return paper;
	}

	public void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length - 1] + "]");
	}
	

	public void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			printArray(arr[i]);
		}
	}
	

	public int[][][] lottoBundle(int money) {

		int num = money / 1000;
		int paper = num / 5;
		int remain = num % 5;
		if (remain != 0)
			paper++;

		int[][][] bundle = new int[paper][5][6];

		for (int i = 0; i < paper; i++) {
			if (i < paper-1)
				bundle[i] = lottoPaper();
			else
				bundle[i] = lottoPaper(remain);
		}

		for(int a = 0; a < bundle.length; a++) {
			printArray(bundle[a]);
			System.out.println("--------------------");
		}
		
		return null;
	}
}
