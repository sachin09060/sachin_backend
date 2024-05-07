package streamsApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateEle {

	public static void main(String[] args) {
		List<Integer> listOfIntergers = Arrays.asList(1, 2, 3, 6, 5, 6, 7, 7, 9, 9, 11, 12, 13, 14, 15);
		List<Integer> duplicate = listOfIntergers.stream().distinct().collect(Collectors.toList());
		System.out.println(duplicate);
	}

}
