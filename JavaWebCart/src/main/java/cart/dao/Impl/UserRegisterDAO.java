package cart.dao.Impl;

import cart.model.entity.User;

public interface UserRegisterDAO {
	//新增 
	int addUser(User user);
	
	//email 驗證 驗成功改 completed=true
	int emailConfirmOK(String username);
	
	
}
