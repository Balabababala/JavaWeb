package case03;

import java.util.*;
import java.util.function.BiPredicate;



public class PhonePlan {
	private Double minutes;
	private Double gb;
	
	static class PhoneRule{
		private String type ;
		private int price; 
		
		private BiPredicate<Double , Double> condition;
		
		public PhoneRule(String type,int price,BiPredicate <Double , Double> condition) {
			this.type=type;
			this.price=price;
			this.condition=condition;
		}
		
		public boolean matches(Double minutes,Double gb) {
			return condition.test(minutes,gb);
		}
		

		public String getFinalType() {
			return type;
		}
		public int getFinalPrice() {
			return price;
		}
	}
	
	private static final List<PhoneRule> rules=List.of(
			new PhoneRule("商務型",1499,(minutes,gb)->minutes>1000 || gb>50),
			new PhoneRule("一般用戶型",660,(minutes,gb)->minutes>500 && gb>10),
			new PhoneRule("長輩節省型",200,(minutes,gb)->minutes<200 && gb<1)
			);

	public PhonePlan(Double minutes,Double gb) {
		this.minutes=minutes;
		this.gb=gb;
	}
	public PhonePlan(String minutes,String gb) {
		this(Double.parseDouble(minutes), Double.parseDouble(gb));
	}
	
	public String getPhoneType() {
		return rules.stream()
				    .filter(rule-> rule.matches(minutes, gb))
				    .findFirst()
				    .map(PhoneRule::getFinalType)
				    //.map(rule -> rule.getFinalResult())
				    .orElse("無法辨識");
	}
	public Integer getPhonePrice() {
		return rules.stream()
				    .filter(rule-> rule.matches(minutes, gb))
				    .findFirst()
				    .map(PhoneRule::getFinalPrice)
				    //.map(rule -> rule.getFinalResult())
				    .orElse(null);
	}
	
	
	public Double getMinutes() {
		return minutes;
	}
	public Double getGb() {
		return gb;
	}
	
	
}
