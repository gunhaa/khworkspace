package edu.kh.oarr.practice.model.vo;

public class Employee {
		
	
	private String number;
	private String name;
	private String department;
	private String rank;
	private String salary;
	
	
	
	
	public Employee() {
	}

	public Employee(String number, String name, String department, String rank, 
			String salary) {

		this.number=number;
		this.name=name;
		this.department=department;
		this.rank=rank;
		this.salary=salary;

	}
	

	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


}


