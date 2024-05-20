package util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProdMain_div {

	static Scanner sc = new Scanner(System.in);
	
	static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public static void main(String[] args) {
	
		System.out.println("상품카테고리를 선택하세요");
		List<Map<String, Object>> list = Category();
		
		//go to category
		List<Map<String, Object>> prodlist = selectCate(list);

		/*
		 * 내가 원하는 상품을 선택 한 후 해당 물품 수량을 물어봄
		 * 해당하는 수량만큼 카트에 담기
		 */
		buyProd(prodlist);

		
	}
	
 	private static void buyProd(List<Map<String, Object>> prodlist) {
		// TODO Auto-generated method stub
		List cart = new ArrayList();
		int num = 1;
		
		for(Map<String, Object> map : prodlist) {
			
			String prod_name =  (String) map.get("PROD_NAME");
			BigDecimal prod_cost =  (BigDecimal) map.get("PROD_COST");
			String prod_color =  (String) map.get("PROD_COLOR");			
			String prod_outline =  (String) map.get("PROD_OUTLINE");			
			System.out.println((num++)+ " " + prod_name + " " + prod_cost + " " + prod_color + " " + prod_outline);
		}
		
		
		int select = sc.nextInt()-1;		
		Map selectMap = prodlist.get(select);
		System.out.println(selectMap.get("PROD_NAME") + "를 몇개 구입하실?");
		
		int count = sc.nextInt();
		
		for(int i = 0; i < count; i++) {
			cart.add(selectMap);
		}
		
	}

 	
 	

	public static List<Map<String, Object>> Category() {
		String sql = "SELECT * FROM LPROD";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		for(Map<String, Object> map: list) {
			System.out.println(map.get("LPROD_ID") + ". " + map.get("LPROD_NM"));
		}
 		return list;	
 	}
 	
 	public static List<Map<String, Object>> selectCate(List<Map<String, Object>> list) {
 		
		int select = sc.nextInt();
		String select_gu = "";
		
		for(Map<String, Object> map: list) {
			BigDecimal bd = (BigDecimal) map.get("LPROD_ID");//			
			if(bd.toString().equals(select+"")) {
				select_gu = (String) map.get("LPROD_GU");
			}
		}
		

		String sql = "SELECT * FROM PROD WHERE PROD_LGU = '" + select_gu + "'";
		List<Map<String, Object>> prodlist = jdbc.selectList(sql);
 		
 		return prodlist;
 	}
}
