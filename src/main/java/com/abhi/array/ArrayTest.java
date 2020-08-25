package com.abhi.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayTest {

	void takeArrayParam(int[] item) {

		for (int i = 0; i < item.length; i++) {
			item[i] *= 2;
		}

	}

	public static void main(String[] args) {
		ArrayTest obj = new ArrayTest();
		int[] arr1 = {5,6,7};
		obj.takeArrayParam(arr1);
		
		/*for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}*/
		
		String[] arr2 = {"india","pakistan","aus","nz"};
		
		Arrays.sort(arr2, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
			}
		});
		
		List<String> list2 = Arrays.asList(arr2);
		System.out.println(list2);
	}
}
