package kr.or.ddit.study13.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HistoGram {

	List<Integer> diceList = new ArrayList<Integer>();
	//key: 주사위 합, value:횟수
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		HistoGram hg = new HistoGram();
		
		hg.process();	
	}
	
	//주사위 값 랜덤 출력 메소드
	//주사위 2개를 던져서 총 주사위의 합을 구한 후
	//list로 구현
	//전체 히스토그래을 구현 해 볼 것
	//주사위 눈은 1~6으로 구현
	
	private void process() {
		doThrowDice(3000);
		
		print();
	}

	public void doThrowDice(int enforcement) {
		for(int a = 0; a < enforcement; a++) {
			int k = throwDice()+throwDice();
			diceList.add(k);
		}
		
//		for(int i = 0; i < enforcement; i++) {
//			int num = throwDice()+throwDice();
//			int cnt = 1;
//			if(map.containsKey(num)) cnt+=map.get(num);
//			map.put(num, cnt);
//		}
		
	}
	//dice롤
	public int throwDice() {
//		int a = (int)(Math.random()*6) + 1;
//		int b = (int)(Math.random()*6) + 1;
//		new Random().nextInt(6) + 1;
		return new Random().nextInt(6) + 1;
	}
	
	public int getDiceNumCount(int num) {
		
		int count = 0;
		for(int a : diceList) {
			if(a == num) count++;
		}
			
		return count;
	}
	
	public void print() {
		for(int a = 2; a <=12; a++) {
			System.out.print("주사위합 " + a + "는\t" + getDiceNumCount(a) + "번 나옴");
			for(int i = 0; i < getDiceNumCount(a)/10; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
