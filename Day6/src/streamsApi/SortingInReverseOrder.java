package streamsApi;

import java.util.*;

public class SortingInReverseOrder {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		asList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
	}
}
