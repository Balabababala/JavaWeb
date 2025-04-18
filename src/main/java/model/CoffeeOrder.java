package model;

import java.util.Map;

public class CoffeeOrder {
	public static Map <String , Map<String , Integer> > coffeeTable =Map.of(
			"latte"       ,Map.of("s",50,"m",70,"l",90),
			"mocha"       ,Map.of("s",45,"m",55,"l",65),
			"americano"   ,Map.of("s",40,"m",45,"l",60),
			"cappuccino"  ,Map.of("s",55,"m",80,"l",100)	
				);
	
	private String type;
	private String size;
	private String sugar;
	private String reSize="";
	private String reSugar="";
	
	public CoffeeOrder(String type,String size,String sugar) {
		this.type=type.toLowerCase();
		this.size=size.toLowerCase();
		this.sugar=sugar.toLowerCase();
	}
	
	public String coffeeToString() {
		if(size.equals("s")) {
			reSize="小";
		}else if(size.equals("m")) {
			reSize="中";
		}else if(size.equals("l")) {
			reSize="大";
		}
		if(sugar.equals("yes")) {
			reSugar="加糖";
		}else if(sugar.equals("no")) {
			reSugar="不加糖";
		}
		if(CoffeeOrder.coffeeTable.containsKey(type)) {
				return  String.format("您點了一杯%s杯%s咖啡(%s) 價格:%s" ,reSize,type,reSugar,CoffeeOrder.coffeeTable.get(type).get(size)
						);
		}
		return "";
	}
}
