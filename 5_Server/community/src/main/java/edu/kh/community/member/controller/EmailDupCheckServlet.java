package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;

@WebServlet("/member/emailDupCheck")
public class EmailDupCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 비동기 통신으로 전달된 파라미터 얻어오기
		String memberEmail=req.getParameter("memberEmail");
		
		MemberService service = new MemberService();
		
		try {
		
			int result = service.emailDupCheck(memberEmail);
			
			// 보통 동기식 코드 작성 시
			// forward 또는 redirect를 이용해서 새로운 페이지가 보이게 동작함
			
			// ** 비동기 통신 시 응답은 화면이 아닌 데이터(int, String, XML, JSON, ...)
			// -> 응답용 스트림을 이용해서 단순 데이터 전달만 하면 된다.
			System.out.println(result);
			resp.getWriter().print(result);
			// 응답 스트림을 이용해서 Result 출력
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
