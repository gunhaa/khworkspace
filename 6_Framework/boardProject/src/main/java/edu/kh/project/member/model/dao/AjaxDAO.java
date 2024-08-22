package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dto.Member;

@Repository
public class AjaxDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public String selectNickname(String email) {
		return sqlSession.selectOne("ajaxMapper.selectNickname", email);
	}

	public String selectTel(String nickname) {
		return sqlSession.selectOne("ajaxMapper.selectTel", nickname);
	}

	public int selectEmail(String email) {
		return sqlSession.selectOne("ajaxMapper.selectEmail", email);
	}

	public String selectNick(String nick) {
		return sqlSession.selectOne("ajaxMapper.selectNick", nick);
	}

	public Member selectMember(String email) {
		return sqlSession.selectOne("ajaxMapper.selectMember", email);
	}

	public List<Member> selectMemberEmail(String email) {
		return sqlSession.selectList("ajaxMapper.selectMemberEmail", email);
	}

	public List<Board> selectBoardSearch(String query) {
		System.out.println(query);
		List<Board> boardList= sqlSession.selectList("ajaxMapper.selectBoardSearch", query);
		System.out.println(boardList);
		return boardList;
	}
}
