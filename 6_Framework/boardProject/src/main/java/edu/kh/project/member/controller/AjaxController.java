package edu.kh.project.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.AjaxService;

@Controller // 요청/응답 제어 + Bean 등록
@SessionAttributes("loginMember")
public class AjaxController {

	@Autowired
	private AjaxService service;
	// 인터페이스는 객체로 만들 수 없다. 전부 다 추상메소드라서 다형성 업캐스팅을 이용해서 impl이 주입된다.
	
	
	@GetMapping(value="/selectNickname", produces = "application/text; charset=UTF-8")
	@ResponseBody
	// 데이터를 요청한 곳으로 보내겠음
	private String selectNickname(@RequestParam String email) {
		
		return service.selectNickname(email);
	}
	
	@GetMapping(value="/selectTel", produces = "application/text; charset=UTF-8")
	@ResponseBody
	// 비동기 요청한 곳으로 돌아감
	private String selectTel(@RequestParam String nickname) {
	
		// return 포워드/리다이렉트 -> (동기식) 새로운 화면이 보임
		
		// return 데이터         -> (비동기식) 데이터를 요청한 곳으로 반환
		
		return service.selectTel(nickname);
	}
	
	// 이메일 중복 검사
	// produces 속성은 한글이 깨질 때 사용한다.
	@GetMapping(value="/selectEmail")
	@ResponseBody //HttpMessageConverter를 이용해서
	 			  // JS에서 인식할 수 있는 형태 (TEXT/JSON) 변환 후
				  // 비동기 요청한 곳으로 돌아간다.
	// jackson-databind pm.xml에 추가
	// int도 테스트 해봐야함
	private int selectEmail(@RequestParam String email) {
		return service.selectEmail(email);
	}
	// int는 produces를 넣으면 null 파싱 에러가 난다.
	
	
	//닉네임 중복검사
	@GetMapping(value="/selectNick", produces="application/text; charset=UTF-8")
	@ResponseBody
	private String selectNick(@RequestParam String nick) {
		return service.selectNick(nick);
	}
	
	@PostMapping(value="/selectMember", produces="application/json; charset=UTF-8")
	@ResponseBody // Java데이터-> TEXT,JSON으로 변환 및 비동기 요청한 곳으로 응답
	private Member selectMember(@RequestBody Map<String, Object> paramMap) {
	
		// RequestBody Map<String, Object> paramMap
		// -> 요청된 HTTP Body에 담긴 모든 데이터를 Map으로 반환
		
		String email = (String)paramMap.get("email");
		return service.selectMember(email);
	}
	
	
	@PostMapping(value="/selectMemberEmail", produces="application/json; charset=UTF-8")
	@ResponseBody
	private List<Member> selectMemberEmail(@RequestBody Map<String, Object> paramMap){
//		String email = (String)paramMap.get("email");		
		String email = String.valueOf(paramMap.get("email"));
		
		return service.selectMemberEmail(email);
	}
	
	/* Ajax를 이용한 비동기 통신 시
     * 
     * - 요청 데이터를 얻어오는 방법
     * 1) GET : 요청 url에 쿼리스트링 형태로 파라미터가 담겨있어
     *          @RequestParam, @ModelAttribute를 이용해서 얻어옴
     * 
     * 2) POST : HTTP 요청 Body에 파라미터가 담겨 있으므로
     *           @RequestBody를 통해 값(JSON)을 얻어와 
     *           Java객체로 변환(HttpMessageConverter)
     * 
     * - 응답 방법(GET/POST 구분 X)
     * : @ResponseBody를 이용해 반환
     *   -> 해당 어노테이션을 작성하면  
     *   Controller에서 반환되는 값이 ViewResolver가 아닌 
     *   HttpMessageConverter로 전달되어 
     *   반환된 Java객체를 text/JSON으로 변환 후 비동기 요청을 한 곳으로 응답함
     * 
     * 
     * ****************************
     * *** HttpMessageConverter ***
     * ****************************
     * 
     * HTTP 요청 Body의 내용을 Java 객체로 변환하고
     * HTTP 응답의 Body의 내용을 text/JSON 형태로 변환해주는 
     * Spring Framework 구성 요소
     * 
     * Spring에서 사용하는 MessageConverter 종류
     * 1순위 : ByteArrayHttpMessageConverter (바이트 배열 자동 변환)
     * 2순위 : StringHttpMessageConverter (Text 형식 자동 변환)
     * 3순위 : MappingJackson2HttpMessageConverter (요청 데이터 -> DTO/Map , 응답 데이터 -> JSON)
     jackson => 자바에서 JSON을 쓰기위한 라이브러리
     * */   

	
	@PostMapping(value="/search", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<Board> boardSearch(@RequestBody String query) {
		
		List<Board> boardList =service.boardSearch(query);
		//System.out.println(boardList);
		return boardList;
	}
	
}
