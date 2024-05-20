package kr.or.ddit.filter;

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

public class LogFileFilter implements Filter {

	private PrintWriter writer;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String filename = (String) filterConfig.getInitParameter("filename");
		
		if(filename == null) {
			throw new ServletException("로그파일 찾을 수 없는딩");
		}
		
		try {
			//PrintWriter
			//두번째 매개변수: authFlush여부(true/false)
			
			//FileWriter
			//두번째 매개변수: append여부(true/false)
			writer = new PrintWriter(new FileWriter(filename, true), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("로그파일 열 수 없는딩");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		writer.printf("현재 일시: %s %n", getCurrentTile());
		
		String clientAddr = request.getRemoteAddr();
		writer.printf("클라이언트 주소: %s %n", clientAddr);
		
		chain.doFilter(request, response);
		
		String contentType= response.getContentType();
		writer.printf("문서컨텐츠 유형 %s %n", contentType);
		
		writer.printf("----------------------------------------------");
		
	}
	
	private String getCurrentTile() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calender.getTime());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
