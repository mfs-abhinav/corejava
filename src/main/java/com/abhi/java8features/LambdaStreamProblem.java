package com.abhi.java8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class LambdaStreamProblem {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("abhinav", 31, new Address("Delhi", 1234), Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234"))),
                new Student("Rahul", 41, new Address("Bhopal", 1235), Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"))),
                new Student("jayesh", 51, new Address("Ranchi", 1236), Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444"))),
                new Student("Banti", 29, new Address("Patna", 1237), Arrays.asList(new MobileNumber("1233"), new MobileNumber("1111")))
        );
        // get student with exact match name "abhinav"
        Optional<Student> student1 = students.stream().filter(s -> s.getName().equalsIgnoreCase("abhinav")).findFirst();
        System.out.println(student1.isPresent() ? student1 : "No student found with matching name");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // get student with matching address "1235"
        Optional<Student> student2 = students.stream().filter(s -> s.getAddress().getZipCode() == 1235).findFirst();
        System.out.println(student2.isPresent() ? student2 : "No student found with matching zipcode");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // get all students having mobile numbers 3333
        List<Student> studentList = students.stream()
                .filter(s -> s.getMobileNumbers().stream().anyMatch(x -> x.getNumber().equals("3333")))
                .collect(Collectors.toList());
        String result = studentList.stream().map(Student::getName).collect(Collectors.joining(", "));
        System.out.println(result);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // get all students having mobile numbers 1233 and 1234
        List<Student> studentList2 = students.stream()
                .filter(s -> s.getMobileNumbers().stream().allMatch(x -> x.getNumber().equals("1233") || x.getNumber().equals("1234")))
                .collect(Collectors.toList());
        String result2 = studentList2.stream().map(Student::getName).collect(Collectors.joining(", "));
        System.out.println(result2);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // create a list<TempStudent> from the List<Student>
        List<TempStudent> tempStudentList = studentList.stream().map(s -> new TempStudent(s.getName(), s.getAge(), s.getAddress(), s.getMobileNumbers()))
                .collect(Collectors.toList());
        tempStudentList.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // convert List<Student> to List<String> of students name
        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
        String result3 = names.stream().collect(Collectors.joining(", "));
        System.out.println(result3);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // convert List<Student> to <String> of students name
        String result4 = students.stream().map(Student::getName).collect(Collectors.joining(", "));
        System.out.println(result4);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // convert List<Student> to List<String> of students name in uppercase
        students.stream().map(s -> s.getName().toUpperCase()).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // convert List<Student> to List<String> of students name in sorted
        students.stream().map(Student::getName).sorted().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // get list of all students phone numbers
        List<String> phoneNumbers = students.stream()
                .flatMap(s -> s.getMobileNumbers().stream())
                .map(MobileNumber::getNumber)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // get List<Map<String, List<MobileNumber>>> create list of map of student's name with mobile number
        List<Map<String, List<MobileNumber>>> listOfStudentNameMobile = students.stream()
                .map(s -> Collections.singletonMap(s.getName(), s.getMobileNumbers()))
                .collect(Collectors.toList());
        System.out.println(listOfStudentNameMobile);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // get list of students from map of student's name with mobile number
        List<String> listOfNames = listOfStudentNameMobile.stream().flatMap(s -> s.keySet().stream()).collect(Collectors.toList());
        System.out.println(listOfNames);
        System.out.println("-----------------------------------------------------------------------------------------------------");

        // get average age of student
        OptionalDouble ageAvg1 = studentList.stream().mapToInt(Student::getAge).average();
        System.out.println(ageAvg1.isPresent() ? ageAvg1.getAsDouble() : "Not found");
        studentList.stream().mapToDouble(Student::getAge).average().getAsDouble();
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
}

class TempStudent {
    private String name;
    private int age;
    private Address address;
    private List<MobileNumber> mobileNumbers;

    public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
    }

    @Override
    public String toString() {
        return "TempStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }
}

class Student {
    private String name;
    private int age;
    private Address address;
    private List<MobileNumber> mobileNumbers;

    public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }
}

class Address {
    private String city;
    private int zipCode;

    public Address(String city, int zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}

class MobileNumber {
    private String number;

    public MobileNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "MobileNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}
