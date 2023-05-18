package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	public static Connection getConnection() {
		Connection c = null;

		String sql = "jdbc:sqlserver://localhost:1433;databaseName=MotobikesManagement;trutsertificate=true";
		String user = "sa";
		String password = "123456789";

		try {
			c = DriverManager.getConnection(sql, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
