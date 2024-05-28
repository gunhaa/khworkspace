package example;

import java.io.IOException;
import java.util.Scanner;

public class control {
	public static void main(String[] args) {
		
		control run = new control();
		run.Run5();
	}
	
	public void Run1() {
		Scanner sc= new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int input = sc.nextInt();

		if(input%2==1) {
			System.out.println("홀수 입니다.");
		}else {
			System.out.println("짝수 입니다.");
		}
		
		sc.close();

	}
	
	public void Run2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수 : ");
		int kor=sc.nextInt();
		System.out.println("수학 점수 : ");
		int math = sc.nextInt();
		System.out.println("영어 점수 : ");
		int eng = sc.nextInt();
		
		int avg =0;
		int sum = 0;
		sum=(kor+math+eng);
		avg=(kor+math+eng)/3;
		
		if(kor>=40 && eng>=40 && math>= 40 && avg>=60) {
			System.out.println("국어 점수 : "+eng);
			System.out.println("수학 점수 : "+math);
			System.out.println("영어 점수 : "+eng);
			System.out.println("합계 : "+sum);
			System.out.println("평균 : "+(double)avg);
			System.out.println("축하합니다, 합격 입니다!");
		} else {
			System.out.println("불합격 입니다.");
		}
		
		sc.close();
	}
	
	public void Run3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~12 사이의 정수 입력 : ");
		int input= sc.nextInt();
		
		switch(input) {
		case 1,3,5,7,8,10,12 :
			System.out.println(input+"월은 31일까지 있습니다.");
			break;
		case 4,6,9,11 :
			System.out.println(input+"월은 30일까지 있습니다.");
		case 2 :
			System.out.println(input+"월은 28일까지 있습니다.");
		default :
			System.out.println(input+"월은 잘못 입력된 달입니다.");
		}
		sc.close();
	}
	
	public void Run4() {
		Scanner sc=new Scanner(System.in);
		double BMI=0;
		
		System.out.println("키(m)를 입력해주세요 : ");
		double tall = sc.nextDouble();
		System.out.println("몸무게(kg)를 입력해주세요 : ");
		double weight = sc.nextDouble();
		
		BMI = weight / (tall*tall);
		
		System.out.println("BMI 지수 : " + BMI);
		
		if(BMI < 18.5) {
			System.out.println("저체중");
		} else if (BMI >= 18.5 && BMI<23) {
			System.out.println("정상체중");
		} else if (BMI >= 23 && 25>BMI) {
			System.out.println("과체중");
		} else if (BMI >= 25 && 30>BMI) {
			System.out.println("비만");
		} else {
			System.out.println("고도 비만");
		}
		sc.close();
	}
	
	public void Run5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("중간 고사 점수 : ");
		double mid = sc.nextInt();
		System.out.println("기말 고사 점수 : ");
		double end = sc.nextInt();
		System.out.println("과제 점수 : ");
		double work = sc.nextInt();
		System.out.println("출석 횟수 : ");
		double hi = sc.nextInt();
		double sum=0;

		mid = mid*0.2;
		end = end*0.3;
		work = work*0.3;
		sum = mid+end+work+hi;
		if(hi>=14) {
			System.out.println("=========== 결과 =============");
			System.out.println("중간 고사 점수(20) : "+mid);
			System.out.println("중간 고사 점수(30) : "+end);
			System.out.println("중간 고사 점수(30) : "+work);
			System.out.println("출석 점수(20) : "+hi);
			System.out.println("총점 : " + sum);
			if(sum>=70) {
				System.out.println("PASS");
			} else
				System.out.println("Fail [점수미달]");
			
			
			
		} else {
			System.out.println("Fail [출석 횟수 부족 ("+(int)hi+"/20)]");
		}
		
		sc.close();
	}
	
}
