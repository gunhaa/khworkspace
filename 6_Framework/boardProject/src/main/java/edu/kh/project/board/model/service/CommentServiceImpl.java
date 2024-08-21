package edu.kh.project.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.CommentDAO;
import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.common.utility.Util;

@Service
public class CommentServiceImpl implements CommentService {

	
	@Autowired
	private CommentDAO dao;

	@Override
	public List<Comment> selectComment(int boardNo) {
		
		List<Comment> commentList = new ArrayList<Comment>();
		
		commentList = dao.selectComment(boardNo);
		
		return commentList;
	}

	@Override
	public int insert(Comment comment) {
		// XSS 방지 처리
		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		
		return dao.insert(comment);
	}

	@Override
	public int delete(int commentNo) {
		return dao.delete(commentNo);
	}

	@Override
	public int update(Comment comment) {
		return dao.update(comment);
	}

	
}
