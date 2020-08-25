package com.abhi.io;

import java.io.IOException;
import java.io.PrintWriter;

public class PrintWritter {

	public static void main(String[] args) throws IOException {

		
		PrintWriter pw = new PrintWriter("test.txt");//most powerful writter can insert int,double,float,.. but for other writer only char or string can be inserted
		
		pw.println(10);
		pw.write(100);
		pw.flush();
		pw.close();
	}

}
