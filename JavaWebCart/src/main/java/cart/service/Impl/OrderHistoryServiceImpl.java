package cart.service.Impl;

import java.util.*;

import cart.dao.OrderHistoryDAO;
import cart.dao.impl.OrderHistoryDAOImpl;
import cart.model.dto.OrderHistoryDTO;
import cart.service.OrderHistoryService;

public class OrderHistoryServiceImpl implements OrderHistoryService{
	OrderHistoryDAO historyDAO = new OrderHistoryDAOImpl();

	@Override
	public List<OrderHistoryDTO> findHistory(String username) {

		List<OrderHistoryDTO> historyDTOs=historyDAO.findHistory(username)
										.stream()
										.map(history->new OrderHistoryDTO(history.getOrderId(),history.getQuantity(),history.getProductName()))
										.toList();
		
		return historyDTOs;
	}
	
	
}
