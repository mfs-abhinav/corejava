package com.abhi.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
	public static void main(String[] args) {
		char[] cbuf;
		try{
			File file = new File("test.txt");
			FileWriter wr = new FileWriter(file);//write data character by character
			wr.write("Hello how r u Hello how r u Hello how r u");
			wr.flush();
			wr.close();
			
			FileReader re = new FileReader(file);//read data characeter by character not by line by line.
			
			/*cbuf = new char[(int) file.length()];
			re.read(cbuf);
			
			for(char ch : cbuf){
				System.out.print(ch);
			}*/
						
			int i = re.read();
			while (i != -1) {//at the end of file -1 will be return.
				System.out.print((char)i);
				i = re.read();
			}
			
			re.close();
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
