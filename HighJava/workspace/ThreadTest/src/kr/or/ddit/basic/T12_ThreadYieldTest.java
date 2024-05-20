package kr.or.ddit.basic;

/*
 *	yield() 메서드에 대하여 << 굳이 권장하지는 않음
 *	
 * 	1.현재 실행 대기중인 동등한 우선순위 이상의 다른 스레드에세 실행기회를 제공한다
 *  2.현재 실행중안 스레드의 상태를 RUNNABLE로 바꾼다
 *	3.yield() 메서드를 실행한다고 해서 현재 실행중인 스레드가 곹바고 RUNNABLE로 되는 건 아님   
 */
public class T12_ThreadYieldTest {

	public static void main(String[] args) {
		
		Thread th1 = new YieldThreadEx1();
		Thread th2 = new YieldThreadEx2();
		
		th1.start();
		th2.start();
	}
	
}

class YieldThreadEx1 extends Thread {
	
	public YieldThreadEx1() {
		super("양보쓰레드");
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(
				Thread.currentThread().getName()+" : " + i
			);
			for(int j = 0; j <= 10000000; j++) {}
			Thread.yield();
		}
	}
}


class YieldThreadEx2 extends Thread {
	
	public YieldThreadEx2() {
		super("비양보쓰레드");
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(
				Thread.currentThread().getName()+" : " + i
			);
			for(int j = 0; j <= 10000000; j++) {}
//			Thread.yield();
		}
	}
}