package note.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import note.service.EmployeeService;
import note.vo.Employee;

public class EmployeeView {

	private Scanner sc = new Scanner(System.in);
	
	private EmployeeService service = new EmployeeService();
	
	public void displayMenu() {

		int menuNum = 0;

		do {
			try {
				
				System.out.println();
				System.out.println("====================================");
				System.out.println("[사원 관리 프로그램]");
				System.out.println("1. 전체 사원 정보 조회");
				System.out.println("2. 사번으로 사원 정보 조회");
				System.out.println("3. 새로운 사원 정보 추가");
				System.out.println("4. 사번으로 사원 정보 수정");
				System.out.println("5. 사번으로 사원 정보 삭제");
				System.out.println("6. 입력 받은 급여 이상으로 받는 모든 직원 조회");
				System.out.println("7. 부서코드, 보너스율을 입력 받아 해당 부서의 보너스를 모두 수정");
				System.out.println("0. 프로그램 종료");
				System.out.println("====================================");

				System.out.print("메뉴 선택 : ");
				menuNum = sc.nextInt();
				System.out.println();

				switch(menuNum) {
				case 1 :
					selectAll();
					break;
				case 2 :
//					selectOne();
					break;
				case 3 :
//					insertEmployee();
					break;
				case 4 :
//					updateEmployee();
					break;
				case 5 :
//					deleteEmployee();
					break;
				case 6 :
//					selectSalary();
					break;
				case 7 :
//					updateBonus();
					break;
				case 0 : 
					System.out.println("프로그램 종료");
					break;
				default : 
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}


			}catch(InputMismatchException e ) {
				System.out.println("입력 형식이 잘못되었습니다. 다시 시도해주세요.");
				menuNum = -1;
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못된 문자열 제거
			}

		} while(menuNum != 0);

	}
	
	
	public void selectAll() {
		
		System.out.println("[전체 사원 정보 조회]");
		
		List<Employee> empList = new ArrayList<>();
		
		empList = service.selectAll();
		
		for (Employee emp : empList) {
			System.out.println(emp.toString());
		}
		
	}
	
}
