package lecture.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.comm.service.AtchFileServiceImpl;
import lecture.comm.service.IAtchFileService;
import lecture.service.ILecService;
import lecture.service.LecServiceImpl;
import lecture.vo.LectureVO;

@MultipartConfig
@WebServlet ("/lecture/insert.do")
public class insertController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/lecture/insertForm.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String lecTitle = req.getParameter("lecTitle");
		String lecCont = req.getParameter("lecCont");
		String lecCata = req.getParameter("lecCata");
		String lecLoc = req.getParameter("lecLoc");
		Integer lecMax = Integer.parseInt(req.getParameter("lecMax"));
		Integer price = Integer.parseInt(req.getParameter("price"));
		String lecGrade = req.getParameter("lecGrade");
		Random rand = new Random();
		
		int a = rand.nextInt(10000) + 1;
		String lecNo = Integer.toString(a);
		
//		이놈들 없애기
//		String tutNo = req.getParameter("tutNo");
//		String lecNo = req.getParameter("lecNo");
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		lecture.comm.vo.AtchFileVO atchFileVO = new lecture.comm.vo.AtchFileVO();
		
		atchFileVO = fileService.saveAtchFileList(req.getParts());
		
		// 강의정보 저장
		ILecService lecService = LecServiceImpl.getInstance();
		
		LectureVO lv = new LectureVO();
		lv.setLecTitle(lecTitle);
		lv.setLecCont(lecCont);
		lv.setTutNo("t001");
		lv.setPrice(price);
		lv.setLecMax(lecMax);
		lv.setLecCata(lecCata);
		lv.setLecLoc(lecLoc);
		lv.setLecGrade(lecGrade);
		lv.setLecNo(lecNo);
		lv.setMemId("a001");
		
		System.out.println(lv.toString());
		
		int cnt = lecService.registLecture(lv);
		
		String msg = "";
		if(cnt < 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/lecture/list.do");
	}
}
