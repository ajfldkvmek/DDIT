package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SaveFileTest {

	static Map<String, String> room = new HashMap<>();

	public static void main(String[] args) {

		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("D:/D_Other/room.txt");
			bw = new BufferedWriter(fw);

			if (room.isEmpty()) {
				System.out.println("전부 공실임");
			} else {
				Iterator<String> keys = room.keySet().iterator();
				while (keys.hasNext()) {
					String key = keys.next();
					String value = room.get(key);
					bw.write(key + " " + value+"\n");
				}
			}
			System.out.println("작업 끝");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
