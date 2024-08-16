package edu.kh.project.myPage.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;

@Controller // 요청/응답 제어 클래스 + Bean 등록
@RequestMapping("/myPage")
@SessionAttributes({"loginMember"})
// 1) Model에 시팅된 값의 key와 {} 작성된 값이 일치하면 session scope로 이동시킨다.
// 2) session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능
public class MyPageController {

	@Autowired //MyPageService의 자식 MyPageServiceImpl 의존성 주입(DI)받고있음
	private MyPageService service;
	
	
	// 내 정보 페이지 이동
	@GetMapping("/info")
	public String info() {
		// ViewResolver 설정 -> servelet-context.xml
		return "myPage/myPage-info";
	}
	
	
	@PostMapping("/info")
	public String info(Member updateMember, String[] memberAddress, Model model, RedirectAttributes ra, @SessionAttribute("loginMember") Member loginMember ) {
		
		// --------------------------매개변수 설명------------------------
		// Member updateMember : 수정할 닉네임, 전화번호가 담긴 커맨드 객체
		// String[] memberAddress : name="memberAddress"인 input 3개의 값
		// @SessionAttribute("loginMember") Member loginMember
		// : Session에서 얻어온 "loginMember"에 해당하는 객체를
		//   매개변수 Member loginMember에 저장
		
		// RedirectAttributes ra : 리다이렉트 시 값 전달용 객체(request)
		// ------------------------------------------------------------
//		System.out.println("주소에 setter를 쓰기 전 updateMember" + updateMember);
//		System.out.println("loginMember" + loginMember);
		// 주소를 하나로 합치기(^^^)
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null);
		} else {
			// String.join("구분자", String[])
			// 배열의 요소를 하나의 문자열로 변경
			// 단, 요소 사이에 "구분자"추가
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
		}
		// 로그인한 회원 정보를 updateMember에 추가
		updateMember.setMemberNo(loginMember.getMemberNo());

//		System.out.println("주소에 setter를 쓴 후 updateMember" + updateMember);
		//DB에 회원 정보 수정 서비스 호출
		int result = service.update(updateMember);
		
		
		// 수정 성공 시 "회원 정보가 수정 되었습니다."
		// 수정 실패 시 "회원정보 수정 실패"

		
		
		
		if(result>0) {
			ra.addFlashAttribute("message", "회원 정보가 수정 되었습니다.");
//			model.addAttribute("loginMember", updateMember);
			loginMember.setMemberAddress(updateMember.getMemberAddress());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			
		} else {
			ra.addFlashAttribute("message", "회원 정보 수정이 실패하였습니다..");
		}
		
		// 내 정보 수정 화면으로 돌아가기
		
		return "redirect:info";
	}
	
	

	
	
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
	
	//비밀번호 변경
	@PostMapping("/changePw")
	public String changePw(String currentPw , String newPw, @SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra) {
		
		//로그인한 회원 번호
		int memberNo = loginMember.getMemberNo();
		
		int result = service.changePw(currentPw, newPw, memberNo);
		
		
		String path = "redirect:";
		if(result==0) {
			// 비밀번호 변경 실패시 "현재 비밀번호가 일치하지 않습니다." 메시지 출력 후 비밀번호 변경 페이지로
			ra.addFlashAttribute("message", "현재 비밀번호가 일치하지 않습니다.");
			path+="changePw";
		} else {
			// 비밀번호 변경 성공시 "비밀번호가 변경 되었습니다." 메시지 출력 후 내 정보 페이지로
			ra.addFlashAttribute("message", "비밀번호가 변경 되었습니다.");
			path+="info";
		}
		
		return path;
	}

	// 회원 탈퇴
	@PostMapping("/secession")
	public String secession(String memberPw, @SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra, SessionStatus status, HttpServletResponse resp) {
		
		
		//------------매개변수 설명----------
		//String memberPw : 입력한 비밀 번호
		//@SessionAttribute("loginMember") Member loginMember : 로그인한 회원
		// SessionStatus status : 세션 관리 객체
		// RedirectAttributes ra : 리다이렉트 시 request scope 전달
		// HttpServletResponse resp : 서버 -> 클라이언트 응답하는 방법 제공 객체
		//---------------------------
		
		
		int result = service.secession(loginMember.getMemberNo(), memberPw);
		
		String path = "redirect:";
		
		if(result==0) {
			
			ra.addFlashAttribute("message", "회원 탈퇴가 실패하였습니다.");
			path+="secession";
		} else {
			status.setComplete();
			
			// 쿠키 삭제
		    Cookie c = new Cookie("saveId", null);
		    // 같은 쿠키가 이미 존재한다면 덮어쓰기 된다.
		    c.setMaxAge(0); // 쿠키의 expiration 타임을 0으로 하여 없앤다.
		    c.setPath("/"); // 모든 경로에서 삭제 됬음을 알린다.
		    resp.addCookie(c); // 응답 객체를 통해서 클라이언트에게 전달한다.
			ra.addFlashAttribute("message", "회원 탈퇴가 성공하였습니다.");
			path+="/";
			
		}
		
		return path;
	}
	
	
	/*
	* MultipartFile : input type="file"로 제출된 파일을 저장한 객체
	* 
	* [제공되는 메소드] 
	* - transferTo() : 파일을 지정된 경로에 저장(메모리 -> HDD/SSD)
	* - getOriginalFileName() : 파일 원본명
	* - getSize() : 파일 크기 
	*/
	// 프로필 이미지 수정
	@PostMapping("/profile")
	public String updateProfile(@RequestParam("profileImage") MultipartFile profileImage, @SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra, HttpSession session)  throws IllegalStateException, IOException  {
		
		// 웹 접근 경로
		String webPath = "/resources/images/member/";
		// 실제로 이미지 파일이 저장되야 하는 서버 컴퓨터 병로
		String filePath = session.getServletContext().getRealPath(webPath);
		//System.out.println(filePath);
		// 프로필 이미지 수정 서비스 호출
		int result = service.updateProfile(profileImage, webPath, filePath, loginMember);
		
		String message = null;
		if(result>0) message = "프로필 이미지가 변경 되었습니다.";
		else         message = "프로필 이미지 변경 실패";
		
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:profile";
	}
	
}
