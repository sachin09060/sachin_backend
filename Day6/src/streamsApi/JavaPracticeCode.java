package streamsApi;

import java.util.*;
//import java.util.stream.Collectors;

public class JavaPracticeCode {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		
//		asList.stream().filter(e -> e%2==0).forEach(System.out::println);
		
//		List<Integer> collect =	asList.stream().filter(e -> e%2==0).collect(Collectors.toList());
//		System.out.println(collect);
		
//		asList.stream().map(e -> e + "").filter(e -> e.startsWith("1")).forEach(System.out::println);
		
		asList.stream().map(e -> Integer.toString(e)).filter(e -> e.startsWith("1")).forEach(System.out::println);
	}

}
