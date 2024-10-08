package edu.kh.array2.ex;

import java.util.Arrays;

public class Array2Example {

	/*2차원 배열
	 * 
	 * -자료형이 같은 1차원 배열을 묶음으로 다루는 것
	 * -> 행,열 개념 추가
	 * 
	 */

	public void ex1() {

		//2차원 배열 선언
		int[][] arr;
		//해석 : int 2차원 배열을 참조하는 참조 변수 선언
		//(참조형 == 참조 변수 == 레퍼런스 변수 ==레퍼런스)

		//2차원 배열 할당
		// -> new 자료형[행크기][열크기]

		arr = new int[2][3];
		//heap 영역에 int 2차원 배열 2행 3열 공간을 할당

		//2차원 배열 초기화

		//1) 행, 열 인덱스를 이용해서 직접 초기화
		/*
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;

		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		 */

		//2중 for문을 이용한 초기화

		int num=10; // 배열 요소 초기화에 사용할 변수

		System.out.println(arr.length); //행의 길이
		//arr이 참조하고 있는 2차원 배열의 행의 길이

		System.out.println(arr[0].length); //열의 길이
		//arr[0] 행이 참조하고 있는 차원 배열(열) 길이

		for(int row=0 ; row<arr.length ; row++) { //행 반복0,1

			for(int col=0; col<arr[0].length; col++) { //열 반복 (0,1,2)

				arr[row][col]=num;
				num+=10; //10씩 증가
			}

		}



		//Arrays.toString(배열명) ;참조하고 있는 1차원 배열 값을 문자열로 반환
		System.out.println(Arrays.toString(arr));

		//Arrays.deepToString (배열명)
		//- 참조하고 있는 배열의 데이터가 나오는 부분까지 파고 들어가서
		//  모든 값을 무자열로 반환

		System.out.println(Arrays.deepToString(arr));

	}

	public void ex2() {

		//2차원 배열 선언과 동시에 초기화

		//3행 3열짜리 정수형 2차원 배열 선언과 동시에
		//1~9까지 초기화

		int [][] arr = {{1,2,3},
						{4,5,6},
						{7,8,9}
		};
		
		//행 별로 합 출력
		

		
		for(int row=0; row<arr.length; row++) {//행 반복
			int sum=0;
			for(int col=0; col<arr[row].length; col++) { //열 반복
				sum+= arr[row][col];
			}
			
			System.out.printf("%d행의 합 : %d\n", row, sum);
		}

		System.out.println("-----------------------------------");
		
		//열 별로 합 출력
		//-> 열 부터 지정 후 각 행의 값을 누적
		//--> 완전한 사각형의 형태를 지닌 2차원 배열은
		//	  모든 열의 길이가 같다.
		
	
		
		for(int col=0; col<arr[0].length; col++) { //열 반복 //row를 선언한 적이 없어 사용할 수 없다.
			int colsum=0;
			for(int row=0; row<arr.length; row++) {//행 반복
				
				colsum+=arr[row][col];
				
			}
			
			System.out.printf("%d열의 합 : %d\n", col, colsum);
			
		}
		System.out.println("------------------------------------");
		
		
		//전체 합 출력
		
		int sumall=0;
		
		for(int row=0; row<arr.length; row++) {
			
			for(int col=0; col<arr.length; col++) {
				
				sumall+=arr[row][col];
			}
	
		}
		
		System.out.println("전체 합 : "+ sumall);	
	}

	public void ex3() {
		
		//가변 배열
		// - 2차원 배열 생성 시 마지막 배열 차수(열)를 지정하지 않고
		//   나중에 서로 크기가 다른 1차원 배열을 생성하여 참조하는 배열
		
		char[][] arr = new char[4][];
						//char 2차원 배열 생성 시 행 부분만 작성
		
		arr[0] = new char[3]; //arr의 0행에 3열짜리 1차원 배열을 생성하여 주소값 저장
		arr[1] = new char[4]; // 1행에 4열짜리 1차원 배열을 생성하여 주소값 저장
		arr[2] = new char[5]; // 2행에 5열짜리 1차원 배열을 생성하여 주소값 저장
		arr[3] = new char[2]; // 3행에 2열짜리 1차원 배열을 생성하여 주소값 저장
		
		// 각 배열 요소에 'a'부터 차례대로 대입
		
		
		char ch= 'a';
		
		for(int row=0; row<arr.length; row++) { //행
			
			for(int col=0; col<arr[row].length; col++) { //열
 				
				arr[row][col]=ch++;
		
			}

		
		}
		
		System.out.println(Arrays.deepToString(arr));
		
	}
	
	
	
}