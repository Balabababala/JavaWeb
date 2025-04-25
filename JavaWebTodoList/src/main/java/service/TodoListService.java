package service;

import java.util.List;

import model.dto.TodoDTO;

public interface TodoListService {
		//1.查尋所有 Todo
		List<TodoDTO> findAllTodo();
		
		//2.查尋單筆 Todo
		TodoDTO getTodo(Integer id);
		
		//3.加     Todo
		void addTodo(String text,Boolean completed);
		
		//4.修     Todo的complete
		void updateToComplete(Integer id,Boolean completed);
		
		//5.修     Todo的Text
		void updateToText(Integer id,String text);
		
		//6.刪     Todo
		void deleteTodo(Integer id);
	
	
}
