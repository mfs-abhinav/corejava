package com.abhi.Static;

import static com.abhi.Static.TestSingleton.*;

public class StaticImport {

	public static void main(String[] args) {
		getInstance();
		getInstance();
		System.out.println(count);

	}

}
