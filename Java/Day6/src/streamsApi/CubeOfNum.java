package streamsApi;

import java.util.*;

public class CubeOfNum {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		asList.stream().map(e -> e*e*e).filter(e -> e > 50).forEach(System.out::println);
	}
}
