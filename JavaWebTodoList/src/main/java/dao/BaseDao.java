package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	protected static Connection conn;
	
	static {
		String username="root";
		String password="abc123";
		String dbUrl="jdbc:mysql://localhost:3306/todolist?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true&useSSL=false";
		 
			try {
		      Class.forName("com.mysql.cj.jdbc.Driver"); // 註冊 MySQL Driver  
		      conn = DriverManager.getConnection(dbUrl, username, password); // 連線建立
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	
	
	
}

		
	

