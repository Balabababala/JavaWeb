package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Order;

public class OrderDAOJDBCImpl implements OrderDAO{
	
	private Connection con ;
	
	OrderDAOJDBCImpl() throws Exception{
		String url="jdbc:mysql://localhost:3306/javaweborderdb";
		String user="root";
		String password="abc123";
		try {
			con=DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new Exception("資料庫連線失敗"+e);
		}
}


	
	// 取得所有歷史資料
	public List<Order> findAll() throws DAOException{
		String query="SELECT * FROM order";
		List<Order> output=new CopyOnWriteArrayList<>();
		Order order=null;
		try (PreparedStatement pstmt = con.prepareStatement(query)){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				order= new Order((rs.getString("item")),
								  rs.getInt("price")
						);
				output.add(order);
			}
			return output;
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DAOException("查詢資料發生錯誤:"+e) ;
		}
		
	} ;
	
	public void save(Order order) throws DAOException{
		String sql ="INSERT INTO EMPLOYEE VALUES (? ,?, ?)";
		try (PreparedStatement pstmt=con.prepareStatement(sql)){
			
			pstmt.setString(2,order.getItem());
			pstmt.setInt(3,order.getPrice());
			if(pstmt.executeUpdate()!=1) {
				throw new DAOException("訂單新增失敗");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DAOException("訂單發生錯誤:"+e);
		}
	} ;
	
	// 刪除一筆資訊
	public void remove(int index) throws DAOException{
		String sql ="DELETE FROM EMPLOYEE WHERE item=?";
		try (PreparedStatement pstmt=con.prepareStatement(sql)){
			pstmt.setInt(1,item);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DAOException("新增資料發生錯誤:"+e);
		}
	}
		
		

	// 修改一筆資訊
	public void update(int index, Order newOrder) {
		
	} ;

	// 取得單筆資料
	public Order getOrder(int index) {
		
	};
}
