package model;

import java.util.Map;

public class CoffeeOrder {
	public static Map <String , Map<String , Integer> > coffeeTable =Map.of(
			"Latte"       ,Map.of("S",50,"M",70,"L",90),
			"Mocha"       ,Map.of("S",45,"M",55,"L",65),
			"Americano"   ,Map.of("S",40,"M",45,"L",60),
			"Cappuccino"  ,Map.of("S",55,"M",80,"L",100)	
				);
	public static String reSize="";
	public static String reSugar="";
	
	public static String coffeeToString(String type,String size,String sugar) {
		if(size.equals("S")) {
			reSize="小";
		}else if(size.equals("M")) {
			reSize="中";
		}else if(size.equals("L")) {
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
