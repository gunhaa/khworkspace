package edu.kh.control.loop;

import java.util.Scanner;

public class WhileExample {

	/*while 문
	 * -별도의 초기식, 증감식이 존재하지 않고
	 * 반복 종료 조건을 자유롭게 설정하는 반복문이다.
	 * 
	 * 	 ** 확실히 언제 반복이 끝날지는 모르지만
	 * 		언젠간 반복 조건이 false가 되는 경우 반복을 종료한다.
	 * 
	 * [작성법]
	 * while(조건식){
	 * 조건식이 true일때 반복 수행할 구문
	 * }
	 * 
	 */
	
	public void ex1() {
		Scanner sc= new Scanner(System.in);
		int input =0;
		
		
		while(input != 9) {
			System.out.println("----------------------------------------");
			System.out.println("----------------메뉴 선택  ----------------");
			System.out.println("1. 돈가스");
			System.out.println("2. 제육 볶음");
			System.out.println("3. 떡볶이");
			System.out.println("9. 종료");
			
			System.out.println("메뉴 선택 >> ");
			input = sc.nextInt();
			switch(input) {
			 case 1 : 
				 System.out.println("돈가스를 주문했습니다.");
				 break;
			 case 2 :
				 System.out.println("제육 볶음을 주문했습니다.");
				 break;
			 case 3 :
				 System.out.println("떡볶이를 주문했습니다.");
				 break;
			 case 9 : 
				 System.out.println("메뉴 선택을 종료 합니다.");
				 break;
			 default :
				 System.out.println("잘못 입력하셨습니다.");

				//input 9를 넣어야 종료된다.	 
			}
			
			
		}
		
		
	}
	
	public void ex2() {
		//입력되는 모든 정수의 합을 구하시오
		//단, 0이 입력되면 반복을 종료 후 결과 출력
		
		//-> 0 이 입력되지 않으면 계속 반복
		Scanner sc = new Scanner(System.in);
		int input = -1; //입력 받은 값을 저장할 변수
		//1) 0이 아닌 값을 대입하여 while문이 처음에 수행될 수 있도록 함
		
		int sum = 0; //모든 정수의 합을 저장하는 변수
		
		while (input != 0 )//input이 0이 아니라면 계속 반복한다 
			{
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			
			sum += input; // 입력 받은 값을 sum에 누적
			
			
		}
		
		System.out.println("합계 : "+sum);
		
	}
	
	public void ex3() {
		//입력되는 모든 정수의 합을 구하시오
		//단, 0이 입력되면 반복을 종료 후 결과 출력
		
		//-> 0 이 입력되지 않으면 계속 반복
		Scanner sc = new Scanner(System.in);
		int input = 0; //입력 받은 값을 저장할 변수
		
		int sum = 0; //모든 정수의 합을 저장하는 변수

		//2) while문을 최소 한번은 수행하는 반복문이 존재
		// -> do ~ while
			
		//input이 0이 아니라면 계속 반복한다 
			do {
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			
			sum += input; // 입력 받은 값을 sum에 누적
			
			
		} while (input != 0 );
		
		System.out.println("합계 : "+sum);
		
	}
	

	
	
}
