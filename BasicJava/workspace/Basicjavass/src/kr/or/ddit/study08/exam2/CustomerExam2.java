package kr.or.ddit.study08.exam2;

public class CustomerExam2 {

	public static void main(String[] args) {
		
		//같은 줄 학생 이름 넣어서 클래스 배열 생성해 볼 것
		
		Customer[] cArr = new Customer[4];
		
		cArr[0] = new Customer("aaa", "111", "k1", 22);
		cArr[1] = new Customer("bbb", "222", "k2", 25);
		cArr[2] = new Customer("ccc", "333", "k3", 26);
		cArr[3] = new Customer("ddd", "444", "k4", 27);
		cArr[3] = new Customer("eee", "555", "k4", 27);
		
		for(int a = 0; a < cArr.length; a++) {
			System.out.println(cArr[a]);
		}
		
		
		/*
		 *		 
		 Customer cArr = {new Customer("qwe", "123", "k1", 22),
		 				  new Customer("qwe", "123", "k1", 22),
		 				  new Customer("qwe", "123", "k1", 22),
		 				  new Customer("qwe", "123", "k1", 22);	 					
		 				}	도 가능
		 * 
		 */
	}
}
