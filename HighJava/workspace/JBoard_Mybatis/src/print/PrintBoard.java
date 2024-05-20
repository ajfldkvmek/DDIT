package print;

//import java.math.BigDecimal;
import java.util.List;

import vo.BoardVO;

public class PrintBoard {

	public void printSelectAll(List<BoardVO> list) {
		if(list == null) {
			System.out.println("글없음");
			return;
		}
		System.out.println("번호\t제목\t작성자\t작성일자\t내용\t");
//		for(int i = 0; i <list.size(); i++) {
//			System.out.println(list.get(i).getBoard_no() +"\t" +
//								list.get(i).getBoard_title() +"\t" +
//								list.get(i).getBoard_writer() +"\t" +
//								list.get(i).getRegDt() +"\t" +
//								list.get(i).getBoard_content());
//		}
		for (BoardVO bv : list) {
			System.out.println(bv.getBoard_no() +"\t" +
			bv.getBoard_title() +"\t" +
			bv.getBoard_writer() +"\t" +
			bv.getRegDt() +"\t" +
			bv.getBoard_content());
		}
	}
	
	public void printInsert(int res) {
		if(res == 0) System.out.println("글 작성 실패");	
		else System.out.println("작성완료");
	}
	
	public void printSearchBoard(List<BoardVO> list) {
		if(list == null) {
			System.out.println("그런거 없다");
			return;
		}
		for (BoardVO bv : list) {
			System.out.println(bv.getBoard_no() +"\t" +
			bv.getBoard_title() +"\t" +
			bv.getBoard_writer() +"\t" +
			bv.getRegDt() +"\t" +
			bv.getBoard_content());
		}
	}
}
