package streamsApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoinListOfStrings {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("sachin", "akshay", "chethan");
		String collect = listOfStrings.stream().map(e -> "Mr. " + e + " Bye").collect(Collectors.joining(", ", "", ""));
		System.out.println(collect);
	}
}
