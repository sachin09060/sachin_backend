package streamsApi;

import java.util.stream.IntStream;

public class SumOfTenNaturalNum {

	public static void main(String[] args) {
		System.out.println("Sum of first 10 Natural Numbers: " + IntStream.range(1, 11).sum());
	}

}
