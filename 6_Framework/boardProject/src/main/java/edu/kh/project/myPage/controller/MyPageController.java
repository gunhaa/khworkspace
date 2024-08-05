package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.myPage.model.service.MyPageService;

@Controller // 요청/응답 제어 클래스 + Bean 등록
@RequestMapping("/myPage")
@SessionAttributes("loginMember")
public class MyPageController {

	@Autowired //MyPageService의 자식 MyPageServiceImple 의존성 주입(DI)받고있음
	private MyPageService service;
	
	// 내 정보 페이지 이동
	@GetMapping("/info")
	public String info() {
		// ViewResolver 설정 -> servelet-context.xml
		return "myPage/myPage-info";
	}
	
	
//	@PostMapping("/info")
//	public String updateinfo() {
//		
//		
//		return ;
//	}
	
	// 프로필 페이지 이동
	@GetMapping("/profile")
	public String profile() {
		// ViewResolver 설정 -> servelet-context.xml
		return "myPage/myPage-profile";
	}

	// 비밀번호 변경 페이지 이동
	@GetMapping("/changePw")
	public String changePw() {
		// ViewResolver 설정 -> servelet-context.xml
		return "myPage/myPage-changePw";
	}
	
	// 회원탈퇴 페이지 이동
	@GetMapping("/secession")
	public String secession() {
		// ViewResolver 설정 -> servelet-context.xml
		return "myPage/myPage-secession";
	}
	
	
}
