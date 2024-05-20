package meet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meet.service.IMeetService;
import meet.service.MeetServiceImpl;
import meet.vo.MbVO;
import meet.vo.MeetVO;

/**
 * Servlet implementation class mbDetail
 */
@WebServlet("/mbDetail")
public class mbDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().getAttribute("pageNo");
		
		int mb_no = Integer.parseInt( req.getParameter("mb_No"));
		IMeetService meetService =  MeetServiceImpl.getInstance();
		System.out.println("mb디테일 시작");
		
		//모임게시판 조회수 업데이트
		meetService.updateMbViewCnt(mb_no);
		
		MbVO mb = meetService.getMbDetail(mb_no);
		req.setAttribute("mb", mb);
		
		
		System.out.println("mb디테일 컨트롤러 테스트: "+mb.getMb_title());
		req.getRequestDispatcher("meet/mbdetail.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
