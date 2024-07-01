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

}
