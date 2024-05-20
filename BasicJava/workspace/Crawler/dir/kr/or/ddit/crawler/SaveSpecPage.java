package kr.or.ddit.crawler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SaveSpecPage {

//	스레드2 	
//	이 클래스는 savefile메소드를 호출하여 단순히 저장만을 위함
//	인코딩방식 다르면 깨질 수 있음 ==> "euc-kr" -> "utf-8"
//	str = str.replaceAll("euc-kr", "utf-8");
//	파일저장 key:주소(파일명), str: html코드(내용)
//	SaveFile.createfile(key, str);
	
	public static void savePage(String s) {
		
		try {
			String url = "https://www.yes24.com" + s;
			Document doc = Jsoup.connect(url).get();
			String str = doc.html();
			str = str.replaceAll("euc-kr", "utf-8");
			SaveFile.createfile(s, str);	
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void savePage(Map<String, String> specMap) {

		try {
			Iterator keys = specMap.keySet().iterator();
			while (keys.hasNext()) {
				
				String key = (String) keys.next();
				System.out.println(key);
				String url = "https://www.yes24.com" + key;
				Document doc = Jsoup.connect(url).get();
				String str = doc.html();

				//인코딩방식 다르면 깨질 수 있음 ==> "euc-kr" -> "utf-8"
				str = str.replaceAll("euc-kr", "utf-8");

				//파일저장 key:주소(파일명), str: html코드(내용)
				SaveFile.createfile(key, str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void savePage(List<String> specPage) {

		try {

			for (int p = 0; p < specPage.size(); p++) {

				String goods = specPage.get(p);
				String url = "https://www.yes24.com" + goods;
				Document doc = Jsoup.connect(url).get();
				String str = doc.html();

				str = str.replaceAll("euc-kr", "utf-8");

				SaveFile.createfile(goods, str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
