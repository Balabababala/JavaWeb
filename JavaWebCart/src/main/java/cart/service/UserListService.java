package cart.service;
import java.util.List;

import cart.model.dto.*;

public interface UserListService {
	List<UserDTO> findAllUsers();
}
