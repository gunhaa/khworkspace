package edu.kh.controlpsh;

import java.util.Scanner;

public class ControlPsh {

	public void ex1() {
		// 1학년부터 4학년까지 중간고사 시험 실시.
		// 4학년은 70점 이상이면 합격, 그 이외는 60점 이상이면 합격
		// 점수가 0미만 100 초과이면 경고문구 출력!
		
		Scanner sc = new Scanner(System.in);
		System.out.print("학년: ");
		int grade = sc.nextInt();
		
		System.out.print("성적: ");
		int score = sc.nextInt();
		
		String result;
		
		if(score < 0 || score > 100) {
				result = "경고!";
			} else if (grade >= 4 && score >= 70){
				result = "합격";
			} else if (grade >= 4 && score < 70) {
				result = "불합격";
			} else if (grade < 4 && score >= 60) {
				result = "합격";
			} else {
				result = "불합격";
			}
			
		System.out.print(result);
		
		
	}
	
	public void ex2() {
		
		// 세 개의 정수를 입력받아, 그 수들의 최대값과 최소값, 합계와 평균을 구하라
		
		Scanner sc = new Scanner(System.in);
		System.out.print("세 개의 정수 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		int sum = num1 + num2 + num3;
		double aver = sum / 3.0;
		
		int max = num1;
		int min = num1;
		
		if (max < num2) {
			max = num2;
		}
		if (max < num3) {
			max = num3;
		}
		
		if (min > num2) {
			min = num2;
		}
		if (min > num3) {
			min = num3;
		}
		
		
		System.out.print("최대값 : " + max);
		System.out.print("최소값 : " + min);
		System.out.print("합계 : " + sum);
		System.out.print("평균 : " + aver);
	}
	
	
	public void ex3() {
		
		// 사용자로부터 키를 입력받는다. 입력받은 키가
		// 1) 150.0 이상이면, 놀이기구 이용 가능
		// 2) 150.0 미만이면
		//	  부모와 함께 왔는지 한 번 더 묻는다.
		//    함께 왔다면 1번을 입력 받고, 혼자 왔다면 0번을 입력 받아라.
		//	  1번 입력 : 좋은 시간 보내렴~
		//	  0번 입력 : 어른 모시고 다시 오렴~
	
		Scanner sc = new Scanner(System.in);
		System.out.print("키: ");
		double hi = sc.nextDouble();
		
		String result;
		
		
		if (hi > 150.0) {
			result = "놀이기구 이용 가능";
		}  else {
			System.out.println("부모님과 함께 오셨나요?");
			System.out.print("함께 왔으면 1번, 혼자 왔으면 0번을 입력하세요 : ");
			int num = sc.nextInt();
			
			if (num == 1) {
				result = "좋은 시간 보내렴~";
			} else {
				result = "어른 모시고 다시 오렴~";
			}
		}
		
			System.out.println(result);
		
	
	}
	
	public void ex4() {
		
		// 과자는 개당 2000원이다. 10개 초과하면 1500원으로 받는다
		// 과자를 구매하였을때 가격을 구하라
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("구매한 과자의 갯수: ");
		int input = sc.nextInt();
		
		int totalPrice;
		
		if (input <= 10) {
			 totalPrice = input * 2000;
		} else {
			totalPrice = input * 1500;
		}
		
		System.out.println(totalPrice + "원 입니다.");
		
	}
	
	
	
}
