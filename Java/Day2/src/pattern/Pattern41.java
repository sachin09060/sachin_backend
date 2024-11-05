package pattern;

import java.util.Scanner;

public class Pattern41 {
	 public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			System.out.println("Enter the value: ");
		    int n =s.nextInt() ;
		    int space = n/2, ch = 1;
		    for(int row = 1;row<=n;row++)
		    {
		      for(int col = 1;col<=space;col++)
		      {
		        System.out.print(" ");
		      }
		    int k = 1;
		    for(int col = 1; col<=ch;col++)
		    {
		      System.out.print(k+"");
		      if(col<=ch/2)
		      k++;
		      else
		      k--;
		    }
		    if(row<=n/2)
		    {
		      space--;
		      ch+=2;
		    }
		    else
		    {
		      space++;
		      ch-=2;
		    }
		    System.out.println();
		    }
		    s.close();
		  }
	 
//	      output: n=7
//		   	    1
//			   121
//			  12321
//			 1234321
//			  12321
//			   121
//			    1
}
