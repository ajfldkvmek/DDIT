package print;

import java.util.List;

import vo.Event;

public class EventPrint {


	public void printEvent() {
		// TODO Auto-generated method stub
		System.out.println("1.문화행사 목록보기");
		System.out.println("2.내 문화행사 확인");
		System.out.println("99.뒤로가기");
	}
	
	
	public void printEventList(List<Event> list) {
		
		System.out.println("행사번호\t행사명\t시간\t");
		for(Event e : list)
			System.out.println(e.getEvt_no() +"\t"+ e.getEvt_name() +"\t"+ e.getEvt_time());
	}
}
