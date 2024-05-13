package com.excel.spring.constructor;

public class Address {
	private int id;
	private String place;
	
	public Address(int id, String place) {
		super();
		this.id=id;
		this.place=place;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", place=" + place + "]";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAddress(String place) {
		this.place = place;
	}

	public String getAddress() {
		return place;
	}
}
