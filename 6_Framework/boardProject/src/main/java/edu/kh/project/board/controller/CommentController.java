package edu.kh.project.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;
import edu.kh.project.common.utility.Util;


// @Controller + @ResponseBody 가 합쳐진 어노테이션
@RestController // 요청/응답 처리(단, 모든 요청/응답은 비동기)
			// -> REST API 구축하기 위한 Controller
public class CommentController {

	
	@Autowired
	private CommentService service;
	// 이곳에서의 service는 CommentService가 아닌 impl이다. 인터페이스는 객체를 만들지 못한다. (업캐스팅)
	
		
//	@ResponseBody

	@GetMapping(value="/comment", produces="application/json; charset=UTF-8")     // RequestParam 생략 가능
	public List<Comment> select(@RequestParam int boardNo) {
		
		System.out.println(boardNo);
		
		List<Comment> commentList = new ArrayList<Comment>();
		
		commentList = service.selectComment(boardNo);
		
		return commentList; // List -> JSON 변환(HttpMessageConverter)
	}
	
	@PostMapping(value="/comment", produces="application/json; charset=UTF-8")
	public int insert(@RequestBody Comment comment) {
		// 요청 데이터(JSON)를
		// HttpMessageConverter가 해석해서 Java 객체(Comment)에 대입
		
		
//		String commentContent = String.valueOf(paramMap.get("commentContent"));
//        int memberNo = Integer.valueOf((String) paramMap.get("memberNo"));
//        int boardNo = Integer.valueOf((String) paramMap.get("boardNo"));

//        Comment comment = new Comment();
//        comment.setBoardNo(boardNo);
//        comment.setMemberNo(memberNo);


        int result = service.insert(comment);
		return result;
	}
	
	@DeleteMapping(value="/comment", produces="application/json; charset=UTF-8")
	public int delete(@RequestBody int commentNo) {
		
		// ajax로 요청 시 body에 담겨있는 하나뿐인 데이터는 
		// 매개변수 commentNo에 담기게 된다.
		
		int result = service.delete(commentNo);
		
		return result;
	}
	
	
	@PutMapping(value="/comment", produces="application/json; charset=UTF-8")
	public int update(@RequestBody Comment comment) {
		
		int result = service.update(comment);
		
		return result;
	}
	
	
	
}
