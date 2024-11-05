package streamsApi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeInYear {

	public static void main(String[] args) {
		LocalDate birthday = LocalDate.of(2000,6,9);
		LocalDate today = LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(birthday, today)+ " Years old");

	}
}
