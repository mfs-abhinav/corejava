package com.abhi.collection;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class BasicLinkedList {

	public static void main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();
		l.add(2);
		l.add(5);
		l.add(6);
		
		// through iterator
		Iterator<Integer> ite = l.iterator(); 
		while ( ite.hasNext() ) {
			System.out.println(ite.next());
		}
	
		//traditional approach
		for ( int i=0; i < l.size(); i++ ) {
			System.out.println(l.get(i));
		}
		
		// enhanced for loop
		for ( Integer i : l ) {
			System.out.println(i.intValue());
		}
		
		// for each loop
		//l.forEach(i -> System.out.println(i));
	}
}
