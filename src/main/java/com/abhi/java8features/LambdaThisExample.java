package com.abhi.java8features;

import java.util.function.Consumer;

public class LambdaThisExample {

    public void process(int a, Consumer<Integer> consumer) {
        consumer.accept(a);
    }

    public void execute(int a) {
        process(a, (i) -> {
            System.out.println("value form execute " + i);
            System.out.println(this);// here this will work because context is not static
        });
    }

    public static void main(String[] args) {
        LambdaThisExample obj = new LambdaThisExample();
        int a = 10;
//        System.out.println(this); this will not work, can't call from static context
        obj.process(a, new Consumer<Integer>(){

            @Override
            public void accept(Integer integer) {
                System.out.println("value is from anonymous " + a);
                System.out.println(this); // this will work, its instance of anonymous inner class
            }

            @Override
            public String toString() {
                return "ThisIsAnonymousInnerClass";
            }
        });

        obj.process(a, (i) -> {
            System.out.println("value is from inner " + i);
//            System.out.println(this); this will not work, here lambda behaviour is different from anonymous class. no change has been done for this
            // in lambda, here context is static hence it will not work
        });

        obj.execute(a);
    }

    @Override
    public String toString() {
        return "ThisIsLambdaThisExampleClass";
    }
}
