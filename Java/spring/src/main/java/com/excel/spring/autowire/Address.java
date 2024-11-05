package com.excel.spring.autowire;

public class Address {
	private String place;

	public String getPlace() {
		return place;
	}

	@Override
	public String toString() {
		return "Address [place=" + place + "]";
	}

	public void setPlace(String place) {
		this.place = place;
	}
}
