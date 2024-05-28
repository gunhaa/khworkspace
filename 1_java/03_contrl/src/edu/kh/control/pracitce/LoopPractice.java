package edu.kh.control.pracitce;

import java.util.Scanner;

public class LoopPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력해주세요 : ");
		int input = sc.nextInt();
		if(input<1) {
			System.out.print("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i=1 ; i <= input ;i++) {
				System.out.print(i+ " ");
			}
		}
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input=sc.nextInt();
		if(input<=0) {
			System.out.print("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i=4 ; i>0; i--) {
				System.out.print(i+" ");
			}
		}
	}

	public void practice3() {
		Scanner sc= new Scanner(System.in);
		System.out.print("정수를 하나 입력 하세요 : ");
		int input = sc.nextInt();
		int i;
		int sum=0;

		for(i = 1 ; i<input ; i++) {
			System.out.print(i+"+");
			sum+=i;
		}
		System.out.print(i+"="+(sum+i));
		//되긴함 수정필요
	}

	public void practice4() {
		Scanner sc=new Scanner(System.in);
		System.out.print("첫 번쨰 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();

		if(num1<1 ||num2<1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else if(num1>num2) {
			for(int k = num1 ; num2<=num1 ; num2++) {
				System.out.print(num2 +" ");
			}
		} else if(num1<num2) {
			for(int i = num2 ; num1<=num2 ; num1++) {
				System.out.print(num1+" ");
			}
		}

	}

	public void practice5() {
		Scanner sc=new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		System.out.print("====="+num+"단 ========");

		for(int i=1 ; i<=9; i++) {
			System.out.println(num+" * "+i+" = "+num*i);
		}

	}

	public void practice6() {
		Scanner sc=new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		if(2>=num || 9<=num) {
			System.out.print("2~9사이 숫자만 입력해주세요.");
		} else {
			for(int i=num; i<=9 ; i++) {
				System.out.println("===="+i+"단====");
			}
		}
	}

	public void practice7() {
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num=sc.nextInt();
		for(int i = 1 ; i<=num ; i++ ) {
			for(int j= 1 ; j<=i ; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public void practice8() {
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num=sc.nextInt();
		for(int i=1 ; i<=num ; i++) {
			for(int j=num ; j>=i ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//왜 되는지 모르겠음 흐름 다시 한번 확인

	public void practice9() {
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num=sc.nextInt();
		/*
		for(int i =1 ; i<=num; i++) {

			for(int j=1 ; j<=num-i ; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i ; j++) {
				System.out.print("*");
			}
			System.out.println("");	
		}
		for를 이용한방법, 사용가능, if else를 이용한 방법
		 */

		for(int i=1 ; i <= num; i++) {
			for(int j=1; j <= num; j++) {

				if( j <= num - i) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}	
			System.out.println();
		}
	}
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int x=1; x<=input; x++) {
			for(int i = 1 ; i <=x; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int y=input-1; y>=1 ; y--) {
			for(int i = 1 ; i<=y; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	/*
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int x=1; x<=input; x++) {
			for(int i=input-x; i>=0 ;i--) {
				System.out.print(" ");
			for(int j=1; ;j++) {
				System.out.print("*");
			}


			}
			System.out.println();
		}
	}
	오답
	 */

	public void practice11() {
		Scanner sc= new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input= sc.nextInt();

		for(int x=1; x<=input; x++) {//입력 받은 input만큼 줄 출력

			//공백 출력 for 문
			for(int i=input-x; i>=1; i--) {
				System.out.print(" ");
			}
			// *출력 for문
			//1,3,5,7,9 홀수
			for(int i=1;i<=2*x-1;i++ ) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

	public void practice12() {
		/*	
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input= sc.nextInt();

		for(int i=1 ; i<=input; i++) {
			if(  || input==i) {
				for(int j=1; j<=input;j++) {
					System.out.print("*");
				}
			}
			else {
				System.out.print("*");
				for(int k=1; k<=input-2; k++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println("");
		}


	}
 조건 한개만 남음
		 */
		Scanner sc=new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		//row:행(줄)
		//col(column) :열(칸)
		for(int row=1; row <= input; row++) {

			//row 또는 col이 1또는 input인 경우 * 출력
			//==테두리
			for(int col=1; col <= input; col++) {
				if(row==1 || row ==input || col == 1 ||col==input ) {
					System.out.print("*");
				} else { //내부
					System.out.print(" ");
				}
			}
			System.out.println();
		}


	}

	public void practice13() {
		Scanner sc=new Scanner(System.in);
		System.out.print("자연수 하나를 입력 하세요 : ");
		int input=sc.nextInt();
		int count=0;
		for(int i=1; i<=input ; i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			} else if(i%3==0) {
				System.out.print(i+" ");
			} 


		}

		for(int i=1; i<=input ; i++) {
			if(i%6==0) {
				count++;
			}
		}
		System.out.printf("\ncount : %d",count);
	}


}

//선생님의 정답 
/*
{
	Scanner sc= new Scanner(System.in);
	System.out.print("짜연수를 하나 입력하세요 : ");
	int input = sc.nextInt();
	int count =0; //2와 3의 공배수를 세기위한 변수
	for(int i=1; i<=input; i++) {
		//i가 2의 배수 또는 3의 배수
		if(i%2==0 || i%3==0) {
			System.out.print(i + " ");
		}
		//2와 3의 공배수 인 경우
		if(i%2==0 && i%3 ==0 ) {
			count++; //count 1 증가
		}

	}
	System.out.println("\ncount: " +count);
}
 */


/*
public void practice1() {
      Scanner sc = new Scanner(System.in);

      System.out.print("1이상의 숫자를 입력하세요 : ");
      int input = sc.nextInt();

      if(input >= 1) {
         for(int i = 1; i <= input; i++) {
            System.out.print(i + " ");
         }
      }else {
         System.out.println("1 이상의 숫자를 입력해주세요.");
      }
   }

   public void practice2() {
      Scanner sc = new Scanner(System.in);

      System.out.print("1이상의 숫자를 입력하세요 : ");
      int input = sc.nextInt();

      if(input >= 1) {
         for(int i = input; 1 <= i; i--) {
            System.out.print(i + " ");
         }
      }else {
         System.out.println("1 이상의 숫자를 입력해주세요.");
      }
   }

   public void practice3() {
      Scanner sc = new Scanner(System.in);

      System.out.print("정수를 하나 입력하세요 : ");
      int input = sc.nextInt();

      int sum = 0;
      for(int i = 1; i <= input; i++) {
         sum += i;

         if(i == input) {
            System.out.print(i + " = ");
         }else {
            System.out.print(i + " + ");
         }
      }
      System.out.print(sum);
   }

   public void practice4() {

      Scanner sc = new Scanner(System.in);

      System.out.print("첫 번째 숫자 : ");
      int num1 = sc.nextInt();

      System.out.print("두 번째 숫자 : ");
      int num2 = sc.nextInt();

      if(num1 < 1 || num2 <1) {
         System.out.println("1 이상의 숫자를 입력해주세요.");

      } else if(num1 < num2) {
         for(int i=num1; i<=num2; i++) {
            System.out.print(i + " ");
         }
      } else { // num1 > num2
         for(int i=num2; i <=num1; i++) {
            System.out.print(i + " ");
         }

      }
   }

   public void practice5() {

      Scanner sc = new Scanner(System.in);

      System.out.print("숫자 : ");
      int dan = sc.nextInt();

      System.out.println("=====" + dan +"단 ====");

      for(int num=1; num <=9; num++) {
         System.out.printf("%d X %d = %d\n", dan, num, dan * num);
      }
   }

   public void practice6() {

      Scanner sc = new Scanner(System.in);

      System.out.print("숫자 : ");
      int input = sc.nextInt();

      if(input >= 2 && input <=9) {


         for(int dan= input; dan<=9; dan++) {
            System.out.println("===== " + dan +"단 ====");

            for(int num=1; num <=9; num++) {
               System.out.printf("%d X %d = %d\n", dan, num, dan * num);
            }
         }

      } else {
         System.out.println("2~9 사이 숫자만 입력해주세요.");
      }
   }

   public void practice7() {
      Scanner sc = new Scanner(System.in);
      System.out.println("정수 입력 : ");
      int num = sc.nextInt();

      for(int x =1; x<=num; x++) {
         for(int i=1; i<=x; i++) {
            System.out.print("*");
         }
         System.out.println();
      }
   }

   public void practice8() {

      Scanner sc = new Scanner(System.in);

      System.out.print("정수 입력 : ");
      int num = sc.nextInt();

      for(int i = num; i >= 1; i--) {

         for(int x = 1; x <= i; x++) {
            System.out.print("*");
         }

         System.out.println();
      }

   }

   public void practice9() {

      Scanner sc = new Scanner(System.in);

      System.out.print("정수 입력 : ");
      int input = sc.nextInt();

      for(int x=1; x<=input; x++) {

         // 1) for문 하나 더 작성
         // * 1개 출력 전에 띄어쓰기 3번
         // * 2개 출력 전에 띄어쓰기 2번
         // * 3개 출력 전에 띄어쓰기 1번
         // * 4개 출력 전에 띄어쓰기 0번


         for(int y=input-x; y >= 1; y--) {
            System.out.print(" ");
         }

         for(int i=1; i <= x; i++) {
            System.out.print("*");
         }

         System.out.println();// 줄바꿈


         2) for + if else

         for(int i=1; i <= input; i++) {

            if( i <= input - x ) {
               System.out.print(" ");
            } else {

               System.out.print("*");
            }

         }
         System.out.println();
      }
   }
선생님이 보내준 코드 끝
 */

