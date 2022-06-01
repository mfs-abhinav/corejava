package com.abhi.singletonStatic;

import static com.abhi.singletonStatic.TestSingleton.*;

public class StaticImport {

	public static void main(String[] args) {
		getInstance();
		getInstance();
		System.out.println(count);

	}

}
