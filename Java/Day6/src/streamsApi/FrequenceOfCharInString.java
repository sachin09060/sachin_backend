package streamsApi;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequenceOfCharInString {

	public static void main(String[] args) {
		String input = "Java articles are Awsome";
		Map<Character, Long> collect = input.chars().mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
	}

}
