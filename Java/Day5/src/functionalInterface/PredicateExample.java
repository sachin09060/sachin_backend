package functionalInterface;

import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
        Predicate<Integer> greaterThanTen = i -> i > 10;
        Predicate<Integer> lowerThanTwenty = i -> i < 20;

        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);
	}
}
 