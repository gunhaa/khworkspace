package edu.kh.community.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.board.model.service.BoardService;


@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		int boardNo = Integer.parseInt(req.getParameter("no"));
		int boardType = Integer.parseInt(req.getParameter("type"));
		HttpSession session = req.getSession();
		BoardService service= new BoardService();
		String path = "";
		String message = "";
		
		try {
			
			
			int result = service.deleteBoard(boardNo);
			
			if(result > 0) {
				// 게시글 삭제 성공시
				// "게시글이 삭제 되었습니다." 알림창
				// 해당게시판 목록 1페이지
				message = "게시글이 삭제 되었습니다";
				path = "list?type="+boardType;
				
			} else {
				// 게시글 삭제 실패시
				// "게시글 삭제에 실패했습니다." 알림창
				// 해당 게시글 상세 페이지
				message = "게시글 삭제가 실패했습니다.";	
				//path = "detail?no="+boardNo;
				// == 이전 요청 페이지 주소 ==referer
				path=req.getHeader("referer");
			}
			
			session.setAttribute("message", message);
			resp.sendRedirect(path);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
