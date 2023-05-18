package entity;

import java.sql.Date;

public class Staff {
	private String staffID;
	private String staffName;
	private boolean gender; // True là nam, flase là nữ
	private Date dateOfBirth;
	private String address;
	private String email;
	private double salary;
	private String phone;
	private String position;
	private String note;

	public Staff() {
		super();
	}

	public Staff(String staffID, String staffName, boolean gender, Date dateOfBirth, String address, String email,
			double salary, String phone, String position, String note) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.email = email;
		this.salary = salary;
		this.phone = phone;
		this.position = position;
		this.note = note;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Staff [staffID=" + staffID + ", staffName=" + staffName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", email=" + email + ", salary=" + salary + ", phone=" + phone
				+ ", position=" + position + ", note=" + note + "]";
	}

}

