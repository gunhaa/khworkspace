package edu.kh.project.board.model.service;

import java.util.List;

import edu.kh.project.board.model.dto.Comment;

public interface CommentService {

	/** 댓글 목록조회
	 * @param boardNo
	 * @return list
	 */
	List<Comment> selectComment(int boardNo);

	/** 댓글 삽입
	 * @param comment
	 * @return result
	 */
	int insert(Comment comment);

	int delete(int commentNo);

	int update(Comment comment);

}
