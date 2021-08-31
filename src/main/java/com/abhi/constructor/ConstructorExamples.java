package com.abhi.constructor;

public class ConstructorExamples {
    public static void main(String[] args) {
        Labrador labrador = new Labrador();
    }
}

class Animal {
    public Animal() {
        System.out.println("Animal Constructor");
    }
}
class Dog extends Animal {
    public Dog() {
        System.out.println("Dog Constructor");
    }

    public Dog(String name) {
        System.out.println("Dog Constructor " + name);
    }
}
class Labrador extends Dog {
    public Labrador() {
        System.out.println("Labrador Constructor");
    }
}
