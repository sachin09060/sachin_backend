package streamsApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleOfFive {

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		
		System.out.print("Multiples of 5 in our list: ");
		List<Integer> collect = listOfIntegers.stream().filter(e -> e % 5==0).collect(Collectors.toList());
		System.out.println(collect);
	}

}
