package com.woniu.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/user?characterEncoding=utf8";
	private static String user="root";
	private static String password="";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConn(ResultSet rs,Statement stat,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(stat!=null) {
					stat.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
