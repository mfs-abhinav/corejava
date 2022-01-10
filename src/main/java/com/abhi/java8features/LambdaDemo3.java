package com.abhi.java8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
public class LambdaDemo3 {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Abhinav", "Kumar", 31),
                new Person("Banti", "Singh", 25),
                new Person("Nita", "Singh", 29),
                new Person("Rahul", "Baghel", 38),
                new Person("Nishant", "Handa", 33)
        );

        // sort list by last name

        // using traditional approach
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        // using lambda approach
        persons.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // create method that print all elements in list
        // traditional approach
        printConditionaly(persons, new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return true;
            }
        }, new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
        // using lambda approach
        printConditionaly(persons, p -> true, p -> System.out.println(p));


        // create a method that print all person that have lastname starts with N
        // using traditional approach
        printConditionaly(persons, new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("N");
            }
        }, new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person.getLastName());
            }
        });
        // using lambda approach
        printConditionaly(persons, p -> p.getLastName().startsWith("N"), p -> System.out.println(p.getLastName()));

    }

    // no need to declare Conditions interface, Predicate can be used here Predicate has same signature
//    private static void printConditionaly(List<Person> persons, Conditions conditions) {
    private static void printConditionaly(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : persons) {
            if (predicate.test(p)) {
//                System.out.println(p); // This can be replaced by Consumer interface
                consumer.accept(p);
            }
        }
    }
}

@FunctionalInterface
interface Conditions {
    boolean test(Person p);
}

