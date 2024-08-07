package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // Service Layer 서비스 담당 계층
         // 비즈니스 로직(데이터 가공, dao 호출, 트랜잭션 제어)을 처리하는 클래스임을 명시
     	 // + Bean으로 등록하는 어노테이션
public class MemberServiceImpl implements MemberService{


	// 작성된 필드와 Bean으로 등록된 객체 중
	// 타입이 일치하는 Bean을 해당 필드에 자동으로 주입(Injection)하는 어노테이션
	// == DI(Dependency Injection, 의존성 주입)
	// -> 객체를 직접 만들지 않고 Spring이 만든 것을 주입함(Spring에 의존)
	@Autowired
	private MemberDAO dao;

	
	@Autowired // bean으로 등록된 객체 중 타입이 일치하는 Bean을 DI
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public Member login(Member inputMember) {
		
		// 암호화 추가 예정
//		System.out.println("암호화 확인 : "+bcrypt.encode(inputMember.getMemberPw()));
		
		// bcrypt 암호화는 salt가 추가되기 때문에
		// 계속 비밀번호가 바뀌게 되어서 DB에서 비교 불가능!!
		// -> 별도로 제공해주는 matches(평문, 암호문)을 이용해서 비교
		
		// dao메소드 호출
		Member loginMember=dao.login(inputMember);
		
		if(loginMember != null) { // 이메일이 일치하는 회원이 조회된 경우
			
			// 입력한 pw와 암호화딘 pw가 같은지 확인
			
			if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) { //같은 경우
				
				// 비밀번호를 유지하지 않기 위해서 로그인 정보에서 제거
				loginMember.setMemberPw(null);
				
			} else { // 다를 경우
				
				loginMember = null; // 로그인 실패처럼 만듬
				
			}
			
		}
		
		return loginMember;
	}


	// 회원 가입 서비스
	//@Transactional(rollbackFor = Exception.class) 
	//예외가 발생하면 rollback 
	//발생 안하면 Service 종료 시 commit
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int signUp(Member inputMember) {
		
		// 비밀번호를 BCrypt를 이용하여 암호화 한 후 다시 inputMember에 세팅
		
		String cryptPw = bcrypt.encode(inputMember.getMemberPw());
		
		inputMember.setMemberPw(cryptPw);
		
		int result = dao.signUp(inputMember);
	
		return result;
	}
	
	
	
	
	
}
