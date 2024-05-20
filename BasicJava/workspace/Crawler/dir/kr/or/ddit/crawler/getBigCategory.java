package kr.or.ddit.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class getBigCategory {
	
//	static List<String> bigCategory  = new ArrayList();
	static List<String> bLink  = new ArrayList();
	static List<String> bName  = new ArrayList();
	
	public static void bigCategory() {
		try {
			//국내도서 메인에서는 안뽑히고 특정 카테고리로 들어가야함 수정필요
			String url = "https://www.yes24.com/24/Category/Display/001001001";
			
			Document doc = Jsoup.connect(url).get();

			String str = doc.html();
			String[] line = str.split("\n");
					
			boolean con = true;
		
			//리스트별 끝 페이지 가져오기

			for (String s : line) {
				
				if(s.contains("<!-- 중카 끝 -->")) break;
				
				if(s.contains("data-submenu-id=\"mCateLi")) {
					s = s.replace("</em> </a> <span class=\"bitCock bgCateN\">&nbsp;</span> ", "").replace(" class=\"lnk_cate2d\"> <em class=\"txt\">", "")
							.replace(" onclick=\"setPcode('001_001')\" data-submenu-id=\"", "").replace("         <li class=\"cate2d\"> <a href=\"", "");				
				}
				else continue;
				
				String[] line_  = s.split("\"");
				for(String s2 : line_) {
					if(s2.contains("mCateLi")) continue;
					if(s2.contains("/24/Category/Display")) bLink.add(s2) ;
					else bName.add(s2);
				}	
				
				if (con) continue;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		|\/?*<>" 제거
		for(int a = 0; a < bLink.size(); a++)
			System.out.println(bLink.get(a) + " " + bName.get(a));
	}
}



//String endList = "";
//for (String s : line) {
//	if (s.contains("\"cate2d\"> <a href=\"/24/Category/Display/")) {
//		s = s.replaceAll(" ", "");					
//		String[] line_  = s.split("\"");
//		for(String s2 : line_) {
//			if(s2.contains("/24/Category/Display")) bigCategory.add(s2);						
//		}					
//	
//	}				
//	if (con) continue;
//}	