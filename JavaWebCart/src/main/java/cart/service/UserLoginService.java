package cart.service;

import cart.model.dto.UserDTO;




public interface UserLoginService {
	//驗證是否登錄成功
	//username , password, authCode 使用者輸入的
	//sessionAuthCode 系統的
	UserDTO login(String username,String password,String authCode ,String sessionAuthCode);
	
	
	
}
