package com.abhi.java8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByLambdaProblem {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3); // here immutable list is created
//        list.add(4); // this will throw runtime exception i.e. UnsupportedOperationException
//        System.out.println(list);

        List<Employee> emps = Arrays.asList(new Employee("Abhi1", 31, 1, 100)
                , new Employee("Abhi2" , 32, 1, 200)
                , new Employee("Abhi3", 33, 2, 300)
                , new Employee("Abhi4", 34, 3, 500)
                , new Employee("Abhi5", 35, 2, 500));

        Map<Integer, List<Employee>> empByDeptId = emps.stream().collect(Collectors.groupingBy(Employee::getDeptId));
        System.out.println(empByDeptId);

    }
}

class Employee {
    private String name;
    private int age;
    private int deptId;
    private double sal;

    public Employee(String name, int age, int deptId, double sal) {
        this.name = name;
        this.age = age;
        this.deptId = deptId;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", deptId=" + deptId +
                ", sal=" + sal +
                '}';
    }
}
