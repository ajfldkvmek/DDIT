package lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.service.ILecService;
import lecture.service.LecServiceImpl;

@WebServlet("/lecture/delete.do")
public class deleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lecNo = req.getParameter("lecNo");
		System.out.println(lecNo);
		ILecService lecService = LecServiceImpl.getInstance();
		
		int cnt = lecService.removeLecture(lecNo);
		System.out.println(cnt);
		
		String msg = "";
		
		if(cnt < 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		// 세션에 저장
		req.getSession().setAttribute("msg", msg);
		
		// 삭제후 목록 화면으로 리다이렉트 처리
		resp.sendRedirect(req.getContextPath()+"/lecture/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}
