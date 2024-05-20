package kr.or.ddit.basic;

/**
 * 
 *
 *
 *
 */

//1 ~ 10억까지 합계 구하기
class MyRunner implements Runnable {
	//Thread가 할 작업
	public void run() {
		long sum = 0;
		for(int i =1; i <= 1000000000; i++) {
			sum+=i;
		}
		System.out.println("합계: " + sum);
	}
	
}
public class T03_ThreadTimeTest {

	public static void main(String[] args) {
		
		Thread th1 = new Thread(new MyRunner());
		
		//utck-> 1970년 1월 1일부터 지금까지 지난 시간(초)
		long startTime = System.currentTimeMillis();
		th1.start();
		
		try {
			//현재 실행중인 스레드에서 작업중인 스레드가 종료될 때 가지 기다림
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과 시간: " + (endTime-startTime));
	}
}
