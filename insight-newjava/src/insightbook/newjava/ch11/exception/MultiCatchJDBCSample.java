package insightbook.newjava.ch11.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC를 처음 배울때 사용하는 대표적인 예제 파일. JDK 7 이상에서 컴파일
 *
 */
public class MultiCatchJDBCSample {
	public static void main(String[] args) {
		String sql = "\"SELECT EMP_NO, EMP_NAME FROM EMP\"";
		
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();) {
	
			while(result.next()) {
				System.out.printf("EMP NO : %s", result.getString("EMP_NO"));
				System.out.printf("EMP NAME : %s", result.getString("EMP_NAME"));
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("", "", "");
		return con;
	}
}