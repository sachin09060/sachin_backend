package pattern;

public class Pattern31 {
    public void pattern31() {
        int n = 5;
        for (int rows = 1; rows <= n; rows++) {

            for (int space = 1; space < rows; space++) {
                System.out.print("  ");
            }


            for (int num = 1; num <= n - rows + 1; num++) {
                System.out.print(num + " ");
            }


            for (int num = n - rows; num >= 1; num--) {
                if (num != 1) {
                    System.out.print(num + " ");
                } else {
                    System.out.print(num);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pattern31 p = new Pattern31();
        p.pattern31();
    }
    
    
//    		 output:
//    	1 2 3 4 5 4 3 2 1
//    	  1 2 3 4 3 2 1
//    	    1 2 3 2 1
//    	      1 2 1
//    	        1 
}
