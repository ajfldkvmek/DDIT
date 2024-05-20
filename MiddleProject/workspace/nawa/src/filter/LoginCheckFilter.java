package filter;


import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/LoginCheckFilter.do")
public class LoginCheckFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// 로그인 없이 허용 가능한 url목록
		List<String> okUrlList = Arrays.asList("/signin.do", "/signUp.do"); //나중에 익명게시판 추가할 것

		String reqURI = req.getRequestURI();

		boolean isAllowed = okUrlList.contains(reqURI.substring(req.getContextPath().length()));

		HttpSession session = req.getSession(false);

		if (isAllowed || (session != null && session.getAttribute("LOGIN_USER") != null)) {
			// 허용가능한 url이거나 로그인 한 사람이라면
			chain.doFilter(request, response);
		} else {

			Enumeration<String> paramNames = req.getParameterNames();

			StringBuffer queryStrBuff = new StringBuffer();

			int cnt = 0;

			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();

				if (cnt == 0) {
					queryStrBuff.append("?");
				} else {
					queryStrBuff.append("&");
				}
				queryStrBuff.append(paramName);
				queryStrBuff.append("=");
				queryStrBuff.append(req.getParameter(paramName));
				cnt++;
			}

			req.getSession().setAttribute("redirectURL", reqURI+queryStrBuff.toString());
			
			resp.sendRedirect(req.getContextPath() + "/signin.do");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
