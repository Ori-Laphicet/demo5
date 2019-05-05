package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DButil {

	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	
	static {
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//连接数据库
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1?useUnicode=true&characterEncoding=utf-8", "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//3.发送SQL语句(不带参数)
	public static Statement getStatement() {
		Connection conn = getConnection();
		try {
			if(conn != null) {
				stmt = conn.createStatement();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	//4.发送SQL语句(带参数)
	public static PreparedStatement getPreparedStatement(String sql) {
		Connection conn = getConnection();
		try {
			if(conn != null) {
				pstmt = conn.prepareStatement(sql);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//5.关闭数据库
	public static void closeDBResources() {
		try {
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
