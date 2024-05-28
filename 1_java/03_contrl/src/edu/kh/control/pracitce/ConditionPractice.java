package edu.kh.control.pracitce;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();

		if(num<0 || num==0) {
			System.out.println("양수만 입력해주세요.");
		} else if(num%2 == 0) {
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("홀수 입니다.");	
		}


	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("국어 점수 : ");
		int kr = sc.nextInt();
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();

		int sum= kr+math+eng;
		double avg = sum /3;


		if(avg<60) {
			System.out.println("불합격 입니다.");
		} else if(math<40 && kr<40 && eng<40) {
			System.out.println("불합격 입니다.");
		} else {
			System.out.printf("국어 : %d \n 수학 : %d \n 영어 : %d \n 합계 : %d \n 평균 : %.2f \n 축하합니다, 합격입니다.!", kr,math,eng,sum,avg );
		}

	}

	public void practice3() {
		/*
		Scanner sc = new Scanner(System.in);

		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		switch (month) {
		case 1,3,5,7,8,10,12 : System.out.printf("%d월은 31일 까지 있습니다.", month); break;
		case 2 : System.out.println("2월은 28일 까지 있습니다."); break;
		case 4,6,9,11 : System.out.printf("%d월은 30일 까지 있습니다.", month); break;
		default : System.out.printf("%d월은 잘못 입력된 달 입니다.",month);
		}
		작동 잘 되는듯
		 */
		//풀이
		Scanner sc = new Scanner(System.in);

		System.out.print("1~12 사이의 정수 입력 :");
		int month = sc.nextInt();

		switch(month) {
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
			System.out.println(month+"월은 31일까지 있습니다."); break;

		case 4 : case 6 : case 9 : case 11 :
			System.out.println(month + "월은 30일까지 있습니다."); break;

		case 2 : System.out.println(month + "월은 28일까지 있습니다."); break;

		default : System.out.println(month + "월은 잘못 입력된 달 입니다.");

		}


	}



	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		double bmi=weight/(height*height);
		System.out.println("BMI 지수 : " + bmi);
		if(bmi<18.5) {
			System.out.println("저체중");
		} else if(bmi>18.5 &&23>bmi) {
			System.out.println("정상체중");
		} else if(bmi>23 && 25>bmi) {
			System.out.println("과체중");
		} else if(bmi>=25 && 30>bmi) {
			System.out.println("비만");
		} else {
			System.out.println("고도 비만");
		}


	}


	/*public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");
		double mid = sc.nextDouble();
		System.out.print("기말 고사 점수 : ");
		double end = sc.nextDouble();
		System.out.print("과제 점수 : ");
		double score = sc.nextDouble();
		System.out.print("출석 횟수 : ");
		double hi = sc.nextDouble();

		mid *= 0.2;
		end *= 0.3;
		score *= 0.3;
		double total=mid+end+score+hi;

		if(hi<14) {
			System.out.printf("Fail [출석 횟수 부족 (%.1f/20)]", hi);
		} else if(total<=70) {
			System.out.printf("중간 고사 점수(20) : %f \n 기말 고사 점수(30) : %.1f \n 과제 점수 : (30) %.1f \n 출석 점수 (20) : %.1f \n 총점 : %.1f \n Fail [점수미달]", mid, end, score, hi, total);
		} else {
			System.out.printf("중간 고사 점수(20) : %f \n 기말 고사 점수(30) : %.1f \n 과제 점수 : (30) %.1f \n 출석 점수 (20) : %.1f \n 총점 : %.1f \n PASS", mid, end, score, hi, total);			
		}
		작동 잘됨. 선생님 해답
	}*/


	public void practice5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("중간 고사 점수 : ");
		double midTerm = sc.nextDouble();

		System.out.print("기말 고사 점수 : ");
		double finalTerm = sc.nextDouble();

		System.out.print("과제 점수 : ");
		double homework = sc.nextDouble();

		System.out.print("출석 횟수 : ");
		double attendance = sc.nextDouble();

		System.out.println("==================== 결과 ===========================");

		if(attendance <= 20 * (1-0.3)){//30%이상 결석 <-> 70%미만 출석이다.
			System.out.println("Fail [출석 횟수 부족 ("+ (int)attendance + " / 20)]");
														// double attendance를 int로 형변환 시켜서 소수점을 지운것
		}else {
			midTerm *= 0.2;
			finalTerm *= 0.3;
			homework *= 0.3;
			attendance *= 5*0.2;
			//합계
			double sum = midTerm+finalTerm+homework+attendance;
			System.out.printf("중간 고사 점수(20) : %.1f \n", midTerm);
			System.out.printf("기말 고사 점수(20) : %.1f \n", finalTerm);
			System.out.printf("과제 점수(20) : %.1f \n", homework);
			System.out.printf("출석 점수(20) : %.1f \n", attendance);
			System.out.printf("총점 : %.1f \n", sum);
			
			if(sum >= 70) {
				System.out.println("PASS");
			} else {
				System.out.println("Fail [점수 미달]");
			}
			
		}

	}
}
