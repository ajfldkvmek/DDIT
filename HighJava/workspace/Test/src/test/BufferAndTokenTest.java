package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BufferAndTokenTest {
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st; 
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		st = new StringTokenizer(str);
		
		List<Integer> list = new ArrayList<Integer>();
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
		}
		
		System.out.println("리스트의 길이>>" + list.size());
		
		for (Integer integer : list) {
			System.out.print( integer + " ");
		}
	}
}
