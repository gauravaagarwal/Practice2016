package com.beans;

public class Person {

	private String name;
	private String dob;
	private String email;
	private String phone;
	private String address;
	private Long pincode;
	private String country;

	public Person(String name, String dob, String email, String phone, String address, Long pincode, String country) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.pincode = pincode;
		this.country = country;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
