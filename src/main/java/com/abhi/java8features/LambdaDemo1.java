package com.abhi.java8features;

public class LambdaDemo1 {
    public static void main(String[] args) {
        // Traditional approach
        IHelloWorld iHelloWorld = new HelloWorldTraditionalWay();
        System.out.println(iHelloWorld.sayHello());

        // lambda approach - implements interface using lambda
        IHelloWorld iHelloWorldLambda = () -> {
            return "Hello World lambda";
        };
        System.out.println(iHelloWorldLambda.sayHello());
    }
}

// functional interface has only on abstract method
interface IHelloWorld {
    public String sayHello();
}

class HelloWorldTraditionalWay implements IHelloWorld {

    @Override
    public String sayHello() {
        return "Hello World";
    }
}