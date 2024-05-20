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
public class Product {
	 private String no;
	 private String name;
	 private int price;
	 private String text;
	 private int count;
	 private String reg;
	 
}
