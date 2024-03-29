package com.abhi.reflection;

public class Employee {

	private Integer id;
	private String name;
	private String designation;
	private Integer age;

	private Address address;

	public Employee() {
	}

	public Employee(Integer id, String name, String designation, Integer age, Address address) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.age = age;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}

class Address {

	private Integer id;
	private Integer houseNum;
	private String street;
	private Long zipCode;

	public Address() {
	}

	public Address(Integer id, Integer houseNum, String street, Long zipCode) {
		this.id = id;
		this.houseNum = houseNum;
		this.street = street;
		this.zipCode = zipCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(Integer houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
}
