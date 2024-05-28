package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class service {
	private int input = 99;
	private boolean flag = true;
	Scanner sc = new Scanner(System.in);

	List<member> member = new ArrayList<member>();

	
	public void start() {



		while(flag) {

			System.out.println("로그인 메뉴");			
			System.out.println("1.회원 가입");			
			System.out.println("2.로그인");
			System.out.println("0.종료");
			System.out.println("몇번? ");
			input = sc.nextInt();			

			switch(input) {
			case 1 : signIn();
				break;
			case 2 : login();
				break;
			case 0 : 
				flag=false;
				break;
			default : 
				System.out.println("잘못 입력하셨습니다 다시 입력해주세요");

			}

		}

		sc.close();
		System.out.println("----종료");
	}

	
	
	public void signIn() {

		System.out.println("아이디를 입력해주세요");
		String inputId=sc.nextLine();	
		System.out.println("비밀번호를 입력해주세요");
		String inputPw=sc.nextLine();
		System.out.println("이름을 입력해주세요");
		String inputName=sc.nextLine();

		
		member.add(new member(inputId, inputPw,inputName));
		System.out.println("회원 가입이 완료 되었습니다.");
	
	}
	
	public void login() {

	}



}
