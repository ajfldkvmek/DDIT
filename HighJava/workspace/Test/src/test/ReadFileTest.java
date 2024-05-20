package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ReadFileTest {

	static Map<String, String> room = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		String str = "";
		StringTokenizer st;
		String key = "";
		String value = "";
		try {
			fr = new FileReader("D:/D_Other/room.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		
		try {
			while((str = br.readLine()) != null) {
				st = new StringTokenizer(str);
				while(st.hasMoreTokens()) {
//					System.out.println(st.nextToken());
					key = st.nextToken();
					value = st.nextToken();
					
					room.put(key, value);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
