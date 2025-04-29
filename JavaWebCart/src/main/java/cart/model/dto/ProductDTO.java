package cart.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
	//entity 資料
	private Integer productID;
	private String productName;
	private Integer price;
	private Integer qty;
	private String imageBase64;
	
	//total=price*qty entity 沒有
	private Integer total; 
}
