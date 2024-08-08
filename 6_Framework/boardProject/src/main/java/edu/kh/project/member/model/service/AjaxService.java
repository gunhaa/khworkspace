package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface AjaxService {

	String selectNickname(String email);

	String selectTel(String nickname);

	int selectEmail(String email);

	/** 닉네임 중복검사
	 * @param nick
	 * @return 닉네임 중복 count
	 */
	String selectNick(String nick);

	/** 이메일로 회원 정보 조회
	 * @param email
	 * @return member
	 */
	Member selectMember(String email);

	/** 이메일로 일부라도 일치하는 회원 검색
	 * @param email
	 * @return 리스트
	 */
	List<Member> selectMemberEmail(String email);

	
}
