package cart.dao;

import cart.model.entity.*;

public interface UserLoginDAO {
	User findUserByName(String name);
}
