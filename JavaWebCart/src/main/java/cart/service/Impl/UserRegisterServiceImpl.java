package cart.service.Impl;

import org.eclipse.tags.shaded.org.apache.xalan.trace.PrintTraceListener;

import cart.dao.UserRegisterDAO;
import cart.dao.impl.UserRegisterDAOImpl;
import cart.model.entity.User;
import cart.service.UserRegisterService;
import cart.util.*;

public class UserRegisterServiceImpl implements UserRegisterService{
	private UserRegisterDAO userRegisterdao=new UserRegisterDAOImpl();
	
	@Override
	public void addUser(String username, String password, String email) {
		
		try {
			String hashSalt=HashUtil.generateSalt();
			String hashPassword= HashUtil.hashPassword(password, hashSalt);
			
			//建user
			//塞資料 不是明碼
			User user =new User();
			user.setUsername(username);
			user.setHashPassword(hashPassword);
			user.setHashSalt(hashSalt);
			user.setEmail(email);
			
			int rowcount =userRegisterdao.addUser(user); //更新 1=成功
			if(rowcount <1) {
				System.out.println("user 新增失敗");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void emailConfirmOK(String username) {
		if(username==null) {
			return;
		}
		userRegisterdao.emailConfirmOK(username);
	}

}
