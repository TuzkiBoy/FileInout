package com.haier.data;

/**
 * JAVA连接数据库类
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BeyondbConnection {
	public static Connection getConnection() {


		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/data?characterEncoding=utf8";
		String user = "root";
		String password = "123456";


		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			Logger.getLogger(BeyondbConnection.class.getName()).log(Level.SEVERE, null, ex);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}

