package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Order;

public class OrderDAOJdbcImpl extends BaseDAO implements OrderDAO{

	public List<Order> orders = new CopyOnWriteArrayList<>();
	

	@Override
	public void save(Order order) {
		try {
            // 找目前最大的 list_index
            String getMaxIndexSql = "SELECT COALESCE(MAX(list_index), -1) + 1 FROM orders";
            PreparedStatement ps1 = conn.prepareStatement(getMaxIndexSql);
            ResultSet rs = ps1.executeQuery();
            int nextIndex = 0;
            if (rs.next()) {
                nextIndex = rs.getInt(1);
            }
            rs.close();
            ps1.close();

            // 插入新資料
            String sql = "INSERT INTO orders (list_index, item, price) VALUES (?, ?, ?)";
            PreparedStatement ps2 = conn.prepareStatement(sql);
            ps2.setInt(1, nextIndex);
            ps2.setString(2, order.getItem());
            ps2.setInt(3, order.getPrice());
            ps2.executeUpdate();
            ps2.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void update(int list_index, Order newOrder) {
		 try {
	            // 更新資料
	            String sql = "UPDATE orders SET item = ?, price = ? WHERE list_index = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, newOrder.getItem());
	            ps.setInt(2, newOrder.getPrice());
	            ps.setInt(3, list_index);
	            ps.executeUpdate();
	            ps.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	@Override
	public void remove(int list_index) {
		 try {
	            // 先刪除
	            String deleteSql = "DELETE FROM orders WHERE list_index = ?";
	            PreparedStatement ps1 = conn.prepareStatement(deleteSql);
	            ps1.setInt(1, list_index);
	            ps1.executeUpdate();
	            ps1.close();

	            // 再重新排 list_index
	            String selectSql = "SELECT id FROM orders ORDER BY list_index ASC";
	            PreparedStatement ps2 = conn.prepareStatement(selectSql);
	            ResultSet rs = ps2.executeQuery();

	            int index = 0;
	            while (rs.next()) {
	                int currentId = rs.getInt("id");
	                String updateSql = "UPDATE orders SET list_index = ? WHERE id = ?";
	                PreparedStatement ps3 = conn.prepareStatement(updateSql);
	                ps3.setInt(1, index++);
	                ps3.setInt(2, currentId);
	                ps3.executeUpdate();
	                ps3.close();
	            }

	            rs.close();
	            ps2.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Order> findAll() {
		 List<Order> list = new ArrayList<>();
	        try {
	            String sql = "SELECT * FROM orders ORDER BY list_index ASC";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Order order = new Order(
	                    rs.getInt("id"),
	                    rs.getInt("list_index"),
	                    rs.getString("item"),
	                    rs.getInt("price")
	                );
	                list.add(order);
	            }
	            rs.close();
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	}
	
	@Override
	public Order getOrder(int list_index) {
		 Order order = null;
		 try {
		        // 查詢資料
		        String sql = "SELECT * FROM orders WHERE list_index = ?";
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setInt(1, list_index);
		        ResultSet rs = ps.executeQuery();

		        // 檢查是否有結果
		        if (rs.next()) {
		            order = new Order(
		                rs.getInt("id"),
		                rs.getInt("list_index"),
		                rs.getString("item"),
		                rs.getInt("price")
		            );
		        }

		        rs.close();
		        ps.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return null;
	}

	
}
	
