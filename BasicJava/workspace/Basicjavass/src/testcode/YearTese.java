package testcode;
import java.util.Scanner;

public class YearTese {

	public static void ytest() {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int year = 0;
			String y="";
			int month = 0;
			String m="";
			int day = 0;
			String d="";
			int err = 0;

			int date = sc.nextInt();

			day = date % 100;
			month = (date % 10000 - day) / 100;
			year = date / 10000;
			
			
			if(month < 1 || month > 12) err=-1;
			else if(month == 2) {
				if(day <= 0 || day > 28) err=-1;						
			}

			else if(month == 4||month == 6||month == 9||month == 11) {
				if(day <= 0 || day > 30) err=-1;
			}
			
			else {
				if(day <= 0 || day > 31) err=-1;
				
			}
			
			if(year < 0 || year > 9999) err=-1;
			else if(year < 10) y="000"+year;
			else if(year < 100) y ="00"+year;
			else if(year < 1000) y = "0"+year;
			else y = Integer.toString(year);
			
			if(day < 10) d = "0"+day;
			else d = Integer.toString(day);
			
			if(month < 10) m = "0"+month;
			else m = Integer.toString(month);		
			
			if(err == 0) System.out.println("#"+test_case+" "+y+"/"+m+"/"+d);
			else System.out.println("#"+test_case+" "+err);
		}

		sc.close();
	}
}
