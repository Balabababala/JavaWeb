package service;

import java.util.*;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import model.dto.TodoDTO;
import model.entity.*;

public class TodoListServiceImpl implements TodoListService{
	private TodoListDao dao=new TodoListDaoImpl();

	@Override
	public List<TodoDTO> findAllTodo() {		
		return dao.findAllTodos()
				  .stream()
				  .map(this::transferToDTO)
				  .toList();
	}

	@Override
	public TodoDTO getTodo(Integer id) {
		return transferToDTO(dao.getTodo(id));
	}

	@Override
	public void addTodo(String text, Boolean completed) {
		dao.addTodo(new Todo(0,text,completed));
	}

	@Override
	public void updateToComplete(Integer id, Boolean completed) {
		dao.updateTodoComplete(id, completed);
	}

	@Override
	public void updateToText(Integer id, String text) {
		dao.updateTodoText(id, text);
	}

	@Override
	public void deleteTodo(Integer id) {
		dao.deleteTodo(id);
	}
	
	//轉DTO
	private TodoDTO transferToDTO(Todo todo) {
		return new TodoDTO(todo.getId(),todo.getText(),todo.getCompleted());
	}
	private Todo transferToEntity(TodoDTO todoDTO) {
		return new Todo(todoDTO.getNo(),todoDTO.getContent(),todoDTO.getIsFinished());
	}
}
