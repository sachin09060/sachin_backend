package functionalInterface;

import java.util.function.Consumer;

public class ConsumerEx {

	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.println(s);
		Consumer<String> c1 = s -> System.out.println(s.length());
		c.accept("Robin");
		c.andThen(c1).accept("Sachin");

	}

}
