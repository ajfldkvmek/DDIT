package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T05_ThreadTest {

	public static void main(String[] args) {
		
		String str = JOptionPane.showInputDialog("입력 ㄱ");
		
		System.out.println("입력한 값은 " + str);
		
		for(int i = 10; i>=0; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
				
	}
}
