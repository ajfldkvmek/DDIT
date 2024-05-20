package kr.or.ddit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParamFilter implements Filter {

	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter02 초기화");
		System.out.println("web.xml에 설정하나 param담고 있는 filterConfig를 전역 변수에 먼저 세팅해준다");
		
		// param1은 아이딩 param2는 비밀번호
		System.out.println(filterConfig.getInitParameter("param1"));
		System.out.println(filterConfig.getInitParameter("param2"));
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter02 실행");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
	
		String msg = "";
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if(id.equals(param1) && pw.equals(param2)) {
			msg = "로긴 성공ㅋ";
			request.setAttribute("msg",msg);
		}else {
			msg = "로긴 실패ㅗ";
			msg += "<a href='filter02.jsp>filter02이동</a>";
			writer.print(msg);
			return;
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Filter02 종료");
	}

}
