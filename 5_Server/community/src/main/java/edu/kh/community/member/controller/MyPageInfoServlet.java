package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;


@WebServlet("/member/myPage/info")
public class MyPageInfoServlet extends HttpServlet {

	
	// 메인페이지 -> 닉네임 클릭 시 요청(GET)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/member/myPage-info.jsp");
	
		
		dis.forward(req, resp);
	}
	
	
	// 회원정보 수정 요청(POST)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 필요한 파라미터 얻어오기 + 주소(배열) -> 문자열로 만들기
		
		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");
		String[] address = req.getParameterValues("memberAddress");
		
		String memberAddress=null;
		if(!address[0].equals("")) {
			memberAddress = String.join(",,", address);
		}
		
		//세션에서 로그인한 회원 정보 얻어오기
		HttpSession session = req.getSession();
		
		// 얕은 복사가 일어남(세션에 있는 원 정보 객체 주소)
		// -> loginMember를 수정 session에 저장된 내용도 수정된다.
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		MemberService service = new MemberService();
		
		int memberNo = loginMember.getMemberNo();

		
		
		
		Member mem= new Member();
		
		
		mem.setMemberNo(memberNo);
		mem.setMemberNickname(memberNickname);
		mem.setMemberTel(memberTel);
		mem.setMemberAddress(memberAddress);
		
		try {
			
			int result = service.update(mem);
			
			if(result>0) {
				session.setAttribute("message", "회원 정보가 수정되었습니다.");

				//DB는 수정 되었지만
				//로그인한 회원 정보가 담겨있는 Session의 정보는 그대로다!
				// -> 동기화 작업
//				session.setAttribute("loginMember", mem); 가능하긴함
				
				loginMember.setMemberNickname(memberNickname);
				loginMember.setMemberTel(memberTel);
				loginMember.setMemberAddress(memberAddress);
			} else {
				session.setAttribute("message", "회원 정보 수정 실패하였습니다.");
			}
			
			
			
			// 성공/실패 여부 관계 없이 "내 정보"화면 재요청
			//절대 경로
			resp.sendRedirect(req.getContextPath()+"/member/myPage/info");
			
			//상대 경로
			//resp.sendRedirect("info");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
