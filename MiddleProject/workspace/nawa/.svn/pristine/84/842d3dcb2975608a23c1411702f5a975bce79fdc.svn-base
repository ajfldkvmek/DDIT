package lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.service.ILecService;
import lecture.service.LecServiceImpl;

public class scoreController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int lecNo = Integer.parseInt(req.getParameter("lecNo"));
		ILecService lecService = LecServiceImpl.getInstance();
		
		lecService.lecScore(lecNo);
		
		// 클라이언트 측에서 알람 띄우기
        String alertScript = "<script>alert('강의신청이 완료되었습니다.'); location.href='/nawa/lecture/list.do';</script>";
        
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head>" + alertScript + "</head><body></body></html>");
        out.flush();
		
		resp.sendRedirect("/nawa/lecture/list.do");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		doGet(req, resp);
	}
}
