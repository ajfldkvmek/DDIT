package kr.or.ddit.basic;

public class T13_ThreadStropTest {

	public static void main(String[] args) {
//		ThreadStopEx1 th1 = new ThreadStopEx1();
//		th1.start();
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		th1.setStop(true);

		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.interrupt();
	}
}

class ThreadStopEx1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void run() {
		while (!stop) {
			System.out.println("스레드 작업중");
		}

		System.out.println("자원 정리중");
		System.out.println("실행 종료");
	}
}

class ThreadStopEx2 extends Thread {

	// 방법1
	// sleep나 join메서드 등을 사용했을 때 interrupt()메서드를 호출하면
	// Interrupted Exception이 발생한다. 이 예외 이용하기
//	public void run() {
//		try {
//			while(true{
//				System.out.println("스레드 작업중");
//				Thread.sleep(1);
//		}
//		} catch (InterruptedException ex) {
////			ex.printStackTrace();
//		}
//		System.out.println("자워 정리중");
//		System.out.println("실행 종료");
//	}

	// 방법2
	// interrupt()가 호출되었는지 검사하기
	public void run() {
		while (true) {
			System.out.println("스레드 처리중");
			
//			if(this.isInterrupted()) {
//				System.out.println("인스턴스 메서드 사용하는 법");
//				break;
//			}
			if(Thread.interrupted()) {
				System.out.println("정적메서드 사용하는 법");
				break;
			}
		}
		System.out.println("자원 정리중");
		System.out.println("실행 종료");
	}
}
