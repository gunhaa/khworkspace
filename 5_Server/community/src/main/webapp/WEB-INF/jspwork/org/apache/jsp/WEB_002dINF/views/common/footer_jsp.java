/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2024-07-22 09:29:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1720687749000L));
    _jspx_dependants.put("jar:file:/C:/workspace/semiproject/talent-four/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("    <footer class=\"footer\">\r\n");
      out.write("\r\n");
      out.write("        <div id=\"chat-box\" hidden>\r\n");
      out.write("            <div id=\"chat-id\">\r\n");
      out.write("                <div id=\"chat-close\">X</div>\r\n");
      out.write("                <input type=\"text\" placeholder=\" 상대 ID\" id=\"chatTo\">\r\n");
      out.write("                <button id=\"chatToBtn\">대화하기</button>\r\n");
      out.write("                <div id=\"myPartner\">현재 대화중인 상대: {얘}</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"chat-message\">\r\n");
      out.write("                <div id=\"chat-tobox\">\r\n");
      out.write("                    <div id=\"chat-to\">안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??안녕??</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"chat-frombox\">\r\n");
      out.write("                    <div id=\"chat-from\">상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임상대임</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"chat-tobox\">\r\n");
      out.write("                    <div id=\"chat-to\">안녕??</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"chat-frombox\">\r\n");
      out.write("                    <div id=\"chat-from\">상대임</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"chat-tobox\">\r\n");
      out.write("                    <div id=\"chat-to\">안녕??</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"chat-frombox\">\r\n");
      out.write("                    <div id=\"chat-from\">상대임</div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"chat-input\">\r\n");
      out.write("                <textarea name=\"chatTextArea\" id=\"chatContent\"></textarea>\r\n");
      out.write("                <button id=\"sendChat\">전송</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- <button class=\"fa-solid fa-headset callServiceCenter\" id=\"chatBtn\">OO</button> -->\r\n");
      out.write("        <button class=\"callServiceCenter\" id=\"chatBtn\">O</button>\r\n");
      out.write("        <p>통신판매 신고번호 : 1234-서울강남-12345<br>\r\n");
      out.write("            상호 : 재능사조<br>\r\n");
      out.write("            주소 : 서울특별시 강남구 역삼역<br>\r\n");
      out.write("            고객센터 : 1234-1234 <br>\r\n");
      out.write("\r\n");
      out.write("            (주) 재능사조는 통신판개중개자로서 거래 당사자가 아니므로, 튜터가 등록한 상품정보를 책임지지 않습니다.<br>\r\n");
      out.write("            Copyright @ 2024 Inc. All rights reserved.</p>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("\r\n");
      out.write("            const chatIcon = document.querySelector(\"#chatBtn\");\r\n");
      out.write("            const chatClose = document.querySelector(\"#chat-close\");\r\n");
      out.write("            const chatBox=document.querySelector(\"#chat-box\");\r\n");
      out.write("            \r\n");
      out.write("            let websocket = new WebSocket(`ws://localhost:8080/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/chat/end?clientId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberNickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`)\r\n");
      out.write("            \r\n");
      out.write("            chatIcon.addEventListener(\"click\", () => {\r\n");
      out.write("                chatIcon.hidden=true;\r\n");
      out.write("                chatBox.hidden=false;\r\n");
      out.write("            \r\n");
      out.write("                websocket.onopen = ()=>{\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("\r\n");
      out.write("                    });\r\n");
      out.write("                };\r\n");
      out.write("            \r\n");
      out.write("            });\r\n");
      out.write("            chatClose.addEventListener(\"click\", ()=>{\r\n");
      out.write("                chatIcon.hidden=false;\r\n");
      out.write("                chatBox.hidden=true;\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </footer>");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/common/footer.jsp(76,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty sessionScope.message}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                <script>\r\n");
          out.write("                    alert(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          out.write("\r\n");
          out.write("                </script>\r\n");
          out.write("\r\n");
          out.write("                ");
          if (_jspx_meth_c_005fremove_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fremove_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_005fremove_005f0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    boolean _jspx_th_c_005fremove_005f0_reused = false;
    try {
      _jspx_th_c_005fremove_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fremove_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /WEB-INF/views/common/footer.jsp(82,16) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fremove_005f0.setVar("message");
      // /WEB-INF/views/common/footer.jsp(82,16) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fremove_005f0.setScope("session");
      int _jspx_eval_c_005fremove_005f0 = _jspx_th_c_005fremove_005f0.doStartTag();
      if (_jspx_th_c_005fremove_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.reuse(_jspx_th_c_005fremove_005f0);
      _jspx_th_c_005fremove_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fremove_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fremove_005f0_reused);
    }
    return false;
  }
}
