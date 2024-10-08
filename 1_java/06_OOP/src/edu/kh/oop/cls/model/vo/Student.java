package edu.kh.oop.cls.model.vo;

public class Student { // 클래스 선언부

	//[접근 제한자] [예약어] class 클래스명
	// 기본형태
	// 접근 제한자 public : 같은 프로젝트 내에 어떤 클래스에서든 import 할 수 있음

	// 1. 필드(field) : 객체의 속성을 작성하는 클래스 내부 영역

	//     ==멤버 변수(=필드와 동의어이다) : 메소드 밖에 작성된 변수

	//인스턴스 변수 : 필드에 작성되는 일반 변수

	// 클래스 변수(==static 변수) : 필드에 static 예약어가 작성된 변수
	//why? 같은 클래스로 만들어진 객체가 값을 공유할 수 있기 떄문에



	/*
	 * [접근 제한자]      [예약어]             자료형        변수명 [=초기값];
	 * 
	 * + public	       final             기본자료형
	 * # protected     static             배열
	 * ~ (default)     final static      클래스명
	 * - private       static final      (참조형)
	 * 
	 * 필드의 접근 제한자의 뜻; 직접 접근이 가능한 범위를 나타냄
	 */

	public int v1 = 10;

	protected int v2 = 20;

	int v3 = 30;

	private int v4 = 40; //Student 클래스 내부에서만 사용가능하다.


	//접근 제한자 예제
	public void ex() {
		System.out.println("같은 클래스 내부에 존재");
		System.out.println(v1); //10
		System.out.println(v2); //20
		System.out.println(v3); //30
		System.out.println(v4); //40
	}

	// ----------------------------------

	// static 예약어

	public static String schoolName = "KH고등학교" ;



	private String name; //캡슐화의 원칙 private -> 간접 접근 방법(setter,getter)이 필요하다
	//직접 접근을 제한한다.

	//getter / setter


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//-------------------------------------------------------


	// 2. 생성자(Constructor)

	/* new 연산자를 통해서 객체를 생성할때
	 * 생성된 객체의 필드 값 초기화 + 지정된 기능을 수행하는 역할
	 * 
	 * - 생성자 작성 규칙
	 * 1) 생성자의 이름은 반드시 클래스명과 같아야 한다.
	 * 2)반환형이 존재하지 않는다.
	 * 
	 *  -생성자의 종류 
	 *  1) 기본 생성자
	 *  2) 매개변수 생성자
	 * 
	 */

	// 기본 생성자
	// [접근 제한자] 클래스명() {코드 }
	public Student() {
		//객체가 생성될 때 수행할 코드
	System.out.println("기본 생성자에 의해서 Student 객체가 생성되었습니다.");
	}

	//public void ex1() {
		//-> void가 반환형(생성자는 존재하지 않음)
	//}



	// 3. 메소드(method)

}





