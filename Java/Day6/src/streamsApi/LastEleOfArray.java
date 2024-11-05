package streamsApi;

import java.util.Arrays;
import java.util.List;

public class LastEleOfArray {

	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("sachin", "akshay", "sachin", "chethan");
		System.out.println("The last element of the string is: " + listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get());
	}

}
