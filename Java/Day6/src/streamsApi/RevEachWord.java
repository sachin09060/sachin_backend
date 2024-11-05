package streamsApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RevEachWord {

	public static void main(String[] args) {
		String str = "Good Morning";
		System.out.println(Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" ")));
	}

}
