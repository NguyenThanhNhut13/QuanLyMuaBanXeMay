package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.ConnectDatabase;
import entity.Customer;
import entity.Staff;

public class CustomersDAO implements InterfaceDAO<Customer> {

	public static CustomersDAO getInstance() {
		return new CustomersDAO();
	}

	@Override
	public int insert(Customer t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "INSERT INTO Customers VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getCustomer_ID());
			pst.setString(2, t.getCustomer_Name());
			pst.setString(3, (t.isCustomer_Gender()) ? "Nam" : "Nữ");
			pst.setString(4, t.getCustomer_DateOfBirth() + "");
			pst.setString(5, t.getCustomer_Phone());
			pst.setString(6, t.getCustomer_Address());

			ketQua = pst.executeUpdate();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Customer t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "UPDATE Customers SET  customer_Name=?, customer_Gender=?, customer_DateOfBirth=?, customer_Phone=?, customer_Address=? WHERE customer_ID=?";

			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getCustomer_Name());
			pst.setString(2, (t.isCustomer_Gender()) ? "Nam" : "Nữ");
			pst.setString(3, t.getCustomer_DateOfBirth() + "");
			pst.setString(4, t.getCustomer_Phone());
			pst.setString(5, t.getCustomer_Address());
			pst.setString(6, t.getCustomer_ID());

			ketQua = pst.executeUpdate();

			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(Customer t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "DELETE Customers WHERE customer_ID =?";

			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getCustomer_ID());

			ketQua = pst.executeUpdate();

			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM Customers";

			PreparedStatement pst = c.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String customerID = rs.getString("customer_ID");
				String customerName = rs.getString("customer_Name");
				boolean gender = (rs.getString("customer_Gender").equals("Nam")); // True là nam, flase là nữ
				Date dateOfBirth = rs.getDate("customer_DateOfBirth");
				String phone = rs.getString("customer_Phone");
				String address = rs.getString("customer_Address");

				Customer customer = new Customer(customerID, customerName, gender, dateOfBirth, phone, address);
				list.add(customer);
			}

			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer selectByID(Customer t) {
		Customer customer = null;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM Customers WHERE customer_ID = ?";

			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, t.getCustomer_ID());
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				String customerID = rs.getString("customer_ID");
				String customerName = rs.getString("customer_Name");
				boolean gender = (rs.getString("customer_Gender").equals("Nam")); // True là nam, flase là nữ
				Date dateOfBirth = rs.getDate("customer_DateOfBirth");
				String phone = rs.getString("customer_Phone");
				String address = rs.getString("customer_Address");

				customer = new Customer(customerID, customerName, gender, dateOfBirth, phone, address);
			}
			
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public Customer selectByID(String custommerId) {
		Customer customer = null;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM Customers WHERE customer_ID = ?";

			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, custommerId);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				String customerID = rs.getString("customer_ID");
				String customerName = rs.getString("customer_Name");
				boolean gender = (rs.getString("customer_Gender").equals("Nam")); // True là nam, flase là nữ
				Date dateOfBirth = rs.getDate("customer_DateOfBirth");
				String phone = rs.getString("customer_Phone");
				String address = rs.getString("customer_Address");

				customer = new Customer(customerID, customerName, gender, dateOfBirth, phone, address);
			}
			
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}

