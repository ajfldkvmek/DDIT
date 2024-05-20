package util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import vo.LprodVo;

public class ProdMain2 {

	
	static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public static void main(String[] args) {
		

		String sql = "SELECT * FROM LPROD";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		
		for(Map<String, Object> map: list) {
			System.out.println(map.get("LPROD_ID") + ". " + map.get("LPROD_NM"));
		}
		
		System.out.println("어디로갈까");
		
		Scanner sc = new Scanner(System.in);
		
		int select = sc.nextInt()-1;
		
		Map selMap = list.get(select);
		System.out.println(selMap);
		
		BigDecimal lprod_id = (BigDecimal) selMap.get("LPROD_ID");
		String lprod_gu = (String) selMap.get("LPROD_GU");
		String lprod_nm = (String) selMap.get("LRPOD_NM");

		LprodVo lprod = new LprodVo();
		lprod.setLprod_gu(lprod_gu);
		lprod.setLprod_id(lprod_id);
		lprod.setLprod_nm(lprod_nm);
		
		ConvertUtils.convertToValueObject(selMap, LprodVo.class);
 	}
}
