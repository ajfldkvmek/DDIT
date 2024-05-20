package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapExample3 {

	public static void main(String[] args) {
		
		MapExample3 me = new MapExample3();
		List<Map> l = me.dataInput(); //list에 map으로 만든 데이터 삽입
		
		int maxSal = me.getMaxSalary(l); //위에서 만든 리스트map에서 sal 최대값 구하기
		List addDept = me.getAddDept(l);
		
//		System.out.println("최고월급: " + maxSal);
		
		me.printEmp_no103(l);
	}	
	
	//eno103출력
	private void printEmp_no103(List<Map> l) {
		
		for(int i = 0; i < l.size(); i++) {
			
			Map m = l.get(i);
			
			Iterator it = m.keySet().iterator();			
			
			while(it.hasNext()) {
				String eno = (String) it.next();
				String value = (String) m.get(eno);
				System.out.println(value + "\t");
			}
			System.out.println();
			
//			for(Map map : l) {
//				String eno = (String) m.get("eno");				
//			}
			
//			String eno = (String)m.get("eno");
//			if(eno.equals("103")) {				
//				System.out.println(m);
//			}
		}
	}

	private List getAddDept(List<Map> l) {
		//각 부서 월급의 합
		ArrayList l2 = new ArrayList();
		HashMap sum = new HashMap();
		for(Map map : l) {
			String dept = (String) map.get("dept");
			String sal = (String) map.get("salary");
			int salint = Integer.parseInt(sal);
			//hashmap sum에 해당 dept 있으면 saling 가져와서 +
			if(sum.containsKey(dept)) salint += (int) sum.get(dept);
			//없으면 삽입
			sum.put(dept, salint);
		}
//		System.out.println(sum);
		
//		Iterator it = sum.keySet().iterator();
//		while(it.hasNext()) {
//			String key = (String) it.next();
//			int value = (int) sum.get(key);
//			l2.add(value);			
//		}
		return l2;
	}
	
	private int getMaxSalary(List<Map> l) {
	
		int maxSal = 0;		
		for(Map map : l) {
			String sal = (String) map.get("salary");			
			maxSal = maxSal < Integer.parseInt(sal) ? Integer.parseInt(sal) : maxSal;
			//maxSal = maxSal < Integer.valueOf(sal) ? Integer.valueOf(sal) : maxSal;
		}
				
		return maxSal;
	}


	public List<Map> dataInput(){
		
		HashMap map1 = new HashMap();
		HashMap map2 = new HashMap();
		HashMap map3 = new HashMap();
		HashMap map4 = new HashMap();
		HashMap map5 = new HashMap();
		
		map1.put("eno", "100");
		map1.put("ename", "장승수");
		map1.put("dept", "영업부");
		map1.put("telno", "01084228117");
		map1.put("salary", "300");
		
		map4.put("eno", "103");
		map4.put("ename", "강나미");
		map4.put("dept", "영업부");
		map4.put("telno", "0108422999");
		map4.put("salary", "350");
		
		map2.put("eno", "101");
		map2.put("ename", "홍성범");
		map2.put("dept", "기획부");
		map2.put("telno", "01075623127");	
		map2.put("salary", "350");
		
		map3.put("eno", "102");
		map3.put("ename", "이만수");
		map3.put("dept", "기획부");
		map3.put("telno", "01032323127");	
		map3.put("salary", "500");
		
		map5.put("eno", "104");
		map5.put("ename", "이이이");
		map5.put("dept", "총무부");
		map5.put("telno", "01032323777");	
		map5.put("salary", "250");
		
		ArrayList l = new ArrayList();
		l.add(map1);
		l.add(map2);
		l.add(map3);
		l.add(map4);
		l.add(map5);
				
		return l;
	}
	

}
