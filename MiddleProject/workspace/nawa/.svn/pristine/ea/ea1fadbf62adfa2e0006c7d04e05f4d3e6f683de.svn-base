package lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.service.ILecService;
import lecture.service.LecServiceImpl;
import lecture.vo.LectureVO;


@WebServlet("/lecture/detail.do")
public class detailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String lecNo = req.getParameter("lecNo");
	String tutNo = req.getParameter("tutNo");
	
	System.out.println("letNO >>>>>>>>>> " + lecNo);
	System.out.println("tutno >>>>>>>>>> " + tutNo);
	
	ILecService lecService = LecServiceImpl.getInstance();
	
	LectureVO lv = lecService.getLecture(lecNo);
	
	List<LectureVO> lecList = lecService.getLecList(tutNo);
	
	
	System.out.println("LECLIST >> " + lecList);
	
	req.setAttribute("lv", lv);
	req.setAttribute("lecList", lecList);
	req.getRequestDispatcher("/lecture/detail.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
