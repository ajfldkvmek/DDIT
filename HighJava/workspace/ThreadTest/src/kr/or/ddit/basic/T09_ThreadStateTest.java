package kr.or.ddit.basic;

/*	쓰레드의 상태
	NEW: 스레드기 생성되고 아직 start가 호출되지 않은 상태
 	RUNNABLE: 실행 중 또는 실행간으 한 상태
 	BLOCKED:  동기화 블럭에 의해서 일지정지된 상태(락이 풀릴때 까지 기다리는 상태)
 	WAITING, TIMED_WAITING: 스레드의 작업이 종료되지는 않았지만 실행가능하지않은
 							일시정지 상태(TIMED_WAITING는 시간지정된 경우)
 	TERMINATED: 스레드의 작업이 종료된 상태
 */
public class T09_ThreadStateTest {

	public static void main(String[] args) {
		Thread target = new TargetThread();
		Thread spt = new StatePrintThread(target);

		spt.start();
	}
}

class TargetThread extends Thread {

	public void run() {
		for (long i = 1; i <= 10000000000l; i++) {
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (long i = 1; i <= 10000000000l; i++) {
		}
	}
}

//스레드의 상태를 출력하기 위한 스레드
class StatePrintThread extends Thread {

	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	@Override
	public void run() {
		while (true) {
			// Thread의상태 구하기
			Thread.State state = targetThread.getState();
			System.out.println("타겟스레드의 상태>> " + state);

			// NEW 상태인지 검사
			if (state == Thread.State.NEW) {
				targetThread.start();
			}
			// 타겟 스레드가 종료상태인지 검사
			if (state == Thread.State.TERMINATED) {
				break;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
