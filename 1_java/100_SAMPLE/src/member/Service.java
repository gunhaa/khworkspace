package member;

import java.util.Scanner;

public class Service {

	Scanner sc = new Scanner(System.in);

	private Member loginInfo = null;
	//이 앞에있는게 의미하는건 뭐임?

	public void displayMenu(){

		int menuNum= 0;

		do {System.out.println("=====회원 정보 관리 프로그램 v1=====");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 회원 정보 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("0. 프로그램 종료");

		System.out.print("메뉴 입력 >> ");
		menuNum = sc.nextInt(); //필드에 작성된 Scanner sc 사용

		switch(menuNum) {

		case 1:

			System.out.println(signUp());
			break;
			//같은 클래스 내부에 있는 필드, 메소드는 이름만 불러도 호출 가능!
		case 2:

			//	System.out.println( login() );

			break;

		case 3:

			//	System.out.println(selectMember());
			break;

		case 4:

			//	int result = updateMember();

			//	if(result==-1) {
			//		System.out.println("로그인 후 이용해주세요.");
			//	} else if (result==1) {
			//		System.out.println("회원 정보가 수정 되었습니다.");
			//	} else {
			//		System.out.println("회원 정보 수정 실패(비밀번호 불일치)");
			//	}



			break;
		case 0:
			System.out.println("프로그램을 종료합니다...");
			break;
		default :
			System.out.println("잘못 입력하셨습니다. 다시 입력 해주세요.");

		}



		} while(menuNum != 0);

	}

	public String signUp() {

		System.out.println("*****회원 가입******");

		System.out.println("아이디 : ");
		String inputId= sc.nextLine();
		System.out.println("비밀번호 : ");
		String inputPw=sc.nextLine();
		System.out.println("비밀번호 확인 : ");
		String inputPw2=sc.nextLine();
		System.out.println("이름 : ");
		String inputName=sc.nextLine();
		System.out.println("나이 : ");
		String inputAge = sc.nextLine();

		if(inputPw.equals(inputPw2)) {

			loginInfo = new Member(inputId,inputPw,inputName , inputAge);
			System.out.println();
			return " 회원 가입 성공 " ;

		} else {

			return "비밀번호가 일치하지 않습니다.";
		}

	}

	public String login() {

		System.out.println("아이디 : ");
		String inputId = sc.next();
		System.out.println("비밀 번호 : ");
		String inputPw = sc.next();
			if(inputPw.equals(loginInfo.getMemberPw())) {
				return "로그인 성공";
			}else {
				return "비밀 번호가 일치하지 않습니다.";
			}
		
	}

}