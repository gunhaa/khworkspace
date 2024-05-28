package baseball;

import java.util.ArrayList;
import java.util.List;

public class vo {
	public static void main(String[] args) {
		List<member> member = new ArrayList<member>();
			member.add(new member("1","2","3"));
			member.add(new member("2","3","4"));
			member.add(new member("3","4","5"));
			System.out.println(member.toString());
	}
}
