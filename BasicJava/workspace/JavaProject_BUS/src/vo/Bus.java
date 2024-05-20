package vo;

import java.text.SimpleDateFormat;

/*vo 자동완성 쿼리
 * SELECT 
      ' private '||
      DECODE( DATA_TYPE , 'NUMBER', 'int ', 'String ' )||
      LOWER(COLUMN_NAME)||';'
	FROM COLS
WHERE TABLE_NAME = 'PROD'
ORDER BY COLUMN_ID;

 */

import lombok.Data;

@Data
public class Bus {
	 private int id;
	 private String company;
	 private String grade;
	 private String orig;
	 private String dest;
	 private String time;
	 private int price;
	 private int seat_resv;
	 private int seat;
}
