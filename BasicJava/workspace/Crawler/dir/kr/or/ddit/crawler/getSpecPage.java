package kr.or.ddit.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sound.midi.Soundbank;

import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//각 페이지리스트에서 상세페이지 주소 출력  ->> 이거도맵으로받는게나으려나?
//여기서 주소 던져주면, 페이지 저장클래스에서 주소내용+링크(파일이름으로) 저장
//리스트들의 페이지를 하나 씩 돌면서 상세페이지를 저장 < 혹시 모를 중복 제거위해 맵 사용 vs 그냥 파일생성에서 같은 이름 있으면 안만들기
//장단: 맵은 순서보장이 안되기 때문에 파일 생성 순서가 랜덤임 하지만 중복이 없기 때문에 파일 저장시 효율적
//리스트로 저장할 경우 파일 생성시 오류 메세지 여러번 출력가능

public class getSpecPage {

	static List<String> specPage = new ArrayList<String>();
	static Map<String, String> specMap = new HashMap();
	
	//map from getListPage
	public static void getSpec(Map<String, Integer> specmap) {
		
		// 여기서 각 리스트 페이지별로 value만큼 반복문 돌려서 상세페이지 리스트에 저장
		try {
			String pName = "?PageNumber=";

			Set set = specmap.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {

				Entry<String, Integer> entry = (Entry) iterator.next();
				String key = (String) entry.getKey();
				int value = (Integer) entry.getValue();
				
				for (int v = 0; v < value; v++) {

					String fp = "https://www.yes24.com" + key + pName + v;
					
					Document doc = Jsoup.connect(fp).get();
					String str = doc.html();
					String[] line = str.split("\n");

					boolean con = true;

					for (String s : line) {

						if (s.contains("<!--검색엔진 사용여부-->"))
							break;

						if (s.contains("goods_imgSet")) {
							con = false;

							String[] str2 = s.split(" ");
							boolean con2 = true;
							for (String s2 : str2) {
								if (s2.contains("href=\"/Product/Goods/")) {
									s2 = s2.replaceAll("href=\"", "");
									s2 = s2.replaceAll("\">", "");

									con2 = false;
									break;
								}
								if (con2) continue;
							}
							con = false;
						}
						if (con) continue;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}

//try {
//	
//	String url = list.get(a);
//	Document doc = Jsoup.connect("https://www.yes24.com"+url).get();
//	
//	String str = doc.html();
//	String[] line = str.split("\n");
//	//String s1= "<p class=\"goods_img\"> <span class=\"goods_imgSet\"> <span class=\"goods_imgSet\">";
//	
//	boolean con = true;
//	
//	for(String s : line) {
//		
//		if(s.contains("<!--검색엔진 사용여부-->")) break;
//		
//		if(s.contains("<span class=\"imgBdr\"> <a href=\"")) {
//		
//			String[] str2 = s.split(" ");
//			boolean con2 = true;
//			for(String s2 : str2) {
//				if(s2.contains("href=\"/Product/Goods/")) {
//					s2 = s2.replaceAll("href=\"", "yes24.com");
//					s2 = s2.replaceAll("\">", "");
//					System.out.println(s2);
//					con2 = false;
//				}
//				if(con2) continue;
//			}
//			
//			con = false;
//		}
//		if(con) continue;				
//	}
//	
//} catch (IOException e) {
//	e.printStackTrace();
//}

//public static void getSpec(List<String> list, List<Integer> page) {
//	
//	List<String> speclist = new ArrayList();
//
//	for(int a = 0; a < list.size(); a++) {
//		
//		try {
//			//
//			String pName = "?PageNumber=";
//			String url = list.get(a);
//			int lpage = page.get(a);
//			
//			
//			//여기서 각 리스트 페이지별로 lpage만큼 반복문 돌려서 상세페이지 출력				
//			for(int p = 0; p < lpage; p++) {
////				"https://www.yes24.com"+ url + pName + lpage
//				String fp = "https://www.yes24.com"+url+pName+p;
//				
//				Document doc = Jsoup.connect(fp).get();
//				String str = doc.html();
//				String[] line = str.split("\n");
//				
//				String contents = "";
//				boolean con = true;
//				
//				//각 하위카테고리들의 리스트로 들어가서 마지막까지 상세페이지 가져오기
//				String name = null;
//				for(String s : line) {
//					
//					if(s.contains("euc-kr")) {
//						s = s.replaceAll("euc-kr", "utf-8");
//					}						
//					contents += s+"\n";
//					
//					if(s.contains("<!--검색엔진 사용여부-->")) break;
//					
//					if(s.contains("goods_imgSet")) {							
//						con = false;
//						
//						String[] str2 = s.split(" ");
//						boolean con2 = true;
//						for(String s2 : str2) {
//							if(s2.contains("href=\"/Product/Goods/")) {
//								s2 = s2.replaceAll("href=\"", "");
//								s2 = s2.replaceAll("\">", "");
//								name = s2;
//								con2 = false;
//								break;
//							}
//							if(con2) continue;
//						}
//					
//						con = false;
//					}
//					if(con) continue;				
//				}
//				
//				specPage.add(name);
//				System.out.println(name);
//				break;
//			}
//		
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}		
//	
////	SaveSpecPage.sav