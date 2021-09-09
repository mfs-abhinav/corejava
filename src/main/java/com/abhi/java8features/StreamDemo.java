package com.abhi.java8features;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Emp> emps = Arrays.asList(new Emp(1,"Abhinav", Arrays.asList("Java","node"),1000),
                new Emp(1,"Rahul", Arrays.asList("C++",".Net"),1000),
                new Emp(1,"Nishant", Arrays.asList("Python","GO"),2000),
                new Emp(1,"Deepak", Arrays.asList("Angular","node"),5000),
                new Emp(1,"Boodhi", Arrays.asList("React","node"),9000));
        System.out.println(emps);

        System.out.println("----------------------------------------------------");

        Map<String, List<String>> userSkills = emps.stream().collect(Collectors.toMap(Emp::getName, Emp::getSkills));
        System.out.println(userSkills);

        System.out.println("----------------------------------------------------");

        List<String> empNames = emps.stream().map(Emp::getName).collect(Collectors.toList());
        System.out.println(empNames);

        System.out.println("----------------------------------------------------");

        List<String> skills = emps.stream().map(Emp::getSkills).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(skills);


        System.out.println("--------------------------------");
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int result1 = nums.stream().reduce(0, Integer::sum);
        System.out.println(result1);

        Optional result2 = nums.stream().reduce(Integer::sum);
        if (result2.isPresent())
            System.out.println(result2.get());

        System.out.println("--------------------------------");
        Stream<Integer> input = Stream.of(1,5,6,7,8,9);
        input.forEach(System.out::print);

        System.out.println("--------------------------------");

        IntStream input1 = IntStream.rangeClosed(1,1000);
        System.out.println("Sum of 1000 numbers is: " + input1.sum());

        IntStream input2 = IntStream.rangeClosed(1,1000);
        OptionalInt min = input2.min();
        if (min.isPresent()) {
            System.out.println("Min of 1000 numbers is: " + min.getAsInt());
        }

        IntStream input3 = IntStream.rangeClosed(1,500);
        List<Integer> numbers = input3.boxed().collect(Collectors.toList());
        numbers.forEach(System.out::print);

        int sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nSum of 500 numbers using sum() " + sum1);

        Optional<Integer> sum2 = numbers.stream().reduce((a, b) -> a+b);
        if(sum2.isPresent()) {
            System.out.println("Sum of 500 numbers using reduce: " + sum2.get());
        }

        IntStream input4 = IntStream.rangeClosed(1,5);
        List<RandomIds> randomIds = input4.mapToObj((i) -> new RandomIds(i, ThreadLocalRandom.current().nextInt(100))).collect(Collectors.toList());
        randomIds.forEach(System.out::println);

        List<String> names = Arrays.asList("Syed", "Abhi", "Banti", "Rahul", "Nita");
        Map<Integer, List<String>> groupedNames = names.stream()
                .collect(Collectors.groupingBy(String::length));
        groupedNames.forEach((key, value) -> System.out.println( key + " = " + value));

    }
}
class Emp {
    private int id;
    private String name;
    private List<String> skills;
    private double salary;

    public Emp(int id, String name, List<String> skills, double salary) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skills=" + skills +
                ", salary=" + salary +
                '}';
    }
}

class RandomIds {
    private int id;
    private int randomNumber;

    public RandomIds(int id, int randomNumber) {
        this.id = id;
        this.randomNumber = randomNumber;
    }

    @Override
    public String toString() {
        return "RandomIds{" +
                "id=" + id +
                ", randomNumber=" + randomNumber +
                '}';
    }
}
