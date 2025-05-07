package case05;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping2 {
	public static void main (String args[]) {
		List<Map<String,String>> students=List.of(
				Map.of("gender","男","grade","A"),
				Map.of("gender","男","grade","B"),
				Map.of("gender","女","grade","C"),
				Map.of("gender","女","grade","B"),
				Map.of("gender","男","grade","A"));
//		System.out.print(students);
		//gender 分
		System.out.println(
				students.stream().collect(Collectors.groupingBy(s->s.get("gender"),Collectors.counting()))
				);
		//grade 分
		System.out.println(
				students.stream().collect(Collectors.groupingBy(s->s.get("grade"),Collectors.counting()))
				);
				
	}
}
