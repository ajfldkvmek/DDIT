package kr.or.ddit.crawler;

public class CrawlTest {

	public static void main(String[] args) {

//		getLinkFromList getL = new getLinkFromList();
//		getSpecPage getS = new getSpecPage();
		
		System.out.println("start");
		getBigCategory.bigCategory();
		System.out.println("-----------getBigCategory done-----------");
			
		getMiddleCategory.middleCate(getBigCategory.bLink, getBigCategory.bName);
		System.out.println("-----------getMiddleCategory done-----------");
////
		getLinkFromList.getList(getMiddleCategory.mLink, getMiddleCategory.mName);
//		System.out.println(getLinkFromList.map);
		System.out.println("---------------done------------");
//		// ------------------- getSpec가 너무 오래 걸림 ->> thread 사용
//		getSpecPage.getSpec(getListPage.map);		
//		System.out.println("-----------getSpecPage done-----------");
	
	}
}
