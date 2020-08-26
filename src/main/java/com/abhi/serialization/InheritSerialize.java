package com.abhi.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Animal {
	int weight=40;
	Animal(){
		System.out.println("Animal constructor is called");
	}
}

class Dog extends Animal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	
	Dog(String name, int wt){
		this.name = name;
		weight=wt;
	}
		
}

public class InheritSerialize {
	public static void main(String[] args) {
		serializeFile();

		derializeFile();
	}

	public static void serializeFile() {
		Dog dog = new Dog("German", 80);

		try {
			FileOutputStream fo = new FileOutputStream("corejava/src/main/resources/dog.ser");

			ObjectOutputStream os = new ObjectOutputStream(fo);
			System.out.println("Before serialize " + dog.name + " " + dog.weight);
			os.writeObject(dog);

			os.flush();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void derializeFile() {
		try {
			FileInputStream fis = new FileInputStream("corejava/src/main/resources/dog.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Dog dogd = (Dog) ois.readObject();
			System.out.println("After serialize " + dogd.name + " " + dogd.weight);
			
			ois.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}