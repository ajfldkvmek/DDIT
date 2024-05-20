package kr.or.ddit.controller.crud;

public class BoardRecordNotFoundException extends Exception{

	public BoardRecordNotFoundException(String msg) {
		//부모 클래스(Exception)에 메세지 날려줌
		super(msg);
	}
}
