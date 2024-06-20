package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletEx3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpServletRequest : 클라이언트의 정보 + 유청 시 전달 값(input)
		// HttpServletResponse : 서버가 클라이언트에게 응답할 때 필요한 방법을 가지고 있는 객체		
		
		String id = req.getParameter("id");
		String pw1 = req.getParameter("pw1");
		String pw2 = req.getParameter("pw2");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String[] color  = req.getParameterValues("color");
		
		// Dynamic Web Project(동적 웹 프로젝트)
		// - 요청에 따라 응답화면 (HTML)을 실시간으로 만드는 것 (동적)
		 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(pw1.equals(pw2)) {
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<TITLE>"+ "회원 정보"+ "</TITLE>");
			out.println("<HEAD>");
			out.println("</HEAD>");
			out.println("<BODY>");
			out.println("<ul>");

			out.println("<li> 아이디 : " + id + "</li>");
			out.println("<li> 이름 : " + name + "</li>");
			out.println("<li> 이메일 : " + mail + "</li>");
			if(color==null) {
				out.println("<li> 좋아하는 색 : 없습니다.</li>");
			} else {
				out.println("<li> 좋아하는 색 :");
				for(String c : color) {
					out.println( c + " ");
				}
				out.print("</li>");
				
			}
			out.println("</ul>");
			out.println("</BODY>");
			out.println("</HTML>");
		} else {
			out.print("<h1>비밀번호가 일치하지 않습니다.</h1>");
		}

	}
	
}
