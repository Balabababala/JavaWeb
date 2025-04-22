package model.coffee;

import java.util.*;


public class Coffee {
	private Double milk;
	private Double coffee;
	private String result;
	private String desctiption;
	private Map<String,String> desctiptionMap = Map.of("濃郁的拿鐵","牛奶的比例遠高於咖啡，味道偏向牛奶。",
													   "平衡的拿鐵","牛奶與咖啡的比例較為平衡，風味溫和。",
													   "標準的卡布奇諾","牛奶與咖啡的比例恰到好處，典型的卡布奇諾。",
													   "濃縮咖啡","咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。",
													   "普通咖啡","牛奶與咖啡的比例較為普通，適合日常飲用。");
	
	public Coffee(String milk, String coffee) {
		this.milk=Double.parseDouble(milk);
		this.coffee=Double.parseDouble(coffee);

		setCoffeeType();
		setDesctiption(result);
	}

	
	public void setCoffeeType() {
		if(milk>=coffee*3) {
			result="濃郁的拿鐵";
		}else if(milk>=coffee*1.5) {
			result="平衡的拿鐵";
		}else if(milk==coffee) {
			result="標準的卡布奇諾";
		}else if(coffee>=milk*3) {
			result="濃縮咖啡";
		}else {
			result="普通咖啡";
		}
	}
	
	

	public void setDesctiption(String result) {
		desctiption = desctiptionMap.get(result);
	}


	public String getDesctiption() {
		return desctiption;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public Double getMilk() {
		return milk;
	}
	public Double getCoffee() {
		return coffee;
	}

	
	
}
