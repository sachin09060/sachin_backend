package pattern;

import java.util.Scanner;

public class Pattern36 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print((char) ('A' + j - 1)+" ");

			}
			for (int j = 2; j <= i; j++) {
				System.out.print((char) ( j - 1+'A')+" ");

			}

			System.out.println();
			s.close();
		}

	}
	
//		output: n=5
//			  A 
//	        B A B 
//	      C B A B C 
//	    D C B A B C D 
//	  E D C B A B C D E
}
