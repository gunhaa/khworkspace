package implement;

public class IPhone13 implements IPhone {
	
	@Override
	public String getModelName() {
		return "IPhone13(A2633)";
	}
	@Override
	public void printSpec() {
		System.out.println("size : "+ SIZE);
		System.out.println("Model name : " + HandPhone.getUpperName(getModelName()));
	}
}
