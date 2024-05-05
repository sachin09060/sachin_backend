package pattern;

import java.util.Scanner;

public class Pattern42 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = s.nextInt();
		int space = n / 2, ch = 1;
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= space; col++) {
				System.out.print(" ");
			}
			int k = (ch / 2) + 1;
			for (int col = 1; col <= ch; col++) {
				System.out.print(k + "");
				if (col <= ch / 2)
					k--;
				else
					k++;
			}
			if (row <= n / 2) {
				space--;
				ch = ch + 2;
			} else {
				space++;
				ch = ch - 2;
			}
			System.out.println();
		}
		s.close();
	}
	
//	     output: n=7
//			    1
//			   212
//			  32123
//			 4321234
//			  32123
//			   212
//			    1	
}
