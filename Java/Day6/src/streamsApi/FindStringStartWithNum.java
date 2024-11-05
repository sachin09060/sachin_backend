package streamsApi;

import java.util.Arrays;
import java.util.List;

public class FindStringStartWithNum {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("manikanta","09Sachin", "akshay", "chethan");
		System.out.print("String which start with number: ");
		listOfStrings.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);
	}

}
