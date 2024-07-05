package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;

@WebServlet("/member/nicknameDupCheck")
public class nicknameDupCheck extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nickname = req.getParameter("nickname");
		MemberService service = new MemberService();
		
		try {
			
			int result = service.nicknameDupCheck(nickname);
			
			resp.getWriter().print(result);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
