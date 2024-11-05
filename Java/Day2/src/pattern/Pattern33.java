package pattern;

public class Pattern33 {
    public void pattern33() {
        int n = 7;
        int middle = n / 2 + 1;
        
        for (int rows = 1; rows <= middle; rows++) {
            for (int space = 1; space <= middle - rows; space++) {
                System.out.print("  ");
            }

            for (int col = 1; col <= 2 * rows - 1; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
        
        for (int rows = middle - 1; rows >= 1; rows--) {
            for (int space = 1; space <= middle - rows; space++) {
                System.out.print("  ");
            }

            for (int col = 1; col <= 2 * rows - 1; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pattern33 p = new Pattern33();
        p.pattern33();
    }
    
//       output:
//          * 
//        * * * 
//      * * * * * 
//    * * * * * * * 
//      * * * * * 
//        * * * 
//          *    
}
