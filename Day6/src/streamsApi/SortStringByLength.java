package streamsApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStringByLength {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("manikanta","sachin", "akshay", "chethan");
		listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	}

}
