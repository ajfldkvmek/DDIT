package controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import util.JDBCUtil;

public class Controller {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();
	static JDBCUtil jdbc = JDBCUtil.getInstance();
	

	public static void main(String[] args) {
		
		//SELECT TO_CHAR(JOIN_DATE ~~ ) as JOIN_DATE ~~ 같이 스트링으로 날짜 받아오는게 편할수도
		String sql = "SELECT ID, NAME, JOIN_DATE, PHONE FROM MB WHERE DELYN IS NULL";
//		String dsql = "DELETE FROM MB WHERE ID = 'test2'";
//		jdbc.update(dsql);
		
//		Map map = jdbc.selectOne(sql);
//		System.out.println(jdbc.selectOne(sql));
//		Map map = jdbc.selectOne(sql);
//		String obj = map.get("JOIN_DATE").toString();
//		System.out.println(obj);
		
		/*
		 * 회원전체 리스트 출력, 비밀번호는 노출X 
		 */
		
		List<Map<String, Object>> list = jdbc.selectList(sql);

//		Set set = m.entrySet();
//		Iterator it = set.iterator();
//		while (it.hasNext()) {
//			String id = (String) m.get("ID");
//			String name = (String) m.get("NAME");
//			String joindate = (String) m.get("JOIN_DATE");			
//		
//			System.out.println(id + "  " + name + "  " + joindate);	
		
		for(Map m : list) {
			String id = (String) m.get("ID");
			String name = (String) m.get("NAME");
//			String phone = (String) m.get("PHONE");
//			Date joindate = (Date) m.get("JOIN_DATE");
			String joindate2 =  m.get("JOIN_DATE").toString();
			//날짜 형식 맞추기
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");
			
			try {
				Date d = sdf.parse(joindate2);
				String res = sdf2.format(d);
				joindate2 = res;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("id: " + id +"\tname: " + name + "\tjoindate: " + joindate2);					
		}
		
		//날짜 형식 맞추기
		
//		Iterator<String> keys = map.keySet().iterator();
//        while( keys.hasNext() ){
//            String key = keys.next();
//            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
//        }		
		
	}	
}
