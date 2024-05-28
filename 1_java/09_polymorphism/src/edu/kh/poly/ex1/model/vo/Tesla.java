package edu.kh.poly.ex1.model.vo;

public class Tesla extends Car {

	private int batteryCapacity; //배터리 용량


	//ctrl + space -> enter
	public Tesla() {
		super(); // car를 의미한다. (부모 생성자)
	}


	//매개변수 생성자
	//alt shift s + o + 설정 만지기

	public Tesla(String engine, String fuel, int wheel, int batteryCapacity) {
		super(engine, fuel, wheel);
		this.batteryCapacity = batteryCapacity;
	}


	public int getBatteryCapacity() {
		return batteryCapacity;
	}


	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	//Car.toString() 오버라이딩
	@Override

	public String toString() {
		return super.toString()+ " / "+ batteryCapacity;
	}
	

	
}
