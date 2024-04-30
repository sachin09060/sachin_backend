package pattern;

public class Pattern25 {

	public static void main(String[] args) {
		int num =6;
		for(int i=1; i<=num; i++) {
			for(int j = 1; j <= num-i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
