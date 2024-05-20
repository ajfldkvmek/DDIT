//package lecture.controller;
//
//import java.io.IOException;
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
//@WebServlet("")
//public class updateScoreController extends HttpServlet{
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String lecNo = req.getParameter("lecNO");
//		
//		ILecService lecService = LecServiceImpl.getInstance();
//		
//		LectureVO lv = lecService.updateScore(lecNo);
//		
//		req.setAttribute("lv", lv);
//		
//		req.getRequestDispatcher("").forward(req, resp);
//	
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//	}
//}
