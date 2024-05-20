package kr.or.ddit.vo;

import lombok.Data;

@Data
public class FreeVO {

	private int freeNo;
	private String freeTitle;
	private String freeContent;
	private String freeWriter;
	private String freeDate;
	private int freeHit = 0;
	
	int count;
}
