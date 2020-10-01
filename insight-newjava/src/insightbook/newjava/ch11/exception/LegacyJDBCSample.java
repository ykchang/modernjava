package insightbook.newjava.ch11.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LegacyJDBCSample {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("SELECT EMP_NO, EMP_NAME FROM EMP");
			result = pstmt.executeQuery();
	
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
		finally {
			if(result != null) {
				try { result.close(); } catch(Exception e) {}
			}
	
			if(pstmt != null) {
				try { pstmt.close(); } catch(Exception e) {}
			}
		
			if(con != null) {
				try { pstmt.close(); } catch(Exception e) {}
			}
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("", "", "");
		return con;
	}
}