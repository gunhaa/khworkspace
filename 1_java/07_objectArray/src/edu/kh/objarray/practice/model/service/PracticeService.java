package edu.kh.objarray.practice.model.service;

import java.util.Scanner;

import edu.kh.objarray.practice.model.vo.Student;

public class PracticeService {

	Scanner sc = new Scanner(System.in);
	
	private Student[] arr = new Student[10];
	
	public void start() {
		int cycle=0;
		boolean flag = true;
		int avg=0;
		
		while(flag) {
			cycle+=1;
			System.out.print("\n학년 : ");
			int inputGrade=sc.nextInt();
			
			System.out.print("반 : ");
			int inputClass=sc.nextInt();
			
			System.out.print("이름 : ");
			String inputName=sc.next();
			
			System.out.print("국어점수 : ");
			int inputKor=sc.nextInt();
			
			System.out.print("영어점수 : ");
			int inputEng=sc.nextInt();
			
			System.out.print("수학점수 : ");
			int inputMath=sc.nextInt();
			
			arr[cycle-1]=new Student(inputGrade, inputClass, inputName,  inputKor,  inputEng, inputMath);
			
			System.out.print("계속 입력하시겠습니까? (y/n)");
			String inputyn=sc.next();
			
			if(inputyn.equals("y")) {
				flag = true;
				if(cycle<11) {
				break;
				}
			} else {
				flag = false;
			}
		}
		
		
		
		for(int i=0 ; i<cycle; i++) {

			avg = (int)((arr[i].getMath()+arr[i].getKor()+arr[i].getEng())/3);
		
			System.out.println(arr[i].getGrade()+"학년 "+arr[i].getClassRoom()+"반 "+arr[i].getName()+" >> 국어 : "+arr[i].getKor()+", 영어 : "+arr[i].getEng()+", 수학 : "+arr[i].getMath()+", 평균 : "+avg);
		}
		
		
	}
}
