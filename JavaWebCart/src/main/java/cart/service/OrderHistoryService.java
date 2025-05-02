package cart.service;

import java.util.List;

import cart.model.dto.OrderHistoryDTO;


public interface OrderHistoryService {
	List<OrderHistoryDTO> findHistory(String username);
}
