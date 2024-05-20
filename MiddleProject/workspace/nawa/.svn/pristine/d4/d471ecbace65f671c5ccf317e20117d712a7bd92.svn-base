package lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.service.ILecService;
import lecture.service.LecServiceImpl;
import lecture.vo.LectureVO;

@MultipartConfig
@WebServlet("/lecture/update.do")
public class updateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String lecNo = req.getParameter("lecNo");
		
		ILecService lecService = LecServiceImpl.getInstance();
		
		LectureVO lv = lecService.getLecture(lecNo);
		
		req.setAttribute("lv", lv);
		
		req.getRequestDispatcher("/lecture/updateForm.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		
		System.out.println("ㅆㅃㄲㅃㄲㄹㅃㅉㄲㅉㅃㄲㅃㄲㅃㅉ>>>>>>>>>>>>>>>" + req.getParameter("lecNo"));
		System.out.println("ㅆㅃㄲㅃㄲㄹㅃㅉㄲㅉㅃㄲㅃㄲㅃㅉ>>>>>>>>>>>>>>>" + req.getParameter("lecTitle"));
		System.out.println("ㅆㅃㄲㅃㄲㄹㅃㅉㄲㅉㅃㄲㅃㄲㅃㅉ>>>>>>>>>>>>>>>" + req.getParameter("lecLoc"));
		System.out.println("ㅆㅃㄲㅃㄲㄹㅃㅉㄲㅉㅃㄲㅃㄲㅃㅉ>>>>>>>>>>>>>>>" + req.getParameter("lecMax"));
		System.out.println("ㅆㅃㄲㅃㄲㄹㅃㅉㄲㅉㅃㄲㅃㄲㅃㅉ>>>>>>>>>>>>>>>" + req.getParameter("lecCate"));
		System.out.println("ㅆㅃㄲㅃㄲㄹㅃㅉㄲㅉㅃㄲㅃㄲㅃㅉ>>>>>>>>>>>>>>>" + req.getParameter("price"));
		System.out.println("ㅆㅃㄲㅃㄲㄹㅃㅉㄲㅉㅃㄲㅃㄲㅃㅉ>>>>>>>>>>>>>>>" + req.getParameter("lecCont"));
		
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String lecTitle = req.getParameter("lecTitle");
		String lecLoc = req.getParameter("lecLoc");
		Integer lecMax = Integer.parseInt(req.getParameter("lecMax"));
		
		String lecGrade = req.getParameter("lecGrade");
		String lecCate = req.getParameter("lecCate");
		Integer price = Integer.parseInt(req.getParameter("price"));
		String lecCont = req.getParameter("lecCont");
		String lecNo = req.getParameter("lecNo");
		System.out.println(lecTitle + " " + lecCont + " " + price + " " + lecMax);
		
		ILecService lecService = LecServiceImpl.getInstance();
		
		LectureVO lv = new LectureVO();
		lv.setLecTitle(lecTitle);
		lv.setLecCont(lecCont);
		lv.setPrice(price);
		lv.setLecMax(lecMax);
		lv.setLecLoc(lecLoc);
		lv.setLecGrade(lecGrade);
		lv.setLecNo(lecNo);
		lv.setLecCate(lecCate);
		
		int cnt = lecService.modifyLec(lv);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		// 목록화면으로 리다이렉팅 처리
		resp.sendRedirect(req.getContextPath() + "/lecture/list.do");
	}
}
