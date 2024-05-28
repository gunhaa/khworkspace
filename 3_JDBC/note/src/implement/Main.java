package implement;

public class Main {

	public static void main(String[] args) {
		Bank bank = new KBBank();
		
		bank.withDraw(100);
		bank.deposit(100);
		String k = bank.findDormancyAccount("763231");
		Bank.BCAuth("KBBank");
	System.out.println(k);
	System.out.println("-------------------------------");
	
	}
	
}
