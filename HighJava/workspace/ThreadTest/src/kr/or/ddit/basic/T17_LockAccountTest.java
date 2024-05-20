package kr.or.ddit.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T17_LockAccountTest {
	/*
	 * 락기능을 제공하는 클래스 ReentrantLock: Read Write 구분없이 사용하기위한 락클래스 동기화 처리를 위해 사용한다
	 * syn~~를 이용한 동기화보다 부가적 기능이 제공됨 ex) Fairness설정 (가장 오래 기다린 스레드 가장 먼저)등
	 * 
	 * ReentrantReadWirteLock: Read및 Write락을 구분하여 사용가능 여러 스레드가 동시에 Read작업은 가능하지만
	 * Write작업은 하나의 스레드만 가능(exclusive) ==> Write보다 Read위주의 작업이 많이 발생할 경우 추천
	 */
	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock(true);

		// LockAccount에 전달
		LockAccount lAcc = new LockAccount(lock);
		lAcc.deposit(10000);

		BankTread2 th1 = new BankTread2(lAcc);
		BankTread2 th2 = new BankTread2(lAcc);

		th1.start();
		th2.start();

	}
}

//입출금 처리를 위한 공유객체
class LockAccount {

	private int balance;

	// Lock객체 생성=>> 되도록이면 private final로 설정한다
	private final Lock lock;

	public LockAccount(Lock lock) {
		this.lock = lock;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int money) {
		// Lock객체의 lock()메소드가 동기화 시작이고
		// unlock()메소드가 덩기화의 끝을 나타냄
		// lock()메소드로 동기화를 설정한 곳에서는 반드시 unlock()메서드로 해제해야함

		lock.lock();// 락설정(락 획득전까지 BLOCKED)됨
		balance += money;

		lock.unlock();

	}

	public boolean withdraw(int money) {

		boolean chk = false;

		//try~catch 블록을 사용할 경우 
		//unlock메서드 호출은 finally블럭에서 하도록한다
		try {
			lock.lock(); //동기화 시작
			if (balance >= money) {
				for (int i = 1; i <= 100000000; i++) {
					// 시간뗴우기
				}
				balance -= money;
				System.out.println("메서드 안에서 balacne: " + getBalance());
				chk = true;
			} else {
				chk = false;
			}
		} catch (Exception ex) {

		} finally {
			lock.unlock();
		}
		return chk;
	}
}

class BankTread2 extends Thread {

	private LockAccount lAcc;

	public BankTread2(LockAccount lAcc) {
		this.lAcc = lAcc;
	}

	public void run() {
		boolean result = lAcc.withdraw(6000);

		System.out
				.println(Thread.currentThread().getName() + " 스레드 안에서: " + result + ", balance: " + lAcc.getBalance());
	}
}
