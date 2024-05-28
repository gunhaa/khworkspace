package edu.kh.op.practice;

import java.util.Scanner;

public class OpPractice {

	
	public void practice1() {
		//모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고 1인당 동일하게 나눠가진
		//사탕 개수와 나눠주고 남은 사탕 개수를 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 : ");
		int input = sc.nextInt();
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
	//int a = candy / input;
	//int b = candy % input;
		System.out.println("1인당 사탕 개수 : " + candy/input );
		System.out.println("남는 사탕 개수 : " + candy%input );
	}
	
	public void practice2() {
	//	Scanner sc = new Scanner(System.in);
	//	System.out.print("이름 : ");
	//	String name = sc.nextLine();
	//	System.out.print("학년 : ");
	//	int grade = sc.nextInt();
	//	System.out.print("반 : ");
	// cla = sc.nextInt();
	//	System.out.print("번호 : ");
	//	int dd = sc.nextInt();
	//	System.out.print("성별");
	//	String sex = sc.nextLine();
	//	System.out.print("성적");
	//	int score = sc.nextInt();
	
	//	System.out.printIn( grade+ "학년"+ cla+"반"+ dd +"번" + name + sex+"의 성적은" +score +"입니다.")
	
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : " );
		String name = sc.next();
		System.out.print("학년(정수) : " );
		int grade = sc.nextInt();
		System.out.print("반(정수) : " );
		int classRoom = sc.nextInt();
		System.out.print("번호(정수) : " );
		int number=sc.nextInt();
		System.out.print("성별(남학생/여학생) : " );
		String gender = sc.next();
		System.out.print("성적(소수점 아래 둘째 자리까지 : " );
		double score = sc.nextDouble();
		//3학년 4반 15번 홍길동 남학생의 성적은 85.75점 입니다.
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다. \n", grade, classRoom, number, name, gender, score);
	}
	
	public void practice3() {

		Scanner sc = new Scanner(System.in);
	
		//System.out.print("정수입력 : ");
	
		//int number = sc.nextInt();
	
		//String(number%2==0 ? = "홀수입니다" : "짝수입니다.")

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		String result = input % 2 == 0 ? "짝수" : "홀수" ;
		
		System.out.println(result + " 입니다.");
		
		
	}

	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
	//	System.out.print("국어 : ");
	//	int kr = sc.nextInt();
	//	System.out.print("영어 : ");
	//	int eng = sc.nextInt();
	//	System.out.print("수학 : ");
	//	int math = sc.nextInt();

	//	int all = kr+eng+math;
	//	System.out.println("합계 : " + all );
		
	//	double avg = all/3;

	//	System.out.printf("평균 : %.1f \n", avg );
		
	//	String result = avg >= 60 ? "합격" : "불합격" ;
	//	System.out.print(result);
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math; //합계
		double avg = sum/ 3.0; //평균
		
		System.out.println("합계 : "+ sum);
		System.out.printf("평균 : %.1f\n", avg);
		
		boolean result = (kor >=40) && (eng >=40) && (math >=40) && (avg >=60);
		
		System.out.println(result ? "합격" : "불합격");
							//조건식? 식1 : 식2
	
	}
	
	
	
	
	
	

}
