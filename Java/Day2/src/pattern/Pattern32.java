package pattern;

public class Pattern32 {
    public void pattern32() {
        int n = 5;
        for (int rows = 1; rows <= n; rows++) {

            for (int space = 1; space < rows; space++) {
                System.out.print("  ");
            }

            for (int num = n - rows + 1; num >= 1; num--) {
                System.out.print(num + " ");
            }

            for (int num = 2; num <= n - rows + 1; num++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pattern32 p = new Pattern32();
        p.pattern32();
    }
    
//            output:
//    	5 4 3 2 1 2 3 4 5 
//    	  4 3 2 1 2 3 4 
//    	    3 2 1 2 3 
//    	      2 1 2 
//    	        1
}
