package com.abhi.exception;

public class DivideByZeroException {
    public static void main(String[] args) {
        double[] arr = {3.5, 0.0, 10, 134, 8.8};
        double x = 3.5 / 0.0; // here exception will not be thrown, rather infinity will be return
        System.out.println(x);
        arr[3] = x;
        for (double d : arr) {
            if (!Double.isInfinite(d)) {
                System.out.println(d);
            }
        }

    }
}
