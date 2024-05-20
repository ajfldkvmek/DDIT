package kr.or.ddit;

import java.util.Arrays;

//import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		
		Solution s = new Solution();
//		s.solution("10203", "15");
		
	}


    public void solution() {

    	
    }
    
    
    public String bin(int num, int n) {
    	
    	String s1 = "";    	
    	while(true) {    		
    		s1 = num%2+s1;
    		num=num/2;    		
    		if(num <= 0) break;
    	} 
    	
    	if(s1.length() < n) {
    		for(int i = s1.length(); i < n; i++) {
    			s1 = 0+s1;
    		}
    	}
    	return s1;
    }
}
