package edu.kh.objarray.practice.model.service;

import java.util.Scanner;

import edu.kh.objarray.practice.model.vo.Student;

public class PracticeService2 { // 선생님의 답안

	Scanner sc = new Scanner(System.in);

	Student[] std = new Student[10];

	int count = 0;
	boolean flag = true;
	
	
	public void start() {

		while(flag) {

			System.out.print("\n학년 : ");
			int inputGrade=sc.nextInt();

			System.out.print("반 : ");
			int inputClass=sc.nextInt();

			System.out.print("이름 : ");
			String inputName=sc.next();

			System.out.print("국어점수 : ");
			int inputKor=sc.nextInt();

			System.out.print("영어점수 : ");
			int inputEng=sc.nextInt();

			System.out.print("수학점수 : ");
			int inputMath=sc.nextInt();

			std[count] = new Student(inputGrade, inputClass, inputName, inputKor, inputEng,inputMath);
			count++;

			while(true) {

				System.out.println("계속 입력 하시겠습니까? (y/n) : ");
				char input = sc.next().toUpperCase().charAt(0);
				//대문자로 바꾸는 메소드
				if(count == 10 || input == 'N') {
					flag =false;
					break;
				}
			
				if(input == 'Y') {
					break;
				} else {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			
			}



		}
		
		for(int i=0; i<count; i++) {
			System.out.println(std[i].toString());
		}
		
		
	}
}
