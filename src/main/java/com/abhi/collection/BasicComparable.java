package com.abhi.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicComparable {
	public static void main(String[] args) {
				
		List<Employee> empList = new ArrayList<Employee>();

		empList.add(new Employee(10, "Abhi"));
		empList.add(new Employee(7, "Abhi"));
		empList.add(new Employee(8, "Abhi"));
		empList.add(new Employee(6, "Abhi"));

		System.out.println("Before sorting..." + empList);

		Collections.sort(empList);

		System.out.println("After sorting..." + empList);

	}
}

class Employee implements Comparable<Employee> {

	private int empId;
	private String name;

	Employee(int id, String name) {
		this.empId = id;
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public int compareTo(Employee e) {
		return this.empId - e.getEmpId();
	}

	public String toString() {
		return empId + " " + name;
	}
}
