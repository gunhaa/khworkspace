package edu.kh.project.myPage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.dao.MyPageDAO;


@Service //비즈니스 로직 처리 클래스 + Bean 등록(IOC)
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired //MyPageDAO 의존성 주입(DI)
	private MyPageDAO dao;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	// 스프링에서는 트랜잭션을 처리할 방법을 지원해줌.(코드기반, 선언적)
	   // 1) <tx:advice> -> AOP를 이용한 방식(XML에 작성)
	   
	   // 2) @Transactional 어노테이션을 이용한 방식(클래스 또는 인터페이스에 작성)
	   // - 인터페이스를 구현한 클래스로 선언된 빈은 인터페이스 메소드에 한해서 트랜잭션이 적용됨
	   // * 트랜잭션 처리를 위해서는 트랜잭션 매니저가 bean으로 등록되어 있어야 함. 
	   //   -> root-context.xml 작성
	   // * tx:annotaion-driven 추가 -> @Transactional 어노테이션 인식, 활성화 해야함.
	   //   servlet-context.xml 작성
	   
	   // 정상 여부는 RuntimeException이 발생했는지 기준으로 결정되며, 
	   // RuntimeException 외 다른 Exception(대표적으로 SQLException 등)에도 트랜잭션 롤백처리를 적용하고 싶으면 
	   // @Transactional의 rollbackFor 속성을 활용하면 된다
	@Override
	@Transactional(rollbackFor = {Exception.class, IndexOutOfBoundsException.class})
	public int update(Member updateMember) {
		
		int result = dao.update(updateMember);
		
		return result;
	}


	// 비밀번호 변경 서비스
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		// 1. 현재 비밀번호, DB에 저장된 비밀번호 비교
		// 1) 회원 번호가 일치하는 MEMBER테이블의 MEMBER_PW조회
		
		String encpw = dao.nowPw(memberNo);
		
		
		// 2) 비밀번호가 같으면(bcrypt.matches(평문, 암호문)) 비밀번호 수정 진행 -> 결과 반환
		if(bcrypt.matches(currentPw, encpw)) {
			//2. 비밀번호 변경 doa 호출
			return dao.changePw(bcrypt.encode(newPw), memberNo);
		}
		
		// 3) 비밀번호가 일치하지 않으면 0 반환

		return 0;
	}


	@Override
	public int secession(int memberNo, String memberPw) {
		
		String encpw=dao.nowPw(memberNo);
		
		if(bcrypt.matches(memberPw, encpw)) {
			return dao.secession(memberNo);
		}
		// 비밀번호 일치하지 않을시 0 반환
		return 0;
	}
	
	
	
}
