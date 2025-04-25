package dao;

import java.io.Closeable;
import java.util.List;
import model.entity.*;

public interface TodoListDao {
	
	//1.查尋所有 Todo
	List<Todo> findAllTodo();
	
	//2.查尋單筆 Todo
	Todo getTodo(Integer id);
	
	//3.加     Todo
	void addTodo(Todo todo);
	
	//4.修     Todo的complete
	void updateToComplete(Integer id,Boolean completed);
	
	//5.修     Todo的Text
	void updateToText(Integer id,String text);
	
	//6.刪     Todo
	void deleteTodo(Integer id);
	

}
