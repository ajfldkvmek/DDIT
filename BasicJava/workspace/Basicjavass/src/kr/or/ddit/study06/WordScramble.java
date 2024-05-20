package kr.or.ddit.study06;

import java.util.Arrays;
import java.util.Scanner;

public class WordScramble {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WordScramble obj = new WordScramble();
		obj.method1();
	}

	private void method1() {
		// TODO Auto-generated method stub
		//5개의 단어다 제공되며 이중 임의의 단어가 선택된다
		//선택된단어의 철자를 섞어 사용자에게 제시되며
		//사용자는 이를 보고 원래의 단어를 입력한다
		//사용자가 단어를 맞출 때 까지 반복하여 단어를 맞추었을 때 시도 횟수 출력
		String[] word = {"apple", "banana", "love","hope",	"persimmon"};
		
		int ran = (int)(Math.random()*word.length);
		String select = word[ran];
		
		//문자열을 char배열로 변환
		char[] ch = select.toCharArray();
		
		for(int i = 0; i < 1000; i++) {
			int r =(int)(Math.random()*ch.length);
			char temp = ch[1];
			ch[1] = ch[r];
			ch[r] = temp;
		}
//		System.out.println(Arrays.toString(ch));
		int count = 0;
		while(true) {
			System.out.println(Arrays.toString(ch));
			System.out.print("입력: ");
			String str = sc.nextLine();
			count++;
//			System.out.println(Arrays.toString(ch));
			if(str.equals(select)) {
				System.out.println("정답! "+ count+" 번 만에 맞췄어");
				System.out.println("답: " + select);
				break;
			}
			else System.out.println("틀렸어");
		}
			
	}
	
}
