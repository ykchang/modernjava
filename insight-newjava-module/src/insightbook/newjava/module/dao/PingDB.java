package insightbook.newjava.module.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class PingDB {
	private String driverName = "org.mariadb.jdbc.Driver";
	private String jdbcUrl = "jdbc:mariadb://127.0.0.1/db";
	private String jdbcUser = "user";
	private String jdbcPassword  = "password";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        return con;
	}
	
	public void ping(int maxNumber) throws Exception {
		for(int i = 0 ; i < maxNumber ; i++) {
			TimeUnit.SECONDS.sleep(1);
			
			try (Connection con = this.getConnection()) {
				PreparedStatement stmt = con.prepareStatement("SELECT 1");
				ResultSet result = stmt.executeQuery();
				if(result.next()) {
					System.out.println("DB 연결에 성공하였습니다.");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
        
	public static void main(String[] args) throws Exception {
		PingDB pingDB = new PingDB();
		pingDB.ping(1000);
	}
}