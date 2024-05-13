package com.excel.spring.constructor;

public class Employee {
	private int id;
	private String name;
	private Address address;
	
	public Employee(int id, String name, Address address) {
		super();
		this.id=id;
		this.name=name;
		this.address=address;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
