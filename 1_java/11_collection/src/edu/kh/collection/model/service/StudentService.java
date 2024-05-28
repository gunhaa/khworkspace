package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

public class StudentService {

	//필드
	private Scanner sc=new Scanner(System.in);

	// 학생 정보를 저장할 List(객체 배열의 Upgrade 버전)

	//private List<Student> studentList = new ArrayList<Student>();

	private List<Student> studentList = new LinkedList<Student>();
	
	//검색 (조회)에 효율적
	
	
	//메소드 설명용 주석
	/**
	 * 메뉴 출력용 메소드
	 * @author 황건하
	 * */
	public void displayMenu() {

		int menuNum = 0;

		//학생 정보를 저장할 List를 생성(객체 배열 Upgrade 버전)
		//java.util.List 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스

		//인터페이스 -> 모든 메소드가 추상메소드 ->미완성 메소드가 포함
		//-> 미완성된 부분이 존재하는 클래스이기 떄문에 객체를 완성해도 미완성 객체가 된다

		//ArryList() 기본 생성자 : 기본 크기 10짜리 리스트생성
		//						-> 하지만 리스트는 크기가 늘었다 줄었다 하기 때문에 큰 의미 없다.

		//ArrayList(용량) : 용량 만큼의 리스트 생성
		//				  -> 너무 큰 ㄱ밧을 작성하면 메모리를 많이 소모함





		do {

			System.out.println("\n ============= 학생 관리 프로그램 ===================\n");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			System.out.println("0. 프로그램 종료");
			System.out.println("\n 메뉴 번호 선택 >>");
			try {

				menuNum = sc.nextInt();


				switch(menuNum) {
				case 1: 
					System.out.println(addStudent());
					break;
				case 2: 
					selectAll();
					break;
				case 3: 
					System.out.println(updateStudent());;
					break;
				case 4:
					System.out.println(removeStudent());
					break;
				case 5: 
					searchName1();
					break;
				case 6: 
					searchName2();
					break;

				case 0: System.out.println("<프로그램 종료>");break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}
			}catch(InputMismatchException e) {
				System.out.println("error : 입력 형식이 유효하지 않습니다. 다시 시도해주세요.");
				sc.nextLine(); //입력 버퍼에 남아있는 잘못 입력된 문자열 제거

				menuNum= -1; //첫 반복시 잘못 입력하는 경우 menuNum이 0을 가지고 있어서 종료됨
				// 이를 방지하기 위해 임의 값 -1 대입
			} 


		}while(menuNum !=0);

	}





	public StudentService() {

		studentList.add( new Student("박서준", 25, "서울시 중구", 'M', 90) );
		studentList.add( new Student("정해인", 23, "경기도 안산시", 'M', 80) );
		studentList.add( new Student("박보영", 22, "서울시 강남구", 'F', 90) );
		studentList.add( new Student("김민서", 33, "충북 청주시", 'F', 100) );
		studentList.add( new Student("오나라", 24, "서울시 서대문구", 'M', 70) );

	}
	// Student로 저장되는 타입이 제한된 리스트 생성
	// Student만 저장 가능 == 모든게 Student
	// == Student임을 검사 할 필요 없다.

	public void ex() {
		//List 테스트

		//List.add(Object e) : 리스트에 객체를 추가하는 메소드
		// *매개변수 타입이 Object == ㅁ든 객체를 매개변수로 전달 할 수 있음
		// (매개변수 Object == 최상위 부모 참조 변수 ==다형성 적용 가능)

		//studentList.add(sc);			//0번 인덱스
		studentList.add(new Student()); //1번 인덱스
		//studentList.add(new Object());  //2번 인덱스
		//studentList.add("문자열");		//3번 인덱스
		//컬렉션 특징 : 여러 타입의 데이터를 저장할 수있다.

		//(반환형)
		//ObjectList.get(index i) : 리스트에서 i번째 인덱스에 있는 객체(Object)를 반환
		//반환형이 Object == 모든 객체를 반환할 수 있다.


		//Student의 이름만 얻어오기
		//Student 객체가 맞는지 확인하고 다운캐스팅을 해야
		//Student 기능을 사용할 수 있다.
		//객체가 맞는지 확인할때는 instanceof로 확인해야한다.
		if(studentList.get(0) instanceof Student) {

			System.out.println(((Student)studentList.get(0)).getName());
			//실행 전 : java.lang.Object.toString() == 정적 바인딩
			//실행 후  : 알고보니 1번째는 Student 객체이고, toString()이 오버라이딩 되어 있음
			//        -> Student의 toString()이 수행됨 == 동적 바인딩
		}

		//->길고 복잡함...
		//->컬렉션의 장점인 여러 객체 저장이 오히려 코딩에 방해됨

		// ***************************그래서 등장 !! -> 제네릭스(generics) ****************
		// (보통 제네릭이라고함) <>
		// [가장 중요한 역할]
		// -> 컬렉션에 저장되는 객체타입을 한가지로 제한
		//


		//Student의 이름만 얻어오기
	}

