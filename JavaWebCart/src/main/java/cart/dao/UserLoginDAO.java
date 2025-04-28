package cart.dao;

import cart.model.entity.*;

public interface UserLoginDAO {
	User findUserByname(String name);
}
