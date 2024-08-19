package edu.kh.project.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.service.BoardService2;
import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;

// 세션에서 해당 값을 가지고 온다.
@SessionAttributes("loginMember")
@RequestMapping("/board2")
@Controller
public class BoardController2 {

	@Autowired
	private BoardService2 service;
				 // 이 곳에 들어오는 것을 boardCode라고 부르기로 정의
	@GetMapping("/{boardCode:[0-9]+}/insert")
								// jsp에서 boardCode 변수를 쓸 수 있도록 세팅
	public String boardWrite(@PathVariable("boardCode") int boardCode , RedirectAttributes ra) {

		// @PathVariable : 주소 값 가져오기 + request scope에 값 올림
		
		return "board/boardWrite";
	}

	
	//게시글 작성
	@PostMapping("/{boardCode:[0-9]+}/insert")				// 커맨드 객체
	public String boardWrite(@PathVariable("boardCode") int boardCode , @SessionAttribute("loginMember") Member loginMember,
			@RequestParam String boardTitle, @RequestParam String boardContent, @ModelAttribute Board board,
			@RequestParam(value="images", required=false) List<MultipartFile> images, HttpSession session, RedirectAttributes ra) throws IllegalStateException, IOException{
		
		// 파라미터 : 제목, 내용, 파일(0~5개)
		// 파일 저장 경로 : HttpSession
		// 세션 : 로그인한 회원의 번호
		// 리다이렉트 시 데이터 전달 : RedirectAttributes
		// 작성 성공 시 이동할 게시판 코드 : @PathVariable("boardCode")
		
		/* List<MultipartFile>
		 * - 업로드 된 이미지가 없어도 List에 MultipartFile 객체가 추가 됨
		 * 
		 * - 단, 업로드된 이미지가 없는 MultipartFile 객체는
		 *   파일 크기(size)가 0 또는 파일명(getOriginalFileName()이 "")
		 * */
		
		// 1. 로그인한 회원 번호 board에 세팅
		board.setMemberNo(loginMember.getMemberNo());
		// 2. boardCode도 board에 세팅
		board.setBoardCode(boardCode);
		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHandling(board.getBoardContent()));
		// 3. 업로드된 이미지 서버에 실제로 저장되는 경로
		//    + 웹에서 요청 시 이미지를 볼 수 있는 경로(웹 접근 경로)
		String webPath = "/resources/images/board/"; 
		String filePath = session.getServletContext().getRealPath(webPath);
		
		// 게시글 삽입 서비스 호출 후 삽입된 게시글 번호 반환 받기
		int boardNo= service.boardInsert(board,images, webPath, filePath);
		
		// 게시글 삽입 성공 시
		// 방금 삽입한 게시글의 상세 조회 페이지로 리 다이렉트
		String message = null;
		String path = "redirect:";
		
		if(boardNo>0) { //게시글 성공 시
			message = "게시글이 등록 되었습니다.";
			path +="/board/"+boardCode+"/"+boardNo;
		} else {
			message = "게시글 등록 실패";
			path += "insert";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
}
