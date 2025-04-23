package model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private int porkNumber;
	private int porkPrice;
	private int plainNumber;
	private int plainPrice;
	private int potatoNumber;
	private int potatoPrice;
	
	
}
