package edu.kh.oarr.practice.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;
import edu.kh.oarr.practice.model.vo.Employee;

public class EmployeeService {

	Scanner sc = new Scanner(System.in);

	private Employee[] empArr = new Employee[3];

	public EmployeeService() {

		empArr[0]= new Employee("1","1","1","1","1");
		empArr[1]= new Employee("2","2","2","2","2");
		empArr[2]= new Employee("3","3","3","3","3");

	}


	public void run1() {


		int menuNum = 0;

		do{

			System.out.println("=== 직원 관리 프로그램 ===");
			System.out.println("1. 직원 정보 입력(3명)");
			System.out.println("2. 모든 직원 정보 출력");
			System.out.println("3. 특정 직원 정보 출력(이름 검색)");
			System.out.println("4. 특정 직원 급여/연봉 출력(사번 검색)");
			System.out.println("5. 모든 직원 급여 합/연봉 합 출력");
			System.out.println("6. 모든 직원 중 급여가 가장 높은 직원의 이름, 부서, 급여 출력");
			System.out.println("0. 종료");
			System.out.print
			("메뉴 선택 >> ");
			menuNum = sc.nextInt();

			switch(menuNum) {

			case 1:
				input();
				break;

			case 2:
				System.out.println(inform());
				break;
			case 3:
				System.out.println(Search());
				break;

			case 4:
				System.out.println(searchNum());
				break;
			case 5:
				System.out.println(salarySum());
				break;
			case 6:
				System.out.println(elite());
				break;
			}




		}while(menuNum!=0);

		System.out.println("프로그램 종료.");

	}

	public void input() {

		for(int i=0 ; i<3 ; i++) {

			System.out.println("==="+(i+1)+"번째 사원 정보 입력 ===");

			System.out.print("사번 : ");

			String inputNum=sc.next();
			empArr[i].setNumber(inputNum);
			System.out.print("이름 : ");

			String inputName=sc.next();	
			empArr[i].setName(inputName);
			System.out.print("부서 : ");

			String inputDepartment=sc.next();	
			empArr[i].setDepartment(inputDepartment);
			System.out.print("직급 : ");

			String inputRank=sc.next();
			empArr[i].setRank(inputRank);
			System.out.print("급여 : ");

			String inputSalary=sc.next();
			empArr[i].setSalary(inputSalary);
		}
	}

	public String inform() {
		String str = "";
		String str1 = "";
		String str2 = "";
		 
		str="사번 : "+ empArr[0].getNumber()+ ", 이름 : "+empArr[0].getName()+", 부서 : "+empArr[0].getDepartment()+", 직급 : "+ empArr[0].getRank()+", 급여 : "+empArr[0].getSalary();
		str1="사번 : "+ empArr[1].getNumber()+ ", 이름 : "+empArr[1].getName()+", 부서 : "+empArr[1].getDepartment()+", 직급 : "+ empArr[1].getRank()+", 급여 : "+empArr[1].getSalary();
		str2="사번 : "+ empArr[2].getNumber()+ ", 이름 : "+empArr[2].getName()+", 부서 : "+empArr[2].getDepartment()+", 직급 : "+ empArr[2].getRank()+", 급여 : "+empArr[2].getSalary();

		 
		 return str+"\n"+str1+"\n"+str2;
	}
	
	public String Search() {
		
		System.out.println("=== 특정 사원 정보 출력(이름 검색)===");
		System.out.print("이름 입력 : ");
		String input = sc.next();
		
		for(int i=0; i<empArr.length ; i++) {
			if(input.equals(empArr[i].getName())) {
				return "사번 : "+ empArr[i].getNumber()+ ", 이름 : "+empArr[i].getName()+", 부서 : "+empArr[i].getDepartment()+", 직급 : "+ empArr[i].getRank()+", 급여 : "+empArr[i].getSalary();
			} 

		}
		return "일치하는 사원이 없습니다.";
	}
	
	public String searchNum() {
		
		System.out.println("=== 급여/연봉 조회 ===");
		System.out.println("사번 입력 : ");
		String input = sc.next();
		
		for(int i=0; i<empArr.length ; i++) {
			if(input.equals(empArr[i].getNumber())) {
				return "급여 : " + empArr[i].getSalary()+ " / 연봉 : " +(Integer.parseInt(empArr[i].getSalary())*12);
			} 
		}
		return "사번이 일치하는 직원이 없습니다.";
	}
	
	public String salarySum() {

		int monthSum = 0;
		System.out.println("=== 모든 사원 급여 합/연봉 합===");
	
		for(int i=0; i<empArr.length; i++) {
			monthSum += Integer.parseInt(empArr[i].getSalary());	
		}
		
		
		return "전 직원 급여 합 : " + monthSum + "\n전 직원 연봉 합 : "+ (monthSum*12);
		
	}
	
	public String elite() {
		
		int king = 0;
		//좀 이상하긴함 이 부분
		for(int i=0; i<1 ; i++) {
			for(int j=0; j<empArr.length;j++) {
				if(Integer.parseInt(empArr[i].getSalary()) >= Integer.parseInt(empArr[j].getSalary())) {
					king= i;
				} else {
					king =j;
				}
			
			}
		
		}
		return "이름 : " +empArr[king].getName()+",부서 : "+ empArr[king].getDepartment()+",급여 : "+empArr[king].getSalary();
	
	}
	
}
