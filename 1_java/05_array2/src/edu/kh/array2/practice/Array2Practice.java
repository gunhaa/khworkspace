package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;


public class Array2Practice {



	public void practice1() {
		//3행 3열짜리 문자열 배열을 선언 및 할당하고
		//인덱스 0행 0열 부터 2행2열까지 차례대로 접근하여 "(0,0)"과 같은 형식으로 저장 후 출력하세요

		String [][] arr = new String[3][3];

		for (int row =0 ; row<arr.length; row++) {

			for(int col=0; col<arr[0].length; col++) {

				arr[row][col]= "(" +row + ", " + col + ")";

				System.out.print(arr[row][col]);
			}
			System.out.println("");

		}

	}

	public void practice2() {
		//4행 4열짜리 정수형 배열을 선언 및 할당하고
		//1) 1-16까지 값을 차례대로 저장하세요
		//2) 저장된 값들을 차례대로 출력하세요

		int [][] arr = new int[4][4];

		int num=1;

		for (int row=0; row<arr.length;row++) {

			for(int col=0; col<arr[0].length;col++) {

				arr[row][col] = num++;
				System.out.printf("%3d", arr[row][col]);

			}

			System.out.println();


		}



	}

	public void practice3() {

		//4행 4열짜리 정수형 배열을 선언 및 할당하고
		//1.16 ~1과 같이 값을 거꾸로 저장하세요.
		//2. 저장된 값들을 차례대로 출력하세요.

		int[][] arr = new int[4][4];

		int num=16;

		for(int row=0; row<arr.length; row++) { //행 반복

			for(int col=0; col<arr[row].length; col++) { //열 반복

				arr[row][col]=num--;

				System.out.printf("%3d",arr[row][col]);

			}
			System.out.println();
		}


	}

