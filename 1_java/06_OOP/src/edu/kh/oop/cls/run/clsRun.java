package edu.kh.oop.cls.run;

import edu.kh.oop.cls.model.service.clsService;
import edu.kh.oop.cls.model.vo.Student;
import edu.kh.oop.cls.model.vo.TestVO;

public class clsRun {

	public static void main(String[] args) {
		
		clsService service = new clsService();
		
		//Student s = new Student();
		
		//TestVO v = new TestVO();
		
		// service.ex2(); // static 확인 예제 호출
	
		//service.ex3(); // 생성자 예제
	
		service.ex4(); //매개변수 생성자 예제
		
	}
	
}
