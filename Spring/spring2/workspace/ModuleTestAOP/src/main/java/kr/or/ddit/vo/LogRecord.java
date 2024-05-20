package kr.or.ddit.vo;

import lombok.Data;

@Data
public class LogRecord {

	private String occurTime;	
	private String clazz;
	private String method;
	private String args;
	
}
