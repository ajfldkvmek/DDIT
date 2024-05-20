package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Member {
	 private int no;
	 private String st_bus;
	 private String ed_bus;
	 private String bus_cls;
	 private String company;
	 private int price;
	 private int sit_no;
	 private Date de_time;
	 
	 private String de_time2;
	 
	 public String getTime() {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 return sdf.format(de_time);
	 }
	 
}
