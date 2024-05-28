package edu.kh.poly.ex2.model.vo;

public class Fish extends Animal {

	//생성자
	//->생성자 미 작성시 컴파일러가 자동으로 기본 생성자를 추가해줌

	public Fish() {
		super();
		//animal을 의미한다.
	}


	public Fish(String type,String eatType) {
		super(type, eatType);
	}

	//추상 메소드는 상속 받으면 오버라이딩이 강제 된다.
	@Override
	public void eat() {
		System.out.println("입을 뻐끔 뻐끔 거리면서 먹는다.");
	}

	@Override
	public void breath() {
		System.out.println("아가미로 호흡 한다.");
	}

	@Override
	public String toString() {
		return "Fish : " + super.toString();
	}
	

}
