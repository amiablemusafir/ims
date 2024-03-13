package com.apsposting;

public class Employee {
	
	public Integer id;
	public String fistName;
	public String lastName;
	public Integer age;
	public String gender;
	public String department;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Employee(Integer id, String fistName, String lastName, Integer age, String gender, String department) {
		super();
		this.id = id;
		this.fistName = fistName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.department = department;
	}
	
	
}
