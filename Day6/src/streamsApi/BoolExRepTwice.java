package streamsApi;

import java.util.*;
import java.util.stream.Collectors;

public class BoolExRepTwice {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 5, 6, 7, 7, 9, 9, 11, 12, 13, 14, 15);
		int size = asList.stream().distinct().collect(Collectors.toList()).size();
		System.err.print(size != asList.size());
	}

}
