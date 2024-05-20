package kr.or.ddit.exam4;

import java.util.Arrays;

public class SortMethod {

	
	public static void main(String[] args) {
		
		SortMethod sort = new SortMethod();
		
		int[] arr  = {67, 55, 9, 87, 98};		
		int[] res = sort.sort(arr);		
		System.out.println(Arrays.toString(res));		
		
		int[] arr2  = {71,45,76,78,21,98,1,51,8};		
		int[] res2 = sort.sort(arr2);		
		System.out.println(Arrays.toString(res2));	
		
		int[] arr3  = {71,45,76,78,21,98,1,51,8,12,61,17};		
		int[] res3 = sort.sort2(arr3);		
		System.out.println(Arrays.toString(res3));	
	}
	
	
	/*
	 * public 접근 범위
	 * int[] return type
	 * int[] arr 매개변수
	 */

	//오름차순
	public int[] sort(int[] arr) {
		for(int a = 0; a < arr.length-1; a++) {
			for(int b = 0; b < arr.length-1; b++) {				
				if(arr[b] > arr[b+1]) {
					int temp = arr[b];
					arr[b] = arr[b+1];
					arr[b+1] = temp;
				}
			}
		}
		return arr;
	}
	
	//내림차순
	public int[] sort2(int[] arr) {
		for(int a = 0; a < arr.length-1; a++) {
			for(int b = 0; b < arr.length-1; b++) {				
				if(arr[b] < arr[b+1]) {
					int temp = arr[b];
					arr[b] = arr[b+1];
					arr[b+1] = temp;
				}
			}
		}
		return arr;
	}
}

