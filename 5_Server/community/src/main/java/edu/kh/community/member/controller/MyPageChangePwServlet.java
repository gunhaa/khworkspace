package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.common.wrapper.EncryptWrapper;
import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;



@WebServlet("/member/myPage/changePw")
public class MyPageChangePwServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/myPage-changePw.jsp").forward(req, resp);
		
	}
	
	
	// post방식 요청 : 비밀번호 변경
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



		
		// ** Service로 전달할 값이 많은데 VO로 해결할 수 없는 경우 **
		// 1. 매개변수로 하나하나 따로 전달한다.
		//  -> 최대 4개를 넘지 않는 것을 권장
		
		// 2. VO 새로 만들기(1회성으로 사용하면 비 효율적임)
		// 성공 -> 비밀번호가 변경 되었습니다.
		// 내 정보 페이지로 돌아오기

		// 실패 -> 현재 비밀번호가 일치하지 않습니다.
		// 비밀번호 변경 페이지로 돌아오기
		
		String currentPw = req.getParameter("currentPw");
		String newPw=req.getParameter("newPw");
		HttpSession session = req.getSession();
		Member mem = (Member)session.getAttribute("loginMember");
		
		
		
//		EncryptWrapper wrap = new EncryptWrapper(req);
//		
//		currentPw = wrap.getSha512(currentPw);
		
		
		
		
		MemberService service = new MemberService();
		
		try {
			
			int result = service.changePw(mem,currentPw,newPw);
			
			if(result>0) {
				session.setAttribute("message", "비밀번호 수정 성공하였습니다.");
				resp.sendRedirect(req.getContextPath()+"/member/myPage/info");
			} else {
				session.setAttribute("message", "비밀번호 수정 실패하였습니다.");
				resp.sendRedirect(req.getContextPath()+"/member/myPage/changePw");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	
	
}
