package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.FreeBoard;

public class Controller {
	
	static JDBCUtil jdbc = JDBCUtil.getInstance();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		 *  테이블 FREE_BOARD 만들기.
		 *  
		 *  1. 전체 테이블 조회 
		 *  2. 상세 페이지 조회.
		 *  3. 게시판 글 신규 등록
		 *  4. 게시판 글 수정 
		 *  5. 게시판 글 삭제 
		 *
		 *  게시번호	제목	작성자	작성시간	내용(10자만 출력)
		 *  3	게시글3	테스트1	2023-11-01	오늘 날씨는 ....
		 *  2	게시글2	테스트1	2023-11-01	오늘 날씨는 ....
		 *  1	게시글1	테스트1	2023-10-31	오늘 날씨는 ....
		 */
		
		Controller c = new Controller();
		c.start();
	}

	public void printHome() {
		System.out.println("1. 전체 게시판 조회");
		System.out.println("2. 게시판 신규 등록");
	}
	
	public void printList(List<FreeBoard> l) {
		// 게시판 내용 출력
		System.out.println("게시번호	제목	작성자	작성시간		내용");
		for (FreeBoard freeBoard : l) {
			System.out.println(freeBoard);
		}
		
		System.out.println("------------------------------------------------------------");
		// 선택 메뉴 출력
		System.out.println("1. 상세 페이지 조회");
		System.out.println("2. 홈");
	}
	
	public void printView(FreeBoard view) {
		System.out.println("----------------");
		System.out.println(view);
		System.out.println("----------------");
		System.out.println("1. 게시판 수정");
		System.out.println("2. 게시판 삭제");
	}
	
	
	public void start() {
		while(true) {
			printHome();
			int select = sc.nextInt();
			if(select == 1) {
				// 전체 게시판 조회.
				List<FreeBoard> list = selectList();
				printList(list);
				select = sc.nextInt();
				if(select == 1) {
					System.out.println("게시판을 선택하세요.");
					select = sc.nextInt();
					FreeBoard view = selectView(select);
					printView(view);
				}
				
			}
			else if(select ==2) {
				// 게시판 신규 등록
			}
		}
	}
	
	public FreeBoard selectView(int board_no) {
		String sql = "SELECT board_no, board_name, board_writer,  TO_CHAR(board_date, 'YYYY-MM-DD') board_date, board_content, board_delyn \r\n" + 
				"            FROM FREE_BOARD\r\n" + 
				"			    where board_no = ?";
		
		List l = new ArrayList<>();
		l.add(board_no);
		Map<String, Object> map = jdbc.selectOne(sql, l);
		
		return ConvertUtils.convertToVo(map, FreeBoard.class);
	}	
	
	public List<FreeBoard> selectList() {
		String sql = "SELECT board_no, board_name, board_writer,  TO_CHAR(board_date, 'YYYY-MM-DD') board_date, substr(board_content, 1, 10) board_content, board_delyn \r\n" + 
				"            FROM FREE_BOARD\r\n" + 
				"			    WHERE BOARD_DELYN IS NULL";
		
		List<Map<String, Object>> l = jdbc.selectList(sql);
		
		return ConvertUtils.convertToList(l, FreeBoard.class);
	}

}
