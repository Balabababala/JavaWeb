package dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import model.dto.TodoDTO;
import model.entity.Todo;

public class TodoListDaoImpl extends BaseDao implements TodoListDao{

	
	@Override
	public List<Todo> findAllTodo() {
		List<Todo> todos =new ArrayList<>();
		String sql="select id,text,completed from todo order by id";
		try (Statement stmt= conn.createStatement()){
			try(ResultSet rs=stmt.executeQuery(sql);) {
				//逐一尋訪rs
				//轉Todo
				//丟到todos
				while(rs.next()) {
					
					Todo todo=new Todo();
					todo.setId(rs.getInt("id"));
					todo.setText(rs.getString("text"));
					todo.setCompleted(rs.getBoolean("completed"));
					
					todos.add(todo);
				}
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todos;
	}

	@Override
	public Todo getTodo(Integer id) {
		String sql="select id,text,completed from todo where id=?";
		
		try (PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setInt(1, id);			
			try (ResultSet rs= pstmt.executeQuery()){
				//找0或1筆
				//轉Todo
				//return
				if(rs.next()) {	
									
					Todo todo=new Todo();
					todo.setId(rs.getInt("id"));
					todo.setText(rs.getString("text"));
					todo.setCompleted(rs.getBoolean("completed"));
					
					return todo;
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addTodo(Todo todo) {
		String sql="Insert into todo(text,completed) value(?,?)";
		try (PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setString(1, todo.getText());
			pstmt.setBoolean(2, todo.getCompleted());
			
			int rowcount=pstmt.executeUpdate();
			System.out.printf("新增%s筆成功",rowcount);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateToComplete(Integer id, Boolean completed) {
		String sql="Update todo set completed=? where id=?";
		try (PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setBoolean(1, completed);
			pstmt.setInt(2, id);
			
			int rowcount=pstmt.executeUpdate();
			
			System.out.printf("更新%s筆成功",rowcount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateToText(Integer id, String text) {
		String sql="Update todo set text=? where id=?";
		try (PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setString(1, text);
			pstmt.setInt(2, id);
			
			int rowcount=pstmt.executeUpdate();
			
			System.out.printf("更新%s筆成功",rowcount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTodo(Integer id) {
		String sql="delete from todo where id=?";
		try (PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setInt(1, id);
			
			int rowcount=pstmt.executeUpdate();
			
			System.out.printf("刪除%s筆成功",rowcount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
