package meet.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meet.service.IMeetService;
import meet.service.MeetServiceImpl;
import meet.vo.MbVO;
import meet.vo.MeetVO;
import member.vo.MemberVO;

/**
 * Servlet implementation class mbInsert
 */
@MultipartConfig
@WebServlet("/mbInsert")
public class mbInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/meet/mbinsertForm.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = req.getSession();
		///////////
		String meetNo = (String) session.getAttribute("meetNo"); //meet_no
		System.out.println("mbinsert에서 meetNo확인:"+ meetNo);//나옴
		MemberVO mmv = (MemberVO) session.getAttribute("LOGIN_USER");
		String memId = mmv.getMem_id();
		
		System.out.println("모임게시판 시작");
		System.out.println("mbInsert에서 모임번호,멤버아이디를 체크:"+ meetNo+memId);
		
		//////////값을 못가져옴
		MeetVO mv = new MeetVO();// 모임게시판을 체크하기위함
		mv.setMeet_no(meetNo);
		mv.setMem_id(memId);
		
		
		
		IMeetService meetService =  MeetServiceImpl.getInstance();
		int chk = meetService.mbcheck(mv);
		
		if( chk==0 ) {
			////////////////////////바꾸기
			resp.sendRedirect(req.getContextPath()+"/mbList");
		} else {
			String mb_ctno = req.getParameter("postCate");//카테
			String mb_title = req.getParameter("postTitle");//제목
			String mb_cont = req.getParameter("postContent");//내용
			System.out.println("mbinsert가져오는지 체크"+mb_ctno+mb_title+mb_cont);
			/* String fileInput = req.getParameter("fileInput"); */
			
			///////////////////////
			Random rand = new Random();
			//int mb_no = rand.nextInt(1000000) + 1;
			
			MbVO mb = new MbVO();//
			
			mb.setMb_ctno(mb_ctno);
			mb.setMb_title(mb_title);
			mb.setMb_cont(mb_cont);
			mb.setMem_id(memId);
			mb.setMeet_no(meetNo);
			
			System.out.println("게시판카테번호:"+mb.getMb_ctno());
			System.out.println("모임게시판 인서트가기직전");
			
			System.out.println(mb);
			
			int cnt = meetService.mbInsert(mb);
			String msg = "";
			if(cnt>0) {
				msg="성공";
			}else {
				msg="실패";
			}
			req.getSession().setAttribute("msg", msg);
			resp.sendRedirect(req.getContextPath()+"/mbList?meetNo="+meetNo);
			
		}
		
		
		
	}

}
