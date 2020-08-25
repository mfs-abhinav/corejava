package com.abhi.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapStreamDemo {

	public static void main(String[] args) {
		Map<String, String> books = new HashMap<>();
		books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
		books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
		books.put("978-0134685991", "Effective Java");
		
		
		List<String> modifiedBooks1 = books.entrySet().stream()
				.filter(e -> e.getValue().startsWith("Effective Java"))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		
		Map<String, String> modifiedBooks2 = books.entrySet().stream()
//				.filter(e -> {
//					System.out.println("Inside filter lambda function");
//					return e.getValue().startsWith("Effective Java");
//					return filterMapData(e);
//				})
				.filter(e -> filterMapData(e))
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()));
		
		Map<String, String> modifiedBooks3 = books.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()));
		
		

	}
	
	public static Boolean filterMapData(Entry<String, String> e) {
		System.out.println("Inside filterMapData function");
		return e.getValue().startsWith("Effective Java");
	}

}
