package streamsApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecLargestNum {

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		
		System.out.println(listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get() + " is the second largest number in given Array");

	}

}
