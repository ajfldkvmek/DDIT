/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2024-03-23 06:52:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<div class=\"page-header min-vh-100\">\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column\">\r\n");
      out.write("\t\t\t\t<div class=\"position-relative bg-gradient-info h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background-image: url('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/illustrations/illustration-lock.jpg'); background-size: cover;\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tclass=\"col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5\">\r\n");
      out.write("\t\t\t\t<div class=\"card card-plain\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t\t\t\t<h4 class=\"font-weight-bolder\">회원가입</h4>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"mb-0\">회원등록 후, 저희 서비스와 함께해요!</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t<form role=\"form\" method=\"post\" action=\"/signup.do\" id=\"signupForm\">\r\n");
      out.write("\t\t\t\t\t\t\t<font class=\"font-weight-bold text-xs mt-1 mb-0 error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errors.memId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group input-group-outline mb-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"memId\" name=\"memId\" placeholder=\"아이디\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<font class=\"text-primary font-weight-bold text-xs mt-1 mb-0 error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errors.memPw }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group input-group-outline mb-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"memPw\" name=\"memPw\" placeholder=\"비밀번호\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group input-group-outline mb-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"memPwRe\" placeholder=\"비밀번호 재입력\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<font class=\"text-primary font-weight-bold text-xs mt-1 mb-0 error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errors.memName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group input-group-outline mb-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"memName\" name=\"memName\" placeholder=\"이름\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<font class=\"font-weight-bold text-xs mt-1 mb-0 error\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errors.memNickname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group input-group-outline mb-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"memNickname\" name=\"memNickname\" placeholder=\"닉네임\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"button\" class=\"form-control\" id=\"nickChkBtn\" value=\"중복확인\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-check form-switch\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"form-check-input\" type=\"checkbox\" id=\"agree\" value=\"Y\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"form-check-label\" for=\"agree\">개인정보 동의</label>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<font class=\"text-primary font-weight-bold text-xs mt-1 mb-0 error\"></font>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-lg bg-gradient-primary btn-lg w-100 mt-4 mb-0\" id=\"signupBtn\">가입하기</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-footer text-center pt-0 px-lg-2 px-1\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"mb-2 text-sm mx-auto\">\r\n");
      out.write("\t\t\t\t\t\t\t우리 서비스 회원이세요? \r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"/signin.do\" class=\"text-primary text-gradient font-weight-bold\">로그인</a>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t<font class=\"text-primary font-weight-bold text-xs mt-1 mb-0 error\"></font>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(function(){\r\n");
      out.write("\tvar signupForm = $(\"#signupForm\");\r\n");
      out.write("\tvar signupBtn = $(\"#signupBtn\");\r\n");
      out.write("\tvar memId = $(\"#memId\");\r\n");
      out.write("\tvar nickChkBtn = $(\"#nickChkBtn\");\r\n");
      out.write("\tvar idFlag = false; // 아이디 사용 여부 flag\r\n");
      out.write("\tvar nickFlag = false; // 닉네임 사용 여부 flag\r\n");
      out.write("\t\r\n");
      out.write("\t// 아이디 입력 란에 키보드를 통해 키를 입력하고 떼는 순간 발생\r\n");
      out.write("\tmemId.keyup(function(){\r\n");
      out.write("\t\tvar id = $(this).val(); // 아이디를 가져온다\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(id.length < 4){\r\n");
      out.write("\t\t\terrPrint(0, \"아이디는 4자리부터 시작합니다!\", \"red\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar data = {\r\n");
      out.write("\t\t\tmemId : id\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : \"/idCheck.do\",\r\n");
      out.write("\t\t\tdata : JSON.stringify(data),\r\n");
      out.write("\t\t\tdataType : \"text\",\r\n");
      out.write("\t\t\tcontentType : \"application/json; charset=utf-8\",\r\n");
      out.write("\t\t\tsuccess : function(res){\r\n");
      out.write("\t\t\t\tif(res == \"NOTEXIST\"){\r\n");
      out.write("\t\t\t\t\terrPrint(0, \"사용가능한 아이디입니다!\", \"green\");\r\n");
      out.write("\t\t\t\t\tidFlag = true;\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\terrPrint(0, \"아이디가 중복됩니다!\", \"red\");\r\n");
      out.write("\t\t\t\t\tidFlag = false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tnickChkBtn.on(\"click\", function(){\r\n");
      out.write("\t\tvar nickname = $(\"#memNickname\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(nickname == null || nickname == \"\"){\r\n");
      out.write("\t\t\terrPrint(3, \"닉네입을 입력해주세요.\", \"red\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar data = {\r\n");
      out.write("\t\t\tmemNickname : nickname\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : \"/nickNameCheck.do\",\r\n");
      out.write("\t\t\tdata :  JSON.stringify(data),\r\n");
      out.write("\t\t\tdataType : \"text\",\r\n");
      out.write("\t\t\tcontentType : \"application/json; charset=utf-8\",\r\n");
      out.write("\t\t\tsuccess : function(res){\r\n");
      out.write("\t\t\t\tif(res == \"NOTEXIST\"){\r\n");
      out.write("\t\t\t\t\terrPrint(3, \"사용가능한 닉네임입니다!\", \"green\");\r\n");
      out.write("\t\t\t\t\tnickFlag = true;\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\terrPrint(3, \"닉네임이 중복됩니다!\", \"red\");\r\n");
      out.write("\t\t\t\t\tnickFlag = false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tsignupBtn.on(\"click\", function(){\r\n");
      out.write("\t\tvar color = \"red\";\r\n");
      out.write("\t\tvar id = $(\"#memId\").val();\r\n");
      out.write("\t\tvar pw = $(\"#memPw\").val();\r\n");
      out.write("\t\tvar pwre = $(\"#memPwRe\").val();\r\n");
      out.write("\t\tvar name = $(\"#memName\").val();\r\n");
      out.write("\t\tvar nickname = $(\"#memNickname\").val();\r\n");
      out.write("\t\tvar agree = $(\"#agree:checked\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar pwFlag = true;\t// 비밀번호 일치 여부(비밀번호 = 재입력 비밀번호)\r\n");
      out.write("\t\tvar agreeFlag = false;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// errPrint 함수를 통해서 발생한 에러 메세지 정보를 init해준다.\r\n");
      out.write("\t\terrInit();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(id == null || id == \"\"){\r\n");
      out.write("\t\t\terrPrint(0, \"아이디를 입력해주세요.\", color);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(pw == null || pw == \"\"){\r\n");
      out.write("\t\t\terrPrint(1, \"비밀번호를 입력해주세요.\", color);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(pwre == null || pwre == \"\"){\r\n");
      out.write("\t\t\terrPrint(1, \"비밀번호 재입력을 입력해주세요.\", color);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(pw != pwre){\r\n");
      out.write("\t\t\terrPrint(1, \"비밀번호가 일치하지 않습니다.\", color);\r\n");
      out.write("\t\t\tpwFlag = false; // 비밀번호 불일치\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(name == null || name == \"\"){\r\n");
      out.write("\t\t\terrPrint(2, \"이름을 입력해주세요.\", color);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(nickname == null || nickname == \"\"){\r\n");
      out.write("\t\t\terrPrint(3, \"닉네임을 입력해주세요.\", color);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(agree != 'Y'){\r\n");
      out.write("\t\t\terrPrint(4, \"개인정보 동의에 체크해주세요.\", color);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tagreeFlag = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(pwFlag && idFlag && nickFlag && agreeFlag){\r\n");
      out.write("\t\t\tsignupForm.submit();\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tif(!pwFlag)\r\n");
      out.write("\t\t\t\terrPrint(5, \"비밀번호가 일치하지 않아 진행할 수 없습니다.\", color);\r\n");
      out.write("\t\t\tif(!idFlag)\r\n");
      out.write("\t\t\t\terrPrint(5, \"아이디 중복체크해주세요.\", color);\r\n");
      out.write("\t\t\tif(!nickFlag)\r\n");
      out.write("\t\t\t\terrPrint(5, \"닉네임 중복체크해주세요.\", color);\r\n");
      out.write("\t\t\tif(!agreeFlag)\r\n");
      out.write("\t\t\t\terrPrint(5, \"개인정보 동의에 체크되어 있지 않습니다.\", color);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function errPrint(cnt, msg, color){\r\n");
      out.write("\t$(\".error:eq(\"+cnt+\")\").text(msg).attr(\"color\", color);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function errInit(){\r\n");
      out.write("\t$(\".error\").text(\"\");\r\n");
      out.write("}\n");
      out.write("</script>");
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