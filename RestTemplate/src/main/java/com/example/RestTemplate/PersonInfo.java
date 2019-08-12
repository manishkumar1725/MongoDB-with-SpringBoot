package com.example.RestTemplate;

public class PersonInfo {

	
	int id;
	String name;
	String city;
	String contactNumber;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonInfo(int id, String name,String city,String contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.city=city;
		this.contactNumber=contactNumber;
	}
	
	public PersonInfo()
	{
		
	}

}
