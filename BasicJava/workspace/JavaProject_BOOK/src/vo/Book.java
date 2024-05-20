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
public class Book {
//	 private Date regdate2;
	 private int no;
	 private String name;
	 private String pub;
	 private String writer;
	 private String regdate;
	 private int reg_price;
	 private int sale_price;
	 private String content;
	 
//	 public void setRegDate(Date regdate) {
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
//		 this.regdate2 = sdf.format(regdate);
//		 this.regdate = regdate;
//	 }
	 
}
