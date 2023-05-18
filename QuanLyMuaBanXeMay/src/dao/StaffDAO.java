package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import connection.ConnectDB;
import connection.ConnectDatabase;
import entity.Staff;

public class StaffDAO implements InterfaceDAO<Staff> {

	public static StaffDAO getInstance() {
		return new StaffDAO();
	}

	@Override
	public int insert(Staff t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();
			
			String sql = "INSERT INTO Staff VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getStaffID());
			pst.setString(2, t.getStaffID());
			pst.setString(3, "123456789");
			pst.setString(4, t.getStaffName());
			pst.setString(5, (t.isGender()) ? "Nam" : "Nữ");
			pst.setString(6, t.getDateOfBirth() + "");
			pst.setString(7, t.getAddress());
			pst.setString(8, t.getEmail());
			pst.setDouble(9, t.getSalary());
			pst.setString(10, t.getPhone());
			pst.setString(11, t.getPosition());
			pst.setString(12, t.getNote());

			ketQua = pst.executeUpdate();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Staff t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "UPDATE Staff SET staff_Name =?, staff_Gender=?, staff_DateOfBirth=?, staff_Address=?, staff_Email=?, staff_Salary=?, staff_Phone=?, staff_Position=?, staff_Note=? WHERE staff_ID =?";

			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getStaffName());
			pst.setString(2, (t.isGender()) ? "Nam" : "Nữ");
			pst.setString(3, t.getDateOfBirth() + "");
			pst.setString(4, t.getAddress());
			pst.setString(5, t.getEmail());
			pst.setDouble(6, t.getSalary());
			pst.setString(7, t.getPhone());
			pst.setString(8, t.getPosition());
			pst.setString(9, t.getNote());
			pst.setString(10, t.getStaffID());

			ketQua = pst.executeUpdate();

			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(Staff t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "DELETE Staff WHERE staff_ID =?";

			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getStaffID());

			ketQua = pst.executeUpdate();

			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<Staff> selectAll() {
		ArrayList<Staff> list = new ArrayList<Staff>();
		
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM Staff";

			PreparedStatement pst = c.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String staffID = rs.getString("staff_ID");
				String staffName = rs.getString("staff_Name");
				boolean gender = (rs.getString("staff_Gender").equals("Nam")); // True là nam, flase là nữ
				Date dateOfBirth = rs.getDate("staff_DateOfBirth");
				String address = rs.getString("staff_Address");
				String email = rs.getString("staff_Email");
				double salary = rs.getFloat("staff_Salary");
				String phone = rs.getString("staff_Phone");
				String position = rs.getString("staff_Position");
				String note = rs.getString("staff_Note");
				
				Staff staff = new Staff(staffID, staffName, gender, dateOfBirth, address, email, salary, phone, position, note);
				list.add(staff);
			}
			
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Staff selectByID(Staff t) {
		Staff staff = null;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM Staff WHERE staff_ID = ?";

			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, t.getStaffID());
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				String staffID = rs.getString("staff_ID");
				String staffName = rs.getString("staff_Name");
				boolean gender = (rs.getString("staff_Gender").equals("Nam")); // True là nam, flase là nữ
				Date dateOfBirth = rs.getDate("staff_DateOfBirth");
				String address = rs.getString("staff_Adsress");
				String email = rs.getString("staff_Email");
				double salary = rs.getFloat("staff_Salary");
				String phone = rs.getString("staffPhone");
				String position = rs.getString("staffPosition");
				String note = rs.getString("staff_Note");
				
				staff = new Staff(staffID, staffName, gender, dateOfBirth, address, email, salary, phone, position, note);
			}
			
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staff;
	}

	public Staff selectByID(String staffId) {
		Staff staff = null;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM Staff WHERE staff_ID = ?";

			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, staffId);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				String staffID = rs.getString("staff_ID");
				String staffName = rs.getString("staff_Name");
				boolean gender = (rs.getString("staff_Gender").equals("Nam")); // True là nam, flase là nữ
				Date dateOfBirth = rs.getDate("staff_DateOfBirth");
				String address = rs.getString("staff_Address");
				String email = rs.getString("staff_Email");
				double salary = rs.getFloat("staff_Salary");
				String phone = rs.getString("staff_Phone");
				String position = rs.getString("staff_Position");
				String note = rs.getString("staff_Note");
				
				staff = new Staff(staffID, staffName, gender, dateOfBirth, address, email, salary, phone, position, note);
			}
			
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return staff;
	}

}

