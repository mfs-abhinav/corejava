package com.abhi.reflection;

public class Address {

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
