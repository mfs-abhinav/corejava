package com.abhi.regularexpression;

public class Main {
    public static void main(String[] args) {
        String str = "acfv12CDvfacf23425wfrgr";

        System.out.println(str.matches("acfv12CdvFacf")); // true
        System.out.println(str.matches("^acf")); // false

        System.out.println(str.replaceAll(".", "A")); // AAAAAAAAAAAAAAAAAAAAAAA
        System.out.println(str.replaceAll("^acf", "A")); // Av12CDvfacf23425wfrgr
        System.out.println(str.replaceAll("acf$", "A")); // acfv12CDvfacf23425wfrgr
        System.out.println(str.replaceAll("acf", "A")); // Av12CDvfA23425wfrgr
        System.out.println(str.replaceAll("[cv]", "Y")); // aYfY12CDYfaYf23425wfrgr
        System.out.println(str.replaceAll("[cv][f]", "K")); // aKv12CDKaK23425wfrgr
        System.out.println(str.replaceAll("[^cv]", "Y")); // YcYvYYYYvYYcYYYYYYYYYYY
        System.out.println(str.replaceAll("[a-z]", "0")); // 000012CD000002342500000
        System.out.println(str.replaceAll("[a-zA-Z]", "0")); // 00001200000002342500000
        System.out.println(str.replaceAll("(?i)[a-z]", "0")); // 00001200000002342500000
        System.out.println(str.replaceAll("[0-9]", "@")); // acfv@@CDvfacf@@@@@wfrgr
        System.out.println(str.replaceAll("\\d", "@")); // acfv@@CDvfacf@@@@@wfrgr

    }
}
