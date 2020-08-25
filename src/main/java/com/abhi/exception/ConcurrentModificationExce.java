package com.abhi.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExce {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("Java"); 
		names.add("PHP");
		names.add("SQL");
		names.add("Angular 2");
		
		System.out.println("Items in list " + names);
		
		List<String> first2Names = names.subList(0, 2);
		
		System.out.println("Items in sublist " + first2Names);
		first2Names.set(0, "Java modified");
		
		names.set(1, "JavaScript");
		//check the output below. 
		System.out.println(names +" , "+first2Names);
		
		//Let's modify the list size and get ConcurrentModificationException
		first2Names.add("NodeJS");
		System.out.println(names +" , "+first2Names);
		System.out.println(first2Names);//this line throws exception
	}
	
	/*public static void main(String args[]) {
		//List<String> list = new ArrayList<String>();
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("A");
		list.add("B");
 
		for (String s : list) {
			if (s.equals("B")) {
				list.remove(s);
			}
		}
	}*/
	
//	public static void main(String args[]){
//		List<String> myList = new ArrayList<String>();
//		
//		myList.add("1");
//		myList.add("2");
//		myList.add("3");
//		myList.add("4");
//		myList.add("5");
//		
//		Iterator<String> it1 = myList.iterator();
//		while(it1.hasNext()){
//			String value = it1.next();
//			if(value.equals("3")) {
//				it1.remove();
//			}
//		}
//		Iterator<String> it2 = myList.iterator();
//		while(it2.hasNext()){
//			String value = it2.next();
//			System.out.println("List Value:"+value);
//		}
//
//	}


}
