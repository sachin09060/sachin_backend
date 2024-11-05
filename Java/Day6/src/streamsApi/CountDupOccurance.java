package streamsApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDupOccurance {

	public static void main(String[] args) {
		List<String> name = Arrays.asList("AA", "BB", "AA", "DD");
		
		name.stream().filter(e -> Collections.frequency(name, e) > 1)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.forEach((str, count) -> System.out.println(str + " ==========> " + count));
		
	}

}
