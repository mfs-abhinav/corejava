package com.abhi.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BasicSet {
	public static void main(String[] args) {
		/*
		 * boolean[] ba = new boolean[5]; Set s = new HashSet(); ba[0] =
		 * s.add("a"); ba[1] = s.add(new Integer(10)); ba[2] = s.add("b"); ba[3]
		 * = s.add("a"); ba[4] = s.add(new Object());
		 * 
		 * for (int x = 0; x < ba.length; x++) { System.out.println(ba[x] +
		 * " "); } System.out.println("\n"); for (Object o : s) {
		 * System.out.println(o + " "); }
		 */

		Set<Patient> s = new HashSet<Patient>();
		Patient p1 = new Patient(1, "Abhi");
		s.add(p1);
		s.add(new Patient(2, "Rahul"));
		s.add(p1);
		s.add(new Patient(3, "Raj"));
		
		for ( Patient p : s ) {
			System.out.println(p.getName());
		}
		
		Iterator<Patient> ite = s.iterator();
		while ( ite.hasNext() ) {
			System.out.println(ite.next().getName());
		}
	}
}

class Patient {

	private int id;
	private String name;

	Patient(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getEmpId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return id + " " + name;
	}

}
