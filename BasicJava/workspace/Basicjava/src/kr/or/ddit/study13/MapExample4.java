package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapExample4 {
	
	public static void main(String[] args) {
//		기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
//		180	5000	10	600
		
		MapExample4 mp4 = new MapExample4();
		
		List<Map> l = mp4.dataInput();
//		mp4.printAll(l);
//		System.out.printf("5961번의 총 주차 시간은 %d분 입니다" , mp4.getMin(l, "5961"));
		int min = mp4.getMin(l, "5961");
		int money = mp4.pay(min);
		
		System.out.printf("5961의 주차시간은 %d분, 총 금액은 %d원 입니다", min, money);
	}
	
	private int pay(int min) {
		// TODO Auto-generated method stub
			
		if(min > 180) {
			min = min - 180;
			min = min/10;
			return 5000 + min*600;
		}
		else return 5000;
		
	}

	private int getMin(List<Map> l, String number) {
		
		ArrayList<Map> l2 = new ArrayList();
		
//		for(int i = 0; i < l.size(); i++) {
//			Map map = l.get(i);
//			String numbers = (String) map.get("차량번호");
//			if(number.equals(numbers)) System.out.println(map.get("내역") + ": " + map.get("시각"));			
//		}
		
		for(Map map : l) {
			String numbers = (String) map.get("차량번호");
			if(!number.equals(numbers)) continue;			
			l2.add(map);			
		}
//		for(int i = 0; i < l2.size(); i++) System.out.println(l2.get(i));
		
		String in = "";
		String out = "";
		int result = 0;
		
		for(int i = 0; i < l2.size(); i++) {
			Map m = l2.get(i);
			
			String cond = (String) m.get("내역");
			String time = (String) m.get("시각");
			
			//내역이 입차라면 in에 시각 입력
			//출차라면 out에 시각 입력 + 주차시간 구하기
			if(cond.equals("입차")) in = time;
			else { 
				out = time;
				int t1 = getTime(in);
				int t2 = getTime(out);
				//총 주차시간
				result += (t2-t1);			
			}			
		}
		return result;
	}

	public int getTime(String t) {
		String[] token = t.split(":");
		
		int hour = Integer.parseInt(token[0]) * 60;
		int min = Integer.parseInt(token[1]);
		
		return hour + min;
	}
	
	public void printAll(List<Map> l) {
		
//		for(int i = 0; i < l.size(); i++) {
//			Map m = l.get(i);
//			System.out.println(m);
//		}
//		
		for(int i = 0; i < l.size(); i++) {
			Map map = l.get(i);
			Iterator it = map.keySet().iterator();
			while(it.hasNext()) {
				String key = (String) it.next();
				String value = (String) map.get(key);
				System.out.print(key + ": " + value+"\t");
			}
			System.out.println();
		}	
	}

	
	public List<Map> dataInput(){
		
//		시각(시:분)차량 번호	 내역
//		05:34	5961	 입차
//		06:00	0000	 입차
//		06:34	0000	 출차
//		07:59	5961	 출차
		
//		07:59	0148	 입차
//		18:59	0000	 입차
//		19:09	0148	 출차
//		22:59	5961	 입차
//		23:00	5961	 출차
		
		HashMap map1 = new HashMap();
		HashMap map2 = new HashMap();
		HashMap map3 = new HashMap();
		HashMap map4 = new HashMap();
		HashMap map5 = new HashMap();
		HashMap map6 = new HashMap();
		HashMap map7 = new HashMap();
		HashMap map8 = new HashMap();
		HashMap map9 = new HashMap();
		
		map1.put("시각", "05:34");
		map1.put("차량번호", "5961");
		map1.put("내역", "입차");
		
//		06:00	0000	 입차
//		06:34	0000	 출차			
		map2.put("시각", "06:00");
		map2.put("차량번호", "0000");
		map2.put("내역", "입차");
		
		map3.put("시각", "06:34");
		map3.put("차량번호", "0000");
		map3.put("내역", "출차");	
		
		map4.put("시각", "07:59");
		map4.put("차량번호", "5961");
		map4.put("내역", "출차");
		
//		07:59	0148	 입차
		map5.put("시각", "07:59");
		map5.put("차량번호", "0148");
		map5.put("내역", "입차");
		
		
//		18:59	0000	 입차		
		map6.put("시각", "18:59");
		map6.put("차량번호", "0000");
		map6.put("내역", "입차");
		
//		19:09	0148	 출차
		map7.put("시각", "07:59");
		map7.put("차량번호", "0148");
		map7.put("내역", "출차");		
		
//		22:59	5961	 입차
//		23:00	5961	 출차
		map8.put("시각", "22:59");
		map8.put("차량번호", "5961");
		map8.put("내역", "입차");
		
		map9.put("시각", "23:00");
		map9.put("차량번호", "5961");
		map9.put("내역", "출차");
		
		ArrayList l = new ArrayList();
		l.add(map1);
		l.add(map2);
		l.add(map3);
		l.add(map4);
		l.add(map5);
		l.add(map6);
		l.add(map7);
		l.add(map8);
		l.add(map9);
		
		return l;
	}
}
