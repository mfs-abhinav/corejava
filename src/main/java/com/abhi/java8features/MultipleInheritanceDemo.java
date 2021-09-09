package com.abhi.java8features;

public class MultipleInheritanceDemo implements A, B, C {
    public static void main(String[] args) {
        MultipleInheritanceDemo obj = new MultipleInheritanceDemo();
        obj.sumA(5,3); // implemented class first then sub interface that extends the interface
    }
    public void sumA(int a, int b) {
        System.out.println("Sum From MultipleInheritanceDemo: " + a+b);
    }

}
interface A {
    default void sumA(int a, int b) {
        System.out.println("Sum From A: " + a+b);
    }
}

interface B extends A {
    default void sumB(int a, int b) {
        System.out.println("Sum From B: " + a+b);
    }

    default void sumA(int a, int b) {
        System.out.println("Sum From B: " + a+b);
    }
}

interface C {
    default void sumC(int a, int b) {
        System.out.println("Sum From C: " + a+b);
    }
}
