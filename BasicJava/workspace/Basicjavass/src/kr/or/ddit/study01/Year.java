package kr.or.ddit.study01;

//1년은 365.2422일 이것을 xxx일 xx시간 xx분 xx초 로 나타내라
public class Year {

	public static void main(String[] args) {
		
        double dyear=365.2422;
        int year=(int)dyear;
        //System.out.println(year);

        //double remain = dyear - year;
        double dsec = 86440 * 0.2422; //0.2422일을 초로 계산
        //System.out.println(dsec);

        double dhour = dsec / 3600;
        int hour = (int) dhour;
       // System.out.println(dhour);
       // System.out.println(hour);

        double dmin = dsec - (hour*3600); //전체 초에서 시간 뺀 나머지 초
        //System.out.println(dmin);

        int min = (int) (dmin/60);
        //System.out.println(min);

        int sec = (int) dmin - (min*60);
       // System.out.println(sec);

        System.out.println("1년은 "+year+"일 "+hour+"시간 "+min+"분 "+sec+"초");
						
	}
}

