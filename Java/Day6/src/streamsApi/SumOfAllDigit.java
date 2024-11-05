package streamsApi;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigit {

	public static void main(String[] args) {
		int inputNumber = 97;
		System.out.println("Sum of all deigit of a given number : " + Stream.of(String.valueOf(inputNumber).split("")).collect(Collectors.summingInt(Integer::parseInt)));

	}

}
