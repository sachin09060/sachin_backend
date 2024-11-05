package pattern;

import java.util.Scanner;

public class Pattern35 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = s.nextInt();

		for (int i = 1; i <= n; i++) {
			char ch = 'A';
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				if (j < i) {
					System.out.print(ch + " ");
					ch++;
				} else {
					System.out.print(ch + " ");
					ch--;
				}
			}
			System.out.println();
			s.close();
		}
	}
	
//		output: n=5
//	          A 
//	        A B A 
//	      A B C B A 
//	    A B C D C B A 
//	  A B C D E D C B A 
}
