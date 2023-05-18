package entity;

import java.sql.Date;

public class Customer {
	private String customer_ID;
	private String customer_Name;
	private boolean customer_Gender;
	private Date customer_DateOfBirth;
	private String customer_Phone;
	private String customer_Address;

	public Customer() {
	}

	public Customer(String customer_ID, String customer_Name, boolean customer_Gender, Date customer_DateOfBirth,
			String customer_Phone, String customer_Address) {
		this.customer_ID = customer_ID;
		this.customer_Name = customer_Name;
		this.customer_Gender = customer_Gender;
		this.customer_DateOfBirth = customer_DateOfBirth;
		this.customer_Phone = customer_Phone;
		this.customer_Address = customer_Address;
	}

	public String getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(String customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public boolean isCustomer_Gender() {
		return customer_Gender;
	}

	public void setCustomer_Gender(boolean customer_Gender) {
		this.customer_Gender = customer_Gender;
	}

	public Date getCustomer_DateOfBirth() {
		return customer_DateOfBirth;
	}

	public void setCustomer_DateOfBirth(Date customer_DateOfBirth) {
		this.customer_DateOfBirth = customer_DateOfBirth;
	}

	public String getCustomer_Phone() {
		return customer_Phone;
	}

	public void setCustomer_Phone(String customer_Phone) {
		this.customer_Phone = customer_Phone;
	}

	public String getCustomer_Address() {
		return customer_Address;
	}

	public void setCustomer_Address(String customer_Address) {
		this.customer_Address = customer_Address;
	}

}

