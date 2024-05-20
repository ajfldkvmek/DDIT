package kr.or.ddit.basic;

public class T16_SyncAccountTest {

	public static void main(String[] args) {

		SyncAccount sAcc = new SyncAccount();
		sAcc.deposit(10000);

		BankThread th1 = new BankThread(sAcc);
		BankThread th2 = new BankThread(sAcc);

		th1.start();
		th2.start();
	}
}

//은행 입출금을 관리하기 위한 공유클래스
class SyncAccount {

	private int balance;

	synchronized public int getBalance() {
		return balance;
	}

	public void deposit(int money) {
		balance += money;
	}

	// 출금처리위한 메소드(ㄱ:true /ㄴ: false)
	// 동기회 영역에서는 호출하는 메서드(여기서는 getBalance)도 동가화 처리를 해주어야 한다
	synchronized public boolean withdraw(int money) {
//	public boolean withdraw(int money) {
//		synchronized (this) {
			if (balance >= money) {
				for (int i = 1; i <= 1000000000; i++) {
					// 시간 뗴우기
				}
				balance -= money;
				System.out.println("메서드 안에서 " + getBalance());
				return true;
			} else {
				return false;
			}
//		}
	}
}

class BankThread extends Thread {
	private SyncAccount sAcc;

	public BankThread(SyncAccount sAcc) {
		this.sAcc = sAcc;
	}

	public void run() {
		boolean result = sAcc.withdraw(6000);
		System.out.println("스레드 안에서 result = " + result + ", " + "balance = " + sAcc.getBalance());
	}
}