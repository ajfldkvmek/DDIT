package meet.controller;

import java.io.IOException;
import java.util.Random;

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
 * Servlet implementation class mbInsert
 */
@WebServlet("/mbInsert")
public class mbInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/meet/mbinsertForm.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		///////////
		String meetNo = (String) req.getSession().getAttribute("pageNo"); //meet_no
		
		System.out.println("모임게시판 시작");
		
		//값을 못가져옴
		MeetVO mv = new MeetVO();// 모임게시판을 체크하기위함
		String mem_id = mv.getMem_id();
		String meet_no = mv.getMeet_no();
		
		
		System.out.println("체크"+ mem_id+meet_no);
		IMeetService meetService =  MeetServiceImpl.getInstance();
		int chk = meetService.mbcheck(mv);
		
		if( chk==0 ) {
			////////////////////////바꾸기
			resp.sendRedirect(req.getContextPath()+"/mbList");
		} else {
			String mb_ctno = req.getParameter("postCate");//카테
			String mb_title = req.getParameter("postTitle");//제목
			String mb_cont = req.getParameter("postContent");//내용
			
			/* String fileInput = req.getParameter("fileInput"); */
			
			///////////////////////
			Random rand = new Random();
			int a = rand.nextInt(10000) + 1;
			
			int mb_no = a;
			
			MbVO mb = new MbVO();
			mb.setMb_no(mb_no);
			mb.setMb_ctno(mb_ctno);
			mb.setMb_ctname(mb_title);
			mb.setMb_cont(mb_cont);
			mb.setMem_id(mem_id);
			mb.setMeet_no(meet_no);
			
			System.out.println("게시판카테번호:"+mb.getMb_ctno());
			System.out.println("모임게시판 인서트가기직전");
			
			int cnt = meetService.mbInsert(mb);
			String msg = "";
			if(cnt>0) {
				msg="성공";
			}else {
				msg="실패";
			}
			req.getSession().setAttribute("msg", msg);
			resp.sendRedirect(req.getContextPath()+"/mbList");
			
		}
		
		
		
	}

}
