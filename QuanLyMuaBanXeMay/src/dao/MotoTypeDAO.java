package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectDB;
import entity.MotoType;

public class MotoTypeDAO {
	Connection con;

	public MotoTypeDAO() {
		
	}

	public MotoType getLoaiXeTheoMa(String typeId) {
		MotoType loaiXe = new MotoType();
		ConnectDB.getInstances().Connect();
		con = ConnectDB.getConnection();
		String sql = "select * from MotobikeType where mType_ID = N'" + typeId + "'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				loaiXe.setTypeId(rs.getNString(1));
				loaiXe.setTypeName(rs.getNString(2));

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loaiXe;
	}

	/**
	 * 
	 * @param tên loại xe
	 * @return mã loại xe
	 * @throws Exception
	 */
	public String getMaLoaiXeTheoTen(String ten) throws Exception {
		String maLoai = "";
		ConnectDB.getInstances().Connect();
		con = ConnectDB.getConnection();
		String sql = "select mType_ID from MotobikeType where mType_Name = N'" + ten + "'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				maLoai = rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
		return maLoai;

	}
}

