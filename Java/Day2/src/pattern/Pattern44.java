package pattern;

import java.util.Scanner;

public class Pattern44 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = s.nextInt();
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {

				if (row == 1 || row == n / 2 + 1 || row == n || col == 1 || col == n / 2 + 1 || col == n) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		s.close();
	}
	
//		     output: n=7
//			* * * * * * * 
//			*     *     * 
//			*     *     * 
//			* * * * * * * 
//			*     *     * 
//			*     *     * 
//			* * * * * * * 
}
