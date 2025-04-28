package cart.service;

public interface UserRegisterService {
	//新增user
	void addUser(String username, String password,String emali);
	//email 驗證成功
	void emailConfirmOK(String username);
}
