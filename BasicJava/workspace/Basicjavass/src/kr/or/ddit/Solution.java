package kr.or.ddit;

public class Solution {
	
	public static void main(String[] args) {
		String[] str = new String[5];
		
		str[0] = "a";
		str[1] = "b";
		str[2] = "c";
		str[3] = "d";
		str[4] = "e";
		
		
		for(int i = 0; i < 3; i++) {
			str[i] = str[i+1];
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.println(str[i]);
		}
	}
	
}
