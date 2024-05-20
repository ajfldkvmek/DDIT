package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFileFilter implements Filter {

	private PrintWriter writer;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LogFilter 초기화");
		String filename = filterConfig.getInitParameter("filename");
		
		if(filename== null) {
			throw new ServletException("로그 파일 찾을 수 없는딩");
		}
		
		try {
			writer = new PrintWriter(new FileWriter(filename, true), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("로그파일 열 수 ㅇ없은딩");
		}
	}
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("LogFilter 실행");
		writer.println("접속한 클라이언트 IP: " + request.getRemoteAddr());
		
		long start = System.currentTimeMillis();
		writer.println("접근 요청한 url 경로: " + getURLPath(request));
		writer.println("요청 처리 시작 시간: " + getCurrentTime());
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		writer.println("요청 처리 종료 시간: " + getCurrentTime());
		writer.println("요청 처리 소요 시간: " + (end-start)+"ms");
		writer.println("------------------------------------------");
	}

	private String getURLPath(ServletRequest request) {
		HttpServletRequest req;
		String currnetPath = "";
		String queryString = "";
		
		if(request instanceof HttpServletRequest) {
			req = (HttpServletRequest) request;
			currnetPath = req.getRequestURI();
			queryString = req.getQueryString();
			
			queryString = queryString == null ? "" : "?" + queryString;
		}
		return currnetPath+queryString;
	}
	
	private String getCurrentTime() {
		
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		
		return formatter.format(calendar.getTime());
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LogFilter 해제");
		writer.close();
	}
	
	
	
}
