package com.abhi.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BasicGeneric {
	public static void main(String[] a){
		List<Integer> li = new ArrayList<>();
		li.add(5);
		li.add(10);
		
		print(li);
		
		List<Integer> ll = new LinkedList<>();
		ll.add(20);
		ll.add(50);
		
		print(ll);
		
		Store<String> st = new Store<>();
		st.setItem("Hello World");
		st.getItem();
		
		HashTable<String, Integer> ht = new HashTable<>();
		ht.setItem("hello", 1234);
		ht.getItem();
		
		GenericMethod gm = new GenericMethod();
		Integer[] arr1 = {2,8,90,50};
		String[] arr2 = {"abhi", "kumar", "banti", "singh"};
		gm.printItem(arr1);
		gm.printItem(arr2);
		System.out.println("Min valuse is: " + gm.calculateMin('g', 'x'));
		System.out.println("Min valuse is: " + gm.calculateMin("Abhi", "abhi"));
		System.out.println("Min valuse is: " + gm.calculateMin(56, 80));
		
		List<Integer> l1 = new ArrayList<>();
		l1.add(5);l1.add(7);
		gm.printUpperBounded(l1);
		
		List<Double> l2 = new ArrayList<>();
		l2.add(5.0);
		l2.add(7.2);
		gm.printUpperBounded(l2);
		
		List<Serializable> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(78);
		gm.printLowerBounded(l3);
	}
	
	public static void print(List<Integer> li) {
		System.out.println(li);
	}
}

class GenericMethod {

	public <T> void printItem(T[] items) {
		for(T item: items ) {
			System.out.println("Item is: " + item.toString());
		}
	}
	
	public <I> I returnItem(I item) {
		return item;
	}
	
	// bounded generic types
	public <T extends Comparable<T>> T calculateMin(T t1, T t2) {
		if (t1.compareTo(t2) < 0) {
			return t1;
		} else {
			return t2;
		}
	}
	
	public void printUpperBounded(List<? extends Number> list) {

		for (Number n: list) {
			System.out.println(n);
		}
	}
	
	public void printLowerBounded(List<? super Serializable> list) {

		for (Object n: list) {
			System.out.println(n);
		}
	}
}

class HashTable<K, V> {
	private K key;
	private V value;
	
	public void setItem(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public void getItem() {
		System.out.println("Key is: " + key.toString() + " and value is: " + value);
	}
}

class Store<T> {
	private T item;
	
	public void setItem(T item) {
		this.item = item;
	}
	
	public void getItem() {
		System.out.println(this.item);
	}

	@Override
	public String toString() {
		return "Store [item=" + item + "]";
	}
	
}