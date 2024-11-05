package pattern;

import java.util.Scanner;

public class Pattern40 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = s.nextInt();
		int space = 0, ch = n;
		for (int row = 1; row <= n; row++) {
			int num = ch / 2 + 1;
			for (int col = 1; col <= space; col++) {
				System.out.print("  ");
			}
			for (int col = 1; col <= ch; col++) {
				System.out.print(num + " ");
				if (col <= ch / 2) {
					num--;
				} else {
					num++;
				}
			}
			if (row <= n / 2) {
				space++;
				ch -= 2;
			} else {
				space--;
				ch += 2;
			}
			System.out.println();
		}
		s.close();
	}
	
//			 output: n=7
//			4 3 2 1 2 3 4 
//			  3 2 1 2 3 
//			    2 1 2 
//			      1 
//			    2 1 2 
//			  3 2 1 2 3 
//			4 3 2 1 2 3 4 	
}
