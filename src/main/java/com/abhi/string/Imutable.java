package com.abhi.string;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// this mutable class ie once object is created its value can't be changed
final class Employee {
	private int id;
	private String name;
	private int age;
	private Date dob;
	private Set<String> skills;
	private Address address;

	public Employee(int id, String name, int age, Date dob, Set<String> skills, Address address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.skills = skills;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// this is mutable hence returing clone copy
	public Date getDob() {
		return new Date(dob.getTime());
	}

	// this is mutable hence returning clone copy
	public Set<String> getSkills() {
		return new LinkedHashSet<>(skills);
	}

	// this is mutable hence returning clone copy
	public Address getAddress() {
		Address addressClone = new Address();
		addressClone.setCity(address.getCity());
		addressClone.setPincode(address.getPincode());
		addressClone.setAddressLine1(address.getAddressLine1());
		return addressClone;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", dob=" + dob +
				", skills=" + skills +
				", address=" + address +
				'}';
	}
}

class Address {
	private String city;
	private int pincode;
	private String addressLine1;

	public Address() {
	}

	public Address(String city, int pincode, String addressLine1) {
		this.city = city;
		this.pincode = pincode;
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Override
	public String toString() {
		return "Address{" +
				"city='" + city + '\'' +
				", pincode=" + pincode +
				", addressLine1='" + addressLine1 + '\'' +
				'}';
	}
}

public class Imutable {
	public static void main(String[] args) {
		Employee emp1 = new Employee(
				101, "Abhinav", 31, new Date(1989, 12, 12)
				, new HashSet<>(Arrays.asList("Java", "Spring")), new Address("New Delhi", 110096, "New Ashok Nagar"));

		System.out.println("Before modification " + emp1);
		emp1.getSkills().add("Nodejs");
		System.out.println("After modification " + emp1);
	}
}
