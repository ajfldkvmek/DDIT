package kr.or.ddit.basic;

class MyThread extends Thread {
	// MyThread의 작업은 run()메소드 안에 입력
	public void run() {
//		super.run();
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간)>> 시간/1000초 만큼 멈춤
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//방법 2: Runnable인터페이스를 구현
//		Thread클래스의 생성자 매개변수를 넘겨줌
//		이렇게 생성된 Thread객체의 start()메서드를 호출한다
class Mythread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 200; i++) {
			System.out.print("$");
			try {
				// Thread.sleep(시간)>> 시간/1000초 만큼 멈춤
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//방법3: 익명 클래스를 이욯하는 법
//		Runnable 인터페이스를 구현한 익명클래스를 이용하기
//		방법2와 유사
class Mythread3 implements Runnable {

	@Override
	public void run() {

	}
}

public class T02_MultiThreadTest {
	// 멀티스레드 프로그램 방식
	// 방법 1: Thread 클래스를 상속후 start()메서드 호출
	public static void main(String[] args) {
		MyThread th1 = new MyThread();

		Runnable r = new Mythread2();
		Thread th2 = new Thread(r);

		//방법3 익명클래스
		Thread th3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 200; i++) {
					System.out.print("#");
					try {
						// Thread.sleep(시간)>> 시간/1000초 만큼 멈춤
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		th1.start();
		th2.start();
		th3.start();
	}
}
