package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.vo.Person;

@WebServlet("/EL/result")
public class ELResultServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("inputName");
		int age = Integer.parseInt(req.getParameter("inputAge"));
		String address= req.getParameter("inputAddress");
		
		//POST 방식 요청-> 한글 깨짐 -> 문자 인코딩 처리 필요	
		
		// 새로운 임의의 값
		String hobby = "운동";
		
		
		//Person 객체에 파라미터 값 대입
		Person user = new Person();
		user.setName(name+"님");
		user.setAge(age+20);
		user.setAddress("대한민국" + address);
		
		// 응답 화면 작성 코드를 JSP로 위임
		
		// 요청 발송자
		String path = "/WEB-INF/views/el/result.jsp";
		RequestDispatcher dis = req.getRequestDispatcher(path);
		// 요청 위임 시 추가할 세팅
		req.setAttribute("user", user);
		req.setAttribute("hobby", hobby);
		
		// 요청 위임
		dis.forward(req, resp);
		
		
	}
}
