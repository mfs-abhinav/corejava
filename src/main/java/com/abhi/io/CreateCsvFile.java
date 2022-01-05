package com.abhi.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateCsvFile {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("user.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        for (long i = 0; i < 1000000000; i++) {
            bw.append("Abhinav" + i);
            bw.append(",");
            bw.append("email@" + i);
            bw.append(",");
            bw.append("male");
            bw.newLine();
        }
        bw.flush();
        fw.close();
    }
}
