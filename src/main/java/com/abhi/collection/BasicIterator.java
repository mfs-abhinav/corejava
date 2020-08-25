package com.abhi.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicIterator {
	public static void main(String[] args) {

		List<Dog> d = new ArrayList<Dog>();
		Dog dog = new Dog("indian");
		d.add(new Dog("german"));
		d.add(dog);
		d.add(new Dog("chinese"));

		Iterator<Dog> it = d.iterator();
		while (it.hasNext()) {
			Dog d1 = it.next();
			System.out.println("Dog name is " + d1.getName());
		}
		System.out.println("Size of dog list " + d.size());
		System.out.println("First element in list " + d.get(0).getName());
		System.out.println("Index of Indian dog " + d.indexOf(dog));

		d.remove(1);
		Object[] oa = d.toArray();
		
		for (Object o : oa) {
			Dog d2 = (Dog) o;
			System.out.println("oa " + d2.getName());
		}
	}
}

class Dog {
	private String name;

	Dog(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

}
