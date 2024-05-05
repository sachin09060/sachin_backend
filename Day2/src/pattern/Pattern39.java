package pattern;

import java.util.Scanner;

public class Pattern39 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=s.nextInt();
		int space=0,ch=n;
		for(int row=1;row<=n;row++) {
			for(int col=1;col<=space;col++) {
				System.out.print("  ");
			}
			int num=space+1;
			for(int k=1;k<=ch;k++) {
				System.out.print(num+" ");
				if(k<=ch/2)
					num++;
				else
					num--;
			}
			if(row<=n/2) {
				space++;
				ch-=2;
			}
			else {
				space--;
				ch+=2;
			}
			System.out.println();
		}
		s.close();

	}
	
//			output: n=7
//			1 2 3 4 3 2 1 
//			  2 3 4 3 2 
//			    3 4 3 
//			      4 
//			    3 4 3 
//			  2 3 4 3 2 
//			1 2 3 4 3 2 1 
}
