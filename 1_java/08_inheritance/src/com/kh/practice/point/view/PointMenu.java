package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {

	RectangleController rc = new RectangleController();
	CircleController cc = new CircleController();
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {

		int input =0;
		boolean flag = true;
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("9. 끝내기");
		System.out.println("메뉴 번호 : ");
		input = sc.nextInt();
		do{

			switch(input) {
			case 1:
				circleMenu();
				break;
			case 2:
				rectangleMenu();

				break;
			case 9:
				flag = false;
				break;
			default:
				mainMenu();
			}

		}while(flag==true);
		System.out.println("종료합니다.");
	}



	public void circleMenu() {
		System.out.println("===== 원 메뉴 ======");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.println("메뉴 번호 : ");
		int input = sc.nextInt();

		switch(input) {
		case 1: 
			System.out.println(cc.calcCircum());
			break;
		case 2:
			System.out.println(cc.calcCircleArea());
			break;
		case 9: 
			mainMenu();
			break;
		default : 
			System.out.println("잘못 입력하셨습니다. 메인 메뉴로 돌아갑니다. \n");
		}
	}

	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 ======");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("3. 메인으로");
		System.out.println("메뉴 번호 : ");
		int input = sc.nextInt();

		switch(input) {
		case 1: 
			System.out.println(rc.rectanglePerimeter());
			break;
		case 2:
			System.out.println(rc.rectangleArea());
			break;
		case 3: 
			mainMenu();
			break;
		}

	}
}
