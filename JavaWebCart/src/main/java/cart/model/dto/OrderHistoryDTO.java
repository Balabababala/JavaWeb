package cart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderHistoryDTO {
	Integer orderId;
	Integer quantity;
	String productName;
}
