//package lecture.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import lecture.service.ILecService;
//import lecture.service.LecServiceImpl;
//import lecture.vo.LectureVO;
//
//@WebServlet("/lecture/count.do")
//public class countController extends HttpServlet {
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		System.out.println("카운트 컨트롤러~~~" + req.getParameter("lecNo"));
//		
//		int countNo = Integer.parseInt(req.getParameter("lecNo"));
//		System.out.println("카운트 컨트롤러~~~" + countNo);
//		
//		ILecService lecService = LecServiceImpl.getInstance();
//		
//		lecService.updateCnt(countNo);
//		
//		// 클라이언트 측에서 알람 띄우기
//        String alertScript = "<script>alert('강의신청이 완료되었습니다.'); location.href='/nawa/lecture/list.do';</script>";
//        
//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = resp.getWriter();
//        out.println("<html><head>" + alertScript + "</head><body></body></html>");
//        out.flush();
//		
//		
//		//req.getRequestDispatcher("/lecture/list.jsp").forward(req, resp);
//		
//		resp.sendRedirect("/nawa/lecture/list.do");
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		doGet(req, resp);
//		
//	}
//	
//}