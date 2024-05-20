package kr.or.ddit.basic;

public class T07_ThreadPriorityTest {

	public static void main(String[] args) {
		
		//1(최소) ~ 10(최대)
		System.out.println("최대 우선 순위: " + Thread.MAX_PRIORITY);
		System.out.println("최소 우선 순위: " + Thread.MIN_PRIORITY);
		System.out.println("보통 우선 순위: " + Thread.NORM_PRIORITY);
		
		Thread[] ths = new Thread[] {
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest2()
		};
		//우선순위는 start() 메서드호출전에 설정
		for(int i = 0; i < ths.length; i++) {
			if(i == 5) {
				ths[i].setPriority(10);
			} else {
				ths[i].setPriority(1);
			}
		}
		//설정된 우선순위출력
		for(Thread th: ths)
			System.out.println(th.getName()+"의 우선순위>>" +th.getPriority());
	
		//스레드 구동
		for(Thread th : ths) {
			th.start();
		}
	}
}


class ThreadTest1 extends Thread {
	public void run() {
		for(char ch= 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);
			
			for(long i = 1; i <= 1000000000; i++) {
				//시간뗴우기용 반복문
			}
		}
	}
}


class ThreadTest2 extends Thread {
	public void run() {
		for(char ch= 'a'; ch <= 'z'; ch++) {
			System.out.println(ch);
			
			for(long i = 1; i <= 1000000000; i++) {
				//시간뗴우기용 반복문
			}
		}
	}
}