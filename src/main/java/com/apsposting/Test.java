package com.apsposting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import jakarta.persistence.criteria.Predicate;

public class Test {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya", "Nanda", 32, "Female", "HR"));
		employeeList.add(new Employee(122, "Paul", "Seth", 25, "Male", "Sales And Marketing"));
		employeeList.add(new Employee(133, "Martin", "Theron", 29, "Male", "Infrastructure"));
		employeeList.add(new Employee(136, "Mukesh", "Kumar", 29, "Male", "Infrastructure"));
		employeeList.add(new Employee(137, "Rajesh", "Thakur", 39, "Male", "Infrastructure"));
		employeeList.add(new Employee(121, "Riya", "Kumari", 22, "Female", "Sales"));
		
		List<String> lastName = employeeList.stream().map(x -> x.getLastName()).collect(Collectors.toList());
		
		System.out.println(lastName);

	}   
}
