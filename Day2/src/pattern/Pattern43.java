package pattern;

import java.util.Scanner;

public class Pattern43 {
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		    System.out.println("Enter the Number : ");
		    int n = s.nextInt();
		    int star=n/2, k=1,l=1;
		    for(int row=1;row<=n;row++)
		    {
		      for(int col=1;col<=star;col++)
		      {
		        System.out.print(" ");
		      }
		    for(int col=1;col<=k;col++)
		    {
		      if(col==1||col==k)
		      System.out.print("*");
		      else
		      System.out.print(" ");
		    }
		    if(row<=n/2)
		    {
		      star--;
		      l++;
		      k=k+2;
		    }
		    else
		    {
		      star++;
		      l--;
		      k=k-2;
		    }
		    System.out.println();
		    }
		    s.close();
	}
	
//		  output: n=7
//			    *
//			   * *
//			  *   *
//			 *     *
//			  *   *
//			   * *
//			    *
}
