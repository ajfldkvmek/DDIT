package kr.or.ddit.basic;

public class T15_SyncThreadTest {

	public static void main(String[] args) {

		ShareObject sObj = new ShareObject();

		WorkThread wTh1 = new WorkThread("1번쓰레드", sObj);
		WorkThread wTh2 = new WorkThread("2번쓰레드", sObj);

		wTh1.start();
		wTh2.start();
	}
}

//공유 객체로 사용할 클래스
class ShareObject {
	private int sum = 0;

	// 동기화 처리하는 방법1: 메서드 자체에 동기화 설정
//	synchronized public void add() {
	public void add() {
//		for (int i = 0; i < 1000000000; i++) {
//			//시간벌기용
//		}
		
		//동기화 처리방법2: 동기화 블럭 설정하기
		//mutex: mutual exclusion Object(상호배제)
//		synchronized (this) {
//			for (int i = 0; i < 1000000000; i++) {
//				//시간벌기용
//			}
//			int n = sum;
//			n += 10;
//			sum = n;
//			System.out.println(Thread.currentThread().getName() + " 합계: " + sum);
//		}
		int n = sum;
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + " 합계: " + sum);
	}
}

//작업을 수행할 스레드
class WorkThread extends Thread {
	private ShareObject sObj;

	public WorkThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}

	public void run() {
		synchronized (sObj) {
			for (int i = 1; i <= 10; i++) {
				sObj.add();
			}
		}
	}
}