package kr.or.ddit.study11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
	
	static boolean debug = false;
	
	public static void main(String[] args) {
		DateExample de = new DateExample();
//		de.dateMethod();
//		de.dateMethod2();
//		de.dateMethod3();
//		de.dateMethod4();
		de.dateMethod5();
	}

	private void dateMethod5() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance(); //<--싱글톤객체
		cal.set(Calendar.YEAR, 22);
		cal.set(Calendar.DATE, 1);
		Date date = cal.getTime();
		System.out.println(cal.getTime());
		cal.add(Calendar.MONTH, 1); //MONTH, DATE 등
		System.out.println(cal.getTime());
	}

	private void dateMethod4() {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		long time = 1000*60*60*24*7;
		
		String dateStr = sdf.format(d);
		System.out.println(dateStr);
		Date d2 = new Date(d.getTime()+time);
		System.out.println(d2);
	}

	private void dateMethod3() {
		// TODO Auto-generated method stub
		String dateStr = "2023-10-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf.parse(dateStr);
			Date cur = new Date();
			long milSec = cur.getTime() - d.getTime();
			milSec = milSec/1000;
			System.out.println(milSec);
			System.out.println(milSec/60);
			System.out.println(milSec/60/60);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dateMethod2() {
		// TODO Auto-generated method stub
		String dateStr = "2023-10-30";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			Date d = new Date();
			Date yesterday = sdf.parse(dateStr);
			System.out.println(yesterday);
			long time1 = d.getTime();
			long time2 = yesterday.getTime();
			long time3 = time1-time2;
			System.out.println(time1);
			System.out.println(time2);
			System.out.println(time3);
			System.out.println(time3/1000);
			
			

			
		} catch (ParseException e){
			e.printStackTrace();
		}
	}

	private void dateMethod() {
		// TODO Auto-generated method stub
		if(debug) System.out.println("method 1");
		
		String date = "2023-10-02";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		Date d1 = new Date();
		System.out.println(d1);
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		
		
		Date d2 = new Date();
		System.out.println(d2);
		
		
		double time = d2.getTime() - d1.getTime();
		System.out.println(time/1000);
		
		System.out.println(d1.getTime());
		System.out.println(d2.getTime());
		
//		double dd1 = d1.getTime();
		
	}
}
