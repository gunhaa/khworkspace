package com.kh.practice.point.controller;

import java.util.Scanner;

import com.kh.practice.model.vo.Rectangle;


public class RectangleController {

	Scanner sc = new Scanner(System.in);

	public String rectanglePerimeter() {
		System.out.println("x 좌표 : ");
		int x= sc.nextInt();
		System.out.println("y 좌표 : ");
		int y= sc.nextInt();
		System.out.println("높이 : ");
		int height= sc.nextInt();
		System.out.println("너비 : ");
		int width= sc.nextInt();

		Rectangle rc = new Rectangle(x,y,height,width);
		
		return "둘레 : "+x+", "+y+" "+height+" "+width+ " /"+rc.calcPerimeter(height, width);
	}
	
	public String rectangleArea() {
		System.out.println("x 좌표 : ");
		int x= sc.nextInt();
		System.out.println("y 좌표 : ");
		int y= sc.nextInt();
		System.out.println("높이 : ");
		int height= sc.nextInt();
		System.out.println("너비 : ");
		int width= sc.nextInt();

		Rectangle rc = new Rectangle(x,y,height,width);
		
		return "넓이 : "+x+", "+y+" "+height+" "+width+ " /"+rc.calcArea(height, width);

	}
	
	
}
