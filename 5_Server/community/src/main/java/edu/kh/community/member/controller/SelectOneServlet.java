package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/selectOne")
public class SelectOneServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberEmail = req.getParameter("memberEmail");

		MemberService service = new MemberService();
		
		try {
			
			Member mem = service.selectOne(memberEmail);
			
			
//			System.out.println(mem.getMemberEmail());
//			System.out.println(mem.getMemberNickname());
//			System.out.println(mem.getMemberTel());
//			System.out.println(mem.getMemberAddress());
//			System.out.println(mem.getEnrollDate());
			
			
			//resp.getWriter().print(mem);
			// print 매개 변수로 참조형 변수가 작성되면
			// 해당 참조 변수의 toString() 메소드를 자동으로 호출해서 출력
			
			// *** Java 객체를 -> Javascript 객체 형태의 문자열(JSON) -> Javascript 객체
			
			// 1) JSON 직접 작성 -> 오타 많이나고 작성하기 번거롭다..
			// String str = "{\"memberNickname\" :\"" + mem.getMemberNickname() +"\"}";
			//resp.getWriter().print(str);
			
			// 2) JSON-Simple 라이브러리에서 제공하는 JSONObject 사용
//			if(mem != null) {
//				JSONObject obj = new JSONObject(); // MAP 형식의 객체
//			
//				obj.put("memberEmail", mem.getMemberEmail());
//				obj.put("memberNickname", mem.getMemberNickname());
//				obj.put("memberTel", mem.getMemberTel());
//				obj.put("memberAddress", mem.getMemberAddress());
//				obj.put("enrollDate", mem.getEnrollDate());
//				// JSONObject의 toString() 메소드는
//				// JSON 형태로 출력 될 수 있도록 오버라이딩이 되어있다.
//				resp.getWriter().print(obj.toString());
//				
//			} else {
//				resp.getWriter().print(mem);
//			}
			
			
			// 3) GSON라이브러리를 이용한 Java객체 -> JSON 변환
			
			// new Gson().toJson(객체, 응답 스트림);
			// 매개 변수에 작성된 객체를 JSON 형태로 변환한 후 스트림을 통해서 출력한다.
			
			new Gson().toJson(mem, resp.getWriter());
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
