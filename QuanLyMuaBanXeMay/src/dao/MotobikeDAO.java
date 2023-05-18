package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;
import entity.MotoType;
import entity.Motobike;

public class MotobikeDAO {
	Connection con;

	public MotobikeDAO() {
	}

	public boolean checkMaXe(String maXe) throws SQLException {
		ConnectDB.getInstances().Connect();
		con = ConnectDB.getConnection();
		String sql = "SELECT * FROM Motobike WHERE motobike_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, maXe);
		ResultSet rs = ps.executeQuery();
		con.close();
		return rs.next();
	}

	public boolean themXe(Motobike xe) {
		ConnectDB.getInstances().Connect();
		con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Motobike values (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, xe.getId());
			stmt.setString(2, xe.getName());
			stmt.setString(3, xe.getManufacturer());
			stmt.setFloat(4, xe.getCapacity());
			stmt.setString(5, xe.getColor());
			stmt.setString(6, xe.getType().getTypeId());
			stmt.setDouble(7, xe.getPrice());
			stmt.setInt(8, xe.getQuantity());
			stmt.setInt(9, xe.getYear());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n > 0;

	}

	public ArrayList<Motobike> getDSXe() {
		ConnectDB.getInstances().Connect();
		con = ConnectDB.getConnection();
		ArrayList<Motobike> lsXe = new ArrayList<Motobike>();
		String sql = "Select * from Motobike";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Motobike xe = new Motobike();
				xe.setId(rs.getNString(1));
				xe.setName(rs.getNString(2));
				xe.setManufacturer(rs.getNString(3));
				xe.setCapacity(rs.getFloat(4));
				xe.setColor(rs.getNString(5));
				xe.setType(new MotoType(rs.getNString(6)));
				xe.setPrice(rs.getDouble(7));
				xe.setQuantity(rs.getInt(8));
				xe.setYear(rs.getInt(9));

				lsXe.add(xe);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lsXe;
	}

	// capnhat-sua
	public boolean capNhatXe(Motobike xe) {
		ConnectDB.getInstances().Connect();
		con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Motobike set motobike_Name = ?, motobike_Manufacturer= ?, motobike_Capacity = ?, motobike_Color = ?, mType_ID = ?, motobike_Price = ?, motobike_Quantity = ?, motobike_ManufacturingYear = ? where motobike_ID = ?");
			stmt.setString(1, xe.getName());
			stmt.setString(2, xe.getManufacturer());
			stmt.setFloat(3, xe.getCapacity());
			stmt.setString(4, xe.getColor());
			stmt.setString(5, xe.getType().getTypeId());
			stmt.setDouble(6, xe.getPrice());
			stmt.setInt(7, xe.getQuantity());
			stmt.setInt(8, xe.getYear());
			stmt.setString(9, xe.getId());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public Motobike get1XeTheoMa(String ma) {
		ConnectDB.getInstances().Connect();
		Connection con = ConnectDB.getConnection();
		Motobike xe = new Motobike();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Motobike where motobike_ID = ? ");
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				xe.setId(rs.getString("motobike_ID"));
				xe.setName(rs.getString("motobike_Name"));
				xe.setManufacturer(rs.getString("motobike_Manufacturer"));
				xe.setCapacity(rs.getFloat("motobike_Capacity"));
				xe.setColor(rs.getString("motobike_Color"));
				xe.setType(new MotoType(rs.getString("mType_ID")));
				xe.setPrice(rs.getDouble("motobike_Price"));
				xe.setQuantity(rs.getInt("motobike_Quantity"));
				xe.setYear(rs.getInt("motobike_ManufacturingYear"));
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return xe;
	}

	/**
	 * 
	 * @param ma xe
	 * @return danh sach xe theo ma
	 * @throws Exception
	 */
	public ArrayList<Motobike> getXeTheoMa(String ma) throws Exception {
		ArrayList<Motobike> lsXe = new ArrayList<Motobike>();
		ConnectDB.getInstances().Connect();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Motobike where motobike_ID = N'" + ma + "' ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Motobike xe = new Motobike();

				xe.setId(rs.getNString(1));
				xe.setName(rs.getNString(2));
				xe.setManufacturer(rs.getNString(3));
				xe.setCapacity(rs.getFloat(4));
				xe.setColor(rs.getNString(5));
				xe.setType(new MotoType(rs.getNString(6)));
				xe.setPrice(rs.getDouble(7));
				xe.setQuantity(rs.getInt(8));
				xe.setYear(rs.getInt(9));

				lsXe.add(xe);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsXe;
	}

	public ArrayList<Motobike> getXeTheoTen(String ten) throws Exception {
		ArrayList<Motobike> lsXe = new ArrayList<Motobike>();
		ConnectDB.getInstances().Connect();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Motobike where motobike_Name = ? ");
			ps.setString(1, ten);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Motobike xe = new Motobike();

				xe.setId(rs.getNString(1));
				xe.setName(rs.getNString(2));
				xe.setManufacturer(rs.getNString(3));
				xe.setCapacity(rs.getFloat(4));
				xe.setColor(rs.getNString(5));
				xe.setType(new MotoType(rs.getNString(6)));
				xe.setPrice(rs.getDouble(7));
				xe.setQuantity(rs.getInt(8));
				xe.setYear(rs.getInt(9));
				lsXe.add(xe);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsXe;
	}

	public boolean xoaXe(String maXe) throws SQLException {
		ConnectDB.getInstances().Connect();
		con = ConnectDB.getConnection();
		String sql = "DELETE FROM Motobike WHERE motobike_ID = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maXe);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return false;
	}

}

