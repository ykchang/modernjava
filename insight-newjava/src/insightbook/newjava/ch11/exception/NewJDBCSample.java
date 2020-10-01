package insightbook.newjava.ch11.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC를 처음 배울때 사용하는 대표적인 예제 파일. JDK 7 이상에서 컴파일
 * 
 * @author Yoonki Chang
 *
 */
public class NewJDBCSample {
	public static void main(String[] args) {
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT EMP_NO, EMP_NAME FROM EMP");
			ResultSet result = pstmt.executeQuery();) {
	
			while(result.next()) {
				System.out.println("EMP NO : " + result.getString("EMP_NO"));
				System.out.println("EMP NAME : " + result.getString("EMP_NAME"));
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("", "", "");
		return con;
	}
}