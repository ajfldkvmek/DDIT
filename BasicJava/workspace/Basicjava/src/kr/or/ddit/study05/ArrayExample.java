package kr.or.ddit.study05;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample obj = new ArrayExample();
		obj.method1();
		obj.method2();
		obj.method3();
		obj.method4();
		obj.method5();
		obj.bubbleSort();
		obj.selectionSort();
	}
	

	private void selectionSort() {
		// TODO Auto-generated method stub
		int[] num = {67, 55, 9, 86, 98};
		System.out.println(Arrays.toString(num));
		
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num.length; j++) {
				if(num[i] < num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num));
		
	}

	private void bubbleSort() {
		//버블정렬
		//원본자료가 n개일 때 n-1차 운행한다
		//각 회처에서 연접한 두 값을 비교하여 오름차순인 경우 작은 갚을 앞에 위치
		//오름차순인 경우 작은 갚을 앞에 위치
		//내림차순인 경우 작은 값을 뒤에 위치
		
		int[] num = {67, 55, 9, 86, 98};
		System.out.println(Arrays.toString(num));
		for(int i = 0; i < num.length-1; i++) {
			for(int j = 0; j < num.length-1; j++) {
				if(num[j] > num[j+1]) {
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num));
	}

	private void method5() {
		// TODO Auto-generated method stub
		//배열 복사 shallow copy:원본 배열이 변경되면 복사된 배열도 같이 변경 , deep copy: 값 따로 따로
		
		//shallow copy:원본 배열이 변경되면 복사된 배열도 같이 변경
		
		System.out.println("---------shallow copy---------");
		int[] arr0 = {1,2,3,4,5};
		int[] copy_arr0 = arr0;	
		for(int i = 0; i < arr0.length; i++) {
			System.out.print(arr0[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i < arr0.length; i++) {
			System.out.print(copy_arr0[i]+" ");
		}
		System.out.println();
		
		System.out.println("change arr[n]'s value");
		arr0[2] = 30;
		for(int i = 0; i < arr0.length; i++) {
			System.out.print(arr0[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i < arr0.length; i++) {
			System.out.print(copy_arr0[i]+" ");
		}
		System.gc();
//		System.out.println("\n---------deep copy---------");
//		deep copy: 값 따로 따로
//		1.반복문
//		2.arraycopy
//		3.clone
		
		
		int[] arr1 = {1,2,3,4,5};
		int[] copy_arr1 = new int[5];
		arr1[2] = 3;
		//1.반복문
		System.out.println("\n---------deep copy with iterator---------");
		for(int i = 0; i < arr1.length; i++) {			
			copy_arr1[i] = arr1[i];
		}
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(copy_arr1[i]+" ");
		}
		System.out.println();
		System.out.println("change arr[n]'s value");
		arr1[2] = 30;
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(copy_arr1[i]+" ");
		}
		
		System.gc();
		int[] arr2 = {1,2,3,4,5};
		int[] copy_arr2 = new int[5];
		arr2[2] = 3;
		System.out.println("\n---------deep copy with arracopy---------");
		System.arraycopy(arr2, 0, copy_arr2, 0, arr2.length);
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(copy_arr2[i]+" ");
		}
		System.out.println();
		System.out.println("change arr[n]'s value");
		arr2[2] = 30;
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(copy_arr2[i]+" ");
		}
		System.out.println();	
			
		System.gc();
		System.out.println("---------deep copy with clone---------");
		int[] arr3 = {1,2,3,4,5};
		
		int[] copy_arr3 = arr3.clone();
		for(int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.print(copy_arr3[i]+" ");
		}
		System.out.println();
		System.out.println("change arr[n]'s value");
		arr3[2] = 30;
		for(int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.print(copy_arr3[i]+" ");
		}
		System.out.println();
		
		System.gc();
	}

	
	private void method4() {
		//키보드로 거스름돈을 입력받아 화폐단위별로 갯수를 구하시오
		int[] coin = {50000,10000, 5000, 1000, 500, 100, 10,1};
		System.out.print("거스름돈의 액수를 입력하자: ");
		int money = sc.nextInt();
		
		for(int i = 0; i < coin.length; i++) {
			System.out.printf("%d원: %d개\n", coin[i], (money/coin[i]));
			money %= coin[i];
		}
				
	}

	private void method3() {
		int[] score = new int[10];
//		int[] scr = {1,2,3,4,5,6,7,8,9,10};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		score[0] = 10;
		score[1] = 13;
		score[2] = 15;
		score[3] = -17;
		score[4] = 19;
		score[5] = 1250;
		score[6] = 313;
		score[7] = 155;
		score[8] = 917;
		score[9] = 139;
//		for(int i = 0; i < 10; i++) System.out.println(score[i]);	
//		for(int i = 0; i < 10; i++) System.out.println(scr[i]);	
		

		for(int i = 0; i < 10; i++) {
			sum+=score[i];

			if(max < score[i]) max = score[i];
			if(min > score[i]) min = score[i];
		}		
		
		double aver = (double)sum/score.length;
		System.out.printf("최댓값: %d\n최솟값: %d\n", max,min);
		//System.out.printf("총합: %d\n평균: %f", sum, (double)sum/score.length);
		System.out.println("총합: " + sum + "\n평균: " + aver);
		
	}

	private void method2() {
		// TODO Auto-generated method stub
		//역순 출력
		int[] num = new int[5];
		
		for(int i = 0; i < num.length; i++) num[i] = sc.nextInt();			
		
		
		for(int i = 1; i <= num.length; i++) System.out.println(num[num.length-i]);
		
	}

	private void method1() {
		// TODO Auto-generated method stub
		//int 변수 5개 선언
//		int i1 = 0;
//		int i2 = 1;
//		int i3 = 2;
//		int i4 = 3;
//		int i5 = 4;
		
		//[] 배열서언, arr: 변수명
		//new: 메모리 할당
		//int[n]: 생성될 배열 크기
		int[] arr = new int[5];
		for(int i = 0; i < arr.length; i++) arr[i] = i;
		
	}

}
