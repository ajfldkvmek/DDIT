package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class T06TreeSet {

	public static void main(String[] args) {
		
		/*
		 * treeset은 set과 다르게 자동정렬 기능이 있음
		 */
		
		TreeSet<String> ts = new TreeSet<String>();
		
		List<String> abcList = new ArrayList<String>();
		
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			String temp = String.valueOf(ch);
			abcList.add(temp);
		}
		
		Collections.shuffle(abcList);
		
		System.out.println("섞은 후의 abcList>> " + abcList);
		
		for(String str : abcList)
			ts.add(str);
		
		System.out.println("정렬 후의 abcList>> " + ts);
		System.out.println();
		
		/*
		 * treeset에 저장된 데이터중  
		 * 특정 값보다 작은 데이터를 찾아 반환하는 메서드 headSet
		 * headset(기준값): 기본적으로 기준값 포함X
		 * headSet(기준값, 논리값): 논리값ㅇ true면 기준값 포함
		 */
		
		SortedSet<String> ss1 = ts.headSet("K");
		System.out.println("K이전자료: " + ss1);
		System.out.println("K이전자료(기준값 포함): " + ts.headSet("K", true));
		
		/*
		 * treeset에 저장된 데이터중  
		 * 특정 값보다 큰 데이터를 찾아 반환하는 메서드 tailSet
		 * tailSet(기준값): 기본적으로 기준값 포함
		 * tailSet(기준값, 논리값): 논리값ㅇ true면 기준값 포함
		 */
		
		SortedSet<String> ss2 = ts.tailSet("K");
		System.out.println("K이전자료: " + ss2);
		System.out.println("K이전자료(기준값 미포함): " + ts.tailSet("K", false));
		
		/*
		 * treeset에 저장된 데이터중  
		 * 특정 값보다 큰 데이터를 찾아 반환하는 메서드 headSet
		 * subSet(기준값(포함), 기준값(미포함)):
		 * subSet(기준값, 논리값, 기준값, 논리값): 논리값ㅇ true면 기준값 포함
		 */
		
		System.out.println("기본(포, 미포)" + ts.subSet("K", "N"));
		System.out.println("포 미포" +ts.subSet("K", "N"));
		System.out.println("포 포" +ts.subSet("K",true, "N", true));
		System.out.println("미포 미포" +ts.subSet("K",false, "N", false));
		System.out.println("미포 포" +ts.subSet("K",false, "N", true));
	}
}
