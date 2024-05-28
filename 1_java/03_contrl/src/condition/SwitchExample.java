package condition;

import java.util.Scanner;

public class SwitchExample {

	/* switch문
	 * - 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	 * -> 식의 결과로 얻은 값과 같은 case 구문이 수행 된다.
	 * [작성법]
	 * switch(식){
	 * case 결과값 1 : 수행코드1; break;
	 * case 결과값 2 : 수행코드2; break;
	 * case 결과값 3 : 수행코드3; break;
	 * ...
	 * defult : case를 모두 만족하지 않을 경우 수행하는 코드;
	 * }
	 */

	public void ex1() {
		//키보드로 정수를 입력 받아
		//1이면 "빨간색"
		//2이면 "주황색"
		//3이면 "노란색"
		//4이면 "초록색"
		//1-4사이 숫자가 아니라면 "흰색" 출력
		/*
		Scanner sc = new Scanner(System.in);
		                        //System.in : 키보드 입력 을 뜻한다.
		String color;

		System.out.print("숫자를 입력하세요 : ");

		int num = sc.nextInt();

		if(num==1) {
			color = "빨간색";
		} else if(num==2) {
			color = "주황색";
		} else if(num==3) {
			color = "노란색";
		} else if(num==4) {
			color = "초록색";
		} else {
			color = "흰색";
		}
		System.out.println(color);
		 */

		Scanner sc = new Scanner(System.in);

		String color;
		System.out.print("숫자를 입력하세요 : ");
		int input = sc.nextInt();
		//여러 값이 나오는 식
		switch(input) {

		case 1 : color = "빨간색"; break;
		//input에 입력된 값이 1인 경우(case)
		//color 변수에 "빨간색"을 대입하고 switch 문을 멈춤(break)
		case 2 : color = "주황색"; break;
		case 3 : color = "노란색"; break;
		case 4 : color = "초록색"; break;
		default : color = "흰색"; 
		}

		System.out.println(color);

	}

	public void ex2() {
		
		//정수를 입력 받아 4팀으로 나누기
		//1이면 백팀
		//2이면 홍팀
		//3이면 청팀
		//너머지는 흑팀
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호 입력 : ");
		int input = sc.nextInt();
		String team;
		
		switch(input%4) {
		case 1 : team = "백팀"; break;
		case 2 : team = "홍팀"; break;
		case 3 : team = "청팀"; break;
		default : team = "흑팀";
		
		}
		
		System.out.println(team + " 입니다.");
		
	}

	public void ex3() {
		
		//달 입력 시 계절 판별(switch 버전)
		
		
		Scanner sc= new Scanner(System.in);
		System.out.print("달을 입력하세요 : ");
		int input = sc.nextInt();
		String season;
		switch(input) {
		case 3,4,5 : season = "봄"; break;
		case 6,7,8 : season = "여름"; break;
		case 9,10,11 : season = "가을"; break;
		case 12,1,2 : season = "겨울"; break;
		default : season = "잘못 입력 하셨습니다.";
		
		}
		
		System.out.println(season);
		
		/* switch(month) {
		 * case 1 : case 2 : case 12 : season = "겨울" ; break;
		 * case 3 : case 4 : case 5 : season = "봄"; break;
		 * case 6 : case 7 :case 8 :season ="여름" ; break; 
		 * case9 : case10 : case11 : season = "겨울"; break;
		 * default : season = "잘못 입력" ; 
		 * } 
		 * 
		 */
		
	}
	
	public void ex4() {
		//정수 2개와 연산자 (+ - * / %) 한가지를 입력 받아서 결과 출력
		//
		// ex)
		// 정수 1 입력 : 4
		// 연산자 입력 : *
		// 정수 2 입력 : 3
		// 계산 결과 : 4*3 = 12
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("숫자를 입력하세요 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자를 입력하세요 : ");

		String input = sc.next();
		switch(input) {
		case "+" : System.out.println(num1+num2); ; break;
		case "-" : System.out.println(num1-num2); ; break;
		case "*" : System.out.println(num1*num2); ; break;
		case "/" : System.out.println(num1/num2); ; break;
		case "%" : System.out.println(num1%num2); ; break;
		}
        문제없이 작동되는듯?*/
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 1 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		//sc.nextChar(); 스캐너는 문자 하나 (char)를 입력 받는 기능이 별도로 존재하지 않음
		
		String op = sc.next(); // 다음 입력되는 한 단어(String) 읽어오기
		// (char) 'a'와 (string)는 "a" 다르다

		System.out.print("정수 2 입력: ");
		int num2 = sc.nextInt();
		 //case에 작성되는 값은 switch 식의 결과값 자료형의 리터럴 표기법이다.
		switch(op) {
		case "+" : System.out.printf("%d+%d=%d\n", num1, num2, num1+num2); break;
		case "-" : System.out.printf("%d-%d=%d\n", num1, num2, num1-num2); break;
		case "*" : System.out.printf("%d*%d=%d\n", num1, num2, num1*num2); break;
		case "/" :
			if(num2==0) { //오류가 발생되는 경우
			System.out.println("0은 나눌수 없습니다.");	
			} else {
			System.out.printf("%d/%d=%d\n", num1, num2, num1/num2);
			}
			break;

			
		
		case "%" : System.out.printf("%d %% %d=%d\n", num1, num2, num1%num2); break;
										//% 하나만 쓰면 에러난다. 뭔지 알수없어서 %%로 해야함
										// 4 /0 은 산술적 오류가 생긴다.
		default : System.out.println("존재하지 않는 연산자 입니다.");
		}
		
		//(int)1와 (string)"1"는 다르다
	
	
	}
	
	
}
