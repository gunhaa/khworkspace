package com.kh.practice.model.vo;

public class Circle extends Point {

	private int radius;
	
	public Circle() {
	}
	
	public Circle(int x, int y, int radius) {
		super(x,y);
		this.radius=radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public double Area(int x, int y, int radius) {
		double Ar = radius*radius*Math.PI;
		return Ar;
	}

	public double Circum(int x, int y, int radius) {
		double cir = radius*2*Math.PI;
		return cir;
	}

	
	public String toString() {
		return "";
	}
}
