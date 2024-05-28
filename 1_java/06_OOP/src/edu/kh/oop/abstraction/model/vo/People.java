package edu.kh.oop.abstraction.model.vo;

//VO(value Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지

public class People { //국민(사람) 클래스
	
	//클래스란? 객체의 특성(속성, 기능)을 정의한 것
	//== 객체를 만들기 위한 설계도
	
	// 캡슐화 (Encapuslation)
	// -데이터와 기능을 하나로 묶어서 관리하는 기법
	// -데이터의 직접적인 접근을 제한하는 것이 원칙이다.
	//  -> 직접 접근을 못하기 때문에
	//     클래스 내부에 간접 접근 방법을 제공하는 기능을 작성해둔다.
	
	// ***데이터 직접 접근 제한 ***
	// public(공공의) -> private(사적인,개인적인) 변경
	
	//속성 == 값 == data
	//값을 저장하기 위한 변수 선언
	//-> 국민이라면 공통적으로 가지고 있는 속성(추상화) 구체적으로 표현하지않고 추상적으로 제시해야 한다.
	private String name;
	private char gender;
	private String pNo; //001212-1234567
	private String address; //
	private String phone;
	private int age;
	/* double bitCoin; // 속성으로 쓸 수 없다, 공통점이 아니므로 제거해야 한다. */
	
	
	
	//기능 == 행동 == method
	public void tax() {
		System.out.println("세금을 냅니다.");
	}
	
	public void vote() {
		System.out.println("투표를 합니다.");
	}
	
	//캡슐화에서 사용할 간접 접근 기능 (getter / setter)
	
	public void setName(String name) { //setter
		
		this.name = name;
	}
	
	public String getName() { //getter
		return name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//alt + shift + s 또는 상단 메뉴 Source
	//-> Generate Getters and Stters.. 클릭
	// -> select All -> generate
	
	
}
