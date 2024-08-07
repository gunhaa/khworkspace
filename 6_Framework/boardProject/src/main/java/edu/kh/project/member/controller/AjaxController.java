package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	
	@GetMapping(value="/selectTel", produces = "apllication/text; charset=UTF-8")
	@ResponseBody
	private String selectTel(@RequestParam String nickname) {
	
		return service.selectTel(nickname);
	}
	
	
}
