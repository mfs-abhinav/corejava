package com.abhi.reflection;


public class ReflectionTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		Employee employee = new Employee(101, "Nishant", "Boss", 29, new Address(366, 686, "Hari Road", 126003l));

		System.out.println(MyPrinter.printAllFields(employee));
	}

}
