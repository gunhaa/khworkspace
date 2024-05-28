package example;

import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Array run = new Array();
		run.practice11();
	}

	Scanner sc = new Scanner(System.in);

	public void practice1() {

		int[] array = new int[9];
		int sum=0;
		for(int i =1; i<10; i++) {
			array[i-1]=i;
			System.out.print(array[i-1] + " ");
			if(array[i-1]%2==1) {
				sum+=array[i-1];
			} else {

			}
		}
		System.out.println();
		System.out.println(sum);

	}

	public void practice2() {
		//skip
	}

	public void practice3() {
		System.out.println("양의 정수 : ");
		int input = sc.nextInt();

		int[] array = new int[input];

		for(int i=1; i<input+1 ; i++) {
			array[i-1]=i;
			System.out.print(array[i-1] + " ");
		}

	}

	public void practice4() {

		System.out.println("입력 0 : ");
		int input0 = sc.nextInt();
		System.out.println("입력 1 : ");
		int input1 = sc.nextInt();
		System.out.println("입력 2 : ");
		int input2 = sc.nextInt();
		System.out.println("입력 3 : ");
		int input3 = sc.nextInt();
		System.out.println("입력 4 : ");
		int input4 = sc.nextInt();

		System.out.println("검색할 값 : ");
		int search = sc.nextInt();

		int[] array = new int[5];
		array[0]=input0;
		array[1]=input1;
		array[2]=input2;
		array[3]=input3;
		array[4]=input4;
		boolean flag = false;
		for(int i=0 ; i<5 ; i++) {
			if(search==array[i]) {
				System.out.println("인덱스 : "+i);
				flag= true;
				break;
			} else {
				flag = false;
			}

		}

		if(flag == false) {
			System.out.println("일치하는 값이 존재하지 않습니다");
		}

	}

	public void practice5() {

		System.out.println("문자열 : ");
		String input = sc.nextLine();
		System.out.println("문자 : ");
		char search = sc.next().charAt(0);

		char[] array = new char[input.length()];
		System.out.print(input+"에 "+search+"가 존재하는 위치(인덱스) : ");
		for(int i=0; i<input.length(); i++) {
			array[i]=input.charAt(i);

			if(array[i]==search) {
				System.out.print(i+ " ");
			}
		}


	}

	public void practice6() {
		int sum=0;
		System.out.print("정수 : ");
		int length = sc.nextInt();
		int[] array = new int[length];
		for(int i=0; i<length; i++) {
			System.out.print("배열 "+i+"번째 인덱스에 넣을 값 : ");
			array[i]=sc.nextInt();
		}

		for(int i=0; i<length; i++) {
			System.out.print(array[i]+" ");
			sum+=array[i];
		}
		System.out.println("\n총 합 : "+sum);
	}

	public void practice7() {
		System.out.println("주민등록번호(-포함) : ");
		String input = sc.nextLine();

		char[] array = new char[input.length()];

		for (int i=0; i<input.length(); i++) {

			if(i<8) {
				array[i]=input.charAt(i);
				System.out.print(array[i]);
			} else  {
				System.out.print("*");
			} 
		}


	}

	public void practice8() {


		boolean flag = true;

		while(flag) {
			System.out.println("정수 : ");
			int input = sc.nextInt();
			int num=1;
			if(input<3 || input%2==0) {

				System.out.println("다시 입력하세요.");

			}else {
				/*
				1/12321/123454321 / 1234567654321
				1 5 9 13
				1 3 5 7
				 */
				int[] array = new int[(input*2)];

				for(int i=1; i<input; i++) {
					array[i]=num++;
					System.out.print(array[i] + " ");
				}

				for(int i=input; i<(input*2) ; i++) {
					array[i]=num--;
					System.out.print(array[i]+ " ");
				}

				flag=false;
			}
		}
	}

	public void practice9() {

		int[] arr= new int[10];
		System.out.print("발생한 난수 : " );
		for(int i=0; i<arr.length; i++) {

			arr[i]=(int)(Math.random()*10+1);
			System.out.print(arr[i]+ " ");
		}

	}

	public void practice10() {
		int[] arr= new int[10];
		System.out.print("발생한 난수 : " );
		for(int i=0; i<arr.length; i++) {

			arr[i]=(int)(Math.random()*10+1);
			System.out.print(arr[i]+ " ");
		}
		int max=1;
		int min=9;
		for(int i=0; i<arr.length; i++) {

			if(arr[i]>max) {
				max=arr[i];
			} else if (arr[i]<min) {
				min=arr[i];
			}
		}

		System.out.println("최대값 : "+ max );
		System.out.println("최소값 : "+ min );


	}
	// 조건 다시

	public void practice11() {

		int[] arr= new int[10];
		System.out.print("발생한 난수 : " );
		for(int i=0; i<arr.length; i++) {
			arr[i]=(int)(Math.random()*10+1);

			for(int j=0; j<i; j++) {
				if(arr[i]==arr[j]) {
					i--;
					break;
				}
			}

		}

		for(int i=0; i<arr.length;i++) {

			System.out.print(arr[i]+ " ");
		}
	}
	//한번 더 보기



	public void practice14() {

		System.out.println("배열의 크기를 입력하세요.");
		int input = sc.nextInt();
		boolean flag = true;
		String[] arr = new String[input];

		for(int i=0; i<arr.length; i++) {
			System.out.print(i+"번째 문자열 : ");
			arr[i]=sc.nextLine();
		}
		while(flag) {
			System.out.println("더 값을 입력하시겠습니까? (Y/N)");
			String yn = sc.nextLine();
			if(yn.equals("y")) {
				
			}else {
				flag=false;
			}
		
		}
		
		System.out.println(arr.toString());
		
	}

}

