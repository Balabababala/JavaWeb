package cart.model.entity;

import lombok.Data;

@Data
public class OrderHistory {
	Integer orderId;
	Integer quantity;
	String productName;
}
