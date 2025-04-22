package model.ice;

import java.util.Map;

public class MainDish {
	private String name;
	private int price;
	
	private static final Map<String, Integer> PRICE_MAP=Map.of("剉冰",50,"豆花",40);
	
	public MainDish(String name) {
		this.name=name;
		this.price=PRICE_MAP.get(name);
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	
	
}
