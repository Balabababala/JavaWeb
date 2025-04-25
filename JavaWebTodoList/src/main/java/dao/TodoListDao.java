package dao;

import java.util.List;
import model.entity.*;

public interface TodoListDao {
	
	//1.查尋所有 Todo
	List<Todo> findAllTodo();
	
	//2.查尋單筆 Todo
	List<Todo> getTodo(Integer id);
	
	//3.加     Todo
	List<Todo> addTodo(Todo todo);
	
	//4.修     Todo的complete
	List<Todo> updataToComplete(Integer id,Boolean completed);
	
	//5.修     Todo的Text
	List<Todo> updataToComplete(Integer id,String text);
	
	//6.刪     Todo
	List<Todo> deleteTodo(Integer id);
}
