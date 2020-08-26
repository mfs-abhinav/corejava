package com.abhi.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String DEPT = "Finance";

	// transient prevent data not to be serialized
	transient private int id;
	private String name;

	Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class TestSerialization {

	public static void main(String[] args) {
		serializeFile();
		derializeFile();
	}

	public static void serializeFile() {
		Employee emp = new Employee(100, "Abhinav");

		try {
			FileOutputStream fo = new FileOutputStream("corejava/src/main/resources/emp.ser");

			ObjectOutputStream os = new ObjectOutputStream(fo);
			System.out.println("Before serialize:- " + emp.getId() + " " + emp.getName() + " " + Employee.DEPT);
			os.writeObject(emp);

			os.flush();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void derializeFile() {
		try {
			FileInputStream fis = new FileInputStream("corejava/src/main/resources/emp.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Employee demp = (Employee) ois.readObject();
			System.out.println("After serialize:- " + demp.getId() + " " + demp.getName() + " " + Employee.DEPT);
			
			ois.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
