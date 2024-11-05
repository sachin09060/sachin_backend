package streamsApi;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MargeUnsortedArray {

	public static void main(String[] args) {
		int[] listOfIntegers1 = {8, 9, 12, 13, 14, 10, 1};
		int[] listOfIntegers2 = { 2, 3, 4, 5, 6, 7, 11, 15};
		
		int[] res = IntStream.concat(Arrays.stream(listOfIntegers1), Arrays.stream(listOfIntegers2))
				.sorted().toArray();
		int[] sorted = {};
		
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
