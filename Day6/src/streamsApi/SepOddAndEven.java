package streamsApi;

import java.util.*;
import java.util.stream.*;

public class SepOddAndEven {

	public static void main(String[] args) {
		List<Integer> listOfIntergers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		System.out.print("Even numbers: ");
		Map<Boolean, List<Integer>> even = listOfIntergers.stream()
				.collect(Collectors.partitioningBy(i -> i%2==0));
		System.out.println(even);

	}

}
