package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T06_ThreadTest {
	
	public static boolean INPUT_CHECK = false;
	
	public static void main(String[] args) {
		Thread th1 = new DateInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
	}
}

class DateInput extends Thread {
	public void run() {
		String str = JOptionPane.showInputDialog("입력 ㄱ");
		
		T06_ThreadTest.INPUT_CHECK = true;
		
		System.out.println("입력한 값은 " + str);
	}
}

class CountDown extends Thread {
	public void run() {
		for (int i = 10; i >= 0; i--) {
		
			//입력이 완료되었는지 검사하고 완료되면 run()종료
			
			if(T06_ThreadTest.INPUT_CHECK) {
				//스레드종료
				return;
				//메서드, 종료되면 해당 스레드도 종료
			}
				
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("10초 지남 자동 종료");
		System.exit(0); //프로그램 종료 명령
	}
}
