package edu.kh.project.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.service.BoardService;


@SessionAttributes("loginMember")
@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	/* 목록 조회 : /board/1?cp=1 (cp : current page(현재 페이지))
	 * 상세 조회 : /board/1/1500?cp=1
	 * 
	 *  ** 컨트롤러 따로 사용 예정
	 *  삽입 : /board2/insert?code=1 (code == BOARD_CODE , 게시판 종류)
	 *  수정 : /board2/update?code=1&no=1500 (no == BOARD_NO, 게시글 번호)
	 *  삭제 : /board2/delete?code=1&no=1500
	 * 
	 * */
	
	//@PathVariable
	// URL 경로에 있는 값을 매개변수로 이용할 수 있게하는 어노테이션
	// + request scope에 세팅
	
	//@PathVariable을 사용하는 경우
	// - 자원(Resource) 구분/식별
	// ex) github.com/userId
	// ex) /board/1 -> 1번(공지사항) 게시판
	// ex) /board/2 -> 2번(자유) 게시판

	//QueryString을 사용하는 경우
	// - 정렬, 필터링
	// ex) search.naver.com?query=날씨
	// ex) search.naver.com?query=점심메뉴
	// ex) /board2/insert?code=1
	// ex) /board2/insert?code=2
	//     -> 삽입이라는 공통된 동작 수행
	//        단, code에 따라 어디에 삽입할지 지정(필터링)
	
	// ex) /board/list?order=recent(최신순)
	// ex) /board/list?order=popular(인기순)
	
	// 게시글 목록 조회
	@GetMapping("/{boardCode}")
	public String selectBoardList(@PathVariable("boardCode") int boardCode , @RequestParam(value="cp", required=false, defaultValue="1") int cp, Model model) {
		
		
		// boardCode 확인
		// System.out.println(boardCode);
		
		// 게시글 목록 조회 서비스 호출
		Map<String, Object> map = service.selectBoardList(boardCode , cp);
		System.out.println(map);
		// 조회 결과를 request scope에 세팅 후 forward
		// 기본적으로 request scope,sessionAttributes 를 써야 세션스코프로 간다.
		model.addAttribute("map", map);
		
		return "board/boardList";
	}
	
	// 상세 조회 : /board/1/1500?cp=1
	// 게시글 상세 조회
	@GetMapping("/{boardCode}/{boardNo}") 																	//데이터 전달용 객체 // 리다이렉트 시 데이터 전달용 객체
	public String boardDetail(@PathVariable("boardCode") int boardCode, @PathVariable("boardNo") int boardNo, Model model,RedirectAttributes ra ) {
				
//		System.out.println("boardCode : " + boardCode);
//		System.out.println("boardNo : "+ boardNo);

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		//게시글 상세 조회 서비스 호출
		Board board = service.selectBoard(map);
		
		String path = null;
		if(board != null) { // 조회된 결과가 있을 경우
			
			
			path = "board/boardDetail";
			model.addAttribute("board", board);
			
			
		} else { // 조회된 결과가 없을 경우
			
			// 게시판 첫 페이지로 리다이렉트
			path = "redirect:/board/" + boardCode;
			
			// 해당 게시글이 존재하지 않습니다. 알림창 출력
			ra.addFlashAttribute("message", "해당 게시글이 존재하지 않습니다.");
		}
		
		return path;
	}
	
	
}
