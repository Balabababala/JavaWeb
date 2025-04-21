package model;

import java.util.*;

public class DrinkOrder {
	
	public String type;
	public String size;
	public String ice;
	public static Map <String, Map<String,Integer>> drinkOrder = Map.of(
																		"greenTea",Map.of("S",30,"M",50,"L",50),
																		"blackTea",Map.of("S",45,"M",55,"L",65),
																		"milkTea" ,Map.of("S",40,"M",45,"L",60)
																		);

	public static Map <String, String> iceMap = Map.of(
													 "yes","加冰",
													 "no","去冰"
													  );
	
	public DrinkOrder(String type,String size,String ice) {
		this.type=type;
		this.size=size;
		this.ice=ice;
	}
	public String getType() {
		return type;
	}
	public String getSize() {
		return size;
	}
	public String getIce() {
		return iceMap.get(ice);
	}
	public String getInfo() {
		return String.format("您點了一杯 %s（%s，有%s），價格為 %s 元", type,size,getIce(),drinkOrder.get(type).get(size));
	}
	
}
