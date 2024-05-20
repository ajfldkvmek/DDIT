package kr.or.ddit.basic;

import java.util.LinkedList;

public class T02StackQueueTest {

	public static void main(String[] args) {
	
		LinkedList<String> stack = new LinkedList<String>();
		
		/*
		 Stack 방식의 동작을 위한 메서드
		 자료입력: push
		 자료출력: pop
		 */
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		System.out.println("현재 stack: " + stack);
		String data = stack.pop();
		System.out.println("꺼내온 자료: " + data);
		System.out.println("거내온 자료: " + stack.pop());
		
		System.out.println("현재 스택 값: " + stack);
		System.out.println("꺼내온 자료: " + stack.pop());

		LinkedList<String> queue = new LinkedList<String>();
		
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 quere의 값: " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 자료: " + temp);
		System.out.println("꺼내온 자료:" + queue.poll());
		System.out.println("꺼내온 queue의 값: " + queue);
		
		if(queue.offer("성춘향")) {
			System.out.println("신규등록: 성춘향");
		}
		System.out.println("현재 queue: " +queue);
		System.out.println("꺼내온 자료: " + queue.poll());
	}
}
