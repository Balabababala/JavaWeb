package cart.service.Impl;

import java.util.ArrayList;
import java.util.List;

import cart.dao.UserListDAO;
import cart.dao.Impl.UserListDAOImpl;

import cart.model.dto.*;
import cart.model.entity.*;
import cart.service.UserListService;


public class UserListServiceImpl implements UserListService{
	private UserListDAO userListDAO=new UserListDAOImpl(); 
	
	
	@Override
	public List<UserDTO> findAllUsers() {
		List<User> users=userListDAO.findAllUser();
//		List<UserDTO> userDTOs=new ArrayList();
//		for(User user:users) {
//			UserDTO userTemp=new UserDTO();
//			userTemp.setId(user.getId());
//			userTemp.setUsername(user.getUsername());
//			userTemp.setEmail(user.getEmail());
//			userTemp.setCompleted(user.getCompleted());
//			userDAOs.add(userTemp);
//		}
		
		List<UserDTO> userDTOs = users.stream()
				.map(user->{
					UserDTO userDTO =new UserDTO();
					userDTO.setId(user.getId());
					userDTO.setUsername(user.getUsername());
					userDTO.setEmail(user.getEmail());
					userDTO.setCompleted(user.getCompleted());
					return userDTO;
				})
				.toList();
		return userDTOs;
	}

}
