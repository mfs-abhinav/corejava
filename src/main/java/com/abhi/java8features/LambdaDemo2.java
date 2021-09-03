package com.abhi.java8features;

public class LambdaDemo2 {

    public static void main(String[] args) {
        //Traditional way
        IAddInterface iAddInterface = new IncrementTraditional();
        System.out.println("Using Traditional: " + iAddInterface.add(10, 15));

        // lambda way
        IAddInterface iAddInterfaceLambda = (i, j) -> i + j;
        System.out.println("Using lambda: " + iAddInterfaceLambda.add(10, 15));
    }
}


class IncrementTraditional implements IAddInterface {

    @Override
    public int add(int i, int j) {
        return i + j;
    }
}

@FunctionalInterface
interface IAddInterface {
    public int add(int i, int j);
}
