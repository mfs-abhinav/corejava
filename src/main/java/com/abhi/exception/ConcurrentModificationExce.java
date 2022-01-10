package com.abhi.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExce {

	public static void main(String[] args) {
		try {
			removeUsingForLoop();
			System.out.println("removeUsingForLoop worked fine");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			removeUsingForLoopCopyOnWrite();
			System.out.println("removeUsingForLoopCopyOnWrite worked fine");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			removeUsingIterator();
			System.out.println("removeUsingIterator worked fine");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static void removeUsingForLoop() {
		List<String> list = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));

		for (String s : list) {
			if (s.equals("3")) {
				list.remove(s);
			}
		}
	}

	public static void removeUsingForLoopCopyOnWrite() {
		List<String> list = new CopyOnWriteArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));

		for (String s : list) {
			if (s.equals("3")) {
				list.remove(s);
			}
		}
	}
	
	public static void removeUsingIterator(){
		List<String> myList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));

		Iterator<String> it1 = myList.iterator();
		while(it1.hasNext()){
			String value = it1.next();
			if(value.equals("3")) {
				it1.remove();
			}
		}
	}


}
