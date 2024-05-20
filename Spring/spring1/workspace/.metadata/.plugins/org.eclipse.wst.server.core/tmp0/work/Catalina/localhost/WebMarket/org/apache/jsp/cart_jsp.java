/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2024-02-07 01:38:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import vo.Product;
import dao.ProductRepository;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1706143833154L));
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
    _jspx_imports_classes.add("vo.Product");
    _jspx_imports_classes.add("dao.ProductRepository");
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./resources/css/bootstrap.min.css\" />\r\n");
      out.write("<title>장바구니</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
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
      out.write("\t\t\t<h1 class=\"display-3\">장바구니</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");

		String cartId = session.getId();
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"left\"><a href=\"./deleteCart.jsp?cartId=");
      out.print(cartId );
      out.write("\" class=\"btn btn-danger\">삭제하기</a></td>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\"><a href=\"./shoppingInfo.jsp?cartId=");
      out.print(cartId );
      out.write("\" class=\"btn btn-success\">주문하기</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"padding-top: 50px\">\r\n");
      out.write("\t\t\t<table class=\"table table-hover\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>상품</th>\r\n");
      out.write("\t\t\t\t\t<th>가격</th>\r\n");
      out.write("\t\t\t\t\t<th>수량</th>\r\n");
      out.write("\t\t\t\t\t<th>소계</th>\r\n");
      out.write("\t\t\t\t\t<th>비고</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
 
					int sum = 0;
					ArrayList<Product> cartList = 
							(ArrayList<Product>)session.getAttribute("cartList");
					
					if(cartList != null) {
						for(int i = 0; i < cartList.size(); i++) {
							Product product = cartList.get(i);
							int total = product.getUnitPrice() * product.getQuantity();
							sum = sum+total;
					
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(product.getProductId() );
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(product.getPname() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(product.getUnitPrice() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(product.getQuantity() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(total );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"./removeCart.jsp?id=");
      out.print(product.getProductId() );
      out.write("\" class=\"badge badge-danger\">삭제</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
}
				
      out.write("\r\n");
      out.write("\t\t\t\t");
} else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t    alert('장바구니에 아무거도 없어');\r\n");
      out.write("\t\t\t\t\t    window.location.href = 'products.jsp'; // Redirect to products.jsp after displaying the alert\r\n");
      out.write("\t\t  \t\t\t </script>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t\t<th>총액</th>\r\n");
      out.write("\t\t\t\t\t<th>");
      out.print(sum );
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<a href=\"./products.jsp\" class=\"btn btn-secondary\"> &laquo; 쇼핑 계속하기</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<footer class=\"container\">\r\n");
      out.write("\t<p>&copy; WebMarket\r\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
