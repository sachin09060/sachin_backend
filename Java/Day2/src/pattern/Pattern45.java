package pattern;

import java.util.Scanner;

public class Pattern45 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = s.nextInt();
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {

				if (col == 1 || col == n || row == 1 || row == n || col == row || col+row-1==n) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		s.close();
	}
//			 output: n=7
//			* * * * * * * 
//			* *       * * 
//			*   *   *   * 
//			*     *     * 
//			*   *   *   * 
//			* *       * * 
//			* * * * * * * 
}
