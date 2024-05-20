package kr.or.ddit.enumtest;

public class EnumTest {
	
	public static void main(String[] args) {

//		WEEK fri = WEEK.FRI;
		
		String week = "FRI";
		if(week.equals("friday")) {
			System.out.println("금요일 입니다");
		}

		for(WEEK w : WEEK.values()){
			if(w == WEEK.FRI) {
				System.out.println("금요일 입니다");
			}			
		}
	}
	
}