	/**
	 * 1. 학새 정보 추가 메소드
	 *  - 추가 성공 시 "성공", 실패 시 "실패" 문자열 반환
	 * @return
	 */
	public String addStudent() throws InputMismatchException {

		System.out.println("=============== 학생 정보 추가 ================");

		System.out.println("이름 : ");
		String name = sc.next();

		System.out.println("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 개행 문자 제거

		System.out.println("사는 곳 : ");
		String region = sc.nextLine();

		System.out.println("성별 : ");
		char gender = sc.next().charAt(0);

		System.out.println("점수 : ");
		int score = sc.nextInt();

		//Student 객체 생성 후 List에 추가
		if(studentList.add (new Student(name, age, region, gender, score))) {
			//boolean java.util.List.add(Student e)
			// (반환형)                    -> 제네릭 <Student> 때문에 List 타입이 Student로 제한됨

			// add() 메소드는 실패하는 경우가 없다.
			// ==무조건 true 반환
			// 대신 예외가 발생해서 add() 수행 전 메소드가 종료될 순 있음


			return "성공";
		} else {
			return "실패";
		}
	}


	/** alt shift j
	 * 2. 학생 전체 조회 메소드
	 */
	private void selectAll() {
		// -list는 인덱스가 있다. (0번부터 시작)
		// -list에 저장된 데이터 개수를 얻어오는 방법 : int List.size()
		// ->배열명.length 대신 사용

		//List가 비어있는지 확인하는 방법
		//boolean List.isEmpty() : 비어있으면 true 값 반환

		System.out.println("========학생 전체 조회 =======");

		//studentList가 비어 있는 경우 "학생 정보가 없습니다." 출력
		//if(studentList.size() == 0)

		if(studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다.");

			return;// 현재 메소드를 종료하고 호출한 곳으로 돌아감
			// 반환 값은 없음음(void)
		}
		/* 일반 for문
		for(int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i));
			//studentList에서 i번째 인덱스 요소를 얻어와 출력
		}
		 */

		//향상된 for 문 (for each문)

		// - 컬렉션, 배열의 모든 요소를 순차적으로 반복 접근 할 수 있는 for문
		// (순차적: 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가)

		//[작성법]
		//for (컬렉션 또는 배열에서 꺼낸 한 개의 요소를 저장할 변수) : 컬렉션 명 또는 배열명 ) {}
		int index = 0 ;
		for (Student std : studentList) {
			//std에는 for문 반복 시 마다 0,1,2 ... 인덱스 요소를 한 번씩 저장한다.

			System.out.println((index++) + "번 : " + std);
		}

	}

	/**
	 * 3. 학생 정보 수정 메소드
	 */
	public String updateStudent() throws InputMismatchException {

		// -studentList.set(int index, Student e)
		//					-> List의 i번째 요소를 전달 받은 e로 변경
		// 					-> 반환 값 Student == 변경 전 Student 객체가 담겨있음

		System.out.println("=========학생 정보 수정 ============");

		System.out.println("인덱스 번호 입력 : ");
		int index = sc.nextInt();

		// 1) 학생 정보가 studentList에 있는가?

		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다.";
			// 2) 입력된 숫자가 0보다 작은가? (음수 검사)	
		} else if (index <0) {
			return "음수는 입력할 수 없습니다.";
			// 3) 만약 문자열을 입력한 경우 -> throws로 예외 처리

			// 4) 입력 받은 숫자가 studentList범위 내 인덱스 번호인가?

		} else if (index >= studentList.size()) {
			return "범위를 넘어선 값을 입력 할 수 없습니다.";
		} else {
			//수정 코드 작성

			System.out.println(index+"번째 인덱스를 수정합니다.");

			System.out.println("이름 : ");
			String name = sc.next();

			System.out.println("나이 : ");
			int age = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행 문자 제거

			System.out.println("사는 곳 : ");
			String region = sc.nextLine();

			System.out.println("성별 : ");
			char gender = sc.next().charAt(0);

			System.out.println("점수 : ");
			int score = sc.nextInt();


			//index번째에 입력 받은 새로운 학생 정보를 세팅
			//이 때 , index번째에 있던 기존 학생 정보가 반환된다.
			Student temp = studentList.set(index, new Student(name, age, region, gender, score));
			return temp.getName();
		}



		// 수정 코드 작성
		/*
		if(studentList.get(0) instanceof Student) {
			if(index>=0){

				if(studentList.size()>=index) {

				System.out.println("수정 하고 싶은 내용은?");
				Student input=sc.nex();
				studentList.set(index, input);

				}
				else {
					System.out.println("인덱스 숫자가 없어서");
				}
			}else {
				System.out.println("음수에요");
			}
		}
		 */
	}

