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

/**
 * Servlet implementation class mbUpdate
 */
@WebServlet("/mbUpdate")
public class mbUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mb_no = Integer.parseInt(req.getParameter("mb_no"));
		System.out.println("mbUpdate에서 mb_no:"+ mb_no);
		IMeetService meetService =  MeetServiceImpl.getInstance();
		MbVO mb = meetService.getMbDetail(mb_no);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
