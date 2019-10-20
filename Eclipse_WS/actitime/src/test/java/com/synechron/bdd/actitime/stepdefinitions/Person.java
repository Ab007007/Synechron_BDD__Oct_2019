package com.synechron.bdd.actitime.stepdefinitions;

public class Person {

	String name ;
	String address ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public Person() {
		System.out.println("******************constructor called*****************************");
		this.name = "Aravinda";
		this.address = "India";
	}
}
