package pattern;

public class Pattern34 {
  public void pattern34() {
    int n = 7;
    int middle = n / 2 + 1;
    
    
    for (int rows = middle; rows >= 1; rows--) {
      for (int space = 1; space <= (middle - rows) * 2; space++) {
        System.out.print(" ");
      }

      for (int col = 1; col <= (2 * rows) - 1; col++) {
        System.out.print("* ");
      }

      System.out.println();
    }

    for (int rows = 2; rows <= middle; rows++) {
      for (int space = 1; space <= (middle - rows) * 2; space++) {
        System.out.print(" ");
      }

      for (int col = 1; col <= (2 * rows) - 1; col++) {
        System.out.print("* ");
      }

      System.out.println();
    }

  }

  public static void main(String[] args) {
    Pattern34 p = new Pattern34();
    p.pattern34();
  }
  
//  	output:
//	  
//	* * * * * * * 
//	  * * * * * 
//	    * * * 
//	      * 
//	    * * * 
//	  * * * * * 
//	* * * * * * *
}