	public void practice4() {
		/*
		int[][] arr= new int[4][4];




		for(int row=0; row<arr.length ; row++) {

			int colsum=0;

			for(int col=0; col<arr[row].length; col++) {

				arr[row][col]=(int)(Math.random()*10+1);

				colsum += arr[row][col];

				if( col !=3) {

					System.out.printf("%3d", arr[row][col]);

				} 

				if(col==3) {
					System.out.print("a"+ colsum);
				}

			}

			System.out.println();

		}

	}
왜 안됨?
		 */
		int[][] arr = new int[4][4];

		// 상수 사용법 : 변하지 않는 특정 값에 이름을 붙여서 사용
		final int ROW_LAST_INDEX = arr.length-1; //행 마지막 인덱스
		final int COL_LAST_INDEX = arr[0].length-1; //열 마지막 인덱스


		for(int row=0; row<arr.length; row++) { //행 반복
			//행의 길이

			for(int col=0; col<arr[row].length; col++) {//열 반복
				//row번째 행의 열 길이


				//마지막 행, 마지막 열이 아닌 경우
				if(row!=ROW_LAST_INDEX && col!=COL_LAST_INDEX) { //&&(and)는 둘다 true여야 실행된다

					int random = (int)(Math.random()*10+1); //1~10사이 난수
					arr[row][col]=random;


					//각 행의 마지막 열에 난수를 누적
					int j=arr[row][COL_LAST_INDEX] += arr[row][col];
					//각 열의 마지막 행에 난수를 누적
					int k=arr[ROW_LAST_INDEX][col] +=arr[row][col];

					//생성된 모든 난수를 마지막 행, 마지막 열에 누적
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += j+k ;					
				}

				System.out.printf("%4d", arr[row][col]);
			} //안쪽 for문 끝
			System.out.println();
		} //행 반복 끝


	}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		while(true) {

			System.out.print("행 크기 : ");
			int row = sc.nextInt();

			System.out.print("열 크기 : ");
			int col = sc.nextInt();

			if(row <1 || row> 10 ||col<1 || col>10) { //1~10사이 숫자가 아닌 경우

				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");

			} else {

				char[][] arr = new char[row][col];

				for(int i=0; i<row; i++) {

					for(int j=0; j<col; j++) {

						arr[i][j] =(char)(Math.random()*26+65);

						System.out.print(arr[i][j]+ " ");

					}
					System.out.println();


				}

				break;

			}


		}

	}

	public void practice5_1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("행 크기 : ");


		int row=0;

		int col=0;

		while(true) {

			row = sc.nextInt();

			if(row>10 || row<1) {
				System.out.print("다시 입력해주세요");		

			} else {

				break;
			}

		}

		System.out.print("열 크기 : ");


		while(true) {

			col = sc.nextInt();

			if(col>10 || col<1) {
				System.out.print("다시 입력해주세요");		

			} else {

				break;
			}

		}


		char[][] arr = new char[row][col];

		for(row = 0 ; row<arr.length; row++) {

			for(col=0; col<arr[row].length; col++) {

				int random = (int)((Math.random()*26)+65);

				arr[row][col]=(char)random;

				System.out.print(arr[row][col]+" ");

			}
			System.out.println();
		}

	}

	public void practice6() {

		Scanner sc = new Scanner(System.in);

		System.out.print("행의 크기 : ");
		int input = sc.nextInt();

		char[][] arr= new char[input][];

		char result = 'a';

		//열 크기를 정하는 for문
		for(int i=0; i < arr.length; i++) {
			System.out.print("열의 크기 : ");
			int col = sc.nextInt();
			arr[i]=new char[col]; 
		}

		//출력용 for문

		for (int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col] =result++;
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}

	}


	public void practice6_1() {
		//안되는것
		Scanner sc = new Scanner(System.in);

		char ch = 'a';

		System.out.print("행의 크기 : ");

		int row = sc.nextInt();

		char[][] arr= new char[row][];


		//열 크기를 정하는 for문

		for(row=0; row<arr.length; row++) {

			System.out.print(row+"열의 크기 : ");

			int col=sc.nextInt();

			arr[row] = new char[col];

			for(col=0; col<row; col++) {

				arr[row][col]=ch++;	

			}


		}


		System.out.println(Arrays.deepToString(arr));


	}

	public void practice7() {

		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축","피풍표", "홍하하"};

		String[][] arr1 = new String[3][2];

		String[][] arr2 = new String[3][2];

		int index = 0; // students 배열에서 0부터 1씩 증가하며 학생들을 선택하는 용도의 변수

		System.out.println("== 1분단 ==");
		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {

				arr1[row][col] = students[index++];
				//students 배열 index번째 학생을 arr1[row][col]에 대입

				System.out.print(arr1[row][col]+ " ");
			}

			System.out.println();
		}

		System.out.println("== 2분단 ==");
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {

				arr2[row][col] = students[index++];
				//students 배열 index번째 학생을 arr1[row][col]에 대입

				System.out.print(arr2[row][col]+ " ");
			}

			System.out.println();
		}


	}


	public void practice7_1() {

		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축","피풍표", "홍하하"};

		String[][] arr = new String[6][];

		int num=0;

		arr[0]= new String[2];
		arr[1]= new String[2];
		arr[2]= new String[2];

		arr[3]= new String[2];
		arr[4]= new String[2];
		arr[5]= new String[2];

		System.out.println("== 1분단 ==");

		for(int row =0; row<3; row++) {

			for(int col=0; col<2; col++) {

				arr[row][col]=students[num];
				System.out.print(arr[row][col]+"  ");
				num++;
			}
			System.out.println();

		}
		System.out.println("== 2분단 ==");
		for(int row =3; row<6; row++) {

			for(int col=0; col<2; col++) {

				arr[row][col]=students[num];
				System.out.print(arr[row][col]+"  ");
				num++;
			}
			System.out.println();

		}
	}

	public void practice8() {

		Scanner sc = new Scanner(System.in);

		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축","피풍표", "홍하하"};

		String[][] arr1 = new String[3][2];

		String[][] arr2 = new String[3][2];


		int index = 0; // students 배열에서 0부터 1씩 증가하며 학생들을 선택하는 용도의 변수

		System.out.println("== 1분단 ==");
		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {

				arr1[row][col] = students[index++];
				//students 배열 index번째 학생을 arr1[row][col]에 대입

				System.out.print(arr1[row][col]+ " ");
			}

			System.out.println();
		}

		System.out.println("== 2분단 ==");
		for(int row=0; row<arr2.length; row++) {
			for(int col=0; col<arr2[row].length; col++) {

				arr2[row][col] = students[index++];
				//students 배열 index번째 학생을 arr1[row][col]에 대입

				System.out.print(arr2[row][col]+ " ");
			}

			System.out.println();
		}

		System.out.println("검색할 학생 이름을 입력하세요 : ");
		String inputName = sc.nextLine();

		for(int row=0; row<arr1.length; row++) {
			for(int col=0; col<arr1[row].length; col++) {

				if(arr1[row][col].equals(inputName)) { //일치하는 학생이름이 있울 경우

					if (col==0) {
						System.out.printf("검색하신 %s 학생은 1분단 %d 번째 줄 왼쪽에 있습니다.",inputName, row+1);
					} else {
						System.out.printf("검색하신 %s 학생은 1분단 %d 번째 줄 오른쪽에 있습니다.",inputName, row+1);
					}

				}
				if(arr2[row][col].equals(inputName)) { //일치하는 학생이름이 있울 경우

					if (col==0) {
						System.out.printf("검색하신 %s 학생은 2분단 %d 번째 줄 왼쪽에 있습니다.",inputName, row+1);
					} else {
						System.out.printf("검색하신 %s 학생은 2분단 %d 번째 줄 오른쪽에 있습니다.",inputName, row+1);
					}

				}
			}
		}
	}

	public void practice9() {

		Scanner sc = new Scanner(System.in);

		System.out.println("행 인덱스 입력 : ");

		int rowIndex = sc.nextInt();

		System.out.println("열 인덱스 입력 : ");

		int colIndex = sc.nextInt();

		String[][] arr= new String[6][6];

		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {

				//arr[rowIndex+1][colIndex+1] = "X"; 여기에 넣었을때 왜 안됨?

				if(row==0 && col!=0){//row는 0이면서 col은 0 이 아닐때 
					arr[row][col]=col-1 + " "; // " "이 들어가서 string이되서 가능함
				} else if (row !=0 && col ==0) {
					arr[row][col]=row-1 + " ";
				} else {
					arr[row][col] = " ";
				}

				arr[rowIndex+1][colIndex+1] = "X";

				System.out.print(arr[row][col]);

			}
			System.out.println();



		}
	}

	public void practice9_1() {

		Scanner sc= new Scanner(System.in);

		String[][] arr = new String[6][6];

		System.out.println("행 인덱스 입력 : ");

		int rowIndex = sc.nextInt();

		System.out.println("열 인덱스 입력 : ");

		int colIndex = sc.nextInt();

		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {

				if(row==0 && col!=0) {
					arr[row][col] = col-1 +" ";
				} else if(row!=0 && col==0){
					arr[row][col] = row-1 +" ";
				} else {
					arr[row][col] = " ";
				}
				arr[rowIndex+1][colIndex+1]="X";
				System.out.print(arr[row][col]);

			}
			System.out.println();
		}


	}


	public void practice10() {

		Scanner sc= new Scanner(System.in);

		String[][] arr = new String[6][6];

		for(int row=0; row<arr.length; row++) {

			for(int col=0; col<arr[row].length; col++) {

				if(row==0 && col!=0) {
					arr[row][col] = col-1 +" ";
				} else if(row!=0 && col==0){
					arr[row][col] = row-1 +" ";
				} else {
					arr[row][col] = " ";
				}

			}
		}


		System.out.println("행 인덱스 입력 : ");

		int rowIndex = sc.nextInt();


		while(true) {

			if(rowIndex==99) {
				System.out.println("프로그램 종료");
				break;
			}

			System.out.println("열 인덱스 입력 : ");

			int colIndex = sc.nextInt();

			arr[rowIndex+1][colIndex+1] ="X ";

			//출력용 for문
			for(int row=0; row<arr.length; row++){
				for(int col=0; col<arr.length; col++) {

					System.out.print(arr[row][col]);

				}
				System.out.println();//줄바꿈
			}

			System.out.print("\n행 인덱스 입력 >> ");
			rowIndex = sc.nextInt();


		}
	}

	public void bingoGame() {

		Scanner sc = new Scanner(System.in);

		System.out.print("빙고판 크기 지정 : ");

		int num = sc.nextInt();
		sc.nextLine(); //입력버퍼 제거, nextInt다음 nextline을 쓸거면 필수이다.
		// 1차원 배열로 빙고판에 입력될 값 생성 + 중복 제거
		int[] tempArr = new int[num*num]; //1차원 배열 생성
		//num*num --> 빙고판의 크기는 가로, 세로의 곱 만큼 공간이 필요함

		//중복값 제거하면서 랜덤 값 집어넣기

		for(int i=0; i<tempArr.length; i++) {
			tempArr[i] = (int)(Math.random()* (num*num)+1) ;

			//중복 제거
			for (int j=0 ; j<i ; j++) {
				if(tempArr[i]==tempArr[j]) {
					i--;
					break;
				}
			}		
		}
		//위에서 만들어진 중복 제거한 1차원 배열 --> 2차원 배열에 넣기
		//string 배열로 변경해서 대입 진행
		//왜 string 배열? 빙고가 된 부분을 "★"로 변경하기 위해서

		int index=0;//1차원 배열 인덱스 지정을 위한 변수

		String[][] bingoBoard = new String[num][num];

		for(int i=0; i<bingoBoard.length; i++) {
			for (int j=0; j < bingoBoard.length;j++){
				bingoBoard[i][j] = tempArr[index++]+""; //숫자 + 문자 -> 문자열

			}
		}


		// -------------------------------------------------------------------

		// 랜덤 배치된 빙고판 출력

		for(int row=0; row<bingoBoard.length; row++) {
			for(int col=0; col<bingoBoard.length; col++) {

				System.out.printf("%4s",bingoBoard[row][col]);

			}
			System.out.println();
		}
		System.out.println("======================빙고게임 시작=====================");

		while(true) {

			System.out.println("정수를 입력하시오 : ");
			String input = sc.nextLine();

			boolean flag = true; //검색된 값이 빙고판에 있는지 확인하기 위한 변수

			for(int row=0; row<bingoBoard.length; row++) {
				for(int col=0; col<bingoBoard.length; col++) {

					//입력된 값과 일치하는 곳을 ★로 변환하겠다.
					if(input.equals(bingoBoard[row][col])) {
						bingoBoard[row][col] = "★";
						flag = false ; //일치하는게 있을 경우
					}

					System.out.printf("%4s" , bingoBoard[row][col]);


				}

				System.out.println();

			}

			if(flag) {

				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				continue;
			}

			//빙고판 크기에 따라
			//빙고 기준이 되는 문자열 생성
			// ex) 5*%크기 빙고-> 한줄이 "★★★★★"이면 빙고

			String bingoLine="";
			for(int i=0; i < num; i++) {
				bingoLine += "★";
			}

			//빙고 검사

			int bingoCount =0; // 빙고 수를 저장할 변수

			// 가로(행)또는 세로(열)의 문자를 더하여 하나의 문자열로 저장
			// --> 저장된 문자열의 모양이 "★★★★★" 인 경우 == 빙고
			// --> bingoCount 증가


			for(int i=0; i<bingoBoard.length; i++) {
				//매 반복 시 마다 row, col을 빈 문자열로 초기화 해줘야 한다.
				//바깥쪽 for문이 반복될때마다 검사하는 행과 열이 이동하므로
				//빙고 여부를 검사하기 위한 row,col을 빈 문자열로 초기화 해야함
				String row = "";
				String col = "";
				for(int j=0; j<bingoBoard[i].length; j++) {
					row+= bingoBoard[i][j]; //현재 행의 문자를 모두 더함

					//i,j(행렬)를 반대로 하여 열의 모든 문자를 더함
					col+= bingoBoard[j][i]; 

				}
				System.out.println(row);	
				if(row.equals(bingoLine)) {//가로 빙고가 존재할 경우
					bingoCount++;
				} 
				if(col.equals(bingoLine)) {
					bingoCount++;
				}



			}

			//대각선 빙고 여부
			//대각성 : diagonal

			//대각선은 빙고판에 두개만 존재
			//--> 대각선 문자를 더해서 저장할 변수 두개 선언 및 빈 문자열로 초기화
			String dia1 = "";
			String dia2 = "";

			//대각선은 for문 하나로 가능

			for(int i=0; i<bingoBoard.length; i++) {
				dia1 += bingoBoard[i][i]; // 좌상 우하
				dia2 += bingoBoard[i][bingoBoard.length-1-i];
			}

			if(dia1.equals(bingoLine)||dia2.equals(bingoLine)) {
				bingoCount++;
			}


			//빙고 카운트 출력

			System.out.println("현 "+bingoCount+"빙고");

			if(bingoCount>2) {
				System.out.println("********* BINGO!!  ********");
				break;
			}

		}//while문 끝


	}

	public void bingoGame_1() {

		Scanner sc = new Scanner(System.in);

		System.out.println("빙고판 크기 지정 : ");
		int input = sc.nextInt();
		sc.nextLine();
		int[] arrTemp = new int[input*input];

		for(int i=0; i<arrTemp.length ; i++) {
			arrTemp[i]=(int)((Math.random()*input*input)+1);

			for(int j=0; j<i; j++) {
				if(arrTemp[j]==arrTemp[i]) {
					i--;
					break;
				}
			}
		}

		String[][] arr = new String[input][input];

		int index = 0;

		for(int row=0; row<arr.length ; row++) {

			for(int col=0; col<arr.length ; col++) {

				arr[row][col]=arrTemp[index++]+"";
			}
		}

		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {

				System.out.printf("%4s",arr[row][col]);

			}
			System.out.println();
		}

		System.out.println("===========빙고게임 시작==============");


		while(true) {
		
			System.out.println("정수를 입력하시오 : ");
		
			String star = sc.next()+"";
			String star2 = "★";
			int bingoCount=0;
			
			boolean flag = true;
			
			for(int row=0; row<arr.length; row++) {
				for(int col=0; col<arr[row].length; col++) {

					if(star==arr[row][col]) {
						arr[row][col]="  ★";
					}
					System.out.printf("%4s",arr[row][col]);
			
				}
				System.out.println();
			}	
			
			
			
			
			
			
			System.out.println("현재 "+bingoCount+"빙고");
			
		}

	}


}






