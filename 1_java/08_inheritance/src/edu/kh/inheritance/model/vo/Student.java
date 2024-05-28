package edu.kh.inheritance.model.vo;

public class Student extends Person{
	//Student 클래스에 person클래스 내용을 연장한다.
	//==Student 클래스에 person 클래스 내용(필드,메소드)을 추가하여 확장한다.

	//*** 상속 ***
	//extends : 확장하다, 연장하다+

	//extends +(상속받을 클래스/부모)


	//필드

	private int grade; // 학년
	private int classRoom; //반


	//생성자

	public Student() {

		//Student() 객체 생성시 
		//내부에 상속받은 Person 객체를 생성하기 위한
		//Person 생성자 호출 코드가 필요하다!

		// super : 상위 <-> sub : 하위
		// super == Person
		super(); //super() 생성자
		//부모 생성자를 호출하는 코드
		// 반드시 자식 생성자 최상단에 작성되어야 한다!!

		// *super() 생성자 때문에
		// 자식 객체 내부에 부모 객체가 생성된다.

		//* super() 생성자 미 작성시
		// 컴파일러가 컴파일 단계에서 자동으로 추가해줌

	}

	public Student(String name, int age, String nationality, int grade , int classRoom) {
		// 전달 받은 값 중 name, age ,nationality를 받아오지 못한다.
		//부모 필드에 세팅해야한다.
		//	this.name=name; (X)
		//상속 받은 부모의 필드(name)를
		//자식의 필드처럼 사용하려 했으나 오류발생

		//왜? 부모의 필드에 private 접근 제한자가 있어서
		// 아무리 물려받은 자식이라도 다른 객체이기 때문에 직접적으로 접근할 수 없다.
		// -> 간접 접근 방법 사용으로 해결해야한다.

		//	this.age=age;
		//	this.nationality=nationality;
		//	setName(name);
		//setAge(age);
		//setNationality(nationality);
		//부모의 setter를 이용하면 되지만 비효율적이다...
		super(name, age, nationality); // 부모의 매개 변수 생성자를 호출한다.
		this.grade=grade;
		this.classRoom=classRoom;
	}


	//메소드

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	//toString() 오버라이딩
	@Override
	public String toString() {
			// super 참조 변수
		return super.toString() + " / " + grade + " / " + classRoom ; 
	}

}
