package functionalInterface;

import java.util.function.Function;

public class FunctionEx {
	public static void main(String[] args) {
		Function<String, Integer> fLength = s -> s.length();
		Function<String, String> fCase = s -> s.toUpperCase();
		System.out.println(fCase.apply("Sachin"));
		System.out.println(fLength.apply("Sachin"));
	}
}
