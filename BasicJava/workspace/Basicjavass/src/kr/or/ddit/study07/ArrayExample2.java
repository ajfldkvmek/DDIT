package kr.or.ddit.study07;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample2 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample2 obj = new ArrayExample2();
		obj.method1();
		// System.gc();
		//obj.method2();
		
	}

	/*
	private void method2() {
		// TODO Auto-generated method stub
		
//		 각 타입별 초기화 값 -> 0
//		 reference type = null;
		 
		boolean[] b = new boolean[5];
		byte[] bt = new byte[5];
		char[] ch = new char[5];
		short[] sh = new short[5];
		int[] a = new int[5];
		long[] l = new long[5];
		float[]	f = new float[5];
		double[] d= new double[5];
		
		for(int i = 0; i < 1; i++) {
			System.out.println(b[0]);
			System.out.println(ch[0]);
			System.out.println(bt[0]);
			System.out.println(sh[0]);
			System.out.println(a[0]);
			System.out.println(l[0]);
			System.out.println(f[0]);
			System.out.println(d[0]);
		}
		
	}
*/

	private void method1() {
		// lotto 만들자 1~45
		// 45개의 번호 배열 생성 후
		// 섞어서 앞에 6개 출력
		int[] lotto = new int[45];
		int[] lotto2 = new int[6];

		for (int i = 0; i < 45; i++)
			lotto[i] = i + 1;

		for (int i = 0; i < 300; i++) {
			int r = (int) (Math.random() * lotto.length);
			int l = (int) (Math.random() * lotto.length);
			int temp = lotto[r];
			lotto[r] = lotto[l];
			lotto[l] = temp;
		}
		 
		System.arraycopy(lotto, 0, lotto2, 0, lotto2.length);
		System.out.println(Arrays.toString(lotto2));
		for(int a = 0; a < lotto2.length-1; a++) {
			for(int b = 0; b < lotto2.length-1; b++) {				
				if(lotto2[b] > lotto2[b+1]) {
					int temp = lotto2[b];
					lotto2[b] = lotto2[b+1];
					lotto2[b+1] = temp;
				}
			}
		}
		
//		Arrays.sort(lotto2);
		System.out.println(Arrays.toString(lotto2));
//		for(int i = 0; i < lotto2.length; i++) lotto2[i] = lotto[i];
//		
//		for (int i = 0; i < lotto2.length; i++) {
//			System.out.print(lotto2[i] + " ");
//		}

	}
}
