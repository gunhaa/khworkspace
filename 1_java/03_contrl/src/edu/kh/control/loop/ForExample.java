package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample {

	/*for 문
	 * -끝이 정해져 있는 (횟수가 지정되어 있는) 반복분
	 * 
	 * [작성법]
	 * for(초기식 ; 조건식; 증감식){
	 * 
	 *    반복 수행할 코드 작성
	 *}
	 *
	 * -초기식 : for문을 제어하는 용도의 변수 선언
	 * 
	 * -조건식 : for문의 반복 여부를 지정하는 식
	 * 			보통 초기식에서 사용된 변수를 이용하여 조건식을 작성함
	 * -증감식 : 초기식에 사용된 변수를
	 * 			for문이 끝날 때 마다 증가 또는 감소 시켜서
	 * 			조건식의 결과를 변하게 하는 식
	 * 
	 */

	public void ex1() {
		//for문 기초 사용법1
		// 1~10 출력하기
		// --> 1부터 10까지 1씩 증가하면서 출력


		for(int i = 1 ; i <=10 ; i++) {
			// 1)초기식; 2) , 5) 조건식 ; 4), 7) 증감식  (코드의 진행순서,반복)
			//3) , 6) 반복 수행할 코드	
			//해당 for문이 종료됬다면 i 값은 11인채로 종료가 된다.
			System.out.println(i + "출력");

		}


		//1234 수행 후 -> 5~7을 반복한다 (조건식이 true 일 때 까지)
	}

	public void ex2() {
		//for문 기초 사용법2
		// 3에서 7까지 1씩 증가하며 출력
		// ->i의 값이 7이하일때 true가 되는 조건식을 쓰면 된다

		for(int i = 3 ; i<=7; i++) {
			System.out.print(i+" ");
		}
	}

	public void ex3() {
		//2부터 17까지 1씩 증가하면서 출력

		for(int i = 2 ; i<=17 ; i++) {
			System.out.println(i);
		}

	}

	public void ex4() {

		//1부터 입력 받은 수까지 2씩 증가하며 출력

		Scanner sc = new Scanner(System.in);

		System.out.print("끝번호 : ");
		int input = sc.nextInt();

		for(int i=1; i<=input; i+=2){
			//i = i+2 -> i에 기존 i값 +2
			System.out.print(i);
		}

	}

	public void ex5() {

		//1부터 입력 받은 실수까지 0.5씩 증가하며 출력
		Scanner sc= new Scanner(System.in);

		System.out.print("끝 번호 : ");
		double input=sc.nextInt();

		for(double i=1; i<=input; i+=0.5){
			System.out.print(i+" ");
			//자동 형변환으로 인해서 1이 아니고 1.0으로 표현된다.

		}

	}

	public void ex6() {
		//알파벳 A부터 Z까지 한 줄로 출력
		//*char 자료형은 문자형 이지만 실제로는 정수(문자표 번호)를 저장한다.
		// int i = 'A'로 설정하면 A에 저장된 값이 숫자로 저장됨
		for(int i = 'A'; i<='Z'; i++) {
			System.out.print((char)i+ " ");
			//강제 형변환
		}

		System.out.println("\n-------------------------------------------");
		for(char i = 'A' ; i <='Z' ; i++) {
			System.out.print(i+" ");
		}
	}

	public void ex7() {

		//10에서 1까지 1씩 감소하며 출력
		for(int i=10; i>=1 ; i--) {
			//여기에 선언된 i는 다음의 {안에서만 사용 할 수 있다.

			System.out.print(i+" ");
		}

	}

	public void ex8() {

		//for문 응용 1 : 반복문을 이용한 값의 누적

		//1부터 10까지 모든 정수의 합 구하기

		int sum = 0 ; //반복되어 증가하는 i값의 합계를 저장할 변수
		//0으로 시작하는 이유 : 아무것도 더하지 않음으로
		// 				 정확히 결과를 도출할 수 있기 때문
		for (int i=1; i<=10; i++) {
			//sum = sum + i; 아래식과 똑같음
			sum += i;
			System.out.println("합계 : "+ sum);
		}
		//System.out.println("합계 : "+ sum); for문의 최종 결과만을 보고 싶다면 밖으로 빼면 된다		
	}

	public void ex9() {

		//for문 응용 2 : 정수 5개를 입력 받아서 합계 구하기

		//ex)
		// 입력1 : 10 
		// 입력2 : 20 
		// 입력3 : 30 
		// 입력4 : 40 
		// 입력5 : 50 

		Scanner sc = new Scanner(System.in);

		int sum=0; //for 문 밖에 존재하는 변수로
		// 아래 for문이 끝나도 사용 가능

		for (int i=1 ; i<=5 ; i++) {
			System.out.print("입력 "+ i + " : ");
			int input=sc.nextInt();
			sum +=input;

			//System.out.println(input);
			//{}안에서 생성된 변수는 {}밖에서는 사용할 수 없다.
			//-> {}끝나는 시점에 사라지기 때문에
		}
		//이 for문이 끝났을때의 i 값은 6이다.
		//System.out.println(input); 에러
		System.out.println(sum);
	}

	public void ex10() {
		// 정수를 몇 번 입력 받을지 먼저 입력 받고
		// 입력된 정수의 합계를 출력

		// ex)
		// 입력 받을 정수의 개수 : 3
		// 입력 1 : 10
		// 입력 2 : 20
		// 입력 3 : 30
		// 합계 : 60

		// ex)
		// 입력 받을 정수의 개수 : 2
		// 입력 1 : 10
		// 입력 2 : 20
		// 합계 : 30		

		Scanner sc= new Scanner(System.in);

		/*		int sum=0;
		int input;
		System.out.print("입력 받을 정수의 개수 : ");
		int cycle=sc.nextInt();
		for(int i = 1 ; i<=cycle ; i++) {
			System.out.print("입력" +cycle + " : ");
			input = sc.nextInt();
			sum+=input;

		}

		System.out.println(sum);
	}
제대로 안돌아감
		 */
		System.out.print("입력 받을 정수의 개수 : ");
		int num=sc.nextInt();
		int sum=0;
		for(int i=1; i <= num ; i++) {
			System.out.print("입력" + i + " : ");
			int input = sc.nextInt();
			sum += input;
		}
		System.out.println("합계 : "+ sum);
	}


	public void ex11() {
		// 1 부터 20 까지 1씩 증가하면서 출력
		// 단, 5의 배수에 () 를 붙여서 출력
		// ex) 1 2 3 4 (5) 6 7 8 9 (10) 11 ...		
		for(int i=1; i<=20 ; i++) {

			if(i%5==0) { // i가 5의 배수인 경우
				System.out.printf("(%d) ",i);
			} else {
				System.out.print(i + " ");
			}
		}


	}

	public void ex12() {
		// 1 부터 20까지 1씩 증가하면서 출력
		// 단, 입력 받은 수의 배수는 () 표시

		// ex)
		// 괄호를 표시할 배수 : 3
		// 1 2 (3) 4 5 (6) ...

		// 괄호를 표시할 배수 : 4
		// 1 2 3 (4) 5 6 7 (8) 9 ...		
		Scanner sc = new Scanner(System.in);
		System.out.print("괄호를 표시할 배수 : ");
		int input=sc.nextInt();

		for(int i=1; i<=20 ; i++) {
			if(i%input==0) {
				System.out.printf("(%d) ",i);
			}else {
				System.out.print(i+" ");
			}
		}
	}

	public void ex13() {
		// [구구단 출력]
		// 2 ~ 9 사이 수를 하나 입력 받아
		// 해당 단을 출력
		// 단, 입력 받은 수가 2 ~ 9 사이 숫자가 아니면 "잘못 입력 하셨습니다" 출력		
		Scanner sc = new Scanner(System.in);

		System.out.print("수를 입력하세요 : ");
		int dan=sc.nextInt();
		if(dan>=2 && dan<=9) {
			for(int i=1; i<=9 ;i++) {
				System.out.printf(" %d X %d = %d\n", dan, i, dan*i);
			}
		} else {
			System.out.print("잘못 입력 하셨습니다.");		
		}

	}
	public void ex14() {
		// [19단 출력기]
		// 2 ~ 19단 사이 단을 입력 받아서 x 1 ~ x 19 까지 출력
		// 단, 2 ~ 19 사이 단이 입력되지 않으면 "잘못 입력 하셨습니다." 출력
		Scanner sc = new Scanner(System.in);

		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		if(dan>=2 && dan<=19) {
			for(int i=1; i<=19 ; i++) {
				System.out.printf("%d X %d = %d \n", dan, i , dan*i);				
			}
		} else {
			System.out.println("잘못 입력 하셨습니다.");
		}

	}
	//**중첩 반복문
	public void ex15() {
		// 구구단 모두 출력하기
		//시계가 중첩 반복문이다 ex)2024 - 04 - 17 14:06:23 (6개 짜리 중첩 반복문)
		for(int dan=2; dan<=9; dan++) { //2~9단까지 차례대로 증가
			//안쪽 for문이 반복하면서 하나의 단을 한 줄로 출력
			for(int num=1; num<=9; num++) { //각 단에 곱해 질 수 1~9까지 차례로 증가
				System.out.printf("%2d X %2d = %d " , dan, num, dan*num);
			}
			System.out.println(); //아무 내용없는 println() ==줄바꿈
		}



	}

	public void ex16() {
		//구구단을 역순으로 출력

		//9단부터 -> 2단 까지 역방향
		// 곱해지는 수는 1->9 정방향

		for (int dan=9; dan>=2 ; dan--) {

			for(int num=1; num<=9; num++) {
				System.out.printf("%2d X %2d = %2d /", dan, num, dan*num);
			} //한 단의 출력 종료

			System.out.println(); //줄바꿈
		}

	}

	public void ex17() {
		//2중 for문을 이용해서 다음 모양을 출력하시오
		//12345
		//12345
		//12345
		//12345
		//12345
		for(int x=1 ; x<=5 ; x++) { //5바퀴 반복하는 for문

			for(int i=1 ; i<=5 ; i++) { //12345 한줄 출력하는 for문
				System.out.print(i);				
			}
			System.out.println();//줄바꿈

		}

		System.out.println("-----------------------------");

		for(int y=1 ; y<=3 ; y++) {
			for(int j=5; j>=1; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

	public void ex18() {
		//2중 for문을 이용하여 다음 모양을 출력하시오

		//1
		//12
		//123
		//1234
		//i가 1이면 4

		for( int i=1; i<=4 ; i++) {//줄을 반복해주는 부분
			for(int j=1; j<=i ; j++) {//출력을 반복하는 부분
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println("-----------------------------");

		//4321
		//321
		//21
		//1
		for(int x=4; x>=1; x--) {//줄 반복

			for(int i=x; i>=1 ; i--) { //숫자출력
				System.out.print(i);
			}
			System.out.println();//줄바꿈
		}

		//x가 4일때 4 3 2 1
		//x가 3일떄 3 2 1
		//x가 2일때 2 1
		//x가 1일때 1

	}

	public void ex19() {
		// count (숫자 세기)

		// 1부터 20까지 1씩 증가하면서
		// 3의 배수의 총 개수 출력

		// 3 6 9 12 15 18 : 6개
		int count = 0; //3의 배수의 개수를 세기 위한 변수
		int sum =0;//3의 배수의 합계를 구하기 위한 변수
		for(int i=1 ; i<=20 ; i++) {
			if(i%3==0) { //3의 배수

				System.out.print(i+" ");

				count++; //if문이 동작할때마다 1씩 증가한다.
				sum+=i;
			}

		}
		System.out.println(": "+count + "개");
		System.out.println("3의 배수의 합계 : "+sum);

	}

	public void ex20() {
		// 2중 for문과 count를 이용해서 아래 모양 출력하기
		//  1  2  3  4
		//  5  6  7  8
		//  9 10 11 12
		/*
		for(int i = 1 ; i<=4 ; i++) {
			for(int j=1 ; j<=4 ; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		안됨
		 */

		int count =1;

		for(int x=1; x<=3; x++) {//3줄
			for(int i=1; i<=4; i++) { //4칸
				System.out.printf("%3d" , count); //%3d는 정수가 들어갈 칸 3칸
				count++;
			}
			System.out.println();
		}

	}

	public void ex21() {
		

	}

}

