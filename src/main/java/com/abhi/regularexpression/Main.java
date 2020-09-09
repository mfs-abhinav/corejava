package com.abhi.regularexpression;

public class Main {
    public static void main(String[] args) {
        String str = "acfv12cdvfacf";

        System.out.println(str.matches("acfv12cdvfacf")); // true
        System.out.println(str.matches("^acf")); // false

        System.out.println(str.replaceAll(".", "A")); // AAAAAAAAAAAAA
        System.out.println(str.replaceAll("^acf", "A")); // Av12cdvfacf
        System.out.println(str.replaceAll("acf$", "A")); // acfv12cdvfA
        System.out.println(str.replaceAll("acf", "A")); // Av12cdvfA
        System.out.println(str.replaceAll("[cv]", "Y")); // aYfY12YdYfaYf
        System.out.println(str.replaceAll("[cv][f]", "K")); // aKv12cdKaK
    }
}
