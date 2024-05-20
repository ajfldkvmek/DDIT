package kr.or.ddit.study07;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Study5 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Study5 obj = new Study5();

		obj.test1();
		obj.test2();
		obj.test3();
		obj.test4("BCBdbe", 'B');

	}

	public void test1() {
		/*
		 * 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기
		 * 위해 필요한 피자의 수를 출력해보세요.
		 */
		int n = new Random().nextInt(200);

		int pizza = n / 7;
		System.out.println("문1. 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기");
		System.out.println(n + "명이 먹기위해서는 " + (pizza + 1) + "개의 피자가 필요해");
	}

	public void test2() {
		/*
		 * 정수가 들어 있는 배열 num_list가 매개변수로 주어집니다. num_list의 원소의 순서를 거꾸로 뒤집은 배열을 출력 해주세요.
		 */
		System.out.println("\n문2. 배열 역출력");
		int length = new Random().nextInt(15);
		int[] num_list = new int[length];
//		System.out.println(length);
		for (int i = 0; i < num_list.length; i++) {
			num_list[i] = new Random().nextInt(10);
		}
		System.out.println(Arrays.toString(num_list));
		int[] new_num = new int[length];
		for (int i = 0; i < num_list.length; i++) {
			new_num[i] = num_list[length - (i + 1)];
		}
		System.out.println(Arrays.toString(new_num));
	}

	public void test3() {
		/*
		 * numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 구하시오
		 */
		System.out.println("\n문3. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 구하시오");
		int[] numbers = { 0, 31, 24, 10, 1, 9};

		int max = 0;

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] * numbers[j] > max)
					max = numbers[i] * numbers[j];
			}
		}
		System.out.println(max);
	}

	public void test4(String my_string, char letter) {
		/*
		 * 문자열 my_string과 문자 letter이 매개변수로 주어집니다. my_string에서 letter를 제거한 문자열을 출력하시오
		 * 
		 * 
		 * my_string letter result "abcdef" 'f' "abcde" "BCBdbe" 'B' "Cdbe"
		 * 
		 */
		System.out.println("\n문4. 매개변수로 주어진 my_string, letter my_string에서 letter를 제거한 문자열을 출력하시오");
		String str = null;

		char[] new_string = my_string.toCharArray();

		System.out.println("my_string: " + my_string + "\nletter: " + letter);
		for (int i = 0; i < new_string.length; i++) {
			if (new_string[i] == letter)
				continue;
			if (str == null)
				str = Character.toString(new_string[i]);
			else
				str = str + new_string[i];
		}

		System.out.println(str);
	}

}
