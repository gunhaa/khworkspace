package edu.kh.inheritance.model.service;

import java.util.Scanner;

import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class inheritanceService {

	public void ex1() {
		//상속 확인
		// person을 상속받은 student가 person의 필드와 메소드를 사용할 수 있나?

		Person p = new Person();

		//p.Name = "홍길동"; // pirvate 때문에 직접 접근 불가
		p.setName("홍길동");
		p.setAge(30);
		p.setNationality("대한민국");

		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
		System.out.println("--------------------");

		//Student 객체 생성

		Student std = new Student();


		//Student 만의 고요한 메소드
		std.setGrade(3);
		std.setClassRoom(5);
		//Person 클래스로부터 상속 받은 메소드
		std.setName("김길동");
		std.setAge(35);
		std.setNationality("대한민국");
		System.out.println(std);
		System.out.println(std.getGrade());		
		System.out.println(std.getClassRoom());	
		//student가 Person의 메소드 뿐만 아니라 필드도 상속 받았는지 확인	
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());

		System.out.println("--------------------------------------");


		Employee emp = new Employee();
		//employee 만의 고유 메소드
		emp.setCompany("KH정보교육원");

		//person으로부터 상속받은 메소드
		emp.setName("고길동");
		emp.setAge(22);
		emp.setNationality("일본");
		System.out.println(emp.getCompany());
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());

		System.out.println("--------------------------");

		//추가된 breath()메소드 확인하기
		p.breath();
		std.breath();
		emp.breath();


	}

	public void ex2() {
		// super() 생성자 사용 방법
		
		// Student 매개 변수 5개 짜리 생성자
		Student std = new Student("공유", 38 , "한국", 1 ,5);
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
	}
	
	
	public void ex3() {
		//오버라이딩 확인 예제
		
		Student std = new Student();
		Employee emp = new Employee();
		
		std.move(); // 오버라이딩 X -> Person의 메소드 수행
		emp.move(); // 오버라이딩 O -> Employee 메소드 수행
		//void edu.kh.inheritance.model.vo.Person.move()
		//void edu.kh.inheritance.model.vo.Employee.move()
	}
	public void ex4() {
		// 모든 클래스는 Object 클래스의 후손이다.
		// ==모든 클래스의 최상위 부모가 object이다.
		
		// 1) object상속 여부 확인
		Person p = new Person(); // Object를 상속 받은 Person 객체 생성
		
		Student std = new Student(); // Person을 상속 받은 Student 객체 생성
		
		Scanner sc = new Scanner(System.in);
		
		String str = "abc";
		
		// ** Object 상속과 단계적인 상속 확인
		
		System.out.println(p.hashCode()); // Object에서 물려 받은 hashCode()
		
		System.out.println(std.getAge());
		
		System.out.println(std.hashCode());
		// Person이 object에서 물려 받은 hashCode() 를
		// Student가 또 물려받아 사용
		
		//-> 상속의 상속의 상속의 .... 상속 가능
		
		//* Object가 모든 클래스의 최상위 부모인지 확인
		System.out.println(sc.hashCode());
		// object - hashCode()
		System.out.println(str.hashCode());
		// String - hashCode()
		// -> String이 object에게 물려받은 hashCode()를 오버라이딩함
	}
	
	public void ex5() {
		
		Person p = new Person("김무열", 34, "한국");
		
		System.out.println(p.toString());
		System.out.println(p);
		
		// print 구문 수행 시 참조 변수명만을 작성하면
		// 자동으로 toString() 메소드를 호출해서 출력한다.
		
		System.out.println("------------------------------------");
		
		Student std = new Student("윈터", 28, "미국", 4 , 6);
		
		System.out.println(std.toString());
		// 1) Student 클래스 toString() 오버라이딩 전
		// Person으로 부터 상속 받은 오버라이딩된 toString() 수행
	
		// 2) Student 클래스 ToString() 오버라이딩 후
		// Student의 toString() 수행
		
		Employee emp = new Employee("김건강", 28 , "일본", "00증권");
		
		System.out.println(emp.toString());
		
	}
	
	public void ex6() {
		
		Person per = new Person("김건강", 28 , "일본" );
		
		System.out.println(per.toString());
		
	}
	
}
