package connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionUtils {
	
	private static final String DB_NAME = "sms";
	private static final String PASSWORD = "";
	private static final String USER = "root";
	
	private static Connection connection = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, USER, PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static Connection getConnection() {
		return connection;
	}
}


