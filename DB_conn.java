import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_conn {
	
	public  Connection getConnection() throws ClassNotFoundException,SQLException {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");//loads jdbc driver
		String url=("jdbc:mysql://localhost:3306/rms?useSSL=false");//this is the thing when we put password to open the database
		con=DriverManager.getConnection(url,"root","root");//performs connectivity
		
	
	
		
		con.prepareStatement("CREATE DATABASE IF NOT EXISTS `pharma`").execute();
		con.prepareStatement("USE `pharma`").execute();
	}catch(Exception e) {
		System.out.println(e);
	}
		return con;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
