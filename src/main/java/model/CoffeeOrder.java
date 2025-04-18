package model;

import java.util.Map;

public class CoffeeOrder {
	public static Map <String , Map<String , Integer> > coffeeTable =Map.of(
			"latte"       ,Map.of("s",50,"m",70,"l",90),
			"mocha"       ,Map.of("s",45,"m",55,"l",65),
			"americano"   ,Map.of("s",40,"m",45,"l",60),
			"cappuccino"  ,Map.of("s",55,"m",80,"l",100)	
				);
	
	public String type;
	public String size;
	public String sugar;
	
	public CoffeeOrder(String type,String size,String sugar) {
		this.type=type.toLowerCase();
		this.size=size.toLowerCase();
		this.sugar=sugar.toLowerCase();
	}
	
	public String getType() {
	    if(type.equals("latte")) return "Latte";
	    if(type.equals("mocha")) return "Mocha";
	    if(type.equals("americano")) return "Americano";
	    if(type.equals("cappuccino")) return "cappuccino";
	    return "";
	}
	public String getSize() {
	    if(size.equals("s")) return "小";
	    if(size.equals("m")) return "中";
	    if(size.equals("l")) return "大";
	    return "";
	}

	public String getSugar() {
	    if(sugar.equals("yes")) return "加糖";
	    if(sugar.equals("no")) return "不加糖";
	    return "";
	}
	
	
	public String getCoffeeInfo() {
		
		if(CoffeeOrder.coffeeTable.containsKey(type)) {
				return  String.format("您點了一杯%s杯%s咖啡(%s) 價格:%s" ,getType(),getType(),getSugar(),CoffeeOrder.coffeeTable.get(type).get(size)
						);
		}
		return "";
	}
}
