package edu.kh.psh;

import java.util.Scanner;

public class PshEx {
	
	public void exam1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력 3 : ");
		int num3 = sc.nextInt();

		System.out.println((num1 == num2 && num1 == num3) ? "true" : "false");
	
	}
	
	public void exam2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		//System.out.println(age <= 13? "어린이" : (age > 13 && age <= 19? "청소년" : " 성인"));;
		System.out.println(age <= 13? "어린이" : (age <= 19? "청소년" : " 성인"));;
		
	}
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		
		
	}
		
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("정수3 : ");
		int num3 = sc.nextInt();
		
		System.out.println(num3 <= num1 || num3 > num2 ? "true" : "false" );
		
		
	}
		
	

}
