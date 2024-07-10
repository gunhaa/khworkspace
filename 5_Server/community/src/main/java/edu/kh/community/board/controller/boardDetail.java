package edu.kh.community.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.board.model.service.BoardService;
import edu.kh.community.board.model.vo.BoardDetail;

@WebServlet("/board/detail")
public class boardDetail extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
		
			int boardNo= Integer.parseInt(req.getParameter("no"));
			BoardService service = new BoardService();
			
			// 게시글 정보 + 이미지리스트 조회
			BoardDetail detail = service.selectBoardDetail(boardNo);
			
			req.setAttribute("detail", detail);
			HttpSession session = req.getSession();
			

			
			req.getRequestDispatcher("/WEB-INF/views/board/boardDetail.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
