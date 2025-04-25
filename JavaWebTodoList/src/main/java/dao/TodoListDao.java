package dao;

import java.io.Closeable;
import java.util.List;
import model.entity.*;

public interface TodoListDao {
	
	//1.查尋所有 Todo
	List<Todo> findAllTodos();
	
	//2.查尋單筆 Todo
	Todo getTodo(Integer id);
	
	//3.加     Todo
	void addTodo(Todo todo);
	
	//4.修     Todo的complete
	void updateTodoComplete(Integer id,Boolean completed);
	
	//5.修     Todo的Text
	void updateTodoText(Integer id,String text);
	
	//6.刪     Todo
	void deleteTodo(Integer id);
	

}
