package cart.dao;

import java.util.List;

import cart.model.entity.OrderHistory;


public interface OrderHistoryDAO {
	List<OrderHistory> findHistory(String username);
}
