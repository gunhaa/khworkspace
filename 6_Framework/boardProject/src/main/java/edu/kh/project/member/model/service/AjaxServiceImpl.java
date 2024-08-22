package edu.kh.project.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dao.AjaxDAO;
import edu.kh.project.member.model.dto.Member;

@Service // 서브시임을 명시 + Bean 등록
public class AjaxServiceImpl implements AjaxService {

	@Autowired // DI
	private AjaxDAO dao;

	
	@Override
	public String selectNickname(String email) {
		return dao.selectNickname(email);
	}


	@Override
	public String selectTel(String nickname) {
		return dao.selectTel(nickname);
	}


	@Override
	public int selectEmail(String email) {
		return dao.selectEmail(email);
	}


	@Override
	public String selectNick(String nick) {
		return dao.selectNick(nick);
	}


	@Override
	public Member selectMember(String email) {
		return dao.selectMember(email);
	}


	@Override
	public List<Member> selectMemberEmail(String email) {
		return dao.selectMemberEmail(email);
	}


	@Override
	public List<Board> boardSearch(String query) {
		return dao.selectBoardSearch(query);
	}
	
	
}
