package com.abhi.io;

import java.io.File;
import java.io.IOException;

public class FileHandling {
	public static void main(String[] args) {
		try {
			File file = new File("test.pdf");//physical file is not created. a java file object is created.
			System.out.println(file.exists());
			file.createNewFile();//create physical file
			
			System.out.println(file.exists());
			
			/*File f = new File("test");
			if (! f.exists()) {
				f.mkdir();
			}
			System.out.println(f.length());
			f = new File(f,"test.txt");
			if (! f.exists()) {
				f.createNewFile();
			}
			
			System.out.println(f.length());*/
			
			//File f = new File("F:\\DOC\\Pay Slip");
			//listAllFile(f);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get all the file in a directory.
	public static void listAllFile(File dir) {
		try {
			File[] fileList = dir.listFiles();
			
			for (File f : fileList) {
				if (f.isDirectory()) {
					System.out.println("directory is " + f.getCanonicalPath());
					listAllFile(f);
				} else {
					System.out.println("   file is " + f.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
