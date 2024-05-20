package kr.or.ddit.basic;

public class T19_WaiNotifyTest {
	/*
	 * wait() 메소드>> 동기화 영역에서 락을 풀고 wait-set영역(공유객체별 존재)으로 이동시킴
	 * 
	 * 
	 * notify() or notofyAll() 메서드>> wait-set 영역에 있는 스레드를 깨워서 실행될 수 있게함 (하나만)
	 * (wait-set 전체) --> Object 클래스에서 제공하는 메소드
	 * 
	 */

	public static void main(String[] args) {
		
		WorkObject workObj = new WorkObject();
		
		Thread thA = new ThreadA(workObj);
		Thread thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
	}

}

//공유객체로 사용할 클래스
class WorkObject {

	public synchronized void methodA() {
		System.out.println("methodA에서 작업중");

		System.out.println(Thread.currentThread().getName() + " : notify()호출");
		notify();
		try {
			System.out.println(Thread.currentThread().getName() + " : wait()호출");
			wait(3000); //3초 대기동안 notify없으면 종료
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void methodB() {
		System.out.println("methodB에서 작업중");

		System.out.println(Thread.currentThread().getName() + " : notify()호출");
		notify();
		try {
			System.out.println(Thread.currentThread().getName());
			wait(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//WorkObject의 methodA()만 호출하는 스레드

class ThreadA extends Thread {
	private WorkObject workObj;
	public ThreadA(WorkObject workObj) {
		super("ThreadA");
		this.workObj = workObj;
	}
	public void run() {
		for (int i = 0; i <= 10; i++) {
			workObj.methodA();
		}
	}
}

class ThreadB extends Thread {
	private WorkObject workObj;
	public ThreadB(WorkObject workObj) {
		super("ThreadB");
		this.workObj = workObj;
	}
	public void run() {
		for (int i = 0; i <= 10; i++) {
			workObj.methodB();
		}
	}
}