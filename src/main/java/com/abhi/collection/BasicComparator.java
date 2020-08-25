package com.abhi.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicComparator {
	public static void main(String[] args) {
		List<EmployeeNew> empList = new ArrayList<EmployeeNew>();
		empList.add(new EmployeeNew(10, "Abhi"));
		empList.add(new EmployeeNew(7, "Abhi"));
		empList.add(new EmployeeNew(8, "Abhi"));
		empList.add(new EmployeeNew(6, "Abhi"));

		System.out.println("Before sorting..." + empList);

		Collections.sort(empList, new EmpComp());

		System.out.println("After sorting..." + empList);
	}

}

class EmployeeNew {

	private int empId;
	private String name;

	EmployeeNew(int id, String name) {
		this.empId = id;
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return empId + " " + name;
	}
}


class EmpComp  implements Comparator<EmployeeNew> {

	public int compare(EmployeeNew o1, EmployeeNew o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}