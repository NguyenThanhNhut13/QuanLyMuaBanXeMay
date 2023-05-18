package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;
import entity.ChiTietHoaDon;
import entity.DonHang;

public class BanHangDAO {
	BanHangDAO dao;
	Connection con;
	
	public BanHangDAO() {
		try {
			ConnectDB.getInstances().Connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getMaHD() throws Exception {
		String maHD="";
		try {
			ConnectDB.getInstances().Connect();;
			Connection con = ConnectDB.getConnection();
			String sql = "select CONCAT('HD', RIGHT(CONCAT('000',ISNULL(right(max(order_ID),3),0) + 1),3)) from [dbo].[Orders] where order_ID like 'HD%'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				maHD = rs.getString(1);
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
		return maHD;
	}
	
	public ArrayList<String> getMaKhachHangList() {
	    ArrayList<String> maKhachHangList = new ArrayList<>();
	    try {
	        String sql = "SELECT customer_ID FROM Customers";
	        Statement statement = con.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	            maKhachHangList.add(resultSet.getString("customer_ID"));
	        }
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return maKhachHangList;
	}
	
	public ArrayList<String> getMaNhanVienList() {
	    ArrayList<String> maNVList = new ArrayList<>();
	    try {
	        String sql = "SELECT staff_ID FROM Staff";
	        Statement statement = con.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()) {
	            maNVList.add(resultSet.getString("staff_ID"));
	        }
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return maNVList;
	}

//	@SuppressWarnings("resource")
//	public boolean addOrder(DonHang order, ChiTietHoaDon orderDetails) throws Exception {
//	    PreparedStatement stmt = null;
//	    boolean success = false;
//	    ConnectDB.getInstances();
//		Connection con = ConnectDB.getConnection();
//	    try {
//	    	
//	        // Insert order record
//	        String insertOrderSQL = "INSERT INTO Orders "
//	                             + "VALUES (?, ?, ?, ?, ?)";
//	        stmt = con.prepareStatement(insertOrderSQL);
//	        stmt.setString(1, order.getOrder_id());
//	        stmt.setDate(2, order.getOrder_Date());
//	        stmt.setString(3, order.getMotobikeID());
//	        stmt.setInt(4, order.getQuantity());
//	        stmt.setDouble(5, order.getOrderAmount());
//	        int rowsInserted = stmt.executeUpdate();
//	        
//	        if (rowsInserted == 1) {
//	            // Insert order details record
//	            String insertOrderDetailsSQL = "INSERT INTO OrderDetail "
//	                                         + "VALUES (?, ?, ?, ?, ?)";
//	            stmt = con.prepareStatement(insertOrderDetailsSQL);
//	            stmt.setString(1, orderDetails.getOrderId());
//	            stmt.setString(2, orderDetails.getSaffId());
//	            stmt.setString(3, orderDetails.getCustommerId());
//	            stmt.setString(4, orderDetails.getOrderNote());
//	            stmt.setString(5, orderDetails.getOrderStatus());
//	            rowsInserted = stmt.executeUpdate();
//	            
//	            if (rowsInserted == 1) {
//	                success = true;
//	            }
//	        }
//	    } catch (SQLException ex) {
//	        ex.printStackTrace();
//	    } finally {
//	       try {
//			stmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    }
//	    
//	    return success;
//	}

	

}
