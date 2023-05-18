package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import connection.ConnectDB;
import connection.ConnectDatabase;
import entity.ChiTietHoaDon;
import entity.DonHang;
import entity.MotoType;
import entity.Motobike;

public class DonHangDAO implements InterfaceDAO<DonHang> {

	public static DonHangDAO getInstance() {
		return new DonHangDAO();
	}

	@Override
	public int insert(DonHang t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "INSERT INTO Orders VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getOrder_id());
			pst.setString(2, t.getOrder_Date() + "");
			pst.setString(3, t.getStaff_id());
			pst.setString(4, t.getCustomer_id());
			pst.setDouble(5, t.getOrderAmount());
			pst.setString(6, t.getStatus());
			pst.setString(7, t.getNote());
			ketQua = pst.executeUpdate();
			c.close();
			for (Motobike motobike : t.getListSanPham()) {
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(t.getOrder_id(), motobike.getId(),
						motobike.getQuantity(), motobike.getPrice());
				ChiTietHDDAO.getInstance().insert(chiTietHoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(DonHang t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "UPDATE Orders SET order_Date = ?, staff_ID=?, customer_ID=?, order_Amount=?, order_Status=?, order_Note=? WHERE order_ID = ?";

			PreparedStatement pst = c.prepareStatement(sql);

			pst.setDate(1, t.getOrder_Date());
			pst.setString(2, t.getStaff_id());
			pst.setString(3, t.getCustomer_id());
			pst.setDouble(4, t.getOrderAmount());
			pst.setString(5, t.getStatus());
			pst.setString(6, t.getNote());
			pst.setString(7, t.getOrder_id());

			ketQua = pst.executeUpdate();
			c.close();
			for (Motobike motobike : t.getListSanPham()) {
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(t.getOrder_id(), motobike.getId(),
						motobike.getQuantity(), motobike.getPrice());
				ChiTietHDDAO.getInstance().update(chiTietHoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(DonHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> list = new ArrayList<DonHang>();
		MotobikeDAO daoMotobike = new MotobikeDAO();
		try {
			Connection c = ConnectDatabase.getConnection();
			String sql = "SELECT * FROM Orders";
			PreparedStatement pst = c.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String orderID = rs.getString("order_ID");
				java.sql.Date order_Date = rs.getDate("order_Date");
				String customer_id = rs.getString("customer_ID");
				String staff_id = rs.getString("staff_ID");
				ArrayList<Motobike> listSanPham = new ArrayList<Motobike>();
				for (ChiTietHoaDon cthd : ChiTietHDDAO.getInstance().selectByID(orderID)) {
					String motobike_id = cthd.getMotobike_ID();
					int quantity = cthd.getQuantity();
					Motobike motobike = daoMotobike.get1XeTheoMa(motobike_id);
					motobike.setQuantity(quantity);
					listSanPham.add(motobike);
				}
				double orderAmount = rs.getDouble("order_Amount");
				String status = rs.getString("order_Status");
				String note = rs.getString("order_Note");

				DonHang donHang = new DonHang(orderID, order_Date, customer_id, staff_id, listSanPham, orderAmount,
						status, note);
				list.add(donHang);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DonHang selectByID(DonHang t) {
		MotobikeDAO daoMotobike = new MotobikeDAO();
		DonHang donHang = null;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM Orders WHERE order_ID = ?";
			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getOrder_id());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String orderID = rs.getString("order_ID");
				java.sql.Date order_Date = rs.getDate("order_Date");
				String customer_id = rs.getString("customer_ID");
				String staff_id = rs.getString("staff_ID");
				ArrayList<Motobike> listSanPham = new ArrayList<Motobike>();
				for (ChiTietHoaDon cthd : ChiTietHDDAO.getInstance().selectByID(orderID)) {
					String motobike_id = cthd.getMotobike_ID();
					int quantity = cthd.getQuantity();
					Motobike motobike = daoMotobike.get1XeTheoMa(motobike_id);
					motobike.setQuantity(quantity);
					listSanPham.add(motobike);
				}
				double orderAmount = rs.getDouble("order_Amount");
				String status = rs.getString("order_Status");
				String note = rs.getString("order_Note");

				donHang = new DonHang(orderID, order_Date, customer_id, staff_id, listSanPham, orderAmount, status,
						note);
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return donHang;
	}

	public ArrayList<String> getTenKHList() {
		Connection con = ConnectDatabase.getConnection();
		ArrayList<String> tenKHList = new ArrayList<>();
		try {
			String sql = "SELECT customer_Name FROM Customers";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				tenKHList.add(resultSet.getString("customer_Name"));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenKHList;
	}
//	public ArrayList<String> getTrangThaiList() {
//		Connection con = ConnectDatabase.getConnection();
//		ArrayList<String> trangthaiList = new ArrayList<>();
//	    try {
//	        String sql = "SELECT order_Status FROM OrderDetail";
//	        Statement statement = con.createStatement();
//	        ResultSet resultSet = statement.executeQuery(sql);
//	        while (resultSet.next()) {
//	            trangthaiList.add(resultSet.getString("order_Status"));
//	        }
//	        statement.close();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return trangthaiList;
//	}

}
