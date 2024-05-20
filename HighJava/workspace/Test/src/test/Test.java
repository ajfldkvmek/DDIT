package test;

import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {

		String str = "/w adasdsa aasdasd sa asdsaddsdas";
		
		StringTokenizer st = new StringTokenizer(str);
		
		if( !(st.nextToken().equalsIgnoreCase("/W")) ) {
			System.out.println("Asdasd");
		}
		while(st.hasMoreTokens()) {
			
			System.out.println(st.nextToken());
		}
	}
}


//class Solution {
//    public int[] solution(int[] numbers) {
//
//    	int[] answer = new int[numbers.length];
//
//       for(int a = 0; a < (numbers.length - 1); a++) {
//    	   for(int b = a+1; b < numbers.length; b++) {
//    		   
//    		   if(numbers[a] < numbers[b]) {
//    			   answer[a] = numbers[b];
//    			   break;
//    		   } else {
//    			   answer[a] = -1;
//    		   }
//    	   }
//       }
//       
//       answer[numbers.length-1] = -1;
//
//        return answer;
//    }
//}