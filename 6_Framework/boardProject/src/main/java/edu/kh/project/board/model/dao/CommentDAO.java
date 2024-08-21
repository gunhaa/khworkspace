package edu.kh.project.board.model.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;

@Repository
public class CommentDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Comment> selectComment(int boardNo) {
										// board-mapper.xml에 작성된 select 이용
		return sqlSession.selectList("boardMapper.selectCommentList", boardNo);
	}

	public int insert(Comment comment) {
		return sqlSession.insert("commentMapper.insert", comment);
	}

	public int delete(int commentNo) {
		return sqlSession.update("commentMapper.delete", commentNo);
	}

	public int update(Comment comment) {
		return sqlSession.update("commentMapper.update" , comment);
	}
	
	
}
