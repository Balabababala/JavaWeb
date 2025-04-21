package case03;

import java.util.function.BiPredicate;

public class Phone {
	private Double minutes;
	private Double internetStream;
	
	static class PhoneRule{
		private String type ;
		
		private String description;
		
		private BiPredicate<Double , Double> condition;
		
		
	}
	
}
