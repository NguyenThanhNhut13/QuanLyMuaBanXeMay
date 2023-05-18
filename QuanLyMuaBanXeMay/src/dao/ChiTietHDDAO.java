package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import connection.ConnectDatabase;
import entity.ChiTietHoaDon;
import entity.Motobike;

public class ChiTietHDDAO implements InterfaceDAO<ChiTietHoaDon> {

	public static ChiTietHDDAO getInstance() {
		return new ChiTietHDDAO();
	}

	@Override
	public int insert(ChiTietHoaDon t) {
		int ketQua = 0;
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "INSERT INTO OrderDetail VALUES (?, ?, ?, ?)";
z
			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, t.getOrderID());
			pst.setString(2, t.getMotobike_ID());
			pst.setInt(3, t.getQuantity());
			pst.setDouble(4, t.getPrice());

			pst.executeUpdate();

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int update(ChiTietHoaDon t) {
		int ketQua = 0;

		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "UPDATE OrderDetail SET quantity=?, price=? WHERE order_ID=? AND motobike_ID =?";

			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, t.getQuantity());
			pst.setDouble(2, t.getPrice());
			pst.setString(3, t.getOrderID());
			pst.setString(4, t.getMotobike_ID());
			
			ketQua = pst.executeUpdate();

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(ChiTietHoaDon t) {
		int ketQua = 0;

		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "DELETE FROM OrderDetail WHERE order_ID=?, motobike_ID=?";

			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getOrderID());
			pst.setString(2, t.getMotobike_ID());

			ketQua = pst.executeUpdate();

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ChiTietHoaDon selectByID(ChiTietHoaDon t) {
		return null;
	}

	@Override
	public ArrayList<ChiTietHoaDon> selectAll() {
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();

		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM OrderDetail";

			PreparedStatement pst = c.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String order_ID = rs.getString("order_ID");
				String motobike_ID = rs.getString("motobike_ID");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");

				ChiTietHoaDon cthd = new ChiTietHoaDon(order_ID, motobike_ID, quantity, price);
				list.add(cthd);
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<ChiTietHoaDon> selectByID(String orderID) {
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			Connection c = ConnectDatabase.getConnection();

			String sql = "SELECT * FROM OrderDetail WHERE order_ID = ?";

			PreparedStatement pst = c.prepareStatement(sql);

			pst.setString(1, orderID);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String motobike_ID = rs.getString("motobike_ID");
				int quantity = rs.getInt("quantity");
				double gia = rs.getDouble("price");

				ChiTietHoaDon cthd = new ChiTietHoaDon(orderID, motobike_ID, quantity, gia);
				list.add(cthd);
			}

			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
