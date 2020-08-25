package com.abhi.collection;

import java.util.concurrent.*; 
import java.util.*; 

public class ConcurrentSetDemo extends Thread { 

	// static CopyOnWriteArraySet l = new CopyOnWriteArraySet();
	static CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>(); 

	public void run() 
	{ 
		// Child thread trying to add 
		// new element in the Set object 
		l.add("D"); 
	} 
	
	public static void main(String[] args) 
	{ 
		l.add("A"); 
		l.add("B"); 
		l.add("C"); 

		// We create a child thread 
		// that is going to modify 
		// CopyOnWriteArraySet l. 
		ConcurrentSetDemo t = new ConcurrentSetDemo(); 
		t.start(); 

		// Wait for the thread to 
		// add the element. 
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) { 
			System.out.println("child going to add element"); 
		} 
		
		System.out.println(l); 
		
		// Now we iterate through the 
		// CopyOnWriteArraySet and we 
		// wont get exception. 
		Iterator itr = l.iterator(); 
		while (itr.hasNext()) 
		{ 
			String s = (String)itr.next(); 
			System.out.println(s); 
		
			if(s.equals("C")) 
			{ 
				// Here we will get 
				// RuntimeException 
				itr.remove();
				// l.remove('C'); 
			} 
		} 
	} 
} 
