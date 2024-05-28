package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public void pr1() {
		int[] arr;
		int sum=0;
		arr= new int[9];

		for(int i=0; i<arr.length;i++) {

			arr[i]=i+1;
			System.out.print(arr[i]+ " ");
			if(i%2 == 0) {
				sum+=arr[i];
			}

		}
		System.out.println("짝수 번째 인덱스의 합 :"+sum);
	}

	public void pr2() {
		int[] arr;
		int sum=0;
		arr=new int[9];
		for(int i=0; i<arr.length; i++) {
			arr[i]=9-i;
			System.out.print(arr[i]+ " ");
			if(i%2==1) {
				sum+=arr[i];
			}
		}
		System.out.print("\n 홀수 번째 인덱스 합 : "+ sum);

	}

	public void pr3() {
		Scanner sc= new Scanner(System.in);
		int[] arr;
		System.out.print("양의 정수 : ");
		int input=sc.nextInt();
		arr=new int[input];

		for(int i=0; i<input ; i++) {
			arr[i]=i+1;
			System.out.print(arr[i] + " ");
		}

	}

	public void pr4() {
		Scanner sc= new Scanner(System.in);

		System.out.print("입력 0 : ");
		int input0=sc.nextInt();
		System.out.print("입력 1 : ");
		int input1=sc.nextInt();		
		System.out.print("입력 2 : ");
		int input2=sc.nextInt();		
		System.out.print("입력 3 : ");
		int input3=sc.nextInt();		
		System.out.print("입력 4 : ");
		int input4=sc.nextInt();
		System.out.print("검색할 값 : ");
		int search=sc.nextInt();
		int index=0;
		boolean flag = false;

		int[] num = {input0, input1, input2, input3, input4};

		for(int i=0 ; i<num.length ; i++) {
			if(num[i]==search) {

				index++;
				flag = true;
			} 
		}


		if(flag==false) {
			System.out.print("일치하는 값이 존재하지 않습니다.");
		} else {
			System.out.print("인덱스 : "+index);
		}


	}

	public void practice5() {
		Scanner sc=new Scanner(System.in);
		System.out.print("문자열 : ");
		String str=sc.next();

		char[] ch=new char[str.length()];
		for(int i=0; i<str.length(); i++ ) {
			ch[i]=str.charAt(i) ;
		}

		System.out.print("문자 : ");
		char ch2=sc.next().charAt(0);

		int count=0;

		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ",str,ch2 );

		for(int i=0; i<str.length();i++ ) {
			if(ch[i]==ch2) {
				count++;
				System.out.print(i+" ");
			}

		}

		System.out.printf("\n%c 개수 : %d",ch2,count);
	}

	public void practice6() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();

		int[] arr = new int[input];

		int sum = 0;

		String value = "";

		for(int i=0; i < arr.length; i++) {
			System.out.print("배열 "+i+"번째 인덱스에 넣을 값 : ");
			arr[i]=sc.nextInt();
			sum += arr[i];
			value += arr[i]+ " ";
		}

		System.out.println(value);

		System.out.println("총합 : "+sum);
	}

	public void practice7() {

		Scanner sc= new Scanner(System.in);

		System.out.print("주민 등록 번호 (-포함) : ");
		String input = sc.nextLine();

		char arr[] = new char[input.length()];

		for (int i=0 ; i<arr.length ; i++) {

			if(i<= 7) { // 번째 인덱스 이하

				arr[i]=input.charAt(i);

			} else { //8번 인덱스 이상부터는 *

				arr[i]='*';

			}


			System.out.print(arr[i]);
		}


	}

	public void practice8() {

		Scanner sc = new Scanner(System.in);



		while(true){//3이상의 홀수가 입력 될때 까지
			//3이상 홀수가 입력되면 break 문으로 종료
			System.out.println("정수 : ");

			int input = sc.nextInt();

			if(input%2==0 || input<3) {
				System.out.println("다시 입력하세요 : ");
				sc.nextInt();

			} else {
				// 입력 받은 정수 만큼의 크기를 가지는 배열 생성
				int[] arr= new int[input];

				int num=0; // arr배열에 대입될 값

				for(int i=0; i<arr.length; i++) {


					if( i<= arr.length/2) { //중간 이전 까지 -> 증가

						arr[i] = ++num ;

						//arr[i] = num++의 arr[0]은 0이 된다. 


					} else { //중간 이후 -> 감소
						arr[i] = --num;
					}

					//출력시 , 추가 (단 , 마지막 제외)

					if(i == arr.length-1) { //마지막 바퀴
						System.out.print(arr[i]);
					} else {
						System.out.print(arr[i] + ", ");
					}



				}
				break;
			}
		}
	}

	public void practice9() {

		int[] arr = new int[10];

		System.out.print("발생한 난수 : ");

		for(int i=0 ; i<arr.length; i++) {

			arr[i]=(int)(Math.random()*10+1);

			System.out.print(arr[i] + " ");
		}



		//	System.out.println(Arrays.toString(array));

	}

	public void practice10() {

		int[] array = new int[10];
		int max = 1;
		//int max = arr[0]; 도 가능
		int min = 10;
		System.out.print("발생한 난수 : ");

		for (int i=0 ; i<array.length ; i++) {

			array[i] = (int)(Math.random()*10+1);
			System.out.print(array[i] + " ");

			if(array[i]>max) {
				max=array[i];
				//max=array[i];와
				//array[i]=max는 다르다. 어떻게????
			}else if(array[i]<min) {
				min=array[i];
			}

		}

		System.out.println("\n최대값 : " + max);


		System.out.println("최소값 : " + min);



	}

	public void practice11() {

		int[] arr = new int[10];

		for(int i=0 ; i<arr.length ;i++) {

			arr[i] = (int)(Math.random()*10+1); //1 ~10 

			//중복 확인 시 i 값을 감소 시켜
			//다음 반복에서 현재 인데스에 난수 덮어 쓰기

			for(int x =0 ; x<i ; x++) {

				if(arr[x]==arr[i]) {
					i--;
					break;
				}
			}
		}

		//출력용 for문
		for(int i=0; i<arr.length;i++) {

			System.out.print(arr[i]+ " ");
		}

	}

	public void practice12() {

		int[] lotto = new int[6];

		for (int i =0 ; i<lotto.length ; i++) {

			lotto[i]=(int)(Math.random()*45+1);

			for(int j =0 ; j<i ; j++) {

				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}

			}


		}

		Arrays.sort(lotto);

		for(int i=0 ; i <lotto.length ; i++) {

			System.out.print(lotto[i]+ " ");
		}

	}

	public void practice13() {
		/*
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String input = sc.nextLine();
		int num=0;
		char[] c = new char[input.length()];
		boolean flag = false;

		for(int i=0 ; i < input.length() ; i++) {

			c[i]=input.charAt(i);

			for(int j=0 ; j < i ; j++) {

				if(c[i]==c[j]) {
					flag = true;
					i++;
					break;
				} else {
					num++;
					break;
				}


			}


		}

		System.out.print("문자열에 있는 문자 : ");

		for(int i=0 ; i<input.length(); i++) {

			if(flag==false) {
				if(i<input.length()-1) {
					System.out.print(c[i]+", ");
				} else {
					System.out.print(c[i]);
				}
			} 



		} 

		System.out.println("\n문자 개수 : "+ num);
	}

		 *안됨 왠지모름
		 */

		Scanner sc= new Scanner(System.in);

		System.out.print("문자열 : ");
		String input = sc.nextLine();

		char[] arr= new char[input.length()];
		int count=0;

		System.out.print("문자열에 있는 문자 : ");
		for(int i=0; i<arr.length;i++) {

			arr[i] = input.charAt(i); //문자열 -> char배열에 옮겨담기
			//변수 선언한 것은 {}안에서만 사용 가능하다
			//중복 검사
			//application
			//배열 :[ a,p,p,l,i,c,a,t,i,o,n]
			//화면 : a,p ,l ,i,c,t,o,n

			boolean flag = true;//신호용 변수
			// **위치가 정말 즁요하다**
			for(int j=0; j<i; j++) { //중복 검사용 for문

				if(arr[i]==arr[j]) {
					//현재 대입된 문자가 앞서 대입된 문자와 같다면 == 중복
					flag = false; //신호용 변수의 값을 false로 변경

					break;

				}

			}

			if(flag) {//flag가 true인 경우 == 중복이 없었다라는 뜻

				count++;

				if(i==0) {//첫 바퀴인 경우

					System.out.print(arr[i]);
				}else {
					System.out.print(", "+arr[i]);
				}
			}




		}	
		System.out.print("\n문자 개수 : "+count);
	}
	
	public void practice14() {
		//배열 값만 복사하는 것 (얕은 복사/깊은 복사 둘다 사용가능)

/*		Scanner sc= new Scanner(System.in);
		
		char yesno='y';
		
		System.out.println("배열의 크기를 입력하세요 : ");
		int input = sc.nextInt();
		
		sc.nextLine(); //왜 추가해야하는지
		
		String[] array = new String[input];
		
		for(int i=0 ; i<input ; i++) {
			System.out.println(i+"번째 문자열 : ");
			array[i]=sc.nextLine();
		}

		while(yesno =='y' ) {
			
				System.out.println("더 값을 입력하시겠습니까?(y/n)");				
				yesno=sc.nextLine().charAt(0);
				Arrays.toString(array);
				
				if(yesno=='y') {
					
				}else {
					
				}
		}
		안됨 뭔가
		*/

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		//scanner ex5에 있던내용, nextInt는 엔터를 처리 안해줘서 숫자+enter 값에서 enter가 남아있어서 1번째 문자열이 넘어간다.
		sc.nextLine();//입력 버퍼에 남아있는 개행문자 제거
		
		
		String[] arr = new String[size]; // 배열 선언 및 할당
		
		int start = 0; //while문 내 for문의 초기식에 사용될 변수
		
		while(true) {
			
			for(int i=start; i<arr.length; i++) {
				System.out.print((i+1)+"번 째 문자열 : ");
				arr[i] =sc.nextLine();
			}
			
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char input = sc.nextLine().charAt(0);
			
						
						//입력 받은 문자열 중 제일 앞 문자 하나만 얻어옴
			
			if(input == 'y' ||input == 'Y') {
				
				start = arr.length;
				// 추가 입력 받기 위한 추가 배열 부분의 시작 위치
				
				System.out.print("더 입력하고 싶은 개수 : ");
				int addSize = sc.nextInt();
				sc.nextLine();//남아있는 엔터 제거
				
				//증가된 크기의 배열을 생성하여 arr배열을 깊은 복사 한다.
				String[] copyArr = new String[arr.length + addSize];

				for(int i=0; i<arr.length; i++) { //기존 배열 크기만큼만 반복
					copyArr[i] = arr[i]; //복사된 배열에 기존 배열 값을 같은 인덱스에 대입
				
				}
				
				//배열 얕은 복사 
				
				arr = copyArr; //arr이 참조하는 주소 값을 
								// copyArr의 주소 값으로 바꿔서
								// arr이 참조하는 배열의 크기가 증가한 것 처럼 보이게 함
				
			} else {
				break; //가장 가까운 반복문 종료(while)
			}
			
		} //while문 끝
		
		System.out.println(Arrays.toString(arr));
		
	}

	
	
	public void pr9() {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("배열의 크기를 입력하세요 : ");
		
		int size = sc.nextInt();
		sc.nextLine();
		int start = 0;
		String[] arr = new String[size];
		
		while(true) {
			
			for(int i = start; i<arr.length ;i++ ) {
				
				System.out.println(i+"번째 문자열 : ");
				
				arr[i]=sc.nextLine();
				
			}
			
			System.out.println("더 값을 입력하시겠습니까?(Y/N)");
			char input = sc.nextLine().charAt(0);
			if(input=='y'||input=='Y') {
				start = arr.length;
				System.out.println("더 입력하고 싶은 개수 : ");
				
				int addSize = sc.nextInt();
				sc.nextLine();
				
				String[] copyArr = new String[arr.length+addSize];
				
				for(int i=0; i<arr.length; i++) { 
					copyArr[i] = arr[i]; 
				
				}
				
				arr=copyArr;
			}
			else {
				break;
			}
		}
		
	}
	
	
}