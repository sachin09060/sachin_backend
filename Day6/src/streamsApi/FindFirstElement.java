package streamsApi;

import java.util.Arrays;
import java.util.List;

public class FindFirstElement {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		Integer orElse = asList.stream().findFirst().orElse(0);
		System.out.println(orElse);
	}
}
