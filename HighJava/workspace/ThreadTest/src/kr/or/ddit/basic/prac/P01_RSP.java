package kr.or.ddit.basic.prac;

import java.util.Random;

import javax.swing.JOptionPane;

public class P01_RSP {

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
		Random rand = new Random();
		String str = JOptionPane.showInputDialog("가위/바위/보 중 하나 입력(5초내로)");

		P01_RSP.INPUT_CHECK = true;
		int you = 0;
		int com = rand.nextInt(3);
		String[] c = {"가위", "바위", "보"};
		// 0:가위, 1:바위, 2:보 로 하자고
		System.out.println("당신의 입력: " + str);
		if (str.equals("가위")) {
			you = 0;
		} else if (str.equals("바위")) {
			you = 1;
		} else if (str.equals("보")) {
			you = 2;
		} else {
			System.out.println("잘못입력 니가 짐");
			System.exit(0);
		}
		System.out.println("컴퓨터: " + c[com]);
		if(you == com) {
			System.out.println("무승부");
		} else if((com == 0 && you == 2) ||
					(com == 1 && you == 0) ||
					 (com == 2 && you == 1)){
				System.out.println("컴승리");
		} else {
			System.out.println("니승리");
		}
	}
}

class CountDown extends Thread {
	public void run() {
		for (int i = 5; i >= 0; i--) {
			// 입력이 완료되었는지 검사하고 완료되면 run()종료
			if (P01_RSP.INPUT_CHECK) {
				// 스레드종료
				return;
				// 메서드, 종료되면 해당 스레드도 종료
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("5초 지남 니가짐");
		System.exit(0); // 프로그램 종료 명령
	}
}
