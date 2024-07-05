package edu.kh.community.member.model.service;

import java.sql.Connection;

import edu.kh.community.member.model.dao.MemberDAO;
import edu.kh.community.member.model.vo.Member;
import static edu.kh.community.common.JDBCTemplate.*;


public class MemberService {

	
	private MemberDAO dao = new MemberDAO();
	
	/** 로그인 서비스
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception {
		
		// Connection 얻어오기
			Connection conn = getConnection();
		// DAO 수행
			
			
			
			Member loginMember = dao.login(conn, mem);
			
		// Connection 반환
			close(conn);
		// 결과 반환
		return loginMember;
	}

	/** 회원 가입 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member mem) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn,mem);
		
		
		// 트랜잭션 제어 처리
		if(result>0) commit(conn);
		else rollback(conn);
		
		//Connection 반환(DBCP로 돌려주기)
		close(conn);
		
		return result;
	}

	
	
	/** 회원 정보 수정
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int update(Member mem) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.update(conn, mem);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/**
	 * @param mem
	 * @param currentPw
	 * @param newPw
	 * @return
	 */
	public int changePw(Member mem, String currentPw, String newPw) throws Exception {
	
		
		Connection conn = getConnection();
		
		int result = dao.changePw(conn, mem,currentPw,newPw);
		
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		
		close(conn);
		
		
		return result;
	}

	public int secession(Member mem, String inputPw) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.secession(conn,mem,inputPw);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	
	
	/** 이메일 중복 검사 Service
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(String memberEmail) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.emailDupCheck(memberEmail, conn);
		
		return result;
	}

	
	/** 닉네임 중복 검사 서비스
	 * @param nickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String nickname) throws Exception {
		
		Connection conn =getConnection();
		
		int result = dao.nicknameDupCheck(nickname,conn);
		
		return result;
	}

	
	
	/** 회원 정보 조회
	 * @param memberEmail
	 * @return Member mem
	 */
	public Member selectOne(String memberEmail) throws Exception {
		
		Connection conn = getConnection();
		
		Member mem = dao.selectOne(memberEmail,conn);
		
		return mem;
	}



}
