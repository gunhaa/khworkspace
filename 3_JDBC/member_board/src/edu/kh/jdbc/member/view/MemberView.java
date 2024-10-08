package edu.kh.jdbc.member.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.member.model.service.MemberService;
import edu.kh.jdbc.member.model.vo.Member;

/**
 * @author user1
 *
 */
public class MemberView { //회원 관련 화면 입/출력


	private Scanner sc = new Scanner(System.in);

	//회원 관련 서비스 제공 객체 생성 및 참조
	private MemberService service = new MemberService();

	/**
	 * 회원 가입 화면 출력용 메소드
	 */
	public void signUp() {
		System.out.println("[회원 가입]");

		try {

			String memberId =null;
			String memberPw =null;
			String memberPw2 =null;
			String memberName =null;
			char memberGender =' ';


			while(true) {
				System.out.println("아이디 : ");
				memberId = sc.nextLine();
				/*아이디 중복 검사(DB에 일치하는 아이디가 있으면 "중복" -> 다시 아이디 입력 받기)*/

				int result = service.duplicateCheck(memberId);
				//result가 중복이면 1, 아니면 0 반환 예정

				if(result == 0) { //중복이 아닌 경우 반복문 종료
					System.out.println("[사용 가능한 아이디 입니다.]");
					break;
				} else {
					System.out.println("[이미 사용중인 아이디 입니다. 다시 입력해주세요.]");
				}
			} // 중복 검사 while 종료

			// 비밀번호, 비밀번호 확인을 각각 입력 받아
			// 일치할 때 까지 무한 반복
			while(true) {

				System.out.println("비밀번호를 입력해주세요");
				memberPw = sc.nextLine();

				System.out.println("비밀 번호를 다시 입력해주세요");
				memberPw2 = sc.nextLine();

				if(memberPw.equals(memberPw2)) { //일치하면 멈춘다
					System.out.println("비밀 번호가 일치 합니다");
					break;
				} else {
					System.out.println("비밀 번호가 일치하지 않습니다. 다시 입력해주세요");
				}

			}

			//이름 입력

			System.out.println("이름을 입력해주세요");
			memberName = sc.nextLine();


			//성별이 'M'또는 'F'가 입력될 때까지 반복
			while(true) {
				System.out.println("성별을 입력해주세요 (M/F)");
				memberGender=sc.nextLine().toUpperCase().charAt(0);
				//String.toUpperCase() : 문자열을 대문자로 변환

				/*
				if(memberGender=='M' || memberGender=='F') {
					System.out.println("가입 되었습니다.");
					break;
				} else {
					System.out.println("형식에 맞춰 다시 입력해주세요.");
				}
				 */

				if(memberGender != 'M' && memberGender != 'F') {
					System.out.println("\n[성별은 M또는 F만 입력해 주세요.]\n");

				} else {
					break;
				}	
			}
			// 입력 받은 값을 하나의 객체(Member) 에 저장

			Member signUpMember = new Member(memberId , memberPw, memberName, memberGender);

			// 회원가입 Service 호출 후 결과 반환 받기
			// - 회원 가입 == DB에 회우너 정보 삽입 
			//  -> DML 구문 수행 시 성공한 행의 개수가 반환됨 == int 형 변수에 결과 저장

			int result = service.signUp(signUpMember);

			//Service 결과에 따른 화면 처리
			if(result > 0) {//가입 성공 시
				System.out.println("\n ***회원 가입 성공 ***\n");

			}else {
				System.out.println("[회원 가입 실패]");
			}


		}catch(Exception e) {

			System.out.println("\n <회원 가입 중 예외 발생> \n");
			e.printStackTrace();

		}



	}

	/**
	 * 로그인 메소드
	 */
	public Member login() {

		System.out.println("[로그인]");

		System.out.println("아이디 : ");
		String memberId = sc.next();

		System.out.println("비밀 번호 : ");
		String memberPw = sc.next();

		//Member 객체를 생성하여 입력 받은 값 세팅
		Member mem = new Member();
		mem.setMemberId(memberId);
		mem.setMemberPw(memberPw);

		//로그인 Service 수행 후 결과 반환 받기
		Member loginMember=null;

		try {
			loginMember = service.login(mem);

			if(loginMember != null) { //로그인 성공
				// 000님 환영합니다.
				System.out.println(loginMember.getMemberId()+"님 환영합니다.");
			} else { //로그인 실패(아이디랑 비밀번호 불일치)
				System.out.println("\n[아이디 또는 비밀번호가 일치하지 않습니다.]\n");
			}

		}catch(Exception e) {
			System.out.println("로그인 과정에서 에러 발생");
			e.printStackTrace();
		}

		return loginMember;
	}

	/**내 정보 조회
	 * @param loginMember
	 */
	public void myInfo(Member loginMember) {
		System.out.println("[내 정보 조회]");

		System.out.println("회원 번호 : "+loginMember.getMemberNo());
		System.out.println("아이디 : "+loginMember.getMemberId());
		System.out.println("이름 : "+loginMember.getMemberName());

		if(loginMember.getMemberGender()=='M' || loginMember.getMemberGender()=='m') {
			System.out.println("성별 : 남자");
		} else {
			System.out.println("성별 : 여자");
		}

		System.out.println("가입일 : "+loginMember.getEnrollDate());


	}

