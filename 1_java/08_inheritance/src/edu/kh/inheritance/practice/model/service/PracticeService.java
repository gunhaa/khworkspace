package edu.kh.inheritance.practice.model.service;

import java.util.Scanner;

import edu.kh.inheritance.practice.model.vo.Employee;
import edu.kh.inheritance.practice.model.vo.Student;

public class PracticeService {

	Scanner sc= new Scanner(System.in);

	public void homework() {

		Student[] studentArr = new Student[3];
		Employee[] employeeArr = new Employee[10];
		Employee[] employeeArr2 = new Employee[2];
		boolean flag = true;
		int count = 0;

		studentArr[0]=new Student("카리나", 20 , 168.2 , 70.0 , 1, "정보시스템공학과");

		studentArr[1]=new Student("정해인", 21 , 187.3 , 80.0 , 2, "경영학과");

		studentArr[2]=new Student("박서준", 23 , 179.0 , 45.0 , 4, "정보통신공학과");
		/*
		향상된 for문
		for(Student std : studentArr) {
			//자료형 변수명 : 배열명
			System.out.pintln(std.toString());
								//std와 같은 결과가 나온다. 기본적으로 .toString을 넣어줌
		}
		
		
		
		*
		*/
		
		for(int i=0; i<studentArr.length; i++) {
			System.out.println(studentArr[i].toString());
		}

		while(flag) {
			
			System.out.println("추가 하시겠습니까? (y/n)");
			char input = sc.next().charAt(0);

			if(input=='y') {

			} else if (count<10) {
				flag=false;
				break;
			} else {
				flag=false;
				break;
			}

			System.out.println("이름 : ");
			String inputName=sc.next();
			System.out.println("나이 : ");
			int inputAge=sc.nextInt();
			System.out.println("신장 : ");
			double inputHeight=sc.nextDouble();
			System.out.println("몸무게 : ");
			double inputWeight=sc.nextDouble();
			System.out.println("급여 : ");
			int inputSalary=sc.nextInt();
			System.out.println("부서 : ");
			String inputDept=sc.next();
			count+=1;
			employeeArr[count-1]=new Employee(inputName, inputAge, inputHeight,inputWeight,inputSalary, inputDept);
			System.out.println(count+"번째 추가");


		}

		employeeArr2[0]=new Employee("박보검", 26 , 180.3 , 72.0 , 100000000, "영업부");
		employeeArr2[1]=new Employee("강동원", 38 , 182.0 , 76.0 , 200000000, "기획부");

		for(int i=0; i<count; i++) {
			//employArr.length 왜 안됨? -> 전체값이 나와서
			//왜 count-1임? count가 아니고 -> count의 위치 잘보기
			System.out.println(employeeArr[i].toString());
		}

		System.out.println(employeeArr2[0].toString());
		System.out.println(employeeArr2[1].toString());
	}
}
