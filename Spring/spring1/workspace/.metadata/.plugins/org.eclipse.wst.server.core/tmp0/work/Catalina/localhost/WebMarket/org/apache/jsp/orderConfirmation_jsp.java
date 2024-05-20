/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2024-02-07 02:05:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vo.Product;
import java.util.ArrayList;
import java.net.URLDecoder;

public final class orderConfirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/menu.jsp", Long.valueOf(1706840159048L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.net.URLDecoder");
    _jspx_imports_classes.add("vo.Product");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./resources/css/bootstrap.min.css\" />\r\n");
      out.write("<title>주문 정보</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		request.setCharacterEncoding("UTF-8");
	
		String cartId = session.getId();
		
		String shopping_cartId="";
		String shopping_name="";
		String shopping_shoppingDate="";
		String shopping_country="";
		String shopping_zipCode="";
		String shopping_addressName="";
		
		Cookie[] cookies = request.getCookies();

		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++){
				Cookie thisCookie = cookies[i];
				String n = thisCookie.getName();
				if(n.equals("Shopping_cartId"))
					shopping_cartId = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
				if(n.equals("Shopping_name"))
					shopping_name = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
				if(n.equals("Shopping_shoppingDate"))
					shopping_shoppingDate = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
				if(n.equals("Shopping_country"))
					shopping_country = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
				if(n.equals("Shopping_zipCode"))
					shopping_zipCode = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
				if(n.equals("Shopping_addressName"))
					shopping_addressName = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
				
			}
		}
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<nav class=\"navbar navbar-expand navbar-dark bg-dark\">\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"./welcome.jsp\">Home</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<h1 class=\"display-3\">주문 정보</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"container col-8 alert alert-info\">\r\n");
      out.write("\t\t<div class=\"text-center \">\r\n");
      out.write("\t\t\t<h1>영수증</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row justify-content-between\">\r\n");
      out.write("\t\t\t<div class=\"col-4\" align=\"left\">\r\n");
      out.write("\t\t\t\t<strong>배송 주소</strong> <br> 성명 : ");
      out.print(shopping_name );
      out.write(" <br> \r\n");
      out.write("\t\t\t\t우편번호 : ");
      out.print(shopping_zipCode );
      out.write(" <br> \r\n");
      out.write("\t\t\t\t주소 : ");
      out.print(shopping_addressName );
      out.write("<br>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-4\" align=\"right\">\r\n");
      out.write("\t\t\t\t<p>\t<em>배송일: ");
      out.print(shopping_shoppingDate );
      out.write("</em>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<table class=\"table table-hover\">\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th class=\"text-center\">도서</th>\r\n");
      out.write("\t\t\t\t<th class=\"text-center\">#</th>\r\n");
      out.write("\t\t\t\t<th class=\"text-center\">가격</th>\r\n");
      out.write("\t\t\t\t<th class=\"text-center\">소계</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

				int sum = 0;
				ArrayList<Product> cartList = (ArrayList<Product>) session.getAttribute("cartList");
				
				if(cartList != null) {
					for(int i = 0; i < cartList.size(); i++){
						Product product = cartList.get(i);
						int total = product.getUnitPrice() * product.getQuantity();
						sum += total;
				
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"text-center\"><em>");
      out.print(product.getPname() );
      out.write("</em></td>\r\n");
      out.write("\t\t\t\t<td class=\"text-center\">");
      out.print(product.getQuantity() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"text-center\">");
      out.print(product.getUnitPrice());
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"text-center\">");
      out.print(total );
      out.write("원</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				}
				
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td> </td>\r\n");
      out.write("\t\t\t\t<td> </td>\r\n");
      out.write("\t\t\t\t<td class=\"text-right\">\t<strong>총액: </strong></td>\r\n");
      out.write("\t\t\t\t<td class=\"text-center text-danger\"><strong>");
      out.print(sum );
      out.write("</strong></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\t\t\t\r\n");
      out.write("\t\t\t\t<a href=\"./shoppingInfo.jsp?cartId=");
      out.print(shopping_cartId );
      out.write("\" class=\"btn btn-secondary\" role=\"button\"> 이전 </a>\r\n");
      out.write("\t\t\t\t<a href=\"./thankCustomer.jsp\"  class=\"btn btn-success\" role=\"button\"> 주문 완료 </a>\r\n");
      out.write("\t\t\t\t<a href=\"./checkOutCancelled.jsp\" class=\"btn btn-secondary\"\trole=\"button\"> 취소 </a>\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
