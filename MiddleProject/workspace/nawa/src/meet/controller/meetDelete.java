package meet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meet.service.IMeetService;
import meet.service.MeetServiceImpl;

@WebServlet("/meetDelete")
public class meetDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String meetNo = req.getParameter("meetNo");
		
		System.out.println("               "+meetNo);
		
		IMeetService meetService = MeetServiceImpl.getInstance();
		int cnt = meetService.deleteMeet(meetNo);
		String msg = "";
		if(cnt>0){
			msg="성공";
		}else {
			msg="실패";
		}
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath()+"/meetList");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
