package com.kh.practice.model.vo;

public class Rectangle extends Point {
	
	private Rectangle r = new Rectangle();
	
	private int width;
	private int height;
	
	public Rectangle() {
	}
	
	public Rectangle(int x, int y, int width, int height) {
		super(x,y);
		this.width=width;
		this.height=height;
	}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String calcPerimeter(int width , int height) {
		int peri = (width+height)*2;
		return Integer.toString(peri);
	}
	public String calcArea(int width , int height) {
		int area = width*height;
		return Integer.toString(area);
	}
	
}
