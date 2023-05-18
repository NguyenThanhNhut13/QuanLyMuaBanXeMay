package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static ConnectDB instances;
	private static Connection connection;

	public void Connect() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=MotobikesManagement;trustServerCertificate=true";
		try {
			connection = DriverManager.getConnection(url, "sa", "123456789");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static ConnectDB getInstances(){
		if (instances == null)
			instances = new ConnectDB();
		return instances;
	}

	public void close() {
		try {
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//    public static void main(String[] args) throws Exception {
//		ConnectDB.getInstances().getConnection();
//	}
}

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConnectDB {
//	public static Connection con = null;
//	private static ConnectDB instance;
//	
//	public static ConnectDB getinstance() {
//		if (instance == null) {
//			instance = new ConnectDB();
//		}
//		return instance;
//	}
//	
//	public void connect() throws SQLException {
//		String url = "jdbc:sqlserver://localhost:1433;databaseName=MotobikesManagement";
//		String user = "sa";
//		String password = "sapassword";
//		con = DriverManager.getConnection(url, user, password);
//	}
//	
//	public void disconnect() {
//		if(con != null) {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//
//	public static Connection getConnection() {
//		return con;
//	}
//	
//	public static void main(String[] args) throws SQLException {
//		ConnectDB.getinstance().connect();
//	}
//}
