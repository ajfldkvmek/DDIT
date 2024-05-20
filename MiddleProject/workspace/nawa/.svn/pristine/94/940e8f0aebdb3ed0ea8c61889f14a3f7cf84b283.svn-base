package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/search.do")
public class MemberSearch extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IMemberService memService = MemberServiceImpl.getInstance();
		
		req.setCharacterEncoding("utf-8");
		String str = req.getParameter("search");
		System.out.println(str);
		
		List<MemberVO> searchList = memService.searchMember(str);
		//System.out.println(searchList);
		req.setAttribute("searchList", searchList);
		req.getRequestDispatcher("/search.jsp").forward(req, resp);
		
	}
	
}
