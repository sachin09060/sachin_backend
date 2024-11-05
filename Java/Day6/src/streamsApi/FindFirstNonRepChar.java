package streamsApi;

public class FindFirstNonRepChar {

	public static void main(String[] args) {
		String input = "Java articles are Awsome";
		Character character = input.chars().mapToObj(c -> (char)c)
		.filter(e -> input.indexOf(e)==input.lastIndexOf(e))
		.findFirst().get();
		
		System.out.println(character);
	}
}
