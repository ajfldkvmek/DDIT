package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.LprodVo;
import vo.ProdVo;

public class ProdMain3 {
	
	static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public static void main(String[] args) {
		String sql = "SELECT * FROM LPROD";
		List<Map<String, Object>> l = jdbc.selectList(sql);
		List<LprodVo> lprodList = ConvertUtils.convertToValueObjects(l, LprodVo.class);
		for(LprodVo lv : lprodList) {
			System.out.println(lv.getLprod_id()+". "+lv.getLprod_nm());
		}
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt()-1;
		LprodVo lv = lprodList.get(select);
		
		/*
		 *  1. 컴퓨터제품
			2. 전자제품
			3. 여성캐주얼
			4. 남성캐주얼
			5. 피혁잡화
			6. 화장품
			7. 음반/CD
			8. 도서
			9. 문구류
			
			값을 출력 하도록 하는 *쿼리* 를 만들고
			1을 선택시 컴퓨터 제품을 출력 하도록 해보기. 
		 */
//		System.out.println(lv.getLprod_gu());
		//"SELECT * FROM PROD WHERE PROD_LGU = '" + lv.getLprod_gu() + "'"	
		String lprod_gu = lv.getLprod_gu();
		sql = "SELECT * FROM PROD WHERE PROD_LGU = '" + lprod_gu + "'";
		
		List<Map<String, Object>> pl = jdbc.selectList(sql);
		List<ProdVo> prodList = ConvertUtils.convertToValueObjects(pl, ProdVo.class);
		
//		System.out.println(prodList);
		
		int num = 1;
		for(ProdVo pv : prodList) {
			String prod_name = pv.getProd_name();
			String prod_color = pv.getProd_color();
			BigDecimal prod_cost = pv.getProd_cost();
			String prod_outline = pv.getProd_outline();
			System.out.println(prod_name + " " + prod_color + " " + prod_cost + " " + prod_outline);
			num++;
			
		}
	}
}
