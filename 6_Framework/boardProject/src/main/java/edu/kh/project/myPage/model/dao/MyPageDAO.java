package edu.kh.project.myPage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // 저장소(DB)와 관련된 클래스 + Bean 등록(스프링이 객체 관리, IOC)
public class MyPageDAO {

	// 등록된 Bean 중 타입이 SqlSessionTemplate으로 일치하는 Bean을 주입(의존성 주입DI)
	// -> root-context.xml에 <bea> 작성됨
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 회원 정보 수정 DAO
	 * @param updateMember
	 * @return result
	 */
	public int update(Member updateMember) {
		return sqlSession.update("myPageMapper.updateInfo", updateMember);
	}

	/** 회원 비밀번호 조회
	 * @param memberNo
	 * @return encPw
	 */
	public String nowPw(int memberNo) {
		return sqlSession.selectOne("myPageMapper.nowPw", memberNo);
	}

	/** 비밀번호 변경
	 * @param encodePw
	 * @param memberNo
	 * @return result
	 */
	public int changePw(String encodePw, int memberNo) {
		
		// Mybatis에서 SQL 수행 시
		// 전달할 수 있는 파라미터는 한개 뿐!
		
		// -> 여러 파라미터를 전달해야 하는 경우
		//    Map 또는 DTO로 묶어서 전달
		Member mem = new Member();
		mem.setMemberNo(memberNo);
		mem.setMemberPw(encodePw);
	

		return sqlSession.update("myPageMapper.changePw", mem);
	}

	/** 회원 탈퇴
	 * @param memberNo
	 * @return 회원 탈퇴
	 */
	public int secession(int memberNo) {
		// sqlSessionTemplate : 마이바티스 + DBCP + close 자동 + 트랜잭션 처리
		return sqlSession.update("myPageMapper.secession", memberNo);
	}
	
}
