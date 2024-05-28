package practice;

import java.util.Scanner;

public class samplePractice {

	public void practice2() {
		Scanner sc = new Scanner(System.in);
		int a,b,c,sum,avg;
		System.out.print("국어 점수 : ");
		a=sc.nextInt();
		System.out.print("영어 점수 : ");
		b=sc.nextInt();
		System.out.print("수학 점수 : ");
		c=sc.nextInt();

		sum=a+b+c;
		avg=sum/3;

		if(avg>60 && a >40 && b>40 && c>40) {
			System.out.printf("평균 %d,합계 %d 합격 입니다.",avg,sum);
		} else {
			System.out.println("불합격 입니다.");
		}

	}

	public void practice3() {
		//for문을 이용해서 1부터 100까지의 정수 중 3의 배수의 총합을 구하는 코드를 작성하시오
		int sum=0;
		for(int i=1; i<=100; i++) {
			if(i%3==0) {
				sum+=i;
			}

		}
		System.out.printf("3의 배수의 합 : %d", sum);


	}

	public void practice4() {
		for(int i = 1; i<=5 ; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}

			System.out.println("");
		}

	}

	public void practice5() {

		Scanner sc= new Scanner(System.in);
		System.out.print("별점을 입력하세요 : ");
		int score = sc.nextInt();
		for(int i=1; i<=score ; i++) {

			System.out.print("★");
		}
	}

	public void pr6() {
		// 2중 for문과 count를 이용해서 아래 모양 출력하기
		//  1  2  3  4
		//  5  6  7  8
		//  9 10 11 12
		int count=1;

		for(int i=1 ; i<=3 ; i++) {

			for(int j=1; j<=4; j++) {
				System.out.printf("%2d ", count);
				count++;

			}
			System.out.println();
		}

	}
	public void pr7() {
		// count (숫자 세기)

		// 1부터 20까지 1씩 증가하면서
		// 3의 배수의 총 개수 출력

		// 3 6 9 12 15 18 : 6개
		int count =0;
		for(int i =1 ; i<=20; i++) {
			if(i%3==0) {
				System.out.print(i+ " ");
				count++;
			}

		}
		System.out.print(": " + count+"개");
	}

	public void pr8(){

		/*while 문
		 * -별도의 초기식, 증감식이 존재하지 않고
		 * 반복 종료 조건을 자유롭게 설정하는 반복문이다.
		 * 
		 * 	 ** 확실히 언제 반복이 끝날지는 모르지만
		 * 		언젠간 반복 조건이 false가 되는 경우 반복을 종료한다.
		 * 
		 * [작성법]
		 * while(조건식){
		 * 조건식이 true일때 반복 수행할 구문
		 * }
		 * 
		 */
		Scanner sc=new Scanner(System.in);

		String menu= "";

		int num=0;

		while(num!=4) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 삭제");
			System.out.println("4. 끝내기");
			System.out.println("작업 할 번호를 선택하세요. :");
			num=sc.nextInt(); 

			if (num==1) {
				System.out.println("입력 하기를 선택하셨습니다");

			}
			else if (num==2) {
				System.out.println("출력하기를 선택 하셨습니다");

			} 
			else if (num==3) {
				System.out.println("삭제하기를 선택 하셨습니다");

			}
			else if (num==4) {
				System.out.println("끝내기를 선택 하셨습니다.");

			}else {
				System.out.println("잘못 선택하셨습니다.");

			}

		}

	}


	public void pr9() {
		Scanner sc = new Scanner(System.in);
		int score=0;

		while(true) {

			double random1 = Math.random();
			double random2 = Math.random();
			double random3 = Math.random();
			int num1=(int)(random1*9)+1;
			int num2=(int)(random2*9)+1;
			int sign=(int)(random3*3)+1;
			int result=0;

			switch(sign) {
			case 1 :
				result=num1+num2;
				System.out.print(num1 + "+"+ num2 + "=?");
				break;
			case 2 :
				result=num1-num2;
				System.out.print(num1 + "-"+ num2 + "=?");
				break;
			case 3 :
				result=num1*num2;
				System.out.print(num1 + "*"+ num2 + "=?");
				break;
			}
			System.out.print("\n 정답을 입력하세요 : ");
			int answer= sc.nextInt();

			if(answer==result) {
				System.out.print("정답입니다. \n");
				score++;
				System.out.println(score+"점");
			} else {
				System.out.print("오답입니다.");
			}
			if(score>=10) {
				System.out.print("끝");
				break;
			}


		}
	}

	public void pr10() {
		String[] arr = { "짜장면" , "짬뽕", "단무지" };
		int menu= (int)(Math.random()*3);

		switch(menu) {
		case 0 :
			System.out.println("오늘 메뉴는 짜장면 입니다.");
			break;

		case 1 :
			System.out.println("오늘 메뉴는 짬뽕 입니다.");
			break;

		case 2 :
			System.out.println("오늘 메뉴는 단무지 입니다.");
			break;
		}



	}


	public void pr11() {
		int[] arr = new int[10];
		for(int i=0 ; i<arr.length; i++) {
			arr[i]= i+1;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}

	}
	
	public void pr12() {
		int[] arr = new int[10];
		for(int i =0 ; i <arr.length ; i++) {

		}
	
	}
	
}	



