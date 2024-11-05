package streamsApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeMaxAndMin {

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		
		System.out.println("First 3 minimum numbers in List: ");
		listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);
		System.out.println();
		
		System.out.println("First 3 maximum numbers in list: ");
		listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		
	}

}
