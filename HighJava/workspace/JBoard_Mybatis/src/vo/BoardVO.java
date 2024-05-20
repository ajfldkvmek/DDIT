package vo;

import java.math.BigDecimal;
//import java.sql.Clob;
//import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 	DB테이블에 존재하느 컬럼명을 기준으로 데이터를 객체화 하기
 */
public class BoardVO {

	private BigDecimal board_no;
	private String board_title;
	private String board_writer;
	private String board_content;
	private LocalDateTime regDt;
	
	
	public BigDecimal getBoard_no() {
		return board_no;
	}
	public void setBoard_no(BigDecimal board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

}
