package com.abhi.Interface;

public class InterfaceDemo implements ITest1{
    @Override
    public void display() {

    }

    public static void main(String[] args) {
        ITest1 obj = new InterfaceDemo();
        System.out.println(obj.print(obj.item));
    }
}
