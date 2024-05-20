package kr.or.ddit.basic;

class AutoSaveThread extends Thread {
	
	public void save() {
		System.out.println("작업내용을 저장합니다");
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
				save(); //저장기능호출
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class T08_DamonThread {
	public static void main(String[] args) throws InterruptedException {
		
		Thread th = new AutoSaveThread();
		
		//데몬 스레드 설정하기(start 호출하기 전에 설정해야함)
		//데몬스레드는 일반스레드가 있을 때만 동작함
		//일반스레드 종료되면 데몬스레드는 알아서 죽음
		th.setDaemon(true);
		
		th.start();
		
		for(int i = 1; i <= 20; i++) {
			System.out.println("작업- " + i);
			Thread.sleep(1000);
		}
		
		System.out.println("메인스레드 종료");
	}
}
