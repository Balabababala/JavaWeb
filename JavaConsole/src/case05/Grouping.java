package case05;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
	public static void main (String args[]) {
		List<String> fruit=List.of("apple","apple","banana","apple","orange","banana","papay");
		System.out.println(
				fruit.stream().collect(Collectors.groupingBy(name->name,Collectors.counting()))
				);
		
				
	}
}
