package kr.or.ddit.study07;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample3 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample3 obj = new ArrayExample3();
		obj.method1();
		obj.method2();
		obj.method3();
		obj.method4();
	}



private void method4() {
		//5명의 3과목 (국영수) 성적과 이름을 배열에 저장하고 총점과 평균과 등수를 구하여 출력하시오
	
		String[] stuName = {"홍길동","강감찬","이성계","이순신","정몽주"};
		int[][] score = {{91,83,97,0,0,0},
						{99,99,97,0,0,0},
						{89,87,83,0,0,0},
						{99,99,99,0,0,0},
						{97,79,97,0,0,0}};
		
		for(int i = 0; i < score.length; i++) {
			for(int sc = 0; sc < 3; sc++) {
				score[i][3] += score[i][sc];
			}
			score[i][4] = score[i][3]/3;
		}
		
		
		for(int a = 0; a < score.length; a++) {
			for(int b = 0; b < score.length; b++) {
				if(score[a][4] <= score[b][4]) score[a][5]++;
			}
		}	
		
//		for(int i = 0; i < stuName.length; i++) {
//			System.out.println(stuName[i] +": "+ Arrays.toString(score[i]));
//		}
		
		System.out.println();
		for(int a = 0; a < score.length-1; a++) {
			for(int b = 0; b < score.length-1; b++) {				
				if(score[b][3] < score[b+1][3]) {
					int[] stemp = score[b];
					
					score[b] = score[b+1];
					score[b+1]= stemp;
					
					String str_temp = stuName[b];
					stuName[b] = stuName[b+1];
					stuName[b+1] = str_temp;
				}
			}
		}		
		
		for(int i = 0; i < stuName.length; i++) {
			System.out.println(stuName[i] +": "+ Arrays.toString(score[i]));
		}

		
	}

private void method3() {
		// TODO Auto-generated method stub
		//1차원 배열 건너 뛰기
	
		int[][] arr = new int[3][];
	
		arr[0] = new int[3];
		arr[1] = new int[3];	
		arr[2] = new int[5]; //크리 다르게 선언하기
		
		for(int i =0; i < arr.length; i++) {
			System.out.println("i " + i);
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}			
			System.out.println();
		}
}

	private void method1() {
		int[][] arr = new int [7][5];
		
		for(int i = 0; i < arr.length; i++) {
			int[] a1 = arr[i];
			for(int j = 0; j < a1.length; j++) {
				a1[j] = i;
			}
			System.out.println(Arrays.toString(a1));
		}
			
	}

	private void method2() {
		//국어 수학 영어 순서
		String[] stuName = {"홍길동", "강감찬", "이순신"};
		int[][] score = {{80,75,87},{88,90,91},{77,73,65}};		
		
		int h_math = score[0][1];	
		System.out.println(h_math);
		
		int l_math = score[2][1];
		System.out.println(l_math);
		
		for(int a = 0; a < score.length; a++) {
			for(int i = 0; i < score[0].length; i++) {
				//System.out.println(stuName[i] + "의 국어 점수는 " + score[i][0] + "입니다");
				if(a == 0) System.out.println(stuName[i] +" 의 국어점수는 "+ score[i][a]+ "입니다");
				if(a == 1) System.out.println(stuName[i] +" 의 수학점수는  "+ score[i][a]+ "입니다");
				if(a == 2) System.out.println(stuName[i] +" 의 영어점수는  "+ score[i][a] +"입니다");
			}
			System.out.println();
		}
	}

}