	/**
	 * 4. 학생 정보 제거 메소드
	 */
	public String removeStudent() {

		// -Student List.remove(int index)
		// 리스트에서 index번째 요소를 제거
		// 이 때, 제거된 요소가 반환된다.

		// *List는 중간에 비어있는 인덱스가 없게 하기 위해서
		// remove() 동작 시 뒤쪽 요소를 한 칸씩 당겨온다.

		System.out.println("=========학생 정보 제거 ============");

		System.out.println("인덱스 번호 입력 : ");
		int index = sc.nextInt();

		// 1) 학생 정보가 studentList에 있는가?

		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다.";
			// 2) 입력된 숫자가 0보다 작은가? (음수 검사)	
		} else if (index <0) {
			return "음수는 입력할 수 없습니다.";
			// 3) 만약 문자열을 입력한 경우 -> throws로 예외 처리

			// 4) 입력 받은 숫자가 studentList범위 내 인덱스 번호인가?

		} else if (index >= studentList.size()) {
			return "범위를 넘어선 값을 입력 할 수 없습니다.";
		} else {
			//학생 정보 제거
			System.out.println("정말 삭제 하시겠습니까?(Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);

			//String.toUpperCase() : 문자열을 대문자로 변경

			if(ch == 'Y') {
				Student temp = studentList.remove(index);
				return temp.getName()+ "의 정보가 제거되었습니다.";
			} else {
				return "취소";
			}

		}

	}

	public void searchName1() {
		System.out.println("====학생 검색 (이름 일치)=====");

		System.out.println("검색할 이름 입력 : ");

		boolean flag = true;
		//향상된 for문

		//향상된 for 문 (for each문)

		// - 컬렉션, 배열의 모든 요소를 순차적으로 반복 접근 할 수 있는 for문
		// (순차적: 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가)

		//[작성법]
		//for (컬렉션 또는 배열에서 꺼낸 한 개의 요소를 저장할 변수) : 컬렉션 명 또는 배열명 ) {}

		String input= sc.next();

		for (Student std : studentList) {
			//std에는 for문 반복 시 마다 0,1,2 ... 인덱스 요소를 한 번씩 저장한다.
			//이름이 일치하는 경우
			if(input.equals(std.getName())) {
				System.out.println(std);
				flag=false;
			} 


		}

		if(flag==true) { //flag가 true인 경우 == for문 내에 있는 if가 수행된 적이 없다
			// == 검색 겨로가가 없다
			System.out.println("검색 결과가 없습니다.");
		}

		//일치한 학생의 정보 출력

		//없는 경우
		//검색 결과가 없습니다. 출력.
	}

	/**
	 * 6. 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메소드
	 */
	public void searchName2() {
		// contains : 포함
		
		// boolean String.contains(문자열) : String에 문자열이 포함되어 있으면 True
		
		System.out.println("====학생 검색 (문자열 포함)=====");

		System.out.println("이름에 포함되는 문자열 입력 : ");

		String input= sc.next();

		boolean flag = false;
		//향상된 for문

		//향상된 for 문 (for each문)

		// - 컬렉션, 배열의 모든 요소를 순차적으로 반복 접근 할 수 있는 for문
		// (순차적: 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가)

		//[작성법]
		//for (컬렉션 또는 배열에서 꺼낸 한 개의 요소를 저장할 변수) : 컬렉션 명 또는 배열명 ) {}

		for (Student std : studentList) {
			//std에는 for문 반복 시 마다 0,1,2 ... 인덱스 요소를 한 번씩 저장한다.
			//이름이 일치하는 경우
			if(std.getName().contains(input)) {
				System.out.println(std);
				flag=false;
			} 


		}

		if(flag==true) { //flag가 true인 경우 == for문 내에 있는 if가 수행된 적이 없다
			// == 검색 겨로가가 없다
			System.out.println("검색 결과가 없습니다.");
		}

		//일치한 학생의 정보 출력

		//없는 경우
		//검색 결과가 없습니다. 출력.
	}
	

}
