package com.excel.spring.autowire;

public class Employee {
	private Address place;

	public Address getAddress() {
		return place;
	}

	public void setAddress(Address place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Employee [address=" + place + "]";
	}
}
