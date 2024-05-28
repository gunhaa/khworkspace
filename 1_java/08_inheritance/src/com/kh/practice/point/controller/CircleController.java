package com.kh.practice.point.controller;

import java.util.Scanner;

import com.kh.practice.model.vo.Circle;

public class CircleController {

	Scanner sc = new Scanner(System.in);


	public String calcCircum() {
		System.out.println("x 좌표 : ");
		int x= sc.nextInt();
		System.out.println("y 좌표 : ");
		int y= sc.nextInt();
		System.out.println("반지름");
		int radius= sc.nextInt();

		Circle c = new Circle(x,y,radius);

		return "둘레 : "+x+", "+y+", "+radius+" / "+c.Circum(x,y,radius);
	}

	public String calcCircleArea() {
		System.out.println("x 좌표 : ");
		int x= sc.nextInt();
		System.out.println("y 좌표 : ");
		int y= sc.nextInt();
		System.out.println("반지름");
		int radius= sc.nextInt();

		Circle c = new Circle(x,y,radius);

		return "넓이 : "+x+", "+y+", "+radius+" / "+c.Area(x,y,radius);
	}

}