	/**
	 *  가입된 회원 목록 조회 View
	 */
	public void selectAll() {
		System.out.println("[가입된 회원 목록 조회]");

		try {

			//회원 정보 조회 Service 호출 후 결과 반환 받기
			List<Member> memberList = service.selectAll();

			if(memberList.isEmpty()) { //조회 결과가 없는 경우 == 비어있음
				System.out.println("조회 결과가 없습니다.");
			} else {

				for(Member m : memberList) {
					//	System.out.println("아이디 : "+m.getMemberId()+"\n이름 : "+ m.getMemberName()+"\n가입일 : "+m.getEnrollDate()+"\n");
					System.out.printf("%12s %12s %20s \n", m.getMemberId(), m.getMemberName(), m.getEnrollDate());
					//EnrollDate는 String 으로 자동 형변환 되었다. m.getEnorollDate().toString()이 실행된 것과 같다.

				}
			}


		}catch(Exception e) {
			System.out.println("\n <회원 목록 조회 과정에서 예외 발생>");
			e.printStackTrace();
		}

	}

	/** 내 정보 수정
	 * @param loginMember
	 */
	public void updateMyInfo(Member loginMember) {
		System.out.println("[내 정보 수정(이름, 성별)]");
		try {
			System.out.println("변경할 이름 : ");
			String memberName = sc.next();

			System.out.println("변경할 성별(M/F) : ");
			char memberGender = sc.next().toUpperCase().charAt(0);

			// 입력 받은 값 + 로그인한 회원 번호를 하나의 Member객체에 저장
			// (로그인한 회원 번호 == 어떤 회원 정보를 수정할지 지정)

			Member updateMember = new Member();
			updateMember.setMemberName(memberName);
			updateMember.setMemberGender(memberGender);
			updateMember.setMemberNo(loginMember.getMemberNo());

			int result = service.updateMyInfo(updateMember);
			//내 정보 수정 서비스 호출 후 결과 반환 받기

			//UPDATE == DML == 성공한 행의 개수 반환

			if(result != 0) {// 수정 성공
				System.out.println("수정에 성공하였습니다.");

				// DB의 수정된 내용과 현재 로그인한 회원 정보를 일치 시킴
				// 얕은 복사 : 참조 주소만 복사하여 같은 객체를 참조
				// -> 특징 : 복사된 주소를 참조하여 수정하면 원본 객체가 수정된다.
				loginMember.setMemberName(updateMember.getMemberName());
				loginMember.setMemberGender(updateMember.getMemberGender());

			} else {
				System.out.println("수정에 실패하였습니다.");
			}


		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**비밀번호 수정
	 * @param loginMember
	 */
	public void updatePw(Member loginMember) {
		System.out.println("[내 비밀번호 수정]");
		try {
			// 현재 비밀번호(UPDATE 조건)
			// 새 비밀번호
			// 새 비밀번호 확인 -> 둘이 일치할때까지 무한 반복

			// 성공 : "[비밀번호가 변경 되었습니다.]"
			// 실패 : "[비밀번호가 일치하지 않습니다.]"
			sc.nextLine();
			System.out.println("현재 비밀 번호를 입력해주세요.");
			String nowPw= sc.nextLine();

			String inputPw="";
			String inputPw2="";
			
			while(true) {
				if(inputPw.equals(inputPw2)) {
					System.out.println("비밀 번호를 입력해주세요.");
					inputPw=sc.nextLine();
				
					System.out.println("비밀 번호를 다시 입력해주세요.");
					inputPw2=sc.nextLine();
					
					break;
				} else {
					System.out.println("[비밀번호가 일치하지 않습니다. 다시 입력해주세요]");
				}
			}
			
			int result = service.updatePw(loginMember.getMemberNo(), nowPw, inputPw);

			if(result != 0) {
				System.out.println("비밀번호가 변경 되었습니다.");
			} else {
				System.out.println("비밀번호 변경이 실패하였습니다.");
			}


		} catch(Exception e) {
			System.out.println("비밀번호 수정 중 오류 발생");
			e.printStackTrace();
		}


	}

	
	
	/** 회원 탈퇴 View
	 * @param loginMember
	 */
	public int secession(Member loginMember) {
		System.out.println("[회원 탈퇴]");
		int result = 0;
		
		try {
		// 1) 현재 비밀번호 입력 받기
		sc.nextLine();
		System.out.println("비밀번호 입력 : ");
		String memberPw=sc.nextLine();
		
		// 2) "정말 탈퇴하시겠습니까?(Y/N)"
		System.out.println("정말 탈퇴 하시겠습니까?(Y/N) : ");
		char ch = sc.nextLine().toUpperCase().charAt(0);
		
		// 3) (y입력 시) 회원 탈퇴 Service 수행
		
		if(ch=='Y') {
			
			result = service.secession(loginMember.getMemberNo(), memberPw);
			
			if(result!=0) {
				
				System.out.println("탙퇴 되었습니다.");
				// loginMember = null;
				// 매개 변수로 전달받은 값(주소 복사본)을 저장할 뿐이다.
				//-> 복사본이 사라진다고 해도 원본(MainView의 loginMember)은 
				//   사라지지 않는다! -> 로그아웃 안됨!!
			} else {
				
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
		} else if(ch=='N') {
			System.out.println("[회원 탈퇴 취소]");
		}
		
		
		// 4) 탈퇴 성공 -> "탈퇴 되었습니다."
		//    탈퇴 실패 -> "비밀번호가 일치하지 않습니다."
		
		
		
		//(N입력 시) "회원 탈퇴 취소"

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}