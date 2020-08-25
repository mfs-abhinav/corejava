package com.abhi.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBufferedReaderWritter {
	
	private static int NUMBER_OF_ROWS = -1;
	private static int NUMBER_OF_COLUMN = 0;
	private static List<Employee> RECORDS = new ArrayList(); 
	
	private static void writeToFile() throws IOException {
		FileWriter fw = new FileWriter("D:\\Project\\java_proj\\CoreJava\\src\\main\\java\\com\\abhi\\io\\employee.csv");

		BufferedWriter bw = new BufferedWriter(fw);
		bw.append("id");
		bw.append(",");
		bw.append("name");
		bw.append(",");
		bw.append("age");
		bw.append(",");
		bw.append("sal");
		bw.newLine();
		
		for(int i=1; i<=50; i++) {
			bw.append("" + i);
			bw.append(",");
			bw.append("abhinav" + i);
			bw.append(",");
			bw.append("" + (20 + i));
			bw.append(",");
			bw.append("" + (10000 + i*i));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
	
	private static void readFile(String filepath) throws IOException {
		FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		String row;
		
		while ((row = br.readLine()) != null) {

			String[] item = row.split(",");
			NUMBER_OF_ROWS ++;

			if (NUMBER_OF_ROWS == 0) {
				NUMBER_OF_COLUMN = item.length;
				continue;
			}
			RECORDS.add(new Employee(Long.parseLong(item[0]), item[1], Integer.parseInt(item[2]), Double.parseDouble(item[3])));
		}
		br.close();
	}
	
	private static String processFile(String columnName, String operation) {
		double columnValue = 0;
		
		for (Employee employee : RECORDS) {
			columnValue = columnValue + employee.getAge();
		}
		
		if (operation == "sum") {
			return "Sum of " + columnName + " is " + columnValue;
		} else if (operation == "avg") {
			return "Avg of " + columnName + " is " + columnValue/NUMBER_OF_ROWS;
		}
		
		return "Invalid operation";
	}

	public static void main(String[] args) throws IOException {

		// writeToFile();
				
		readFile(args[0]);
		
		String[] param1 = args[1].split("\\|");		
		System.out.println(processFile(param1[0], param1[1]));
		
	}

}

class Employee {
	long id;
	String name;
	int age;
	double sal;
	
	Employee() {}
	
	Employee(long id, String name, int age, double sal) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sal = sal;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}
	
}
