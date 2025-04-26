package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Order;

public class BaseDAO {
	
	protected Connection conn ;
	
	BaseDAO() throws Exception{
		String url="jdbc:mysql://localhost:3306/javaweborderdb";
		String user="root";
		String password="abc123";
		try {
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
