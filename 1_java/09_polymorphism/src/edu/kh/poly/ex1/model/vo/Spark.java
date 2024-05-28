package edu.kh.poly.ex1.model.vo;

public class Spark extends Car{ //경차
	
	private double discountOffer; //할인 혜택
	//기본생성자
	public Spark() {
	 //super() 생략시 컴파일러가 자동추가
	}

	//매개변수 생성자(상속버전)
	//alt shift s -> o -> 아래방향키 -> enter
	public Spark(String engine, String fuel, int wheel, double discountOffer) {
		super(engine, fuel, wheel);
		this.discountOffer = discountOffer;
	}

	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	
	@Override
	public String toString() {
		return super.toString() +  " / "+discountOffer;
	}
	
}
